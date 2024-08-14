package cn.com.common.entity.request;

import cn.com.common.entity.vo.RiceScreenExcelVo;
import lombok.Data;

import java.util.List;

/**
 * 查询水稻基因请求参数
 */
@Data
public class RiceScreenExportRequest {

    // 缓存key
    private String cacheKey;

}
