package com.lcvc.new_coronavirus_report.dao;

import com.lcvc.new_coronavirus_report.model.Questionnaire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireDaoTest {

    @Autowired
    private QuestionnaireDao questionnaireDao;

    @Test
    public void testSave(){
        //创建对象
        Questionnaire questionnaire=new Questionnaire();
        //录入各个字段信息进行保存

        questionnaireDao.save(questionnaire);//保存后去数据库检查相关字段是否有值
    }

}
