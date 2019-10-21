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


}
