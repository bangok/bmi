package com.maamcare.bmi.service.impl;

import com.maamcare.bmi.dao.TestMapper;
import com.maamcare.bmi.po.Test;
import com.maamcare.bmi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author：张昌飞
 * Time：2019年10月12日14:11:03
 * Description：测试Java环境
 *
 * */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public Test getAllData() {
        return testMapper.getAllData();
    }
}
