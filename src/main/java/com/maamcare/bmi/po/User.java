package com.maamcare.bmi.po;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class User {
    Integer id;
    String username;
    String password;
    Integer height;
}
