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

    @Override
    public List<Record> getRecordbYTimeSlot(TimeSlot timeSlot) {
        System.out.println(timeSlot.toString());
        return recordMapper.getRecordbYTimeSlot(timeSlot);
    }

    @Override
    public boolean addRecord(Record record) {
        return recordMapper.addRecord(record);
    }

    @Override
    public boolean updateWeightById(Integer id, Integer weight) {
        return recordMapper.updateWeightById(id,weight);
    }

    @Override
    public int count() {
        return recordMapper.count();
    }
}
