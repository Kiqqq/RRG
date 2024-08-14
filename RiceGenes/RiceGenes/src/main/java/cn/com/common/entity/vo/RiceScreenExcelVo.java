package cn.com.common.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * 水稻筛选结果
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
@ColumnWidth(30)
public class RiceScreenExcelVo {

    // 水稻基因名称
    @ExcelProperty("GeneId")
    private String riceName;

    // 平均值
    @ExcelProperty("Average")
    private String average;

    // 范围差
    @ExcelProperty("RangeDifference")
    private String rangeDifference;

    // 标准差
    @ExcelProperty("StandardDeviation")
    private String standardDeviation;

}
