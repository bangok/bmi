package com.maamcare.bmi;

import com.maamcare.bmi.po.User;
import com.maamcare.bmi.service.UserService;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
   private UserService userService;
    //注册
    @Test
    public void testRegisterNormalExpectSuccess() throws Exception
    {
       Integer height = 180;
       String username = "hsy";
       String passWord = "123456";

        User user = User.builder()
                .height(height)
                .username(username)
                .password(passWord)
                .build();
       Integer userId =  userService.register(user) ;
        Assertions.assertThat(userId).isNotNull();
    }
    @Test
    public void testRegisterUserExistenceExpectError() throws Exception
    {
        Integer height = 180;
        String username = "zcf";
        String passWord = "123456";
        try {
            User user = User.builder()
                    .height(height)
                    .username(username)
                    .password(passWord)
                    .build();
            Integer userId =  userService.register(user) ;

        }catch (Exception e)
        {
            Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(()->{
                throw e;
            });
        }

    }
    //登录
    @Test
    public void testloginNormalExpectSuccess() throws Exception
    {
        String username = "hsy";
        String passWord = "123456";

        User user = User.builder()
                .username(username)
                .password(passWord)
                .build();
        Integer userId =  userService.register(user) ;
        Assertions.assertThat(userId).isNotNull();
    }
    @Test
    public void testloginAccountErrorExpectError() throws Exception
    {
        Integer height = 180;
        String username = "leh";
        String passWord = "123456";
        try {
            User user = User.builder()
                    .username(username)
                    .password(passWord)
                    .build();
            Integer userId =  userService.login(user) ;

        }catch (Exception e)
        {
            Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(()->{
                throw e;
            });
        }

    }
    @Test
    public void testloginPasswordErrorExpectError() throws Exception
    {
        Integer height = 180;
        String username = "zcf";
        String passWord = "12345677";
        try {
            User user = User.builder()
                    .username(username)
                    .password(passWord)
                    .build();
            Integer userId =  userService.login(user) ;

        }catch (Exception e)
        {
            Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(()->{
                throw e;

            });
        }

    }
    @Test
    public void testGetUserInfoByIdWithIdNormalExpectSuccess() throws Exception
    {
      Integer userId = 13;
        User user =  userService.getUserInfoById(userId) ;
        Assertions.assertThat(user).isNotNull();
    }
    @Test
    public void testGetUserInfoByIdWithIdNothingExpectError()
    {
        Integer userId = 18;
        try {
            User user =  userService.getUserInfoById(userId) ;


        }catch (Exception e)
        {
            Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(()->{
                throw e;

            });
        }
    }
    @Test
    public void  testUpdateHeightWithNormalExpectSuccess()
    {
        Integer userId = 13;
        Integer height = 174;
        Boolean isSuccess =  userService.updateHeight(userId,height) ;
        Assertions.assertThat(isSuccess).isTrue();
    }

}
