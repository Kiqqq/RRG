package cn.com.common.entity.dto;

import lombok.Data;

/**
 * 水稻基因数据表【RICE_GENES_CATEGORIES_PROJECT】实体类
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class RiceGenesCategoriesPjDto {

    private String tableName;

    private String geneId;

    private String sample;

    private String riceValue;

}
