package com.maamcare.bmi.controller;


import com.maamcare.bmi.component.TestComponent;
import com.maamcare.bmi.po.User;
import com.maamcare.bmi.service.UserService;
import com.maamcare.bmi.vo.Result;
import com.maamcare.bmi.vo.UserFormInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TestComponent testComponent;

    //@DateTimeFormat(pattern="yyyy-MM-dd")获取格式化日期数据

    @GetMapping("/noLogin")
    public Result noLogin(HttpSession session){
        Map<String,String> map = new HashMap();
        map.put("code","1");
        map.put("msg","用户未登录");
        return Result.builder().status(0).err(map).data(null).build();
    }

    @GetMapping("/getUserInfoById")
    public Result getUserInfoById(@RequestParam Integer id) throws Exception{
        Map<String,String> checkmap= new HashMap<>();
        if(id<0){
            checkmap.put("code","1");
            checkmap.put("msg","id不允许为负");
            return Result.builder()
                    .status(0)
                    .err(checkmap)
                    .data(null)
                    .build();
        }
        User user = null;
        try {
            user = userService.getUserInfoById(id);
        } catch (Exception e) {
            Map<String,String> errMap = new HashMap();
            errMap.put("code","-1");
            errMap.put("msg",e.getMessage());
            return Result.builder()
                    .status(0)
                    .err(errMap)
                    .data(null)
                    .build();
        }
        return Result.builder()
                .status(1)
                .err(null)
                .data(user)
                .build();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserFormInfo userFormInfo, HttpSession session){
        Map<String,String> map= new HashMap<>();
        map= testComponent.testLogin(userFormInfo.getUsername(),userFormInfo.getPassword());
        Integer userid = null;
        //校验数据合法性
        if(!map.get("code").equals("0")){
            return Result.builder()
                    .status(0)
                    .err(map)
                    .data(null)
                    .build();
        }
        try {
            userid =userService.login(User.builder()
                            .username(userFormInfo.getUsername())
                            .password(userFormInfo.getPassword())
                            .build());
        } catch (Exception e) {
            //登录失败
            HashMap<String, String> errMap = new HashMap<>();
            errMap.put("code","-1");
            errMap.put("msg",e.getMessage());
            return Result.builder()
                    .status(0)
                    .err(errMap)
                    .data(null)
                    .build();
        }
        //登录成功，保存到session中
        session.setAttribute("loginUser",userFormInfo.getUsername());
        HashMap<String, Integer> resmap = new HashMap<>();
        resmap.put("userid",userid);
        return Result.builder()
                .status(1)
                .err(null)
                .data(resmap)
                .build();
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserFormInfo userFormInfo,HttpSession session){
        Map<String,String> map= new HashMap<>();
        map= testComponent.testRegister(userFormInfo.getUsername(),userFormInfo.getPassword(),userFormInfo.getHeight());
        //校验数据合法性
        if(!map.get("code").equals("0")){
            return Result.builder()
                    .status(0)
                    .err(map)
                    .data(null)
                    .build();
        }
        Integer userid = null;
        try {
            userid =userService.register(User.builder()
                                .height(userFormInfo.getHeight())
                                .username(userFormInfo.getUsername())
                                .password(userFormInfo.getPassword())
                                .build());
        } catch (Exception e) {
            //注册失败
            HashMap<String, String> errMap = new HashMap<>();
            errMap.put("code","-1");
            errMap.put("msg",e.getMessage());
            return Result.builder()
                    .status(0)
                    .err(errMap)
                    .data(null)
                    .build();
        }
        //注册成功，保存到session中
        session.setAttribute("loginUser",userFormInfo.getUsername());
        //返回userid给前端
        HashMap<String, Integer> resMap = new HashMap<>();
        resMap.put("userid",userid);
        return Result.builder()
                .status(1)
                .err(null)
                .data(resMap)
                .build();

    }

    @GetMapping("/updateHeight")
    public Result updateHeight(@RequestParam Integer id ,@RequestParam Integer height){
        Map<String,String> checkMap= new HashMap<>();
        if(height<0){
            checkMap.put("code","1");
            checkMap.put("code","身高不允许为负数");
            return  Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        boolean isSuc = userService.updateHeight(id,height);
        if(!isSuc){
            checkMap.put("code","2");
            checkMap.put("msg","更新身高失败");
            return  Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        return  Result.builder()
                .status(1)
                .err(null)
                .data(null)
                .build();

    }
}
