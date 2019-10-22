package com.maamcare.bmi.dao;

import com.maamcare.bmi.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserMapper {
    public boolean addUser(User user);
    public User getUserInfoByUserame(String username);
    public User getUserInfoById(Integer id);
    public boolean updateHeight(@Param(value = "id") Integer id, @Param(value = "height") Integer height);
}
