package com.maamcare.bmi.po;

import lombok.*;

/**
 * 不建议在po类中使用builder，遇到date等类型，mybaties类型转换会冲突
 * 在这里，因为没有使用date类型，所以使用了@Builder也没报错
 *
 * 日期映射不建议使用Date类型，因为精度损失，数据库操作会有边界值问题
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    public Integer id;
    public Integer userid;
    public Integer weight;
    public String record_date;
}
