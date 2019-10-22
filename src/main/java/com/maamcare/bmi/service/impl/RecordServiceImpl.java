package com.maamcare.bmi.service.impl;


import com.maamcare.bmi.dao.RecordMapper;
import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.pojo.TimeSlot;
import com.maamcare.bmi.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    /**
     * 获取一段时间内的体重记录
     * */
    @Override
    public List<Record> getRecordbYTimeSlot(TimeSlot timeSlot) {
        return recordMapper.getRecordbYTimeSlot(timeSlot);
    }

    /**
     * 增加一条体重记录
     * */
    @Override
    public boolean addRecord(Record record) {
        return recordMapper.addRecord(record);
    }

    /**
     * 更新一条体重记录
     * */
    @Override
    public boolean updateWeightById(Integer id, Integer weight) {
        return recordMapper.updateWeightById(id,weight);
    }
}
