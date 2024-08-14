package cn.com.common.entity.vo;

import cn.com.common.entity.dto.RiceGenesCategoriesDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 水稻基因表【RICE_GENES_CATEGORIES】实体类
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class RiceGenesCategoriesVo {

    private String sample;

    private String title;

    private String project;

    private String tissue;

    private String organism;

    private String cultivar;

    private String genoType;

    private String treatment;

    private String totalReads;

    private String uniquelyMappedRate;

    private String pmId;

    private String releaseDate;

    private String tissueType;

    private String treatmentType;

    /**
     * RiceGenesCategoriesDto转换为RiceGenesCategoriesVo
     *
     * @param dto RiceGenesCategoriesDto
     * @return RiceGenesCategoriesVo
     */
    public static RiceGenesCategoriesVo convertDtoToVo(RiceGenesCategoriesDto dto) {
        RiceGenesCategoriesVo vo = new RiceGenesCategoriesVo();
        try {
            BeanUtils.copyProperties(dto, vo);
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
        return vo;
    }

}
