package com.maamcare.bmi.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class UserFormInfo {
    String username;
    String password;
    Integer height;
}
