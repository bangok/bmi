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
    public HashMap<String,String> testRegister(String username,String password,Integer height){
        HashMap<String,String> map = new HashMap<>();

        Pattern pattern = Pattern.compile(regForTestUsername);
        Matcher match=pattern.matcher(username);

        if(username.equals("")){
            map.put("code","1");
            map.put("msg","用户名为空");
            return map;
        }
        if(username.length()>8){
            map.put("code","2");
            map.put("msg","用户名长度不能大于8");
            return map;
        }
        if(username.length()<3){
            map.put("code","3");
            map.put("msg","用户名长度不能小于3");
            return map;
        }
        if(!match.matches()){
            map.put("code","4");
            map.put("msg","用户名只允许英文、数字");
            return map;
        }
        if(password.equals("")){
            map.put("code","6");
            map.put("msg","密码为空");
            return map;
        }
        if(password.length()!=6){
            map.put("code","7");
            map.put("msg","密码长度必须为6");
            return map;
        }
        map.put("code","0");
        map.put("msg","");
        return map;
    }

    /**
     * 用户名：长度3-8，只允许英文、数字的组合
     * 密码：6位，英文、数字组合
     * */

    public HashMap<String,String> testLogin(String username,String password){
        HashMap<String,String> map = new HashMap<>();

        Pattern pattern = Pattern.compile(regForTestUsername);
        Matcher match=pattern.matcher(username);

        if(username.equals("")){
            map.put("code","1");
            map.put("msg","用户名为空");
            return map;
        }
        if(username.length()>8){
            map.put("code","2");
            map.put("msg","用户名长度不能大于8");
            return map;
        }
        if(username.length()<3){
            map.put("code","3");
            map.put("msg","用户名长度不能小于3");
            return map;
        }
        if(!match.matches()){
            map.put("code","4");
            map.put("msg","用户名只允许英文、数字");
            return map;
        }
        if(password.equals("")){
            map.put("code","6");
            map.put("msg","密码为空");
            return map;
        }
        if(password.length()!=6){
            map.put("code","7");
            map.put("msg","密码长度必须为6");
            return map;
        }
        map.put("code","0");
        map.put("msg","");
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
