package com.maamcare.bmi.service;


import com.maamcare.bmi.po.User;

public interface UserService {
    public Integer register (User user) throws Exception;
    public Integer login (User user) throws Exception;
    public User getUserInfoById(Integer id);
    public boolean updateHeight(Integer id,Integer height);
}
