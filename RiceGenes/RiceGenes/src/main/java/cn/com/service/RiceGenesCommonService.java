package cn.com.service;

import cn.com.common.entity.request.RiceCountByTissueTypeRequest;
import cn.com.common.entity.request.RiceGenesCategoriesRequest;
import cn.com.common.entity.request.RiceScreenExportRequest;
import cn.com.common.entity.request.RiceScreenRequest;
import cn.com.common.entity.response.RiceCountResponse;
import cn.com.common.entity.response.RiceScreenResponse;
import cn.com.common.entity.vo.RiceGenesCategoriesVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RiceGenesCommonService {

    /**
     * 根据参数查询水稻信息
     *
     * @param request request
     * @return List<RiceGenesCategoriesVo>
     */
    List<RiceGenesCategoriesVo> selectRiceGenesCategories(RiceGenesCategoriesRequest request);

    /**
     * 水稻筛选
     *
     * @param riceScreenRequest riceScreenRequest
     * @return List<RiceScreenResponse>
     */
    List<RiceScreenResponse> screenSamples(RiceScreenRequest riceScreenRequest);


    ResponseEntity<byte[]> screenSamplesExport(RiceScreenExportRequest riceScreenExportRequest);

    /**
     * 查询水稻各部位数据量
     *
     * @return RiceCountResponse RiceCountResponse
     */
    RiceCountResponse getRiceCount();

    /**
     * 根据水稻各部位查询其对应条件的数据量
     *
     * @return RiceCountResponse RiceCountResponse
     */
    RiceCountResponse getRiceCountByTissueTypeRequest(RiceCountByTissueTypeRequest riceCountByTissueTypeRequest);

}
