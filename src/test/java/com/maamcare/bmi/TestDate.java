package com.maamcare.bmi;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    @Test
    public void test1(){
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        try {
            date = format1.parse("2019-10-19");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());

    }
}
