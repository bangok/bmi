package com.maamcare.bmi.controller;


import com.maamcare.bmi.vo.Result;
import com.maamcare.bmi.vo.UserFormInfo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/noLogin")
    public Result noLogin(HttpSession session){
        return Result.builder().status(1).err("用户未登录").data(null).build();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserFormInfo userFormInfo, HttpSession session){
        //session.setAttribute("userName","1");
        System.out.println(userFormInfo.toString());
        HashMap<String, String> map = new HashMap<>();
        map.put("userid","曹尼玛傻逼");
        return Result.builder().status(0).err("").data(map).build();
    }
    @PostMapping("/register")
    public Result register(@RequestBody UserFormInfo userFormInfo,HttpSession session){
        System.out.println(userFormInfo.toString());
        HashMap<String, String> map = new HashMap<>();
        map.put("userid","119114");
        return Result.builder().status(0).err("").data(map).build();
    }

}
