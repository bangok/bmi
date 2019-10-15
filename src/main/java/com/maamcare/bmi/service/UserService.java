package com.maamcare.bmi.service;

import org.apache.ibatis.annotations.Param;

public interface UserService {
    //根据用户id获取用户信息
   void getInfoById(Integer userId);
}
