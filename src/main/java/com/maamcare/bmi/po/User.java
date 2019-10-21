package com.maamcare.bmi.po;

import lombok.*;

@Builder
@Data
public class User {
    Integer id;
    String username;
    String password;
    Integer height;
}
