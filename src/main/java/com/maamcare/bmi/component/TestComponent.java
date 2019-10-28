package com.maamcare.bmi.component;


import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TestComponent {

    //用户名只允许英文+数字
    public String regForTestUsername = "[a-zA-Z0-9]+$";
    //密码只允许英文+数字
    public String regForTestPassword = "[a-zA-Z0-9]+$";



    /**
     * 用户名：长度3-8，只允许英文、数字的组合
     * 密码：6位，英文、数字组合
     * 身高：正整数
     * */
    public HashMap<Integer,String> testRegister(String username,String password,Integer height){
        HashMap<Integer,String> map = new HashMap<>();

        Pattern pattern = Pattern.compile(regForTestUsername);
        Matcher match=pattern.matcher(username);

        if(username.equals("")){
            map.put(1,"用户名为空");
            return map;
        }
        if(username.length()>8){
            map.put(2,"用户名长度不能大于8");
            return map;
        }
        if(username.length()<3){
            map.put(3,"用户名长度不能小于3");
            return map;
        }
        if(!match.matches()){
            map.put(4,"用户名只允许英文、数字的组合");
            return map;
        }
        if(password.equals("")){
            map.put(5,"密码为空");
            return map;
        }
        if(password.length()!=6){
            map.put(6,"密码必须是6位");
            return map;
        }
        pattern = Pattern.compile(regForTestPassword);
        match=pattern.matcher(password);
        if(!match.matches()){
            map.put(7,"密码只允许英文、数字的组合");
            return map;
        }
        if(height<0){
            map.put(8,"身高必须为正");
            return map;
        }
        map.put(0,"");
        return map;
    }

    /**
     * 用户名：长度3-8，只允许英文、数字的组合
     * 密码：6位，英文、数字组合
     * */

    public HashMap<Integer,String> testLogin(String username,String password){
        HashMap<Integer,String> map = new HashMap<>();

        Pattern pattern = Pattern.compile(regForTestUsername);
        Matcher match=pattern.matcher(username);

        if(username.equals("")){
            map.put(1,"用户名为空");
            return map;
        }
        if(username.length()>8){
            map.put(2,"用户名长度不能大于8");
            return map;
        }
        if(username.length()<3){
            map.put(3,"用户名长度不能小于3");
            return map;
        }
        if(!match.matches()){
            map.put(4,"用户名只允许英文、数字的组合");
            return map;
        }
        if(password.equals("")){
            map.put(5,"密码为空");
            return map;
        }
        if(password.length()!=6){
            map.put(6,"密码必须是6位");
            return map;
        }
        map.put(0,"");
        return map;
    }

    @Test
    public void testOne(){
        String str = "zcf123";
        String reg = "[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(reg);
        Matcher match=pattern.matcher(str);
        System.out.println(match.matches());

    }

    @Test
    public void testTwo(){
        Integer str = -123;
        System.out.println(str>0);
    }
}
