package cn.com.common.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnDefinition {

    //字段名称
    private String name;

    //字段类型
    private String dataType;

}
