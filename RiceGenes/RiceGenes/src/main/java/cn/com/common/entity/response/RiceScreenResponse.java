package cn.com.common.entity.response;

import cn.com.common.entity.vo.RiceScreenVo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 水稻筛选结果
 *
 * @author zhaohai
 * @date 2023/11/04
 */
@Data
public class RiceScreenResponse {

    // 水稻基因名称
    private String riceName;

    // 平均值
    private String average;

    // 范围差
    private String rangeDifference;

    // 标准差
    private String standardDeviation;

    /**
     * RiceScreenVo转换为RiceScreenResponse
     *
     * @param riceScreenVo riceScreenVo
     * @return RiceScreenResponse
     */
    public static RiceScreenResponse convertDtoToVo(RiceScreenVo riceScreenVo) {
        RiceScreenResponse response = new RiceScreenResponse();
        try {
            BeanUtils.copyProperties(riceScreenVo, response);
            response.setAverage(riceScreenVo.getAverage().toString());
            response.setRangeDifference(riceScreenVo.getRangeDifference().toString());
            response.setStandardDeviation(riceScreenVo.getStandardDeviation().toString());
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
        return response;
    }

}
