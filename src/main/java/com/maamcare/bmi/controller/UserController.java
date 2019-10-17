package com.maamcare.bmi.controller;


import com.maamcare.bmi.po.User;
import com.maamcare.bmi.service.UserService;
import com.maamcare.bmi.vo.Result;
import com.maamcare.bmi.vo.UserFormInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //@DateTimeFormat(pattern="yyyy-MM-dd")获取格式化日期数据

    @GetMapping("/noLogin")
    public Result noLogin(HttpSession session){
        return Result.builder().status(1).err("用户未登录").data(null).build();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserFormInfo userFormInfo, HttpSession session){
        System.out.println(userFormInfo.toString());

        Integer userid = null;

        try {
            userid =userService.login(User.builder()
                            .username(userFormInfo.getUsername())
                            .password(userFormInfo.getPassword())
                            .build());
        } catch (Exception e) {
            //登录失败
            return Result.builder()
                    .status(0)
                    .err(e.getMessage())
                    .data(null)
                    .build();
        }
        //登录成功，保存到session中
        session.setAttribute("loginUser",userFormInfo.getUsername());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("userid",userid);
        return Result.builder()
                .status(1)
                .err("")
                .data(map)
                .build();
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserFormInfo userFormInfo,HttpSession session){
        System.out.println(userFormInfo.toString());
        Integer userid = null;
        try {
            userid =userService.register(User.builder()
                                .height(userFormInfo.getHeight())
                                .username(userFormInfo.getUsername())
                                .password(userFormInfo.getPassword())
                                .build());
        } catch (Exception e) {
            //注册失败
            return Result.builder()
                    .status(0)
                    .err(e.getMessage())
                    .data(null)
                    .build();
        }
        //注册成功，保存到session中
        session.setAttribute("loginUser",userFormInfo.getUsername());
        //返回userid给前端
        HashMap<String, Integer> map = new HashMap<>();
        map.put("userid",userid);
        return Result.builder()
                .status(1)
                .err("")
                .data(map)
                .build();

    }

}
