package cn.com.common.entity.request;

import lombok.Data;

/**
 * 查询水稻基因请求参数
 */
@Data
public class RiceGenesCategoriesRequest {

    private String project;

    private String cultivar;

    private String treatment;

    private String tissueType;

    private String treatmentType;

}
