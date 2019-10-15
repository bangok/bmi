package com.maamcare.bmi.controller;


import com.alibaba.fastjson.JSONObject;
import com.maamcare.bmi.vo.Result;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/noLogin")
    public Result noLogin(HttpSession session){
        return Result.builder().status(0).err("用户未登录").data(null).build();
    }

    @PostMapping("/login")
    public Result login(@RequestBody String a){
//        System.out.println(a);
//        session.setAttribute("loginUser",a);
//        return Result.builder().status(0).err("用户已登录").data(a).build();
        System.out.println("接收的参数："+ a );
        JSONObject jsonObject = JSONObject.parseObject(a);
        String account = jsonObject.get("account").toString();
        String password = jsonObject.get("password").toString();
        if ( account.equals("")){
            return Result.builder().status(0).err("用户账号不能为空").data(null).build();
        }
        if (password.equals("")){
            return Result.builder().status(0).err("用户密码不能为空").data(null).build();
        }
        return Result.builder().status(1).err("登陆成功").data(null).build();

    }
    @GetMapping("/getInfoById")
    public  Result getInfoById(@RequestParam(name="id") Integer userId){
    if (userId != null)
    {
        Map<String, String> dataMap = new HashMap<String, String>(2);
        dataMap.put("account", "555");
        dataMap.put("height", "170");
        return Result.builder().status(1).data(dataMap).build();
    }else
    {
       return Result.builder().status(0).err("用户id不能为空").data(null).build();
    }
    }
    @PostMapping("/register")
    public  Result register(@RequestBody String string){
        System.out.println("接收的参数："+ string );
        JSONObject jsonObject = JSONObject.parseObject(string);
        String account = jsonObject.get("account").toString();
        String password = jsonObject.get("password").toString();
        Integer height = Integer.parseInt(jsonObject.get("height").toString());
        if (account.equals("")){
            return Result.builder().status(0).err("用户账号不能为空").data(null).build();
        }
        if (password.equals("")){
            return Result.builder().status(0).err("用户密码不能为空").data(null).build();
        }
        if (height == null) {
            return Result.builder().status(0).err("用户身高不能为空").data(null).build();
        }

        Map<String, String> dataMap = new HashMap<String, String>(3);
        dataMap.put("account", "555");
        dataMap.put("height", "170");
        dataMap.put("password", "123456");
        return Result.builder().status(1).data(dataMap).build();
    }

    @PostMapping("/logout")
    public  Result logout(@RequestBody String string){
        JSONObject jsonObject = JSONObject.parseObject(string);
        String account = jsonObject.get("account").toString();
        if (!account.equals("")){
            return Result.builder().status(1).err("退出登录成功").data(null).build();
        }else
        {
            return Result.builder().status(0).err("用户账号不能为空").data(null).build();
        }
    }
}
