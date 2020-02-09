package com.lcvc.new_coronavirus_report.dao;

import com.lcvc.new_coronavirus_report.model.Admin;
import com.lcvc.new_coronavirus_report.model.Questionnaire;
import org.springframework.stereotype.Repository;

@Repository//为了不让idea报错加上
public interface QuestionnaireDao extends IBaseDao<Questionnaire>{

    /**
     * 获取该教师今天填写的调查表数量
     * @param teacherNumber
     * @return 返回整数
     */
    int getQuestionnaireNumberByTeacherToday(String teacherNumber);

    /**
     * 获取该学生今天填写的调查表数量
     * @param studentNumber
     * @return 返回整数
     */
    int getQuestionnaireNumberByStudentToday(String studentNumber);

}
