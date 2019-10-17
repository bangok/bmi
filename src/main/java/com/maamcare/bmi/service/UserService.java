package com.maamcare.bmi.service;


import com.maamcare.bmi.po.User;

public interface UserService {
    public Integer register (User user) throws Exception;
    public Integer login (User user) throws Exception;
}
