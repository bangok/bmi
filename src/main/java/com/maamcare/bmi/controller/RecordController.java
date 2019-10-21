package com.maamcare.bmi.controller;


import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.pojo.TimeSlot;
import com.maamcare.bmi.service.RecordService;
import com.maamcare.bmi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    //@DateTimeFormat(pattern="yyyy-MM-dd")获取格式化日期数据

    @GetMapping("/get")
    public Result getRecordbYTimeSlot(@RequestParam Integer userid,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) {
        TimeSlot timeSlot = new TimeSlot(userid, startdate, enddate);
        System.out.println(timeSlot.toString());
        List<Record> recordbYTimeSlot = recordService.getRecordbYTimeSlot(timeSlot);
//        int count = recordService.count();
        return Result.builder().status(1).err("").data(recordbYTimeSlot).build();
    }

}
