package com.maamcare.bmi.controller;


import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.pojo.TimeSlot;
import com.maamcare.bmi.service.RecordService;
import com.maamcare.bmi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    //@DateTimeFormat(pattern="yyyy-MM-dd")获取格式化日期数据


    @GetMapping("/getRecordbYTimeSlot")
    public Result getRecordbYTimeSlot(@RequestParam  Integer userid,
                                      @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate,
                                      @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate) {
        //数据校验
        HashMap<String,String> checkMap = new HashMap<>();
        if(userid<0){
            checkMap.put("code","1");
            checkMap.put("msg","用户id不允许为负");
            return Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        if(startdate.getTime()>enddate.getTime()){
            checkMap.put("code","2");
            checkMap.put("msg","开始时间不能大于结束时间");
            return Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        //注意：如果使用的是java.utill.date，那么需要格式转换字符串，如果使用java.sql.date则可以直接使用.toString()
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        TimeSlot timeSlot = new TimeSlot(userid,sdf.format(startdate), sdf.format(enddate));
        List<Record> recordList = recordService.getRecordbYTimeSlot(timeSlot);
        return Result.builder()
                .status(1)
                .err(null)
                .data(recordList)
                .build();
    }

    @GetMapping("/addRecord")
    public Result addRecord(@RequestParam  Integer userid,
                                      @RequestParam  Integer weight,
                                      @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date record_date) {
        HashMap<String,String> checkMap = new HashMap<>();
        if(userid<0){
            checkMap.put("code","1");
            checkMap.put("msg","用户id不允许为负");
            return Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        if(weight<0){
            checkMap.put("code","2");
            checkMap.put("msg","体重不允许为负");
            return Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Record record = new Record();
        record.setUserid(userid);
        record.setWeight(weight);
        record.setRecord_date(sdf.format(record_date));
        try {
            recordService.addRecord(record);
            return Result.builder()
                    .status(1)
                    .err(null)
                    .data(null)
                    .build();
        } catch (Exception e) {
            HashMap<String,String> errMap = new HashMap<>();
            errMap.put("code","-1");
            errMap.put("msg",e.getMessage());
            return Result.builder()
                    .status(0)
                    .err(errMap)
                    .data(null)
                    .build();
        }

    }

    @GetMapping("/updateWeightById")
    public Result updateWeightById(@RequestParam  Integer id,
                                   @RequestParam  Integer weight) {
        HashMap<String,String> checkMap = new HashMap<>();
        if(id<0){
            checkMap.put("code","1");
            checkMap.put("msg","id不允许为负数");
            return Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        if(weight<0){
            checkMap.put("code","2");
            checkMap.put("msg","体重不允许为负数");
            return Result.builder()
                    .status(0)
                    .err(checkMap)
                    .data(null)
                    .build();
        }
        try {
            return Result.builder()
                    .status(1)
                    .err(null)
                    .data(recordService.updateWeightById(id,weight))
                    .build();
        } catch (Exception e) {
            HashMap<String,String> errMap = new HashMap<>();
            errMap.put("code","-1");
            errMap.put("msg",e.getMessage());
            return Result.builder()
                    .status(0)
                    .err(errMap)
                    .data(null)
                    .build();
        }
    }

}
