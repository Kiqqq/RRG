package cn.com.common.entity.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 水稻数量分布
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class RiceCountResponse {

    private List<Map<String, Object>> riceCountMap;

}
