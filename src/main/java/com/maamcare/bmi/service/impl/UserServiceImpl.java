package com.maamcare.bmi.service.impl;

import com.maamcare.bmi.dao.UserMapper;
import com.maamcare.bmi.po.User;
import com.maamcare.bmi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfoById(Integer id) throws Exception {
        User dbuser = userMapper.getUserInfoById(id);
        if(dbuser == null){
            //用户不存在
            throw new Exception("用户不存在");
        }
        return dbuser;
    }

    @Override
    public Integer register(User user) throws Exception{

        String username = user.getUsername();
        if(userMapper.getUserInfoByUserame(username) != null){
            //用户名重复
            throw new Exception("用户名重复");
        }else{
            //不重复，可以注册
            userMapper.addUser(user);
            //获取刚刚插入的User的id
            Integer userid = userMapper.getUserInfoByUserame(user.getUsername()).getId();
            return userid;
        }

    }

    @Override
    public Integer login(User user) throws Exception {
        User dbuser = userMapper.getUserInfoByUserame(user.getUsername());
        if(dbuser == null){
            //用户不存在
            throw new Exception("用户不存在");
        }
        if(!dbuser.getPassword().equals(user.getPassword())){
            //密码错误
            throw new Exception("密码错误");
        }
        return dbuser.getId();
    }

    @Override
    public boolean updateHeight(Integer id, Integer height) {
        return userMapper.updateHeight(id,height);
    }
}
