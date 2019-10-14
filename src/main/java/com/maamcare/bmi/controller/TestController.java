package com.maamcare.bmi.controller;


import com.maamcare.bmi.service.TestService;
import com.maamcare.bmi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
