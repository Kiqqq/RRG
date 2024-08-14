package cn.com.service.impl;

import cn.com.common.entity.dto.RiceGenesCategoriesDto;
import cn.com.common.entity.dto.RiceGenesCategoriesPjDto;
import cn.com.common.entity.enums.TableNameEnum;
import cn.com.common.entity.request.RiceCountByTissueTypeRequest;
import cn.com.common.entity.request.RiceGenesCategoriesRequest;
import cn.com.common.entity.request.RiceScreenExportRequest;
import cn.com.common.entity.request.RiceScreenRequest;
import cn.com.common.entity.response.RiceCountResponse;
import cn.com.common.entity.response.RiceScreenResponse;
import cn.com.common.entity.vo.RiceGenesCategoriesVo;
import cn.com.common.entity.vo.RiceScreenExcelVo;
import cn.com.common.entity.vo.RiceScreenVo;
import cn.com.dao.RiceGenesCategoriesMapper;
import cn.com.dao.SampleSelectMapper;
import cn.com.service.RiceGenesCommonService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RiceGenesCommonServiceImpl implements RiceGenesCommonService {

    @Autowired
    RiceGenesCategoriesMapper riceGenesCategoriesMapper;

    @Autowired
    SampleSelectMapper sampleSelectMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @Transactional
    public List<RiceGenesCategoriesVo> selectRiceGenesCategories(RiceGenesCategoriesRequest request) {
        List<RiceGenesCategoriesDto> riceGenesCategoriesDtoList = riceGenesCategoriesMapper.selectByRiceGenesCategoriesRequest(request);
        return riceGenesCategoriesDtoList.stream().map(RiceGenesCategoriesVo::convertDtoToVo).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<RiceScreenResponse> screenSamples(RiceScreenRequest riceScreenRequest) {
        List<RiceScreenVo> riceScreenVoList = new ArrayList<>();
        List<String> sampleList = riceScreenRequest.getSampleList();
        TableNameEnum tableNameEnum = TableNameEnum.getTableNameEnum(
                riceScreenRequest.getTissueType() + "_" + riceScreenRequest.getTreatmentType());

        List<RiceGenesCategoriesPjDto> pjDtoList = getRiceList(tableNameEnum, sampleList);

        // 提取所有字符串值并转换为数值
        List<Double> numericValues = new ArrayList<>();
        for (RiceGenesCategoriesPjDto riceGenesCategoriesPjDto : pjDtoList) {
            numericValues.add(Double.parseDouble(riceGenesCategoriesPjDto.getRiceValue()));
        }

        // 计算总和
        double valueSum = 0;
        for (double val : numericValues) {
            valueSum += val;
        }

        // 计算平均值
        double valueAverage = valueSum / pjDtoList.size();

        Map<String, List<RiceGenesCategoriesPjDto>> listMap = pjDtoList.stream().collect(Collectors.groupingBy(RiceGenesCategoriesPjDto::getGeneId));

        BigDecimal decimal = new BigDecimal(valueAverage * 0.7);
        BigDecimal averageLess = new BigDecimal("0.75");
        BigDecimal averageGreater = new BigDecimal("1.25");
        BigDecimal standardDeviationLess = new BigDecimal("0.5");

        // 遍历Map
        listMap.forEach((geneId, riceGenesCategoriesPjDtoList) -> {
            boolean flag = false;
            List<BigDecimal> values = new ArrayList<>();
            // 筛选riceValue>平均值*0.7的数据
            for (RiceGenesCategoriesPjDto pjDto : riceGenesCategoriesPjDtoList) {
                if (null == pjDto.getRiceValue() || pjDto.getRiceValue().equals("")) {
                    flag = true;
                    break;
                }
                if (new BigDecimal(pjDto.getRiceValue()).compareTo(decimal) < 0) {
                    flag = true;
                    break;
                }
                values.add(new BigDecimal(pjDto.getRiceValue()));
            }

            if (flag || values.isEmpty()) {
                return;
            }

            BigDecimal sum = BigDecimal.ZERO;
            for (BigDecimal value : values) {
                sum = sum.add(value);
            }
            // 计算平均值
            BigDecimal average = sum.divide(new BigDecimal(values.size()), 4, BigDecimal.ROUND_HALF_UP);

            List<BigDecimal> values1 = new ArrayList<>();
            // 筛选平均值为0.75-1.25的数据
            for (BigDecimal value : values) {
                if (value.divide(average, 4, RoundingMode.HALF_UP).compareTo(averageLess) < 0
                        || value.divide(average, 4, RoundingMode.HALF_UP).compareTo(averageGreater) > 0) {
                    flag = true;
                    break;
                }
                values1.add(value.divide(average, 4, RoundingMode.HALF_UP));
            }

            if (flag) {
                return;
            }

            // 找到最大值
            BigDecimal max = values1.get(0);
            for (BigDecimal value : values1) {
                if (value.compareTo(max) > 0) {
                    max = value;
                }
            }

            // 找到最小值
            BigDecimal min = values1.get(0);
            for (BigDecimal value : values1) {
                if (value.compareTo(min) < 0) {
                    min = value;
                }
            }

            // 计算最大值减去最小值(范围差)
            BigDecimal range = max.subtract(min);

            // 计算每个值的log2，并放入新的列表中
            List<BigDecimal> log2Values = new ArrayList<>();
            for (BigDecimal value : values) {
                BigDecimal log2Value = log2(value);
                log2Values.add(log2Value);
            }
            // 计算log2Values的标准差
            BigDecimal standardDeviation = calculateStandardDeviation(log2Values);
            BigDecimal standardDeviationValue = standardDeviation.setScale(4, RoundingMode.HALF_UP);


            // 获取标准差小于0.5的数据
            if (standardDeviation.compareTo(standardDeviationLess) > 0) {
                return;
            }

            RiceScreenVo riceScreenVo = new RiceScreenVo();
            riceScreenVo.setAverage(average);
            riceScreenVo.setRangeDifference(range);
            riceScreenVo.setRiceName(geneId);
            riceScreenVo.setStandardDeviation(standardDeviationValue);
            riceScreenVoList.add(riceScreenVo);

        });

        // 使用 Comparator 对 standardDeviation 进行排序
        Collections.sort(riceScreenVoList, Comparator.comparing(RiceScreenVo::getRangeDifference));

        // 把查询的值放入缓存中
        List<RiceScreenResponse> screenResponseList = riceScreenVoList.stream().map(RiceScreenResponse::convertDtoToVo).collect(Collectors.toList());
        Cache cache = cacheManager.getCache("screenedData");
        if (cache != null) {
            cache.put(riceScreenRequest.getCacheKey(), screenResponseList);
        }

        // 取前20个元素，如果列表长度小于20，则取列表的全部元素
        List<RiceScreenVo> top20List = riceScreenVoList.subList(0, Math.min(riceScreenVoList.size(), 20));

        List<RiceScreenResponse> result = top20List.stream().map(RiceScreenResponse::convertDtoToVo).collect(Collectors.toList());

        return result;
    }

    @Override
    public ResponseEntity<byte[]> screenSamplesExport(RiceScreenExportRequest riceScreenExportRequest) {
        List<RiceScreenExcelVo> riceScreenExcelVoList = getCachedData(riceScreenExportRequest.getCacheKey());

        // 创建 ExcelWriter 对象
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ExcelWriter excelWriter = EasyExcel.write(out, RiceScreenExcelVo.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();

        // 将数据写入 Excel
        excelWriter.write(riceScreenExcelVoList, writeSheet);
        excelWriter.finish();

        // 构建响应头部
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "rice_samples.xlsx");

        try {
            // 将 Excel 流转换为字节数组并返回响应
            byte[] excelBytes = out.toByteArray();
            return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            // 关闭流
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取缓存中的数据
     *
     * @param cacheKey 缓存键
     * @return List<RiceScreenExcelVo> 缓存数据
     */
    public List<RiceScreenExcelVo> getCachedData(String cacheKey) {
        // 获取缓存的值
        Cache cache = cacheManager.getCache("screenedData");
        if (cache != null) {
            Cache.ValueWrapper valueWrapper = cache.get(cacheKey);
            if (valueWrapper != null) {
                return (List<RiceScreenExcelVo>) valueWrapper.get();
            }
        }
        return null;
    }

    /**
     * 查询获取数据集合
     *
     * @param tableNameEnum 表名
     * @param sampleList    需要查询的sample集合
     * @return List<RiceGenesCategoriesPjDto>
     */
    private List<RiceGenesCategoriesPjDto> getRiceList(TableNameEnum tableNameEnum, List<String> sampleList) {
        switch (tableNameEnum) {
            case LEAF_COLD:
                return sampleSelectMapper.selectLeafCold(sampleList);
            case LEAF_MOCK:
                return sampleSelectMapper.selectLeafMock(sampleList);
            case LEAF_HEAT:
                return sampleSelectMapper.selectLeafHeat(sampleList);
            case LEAF_DROUGHT:
                return sampleSelectMapper.selectLeafDrought(sampleList);
            case LEAF_SALT:
                return sampleSelectMapper.selectLeafSalt(sampleList);
            case LEAF_HORMONE:
                return sampleSelectMapper.selectLeafHormone(sampleList);
            case LEAF_DISEASES:
                return sampleSelectMapper.selectLeafDiseases(sampleList);
            case LEAF_METAL:
                return sampleSelectMapper.selectLeafMetal(sampleList);
            case PANICLE_COLD:
                return sampleSelectMapper.selectPanicleCold(sampleList);
            case PANICLE_MOCK:
                return sampleSelectMapper.selectPanicleMock(sampleList);
            case PANICLE_HEAT:
                return sampleSelectMapper.selectPanicleHeat(sampleList);
            case PANICLE_DROUGHT:
                return sampleSelectMapper.selectPanicleDrought(sampleList);
            case PANICLE_SALT:
                return sampleSelectMapper.selectPanicleSalt(sampleList);
            case PANICLE_HORMONE:
                return sampleSelectMapper.selectPanicleHormone(sampleList);
            case PANICLE_DISEASES:
                return sampleSelectMapper.selectPanicleDiseases(sampleList);
            case PANICLE_METAL:
                return sampleSelectMapper.selectPanicleMetal(sampleList);
            case ROOT_COLD:
                return sampleSelectMapper.selectRootCold(sampleList);
            case ROOT_MOCK:
                return sampleSelectMapper.selectRootMock(sampleList);
            case ROOT_HEAT:
                return sampleSelectMapper.selectRootHeat(sampleList);
            case ROOT_DROUGHT:
                return sampleSelectMapper.selectRootDrought(sampleList);
            case ROOT_SALT:
                return sampleSelectMapper.selectRootSalt(sampleList);
            case ROOT_HORMONE:
                return sampleSelectMapper.selectRootHormone(sampleList);
            case ROOT_DISEASES:
                return sampleSelectMapper.selectRootDiseases(sampleList);
            case ROOT_METAL:
                return sampleSelectMapper.selectRootMetal(sampleList);
            case SEED_COLD:
                return sampleSelectMapper.selectSeedCold(sampleList);
            case SEED_MOCK:
                return sampleSelectMapper.selectSeedMock(sampleList);
            case SEED_HEAT:
                return sampleSelectMapper.selectSeedHeat(sampleList);
            case SEED_DROUGHT:
                return sampleSelectMapper.selectSeedDrought(sampleList);
            case SEED_SALT:
                return sampleSelectMapper.selectSeedSalt(sampleList);
            case SEED_HORMONE:
                return sampleSelectMapper.selectSeedHormone(sampleList);
            case SEED_DISEASES:
                return sampleSelectMapper.selectSeedDiseases(sampleList);
            case SEED_METAL:
                return sampleSelectMapper.selectSeedMetal(sampleList);
            case SEEDLING_COLD:
                return sampleSelectMapper.selectSeedlingCold(sampleList);
            case SEEDLING_MOCK:
                return sampleSelectMapper.selectSeedlingMock(sampleList);
            case SEEDLING_HEAT:
                return sampleSelectMapper.selectSeedlingHeat(sampleList);
            case SEEDLING_DROUGHT:
                return sampleSelectMapper.selectSeedlingDrought(sampleList);
            case SEEDLING_SALT:
                return sampleSelectMapper.selectSeedlingSalt(sampleList);
            case SEEDLING_HORMONE:
                return sampleSelectMapper.selectSeedlingHormone(sampleList);
            case SEEDLING_DISEASES:
                return sampleSelectMapper.selectSeedlingDiseases(sampleList);
            case SEEDLING_METAL:
                return sampleSelectMapper.selectSeedlingMetal(sampleList);
        }
        return null;
    }

    /**
     * 计算log2值
     *
     * @param value value
     * @return BigDecimal
     */
    private static BigDecimal log2(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Input must be greater than 0");
        }
        return BigDecimal.valueOf(Math.log(value.doubleValue()) / Math.log(2.0));
    }

    /**
     * 计算标准差
     *
     * @param values values
     * @return BigDecimal
     */
    private static BigDecimal calculateStandardDeviation(List<BigDecimal> values) {
        BigDecimal mean = calculateMean(values);

        // 计算差的平方和
        BigDecimal squaredDiffSum = BigDecimal.ZERO;
        for (BigDecimal value : values) {
            BigDecimal diff = value.subtract(mean);
            squaredDiffSum = squaredDiffSum.add(diff.multiply(diff));
        }

        // 计算平均值
        BigDecimal variance = squaredDiffSum.divide(BigDecimal.valueOf(values.size()), 4, RoundingMode.HALF_UP);

        // 计算标准差
        return BigDecimal.valueOf(Math.sqrt(variance.doubleValue()));
    }

    /**
     * 计算平均值
     *
     * @param values values
     * @return BigDecimal
     */
    private static BigDecimal calculateMean(List<BigDecimal> values) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal value : values) {
            sum = sum.add(value);
        }
        return sum.divide(BigDecimal.valueOf(values.size()), 4, RoundingMode.HALF_UP);
    }

    @Override
    public RiceCountResponse getRiceCount() {
        RiceCountResponse result = new RiceCountResponse();
        List<Map<String, Object>> riceCount = riceGenesCategoriesMapper.getRiceCount();
        result.setRiceCountMap(riceCount);
        return result;
    }

    @Override
    public RiceCountResponse getRiceCountByTissueTypeRequest(RiceCountByTissueTypeRequest riceCountByTissueTypeRequest) {
        RiceCountResponse result = new RiceCountResponse();
        List<Map<String, Object>> riceCount = riceGenesCategoriesMapper.getRiceCountByTissueTypeRequest(riceCountByTissueTypeRequest);
        result.setRiceCountMap(riceCount);
        return result;
    }
}
