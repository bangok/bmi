package com.maamcare.bmi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    public Integer userid;
    public Date startdate;
    public Date enddate;
}
