package cn.com.common.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 水稻筛选结果
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class RiceScreenVo {

    // 水稻基因名称
    private String riceName;

    // 平均值
    private BigDecimal average;

    // 范围差
    private BigDecimal rangeDifference;

    // 标准差
    private BigDecimal standardDeviation;

}
