package com.maamcare.bmi.po;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Builder
@Setter
@Getter
@ToString
public class Record {
    Integer id;
    Integer userid;
    Date date;
    Integer weight;
}
