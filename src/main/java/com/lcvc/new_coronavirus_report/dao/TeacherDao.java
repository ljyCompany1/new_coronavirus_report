package com.lcvc.new_coronavirus_report.dao;

import com.lcvc.new_coronavirus_report.model.Student;
import com.lcvc.new_coronavirus_report.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository//为了不让idea报错加上
public interface TeacherDao extends IBaseDao<Teacher>{

}
