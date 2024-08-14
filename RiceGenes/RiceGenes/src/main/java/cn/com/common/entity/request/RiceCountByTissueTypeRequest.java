package cn.com.common.entity.request;

import lombok.Data;

/**
 * 根据水稻位置查询数据量
 */
@Data
public class RiceCountByTissueTypeRequest {

    private String tissueType;

}
