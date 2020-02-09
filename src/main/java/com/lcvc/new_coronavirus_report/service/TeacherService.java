package com.lcvc.new_coronavirus_report.service;

import com.lcvc.new_coronavirus_report.dao.AdminDao;
import com.lcvc.new_coronavirus_report.dao.TeacherDao;
import com.lcvc.new_coronavirus_report.model.Admin;
import com.lcvc.new_coronavirus_report.model.Teacher;
import com.lcvc.new_coronavirus_report.model.exception.MyWebException;
import com.lcvc.new_coronavirus_report.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
@Validated//表示开启sprint的校检框架，会自动扫描方法里的@Valid（@Valid注解一般写在接口即可）
@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;


    /**
     * 根据tteacherNumber读取指定记录
     * @param teacherNumber
     * @return
     */
    public Teacher get(@NotNull String teacherNumber) {
        return teacherDao.get(teacherNumber);
    }

}
