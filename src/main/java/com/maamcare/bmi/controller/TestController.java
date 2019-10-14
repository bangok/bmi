package com.maamcare.bmi.controller;


import com.maamcare.bmi.service.TestService;
import com.maamcare.bmi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Author：张昌飞
 * Time：2019年10月12日14:11:03
 * Description：测试Java环境
 *
 * */


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/all")
    public Result testDB(){
        return Result
                .builder()
                .status(1)
                .err("{}")
                .data(testService.getAllData())
                .build();
    }

    @GetMapping("/date")
    public Result testDatefomater(@DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        System.out.println(date.toString());

        return Result
                .builder()
                .status(1)
                .err("{}")
                .data(date)
                .build();
    }

    @PostMapping("/testPost")
    public Result testPost(@RequestBody String info){
        System.out.println(info);
        System.out.println("获取到POST提交");
        return Result
                .builder()
                .status(1)
                .err("{}")
                .data(info)
                .build();
    }

}
