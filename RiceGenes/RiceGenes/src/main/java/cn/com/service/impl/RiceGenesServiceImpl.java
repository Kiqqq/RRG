package cn.com.service.impl;

import cn.com.common.entity.dto.RiceGenesCategoriesDto;
import cn.com.common.entity.dto.RiceGenesCategoriesPjDto;
import cn.com.common.entity.enums.TableNameEnum;
import cn.com.common.utils.ExcelToDto;
import cn.com.dao.RiceGenesCategoriesMapper;
import cn.com.dao.SampleInsertMapper;
import cn.com.service.RiceGenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RiceGenesServiceImpl implements RiceGenesService {

    @Autowired
    RiceGenesCategoriesMapper riceGenesCategoriesMapper;

    @Autowired
    SampleInsertMapper sampleInsertMapper;

    @Override
    @Transactional
    public void excelInsertToRiceGenesCategoriesMapper(MultipartFile file) {
        //excel转为RiceGenesCategoriesDto
        List<RiceGenesCategoriesDto> riceGenesCategoriesDtoList = ExcelToDto.excelToObjects(file, RiceGenesCategoriesDto.class);

        for (RiceGenesCategoriesDto riceGenesCategoriesDto : riceGenesCategoriesDtoList) {
            riceGenesCategoriesMapper.insert(riceGenesCategoriesDto);

        }
    }

    @Override
    @Transactional
    public void excelInsertToRiceGenesCategoriesPjMapper(MultipartFile file) {
        //excel转为RiceGenesCategoriesDto
        List<RiceGenesCategoriesPjDto> riceGenesCategoriesPjDtoList = ExcelToDto.excelToObjects(file, RiceGenesCategoriesPjDto.class);

        for (RiceGenesCategoriesPjDto riceGenesCategoriesPjDto : riceGenesCategoriesPjDtoList) {
            TableNameEnum tableNameEnum = TableNameEnum.getTableNameEnum(riceGenesCategoriesPjDto.getTableName());
            switch (tableNameEnum) {
                case LEAF_COLD:
                    sampleInsertMapper.insertLeafCold(riceGenesCategoriesPjDto);
                    break;
                case LEAF_MOCK:
                    sampleInsertMapper.insertLeafMock(riceGenesCategoriesPjDto);
                    break;
                case LEAF_HEAT:
                    sampleInsertMapper.insertLeafHeat(riceGenesCategoriesPjDto);
                    break;
                case LEAF_DROUGHT:
                    sampleInsertMapper.insertLeafDrought(riceGenesCategoriesPjDto);
                    break;
                case LEAF_SALT:
                    sampleInsertMapper.insertLeafSalt(riceGenesCategoriesPjDto);
                    break;
                case LEAF_HORMONE:
                    sampleInsertMapper.insertLeafHormone(riceGenesCategoriesPjDto);
                    break;
                case LEAF_DISEASES:
                    sampleInsertMapper.insertLeafDiseases(riceGenesCategoriesPjDto);
                    break;
                case LEAF_METAL:
                    sampleInsertMapper.insertLeafMetal(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_COLD:
                    sampleInsertMapper.insertPanicleCold(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_MOCK:
                    sampleInsertMapper.insertPanicleMock(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_HEAT:
                    sampleInsertMapper.insertPanicleHeat(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_DROUGHT:
                    sampleInsertMapper.insertPanicleDrought(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_SALT:
                    sampleInsertMapper.insertPanicleSalt(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_HORMONE:
                    sampleInsertMapper.insertPanicleHormone(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_DISEASES:
                    sampleInsertMapper.insertPanicleDiseases(riceGenesCategoriesPjDto);
                    break;
                case PANICLE_METAL:
                    sampleInsertMapper.insertPanicleMetal(riceGenesCategoriesPjDto);
                    break;
                case ROOT_COLD:
                    sampleInsertMapper.insertRootCold(riceGenesCategoriesPjDto);
                    break;
                case ROOT_MOCK:
                    sampleInsertMapper.insertRootMock(riceGenesCategoriesPjDto);
                    break;
                case ROOT_HEAT:
                    sampleInsertMapper.insertRootHeat(riceGenesCategoriesPjDto);
                    break;
                case ROOT_DROUGHT:
                    sampleInsertMapper.insertRootDrought(riceGenesCategoriesPjDto);
                    break;
                case ROOT_SALT:
                    sampleInsertMapper.insertRootSalt(riceGenesCategoriesPjDto);
                    break;
                case ROOT_HORMONE:
                    sampleInsertMapper.insertRootHormone(riceGenesCategoriesPjDto);
                    break;
                case ROOT_DISEASES:
                    sampleInsertMapper.insertRootDiseases(riceGenesCategoriesPjDto);
                    break;
                case ROOT_METAL:
                    sampleInsertMapper.insertRootMetal(riceGenesCategoriesPjDto);
                    break;
                case SEED_COLD:
                    sampleInsertMapper.insertSeedCold(riceGenesCategoriesPjDto);
                    break;
                case SEED_MOCK:
                    sampleInsertMapper.insertSeedMock(riceGenesCategoriesPjDto);
                    break;
                case SEED_HEAT:
                    sampleInsertMapper.insertSeedHeat(riceGenesCategoriesPjDto);
                    break;
                case SEED_DROUGHT:
                    sampleInsertMapper.insertSeedDrought(riceGenesCategoriesPjDto);
                    break;
                case SEED_SALT:
                    sampleInsertMapper.insertSeedSalt(riceGenesCategoriesPjDto);
                    break;
                case SEED_HORMONE:
                    sampleInsertMapper.insertSeedHormone(riceGenesCategoriesPjDto);
                    break;
                case SEED_DISEASES:
                    sampleInsertMapper.insertSeedDiseases(riceGenesCategoriesPjDto);
                    break;
                case SEED_METAL:
                    sampleInsertMapper.insertSeedMetal(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_COLD:
                    sampleInsertMapper.insertSeedlingCold(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_MOCK:
                    sampleInsertMapper.insertSeedlingMock(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_HEAT:
                    sampleInsertMapper.insertSeedlingHeat(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_DROUGHT:
                    sampleInsertMapper.insertSeedlingDrought(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_SALT:
                    sampleInsertMapper.insertSeedlingSalt(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_HORMONE:
                    sampleInsertMapper.insertSeedlingHormone(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_DISEASES:
                    sampleInsertMapper.insertSeedlingDiseases(riceGenesCategoriesPjDto);
                    break;
                case SEEDLING_METAL:
                    sampleInsertMapper.insertSeedlingMetal(riceGenesCategoriesPjDto);
                    break;
            }
        }
    }

}
