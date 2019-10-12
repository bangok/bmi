package com.maamcare.bmi.dao;

import com.maamcare.bmi.po.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TestMapper {
    public Test getAllData();
}
