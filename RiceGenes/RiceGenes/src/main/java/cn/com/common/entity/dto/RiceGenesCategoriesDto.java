package cn.com.common.entity.dto;

import lombok.Data;

/**
 * 水稻基因表【RICE_GENES_CATEGORIES】实体类
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class RiceGenesCategoriesDto {

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

}
