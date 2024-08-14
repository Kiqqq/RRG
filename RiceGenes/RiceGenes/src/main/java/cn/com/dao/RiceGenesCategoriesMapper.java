package cn.com.dao;

import cn.com.common.entity.dto.RiceGenesCategoriesDto;
import cn.com.common.entity.request.RiceCountByTissueTypeRequest;
import cn.com.common.entity.request.RiceGenesCategoriesRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 操作水稻基因表【RICE_GENES_CATEGORIES】
 */

@Mapper
public interface RiceGenesCategoriesMapper {

    /**
     * 主表数据入库
     *
     * @param riceGenesCategoriesDto riceGenesCategoriesDto
     */
    void insert(@Param("item") RiceGenesCategoriesDto riceGenesCategoriesDto);

    /**
     * 根据参数查询水稻基因
     *
     * @param request 参数
     * @return List<RiceGenesCategoriesDto>
     */
    List<RiceGenesCategoriesDto> selectByRiceGenesCategoriesRequest(@Param("item") RiceGenesCategoriesRequest request);

    /**
     * 查询水稻各部位数据量
     *
     * @return List<Map < String, Object>>
     */
    List<Map<String, Object>> getRiceCount();

    /**
     * 根据水稻各部位查询其对应条件的数据量
     *
     * @param request request
     * @return List<Map < String, Object>>
     */
    List<Map<String, Object>> getRiceCountByTissueTypeRequest(@Param("item") RiceCountByTissueTypeRequest request);

}
