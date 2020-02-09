package com.lcvc.new_coronavirus_report.service;

import com.lcvc.new_coronavirus_report.dao.QuestionnaireDao;
import com.lcvc.new_coronavirus_report.dao.StudentDao;
import com.lcvc.new_coronavirus_report.dao.TeacherDao;
import com.lcvc.new_coronavirus_report.model.Questionnaire;
import com.lcvc.new_coronavirus_report.model.Student;
import com.lcvc.new_coronavirus_report.model.Teacher;
import com.lcvc.new_coronavirus_report.model.exception.MyServiceException;
import com.lcvc.new_coronavirus_report.model.exception.MyWebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 负责处理调查表信息
 *
 */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
@Validated//表示开启sprint的校检框架，会自动扫描方法里的@Valid（@Valid注解一般写在接口即可）
@Service
public class QuestionnaireService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private QuestionnaireDao questionnaireDao;
    /**
     * 保存表格
     */
    public void saveReport(@NotNull Questionnaire questionnaire){
        //验证教工号或学号，并赋予相应信息
        if(questionnaire.getIdentity().equals("teacher")){
            if(StringUtils.isEmpty(questionnaire.getWorkType())){
                throw new MyWebException("提交失败：必须填写教师工作岗位");
            }
            Teacher teacher=teacherDao.get(questionnaire.getTeacherNumber());//从教工号读取教师信息
            if(teacher!=null){
                if(questionnaireDao.getQuestionnaireNumberByTeacherToday(teacher.getTeacherNumber())>0){
                    throw new MyServiceException("提交失败：今天已经提交过调查表，请明天再来");
                }
                questionnaire.setName(teacher.getName());//获取姓名
                questionnaire.setSex(teacher.getSex());//获取性别
                questionnaire.setIdentityCard(teacher.getIdentityCard());//获取身份证
                //questionnaire.setTel(teacher.getTel());// 电话号码为了保证准确性，暂时都自己填
            }else{
                throw new MyWebException("提交失败：该教工号不存在");
            }
        }else if(questionnaire.getIdentity().equals("student")){
            if(questionnaire.getPractice()==null){
                throw new MyWebException("提交失败：必须填写是否在实习");
            }
            Student student=studentDao.get(questionnaire.getStudentNumber());//从学号读取学生信息
            if(student!=null){
                if(questionnaireDao.getQuestionnaireNumberByStudentToday(student.getStudentNumber())>0){
                    throw new MyServiceException("提交失败：今天已经提交过调查表，请明天再来");
                }
                questionnaire.setName(student.getName());
                questionnaire.setSex(student.getSex());
                questionnaire.setIdentityCard(student.getIdentityCard());
                //questionnaire.setTel(student.getTel());// 电话号码为了保证准确性，暂时都自己填
            }else{
                throw new MyWebException("提交失败：该学生号不存在");
            }
        }else{
            throw new MyWebException("提交失败：数据异常");
        }
        //对其他字段进行验证
        //常规字段
        if(StringUtils.isEmpty(questionnaire.getMyHealth())){
            throw new MyWebException("提交失败：必须填写本人健康状况");
        }
        if(StringUtils.isEmpty(questionnaire.getMyHealth())){
            throw new MyWebException("提交失败：必须填写本人家庭成员的健康状况");
        }
        if(questionnaire.getTouchHuBeiPerson()==null){
            throw new MyWebException("提交失败：必须填写是否密切接触来自或到达过武汉及湖北其他地区人员");
        }
        if(questionnaire.getConfirmIll()==null){
            throw new MyWebException("提交失败：必须填写是否为疑似病例或确诊病例");
        }

        //如果来自武汉湖北的市外人员
        if(questionnaire.getComefromHuBei()||questionnaire.getComefromWuHan()){
            if(questionnaire.getLeaveHubei()==null){
                throw new MyWebException("提交失败：必须填写离开湖北的时间");
            }
            if(StringUtils.isEmpty(questionnaire.getLeaveHubeiWay())){
                throw new MyWebException("提交失败：必须填写回柳州的方式：车次/航班/汽车/自驾等");
            }
        }
        //检查是去过湖北或武汉
        if(questionnaire.getArriveHuBei()||questionnaire.getArriveWuHan()){//如果去过武汉湖北，但可能还没回来，所以一些字段不做限制
            if(questionnaire.getLeaveLiuZhou()==null){
                throw new MyWebException("提交失败：必须填写离柳时间");
            }
            if(StringUtils.isEmpty(questionnaire.getRegisteredPlace())){//户口地址
                throw new MyWebException("提交失败：必须填写户口地址");
            }
            if(StringUtils.isEmpty(questionnaire.getEpidemicArea())){//疫区居住地
                throw new MyWebException("提交失败：必须填写疫区居住地");
            }
        }

        //满足任何一个需要上报条件的（湖北来的人，去过湖北，接触过疫区）
        if(questionnaire.getComefromHuBei()||questionnaire.getComefromWuHan()||questionnaire.getArriveHuBei()||questionnaire.getArriveWuHan()||questionnaire.getTouchHuBeiPerson()){//如果去过武汉湖北
            if(StringUtils.isEmpty(questionnaire.getAddressInLiuZhou())){//柳州居住地
                throw new MyWebException("提交失败：必须填写在柳州的居住地");
            }
            if(questionnaire.getArriveLiuZhou()==null){
                throw new MyWebException("提交失败：必须填写回柳时间");
            }
        }
        //都验证通过了，就保存表单信息
        questionnaireDao.save(questionnaire);//保存调查表所有信息
        //保存到日常居家观察健康状况表
        if(questionnaire.getIdentity().equals("teacher")){
            //保存到教师记录表
        }else{
            //保存到学生记录表
        }
    }

}
