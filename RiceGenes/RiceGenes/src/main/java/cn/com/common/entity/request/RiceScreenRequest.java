package cn.com.common.entity.request;

import lombok.Data;

import java.util.List;

/**
 * 查询水稻基因请求参数
 */
@Data
public class RiceScreenRequest {

    // 部位
    private String tissueType;

    // 条件
    private String treatmentType;

    // sample集合
    private List<String> sampleList;

    // 缓存key
    private String cacheKey;

}
