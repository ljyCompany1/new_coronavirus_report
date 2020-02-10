package com.lcvc.new_coronavirus_report.dao;

import com.lcvc.new_coronavirus_report.model.Teacher;
import com.lcvc.new_coronavirus_report.model.TeacherQuestionnaire;
import org.springframework.stereotype.Repository;

@Repository//为了不让idea报错加上
public interface TeacherQuestionnaireDao extends IBaseDao<TeacherQuestionnaire>{
}
