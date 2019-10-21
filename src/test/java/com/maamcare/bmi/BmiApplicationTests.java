package com.maamcare.bmi;

import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.po.User;
import com.maamcare.bmi.pojo.TimeSlot;
import com.maamcare.bmi.service.RecordService;
import com.maamcare.bmi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BmiApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    RecordService recordService;

    @Test
    public void contextLoads() {
        System.out.println("开始测试");
    }


    @Test
    public void testRegisterWithUsernameIsNotRepeatExpectSuccess() {
        try {
            userService.register(User.builder().username("xxx").height(190).password("123456").build());
        } catch (Exception e) {
            System.out.println("失败");
        }
        System.out.println("成功");
    }

    @Test
    public void testRegisterWithUsernameIsRepeatExpectFiled() {
        try {
            userService.register(User.builder().username("zcf").height(190).password("123456").build());
        } catch (Exception e) {
            System.out.println("成功");
        }
        System.out.println("失败");
    }


}
