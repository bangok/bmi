package com.maamcare.bmi;

import com.maamcare.bmi.po.Record;
import com.maamcare.bmi.pojo.TimeSlot;
import com.maamcare.bmi.service.RecordService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordServiceTest {

    @Autowired
    private RecordService recordService;

    @Test
    public  void  testGetRecordbYTimeSlotWithNormalExceptSuccess(){
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.enddate = "2019-10-25";
        timeSlot.startdate = "2019-10-10";
        timeSlot.userid = 1;
      List<Record> list= recordService.getRecordbYTimeSlot(timeSlot);
        Assertions.assertThat(list).isNotNull();

    }
    @Test
    public  void  testaddRecordWithNormalExceptSuccess(){
        Record record = new Record();
        record.userid = 1;
        record.weight = 680;
        record.record_date = "2019-10-22";

        Boolean isSuccess = recordService.addRecord(record);
        Assertions.assertThat(isSuccess).isTrue();

    }
    @Test
    public  void  testupdateWeightByIdWithNormalExceptSuccess(){
        Integer userId = 2;
        Integer weight = 700;

        Boolean isSuccess = recordService.updateWeightById(userId,weight);
        Assertions.assertThat(isSuccess).isTrue();

    }
}
