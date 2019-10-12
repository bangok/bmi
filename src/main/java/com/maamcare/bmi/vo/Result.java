package com.maamcare.bmi.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class Result {
    public Integer status;
    public String err;
    public Object data;
}
