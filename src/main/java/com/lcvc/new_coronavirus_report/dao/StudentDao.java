package com.lcvc.new_coronavirus_report.dao;

import com.lcvc.new_coronavirus_report.model.Admin;
import com.lcvc.new_coronavirus_report.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository//为了不让idea报错加上
public interface StudentDao extends IBaseDao<Student>{

}
