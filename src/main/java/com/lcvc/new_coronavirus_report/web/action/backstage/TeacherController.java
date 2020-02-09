package com.lcvc.new_coronavirus_report.web.action.backstage;

import com.lcvc.new_coronavirus_report.model.Questionnaire;
import com.lcvc.new_coronavirus_report.model.Teacher;
import com.lcvc.new_coronavirus_report.model.base.Constant;
import com.lcvc.new_coronavirus_report.model.base.JsonCode;
import com.lcvc.new_coronavirus_report.service.AdminService;
import com.lcvc.new_coronavirus_report.service.QuestionnaireService;
import com.lcvc.new_coronavirus_report.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController(value = "/api/backstage/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    //读取指定教师信息
    @GetMapping("/{teacherNumber}")
    public Map<String, Object> doPostQuestionnaire(@PathVariable String teacherNumber){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,teacherService.get(teacherNumber));
        return map;
    }

}
