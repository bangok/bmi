package com.maamcare.bmi.controller;

import com.alibaba.fastjson.JSONObject;
import com.maamcare.bmi.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @PostMapping("/getWeightByDate")
    public Result getWeightByDate(@RequestBody String string) {
        JSONObject jsonObject = JSONObject.parseObject(string);
        String startDate = jsonObject.get("startDate").toString();
        String endDate = jsonObject.get("endDate").toString();
        Integer userId = Integer.parseInt(jsonObject.get("id").toString());

        if (userId == null) {
            return Result.builder().status(0).err("用户id不能为空").data(null).build();
        }
        if (startDate.equals("null") && startDate.equals("")) {
            return Result.builder().status(0).err("开始日期不能为空").data(null).build();
        }
        if (endDate.equals("null") && endDate.equals("")) {
            return Result.builder().status(0).err("结束日期不能为空").data(null).build();
        }


        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> newL = new ArrayList<String>();
        String data = "{“2019-10-5”:””}";
        newL.add(data);
        map.put("weightList", newL);
        return Result.builder().status(1).data(map).build();
    }

    @PostMapping("/saveOrUpdateWeight")
    public Result saveOrUpdateWeight(@RequestBody String string) {
        JSONObject jsonObject = JSONObject.parseObject(string);
        String date = jsonObject.get("date").toString();
        Integer weight = Integer.parseInt(jsonObject.get("weight").toString());
        Integer userId = Integer.parseInt(jsonObject.get("id").toString());
        if (userId == null) {
            return Result.builder().status(0).err("用户id不能为空").data(null).build();
        }
        if (weight == null) {
            return Result.builder().status(0).err("体重不能为空").data(null).build();
        }
        if (date.equals("")) {
            return Result.builder().status(0).err("日期不能为空").data(null).build();
        }
        return Result.builder().status(1).err("修改体重成功").data(null).build();

    }

    @PostMapping("/updateHeight")
    public Result updateHeight(@RequestBody String string) {
        JSONObject jsonObject = JSONObject.parseObject(string);
        Integer height = Integer.parseInt(jsonObject.get("height").toString());
        Integer userId = Integer.parseInt(jsonObject.get("id").toString());
        if (userId == null) {
            return Result.builder().status(0).err("用户id不能为空").data(null).build();
        }
        if (height == null) {
            return Result.builder().status(0).err("身高不能为空").data(null).build();
        }

        return Result.builder().status(1).err("修改身高成功").data(null).build();

    }


}
