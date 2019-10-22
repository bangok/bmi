package com.maamcare.bmi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注意：pojo的日期类型，当做mapper的入参的时候，尽量用String，否则数据库查询有边界值问题
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    public Integer userid;
    public String startdate;
    public String enddate;
}
