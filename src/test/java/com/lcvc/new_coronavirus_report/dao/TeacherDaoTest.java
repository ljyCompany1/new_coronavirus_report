package com.lcvc.new_coronavirus_report.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDaoTest{

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testGet(){
        System.out.println(teacherDao.get("2006010018").getName());
    }

}
