package com.lcvc.new_coronavirus_report.web.action.frontdesk;

import com.lcvc.new_coronavirus_report.model.base.Constant;
import com.lcvc.new_coronavirus_report.model.base.JsonCode;
import com.lcvc.new_coronavirus_report.service.StudentService;
import com.lcvc.new_coronavirus_report.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/frontdesk/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    //读取指定教师信息
    @GetMapping("/{studentNumber}")
    public Map<String, Object> doPostQuestionnaire(@PathVariable String studentNumber){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,studentService.get(studentNumber));
        return map;
    }

}
