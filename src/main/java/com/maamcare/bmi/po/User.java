package com.maamcare.bmi.po;

import lombok.*;


/**
 * 不建议在po类中使用builder，遇到date等类型，mybaties类型转换会冲突
 * 在这里，因为没有使用date类型，所以使用了@Builder也没报错
 * */
@Builder
@Data
public class User {
    Integer id;
    String username;
    String password;
    Integer height;
}
