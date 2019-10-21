package com.maamcare.bmi.service;

import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.pojo.TimeSlot;

import java.util.List;

public interface RecordService {
    public List<Record> getRecordbYTimeSlot(TimeSlot timeSlot);
    public boolean addRecord(Record record);
    public boolean updateWeightById(Integer id,Integer weight);

}
