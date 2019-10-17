package com.maamcare.bmi;

import com.maamcare.bmi.po.User;
import com.maamcare.bmi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BmiApplicationTests {

    @Autowired
    UserService userService;

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
