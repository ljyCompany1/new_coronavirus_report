package com.lcvc.new_coronavirus_report.service;

import com.lcvc.new_coronavirus_report.dao.QuestionnaireDao;
import com.lcvc.new_coronavirus_report.model.Questionnaire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireServiceTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Test
    public void testSave(){
        //创建对象
        Questionnaire questionnaire=new Questionnaire();
        //根据逻辑一个一个字段进行验证

        //录入各个字段信息进行保存
        questionnaire.setName("历史");
        questionnaire.setTeacherNumber("123123132");
        questionnaire.setStudentNumber("123132132");
        questionnaire.setSex("男");
        questionnaire.setRegisteredPlace("五星街");
        questionnaire.setIdentityCard("111112222233333111");
        questionnaire.setTel("17878011321");
        questionnaire.setWorkType("软件技术");
        questionnaire.setPractice(true);
        questionnaire.setComefromHuBei(false);
        questionnaire.setComefromWuHan(false);
        questionnaire.setArriveHuBei(false);
        questionnaire.setEpidemicArea("武汉不知道那里");
        questionnaire.setAddressInLiuZhou("l柳州着");
        questionnaire.setManageMethods("管理方式很严格哦");
        questionnaire.setArriveLiuZhou(new Date());
        questionnaire.setLeaveLiuZhou(new Date());
        questionnaire.setLeaveHubeiWay("wu");
        questionnaire.setLeaveTogetherPersonName("zhangzhang");
        questionnaire.setTouchHuBeiPerson(false);
        questionnaire.setConfirmIll(false);
        questionnaire.setMyfamilyHealth("健康");
        questionnaire.setMyHealth("健康");
        questionnaire.setIntro("wuwuw");
        questionnaire.setIp("123.1.1");
        questionnaireService.save(questionnaire);//保存后去数据库检查相关字段是否有值
        //questionnaireDao.save(questionnaire);//保存后去数据库检查相关字段是否有值
    }

}
