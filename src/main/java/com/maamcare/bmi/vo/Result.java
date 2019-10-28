package com.maamcare.bmi.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Builder
@Setter
@Getter
@ToString
public class Result {
    public Integer status;
    public Map err;
    public Object data;
}
