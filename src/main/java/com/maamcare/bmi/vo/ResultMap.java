package com.maamcare.bmi.vo;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
    public static Map<String,String> getNullMap(){
        Map<String,String> map = new HashMap();
        map.put("code","0");
        map.put("msg","");
        return map;
    }
}
