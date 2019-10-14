package com.maamcare.bmi.controller;


import com.maamcare.bmi.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/noLogin")
    public Result noLogin(HttpSession session){
        return Result.builder().status(0).err("用户未登录").data(null).build();
    }

    @GetMapping("/login")
    public Result login(@RequestParam String a, HttpSession session){
        System.out.println(a);
        session.setAttribute("loginUser",a);
        return Result.builder().status(0).err("用户已登录").data(a).build();
    }
}
