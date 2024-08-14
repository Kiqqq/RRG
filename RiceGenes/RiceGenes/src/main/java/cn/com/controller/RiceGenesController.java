package cn.com.controller;

import cn.com.common.entity.request.RiceCountByTissueTypeRequest;
import cn.com.common.entity.request.RiceGenesCategoriesRequest;
import cn.com.common.entity.request.RiceScreenExportRequest;
import cn.com.common.entity.request.RiceScreenRequest;
import cn.com.common.entity.response.RiceCountResponse;
import cn.com.common.entity.response.RiceScreenResponse;
import cn.com.common.entity.response.SelectRiceGenesCategoriesResponse;
import cn.com.common.entity.vo.RiceGenesCategoriesVo;
import cn.com.service.RiceGenesCommonService;
import cn.com.service.RiceGenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/rice")
@CrossOrigin
public class RiceGenesController {

    @Autowired
    RiceGenesService riceGenesService;

    @Autowired
    RiceGenesCommonService riceGenesCommonService;

    /**
     * 导入excel文件入库，向RICE_GENES_CATEGORIES表填充数据
     *
     * @param file 文件
     * @return 结果
     */
    @PostMapping("/excelInsertToRiceGenesCategoriesMapper")
    public String excelInsertToRiceGenesCategoriesMapper(@RequestParam("excelFile") MultipartFile file) {
        if (!file.isEmpty()) {
            riceGenesService.excelInsertToRiceGenesCategoriesMapper(file);
            return "添加成功"; // 假设存在名为 "success.html" 的成功页面
        } else {
            return "添加失败";
        }
    }

    /**
     * 导入excel文件入库，向RICE_GENES_CATEGORIES_PROJECT表填充数据
     *
     * @param file 文件
     * @return 结果
     */
    @PostMapping("/excelInsertToRiceGenesCategoriesPjMapper")
    public String excelInsertToRiceGenesCategoriesPjMapper(@RequestParam("excelSampleFile") MultipartFile file) {
        if (!file.isEmpty()) {
            riceGenesService.excelInsertToRiceGenesCategoriesPjMapper(file);
            return "添加成功"; // 假设存在名为 "success.html" 的成功页面
        } else {
            return "添加失败";
        }
    }

    /**
     * 根据参数查询水稻信息
     *
     * @param request RiceGenesCategoriesRequest
     * @return List<RiceGenesCategoriesVo>
     */
    @PostMapping("/selectRiceGenesCategories")
    @ResponseBody
    public SelectRiceGenesCategoriesResponse selectRiceGenesCategories(@RequestBody RiceGenesCategoriesRequest request) {
        SelectRiceGenesCategoriesResponse result = new SelectRiceGenesCategoriesResponse();
        List<RiceGenesCategoriesVo> riceGenesCategoriesVoList = riceGenesCommonService.selectRiceGenesCategories(request);
        result.setRiceGenesCategoriesVoList(riceGenesCategoriesVoList);
        return result;

    }

    /**
     * 水稻筛选
     *
     * @param riceScreenRequest riceScreenRequest
     * @return List<RiceScreenResponse>
     */
    @PostMapping("/screen")
    public List<RiceScreenResponse> screenSamples(@RequestBody RiceScreenRequest riceScreenRequest) {
        return riceGenesCommonService.screenSamples(riceScreenRequest);
    }

    /**
     * 水稻筛选导出
     */
    @PostMapping("screenSamplesExport")
    public ResponseEntity<byte[]> screenSamplesExport(@RequestBody RiceScreenExportRequest riceScreenExportRequest) {
        return riceGenesCommonService.screenSamplesExport(riceScreenExportRequest);
    }

    /**
     * 查询水稻大类数量
     *
     * @return RiceCountResponse
     */
    @PostMapping("/getRiceCount")
//    @CrossOrigin
    public RiceCountResponse getRiceCount() {
        return riceGenesCommonService.getRiceCount();
    }

    /**
     * 查询水稻大类中各个小类数量
     *
     * @return RiceCountResponse
     */
    @PostMapping("/getRiceCountByTissueTypeRequest")
    public RiceCountResponse getRiceCountByTissueTypeRequest(@RequestBody RiceCountByTissueTypeRequest riceCountByTissueTypeRequest) {
        return riceGenesCommonService.getRiceCountByTissueTypeRequest(riceCountByTissueTypeRequest);
    }

}
