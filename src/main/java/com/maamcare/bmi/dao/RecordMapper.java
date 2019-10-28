package com.maamcare.bmi.dao;

import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.pojo.TimeSlot;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RecordMapper {
    public List<Record> getRecordbYTimeSlot(TimeSlot timeSlot);
    public boolean addRecord(Record record);
    public boolean updateWeightById(@Param(value = "id") Integer id,@Param(value = "weight") Integer weight);
    public List<Record> getRecordbYUseridAndDate(@Param(value = "record_date") String record_date,@Param(value = "userid") Integer userid);
}
