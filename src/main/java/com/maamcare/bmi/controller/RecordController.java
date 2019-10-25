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
        //注意：如果使用的是java.utill.date，那么需要格式转换字符串，如果使用java.sql.date则可以直接使用.toString()
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        TimeSlot timeSlot = new TimeSlot(userid,sdf.format(startdate), sdf.format(enddate));
        System.out.println(timeSlot.toString());
        List<Record> recordList = recordService.getRecordbYTimeSlot(timeSlot);
        return Result.builder().status(1).err("{code:0,msg:null}").data(recordList).build();
    }

    @GetMapping("/addRecord")
    public Result addRecord(@RequestParam  Integer userid,
                                      @RequestParam  Integer weight,
                                      @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date record_date) {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Record record = new Record();
        record.setUserid(userid);
        record.setWeight(weight);
        record.setRecord_date(sdf.format(record_date));
        System.out.println(record.toString());
        return Result.builder().status(1).err("{code:0,msg:null}").data(recordService.addRecord(record)).build();

    }

    @GetMapping("/updateWeightById")
    public Result updateWeightById(@RequestParam  Integer id,
                                   @RequestParam  Integer weight) {

        return Result.builder().status(1).err("{code:0,msg:null}").data(recordService.updateWeightById(id,weight)).build();
    }

}
