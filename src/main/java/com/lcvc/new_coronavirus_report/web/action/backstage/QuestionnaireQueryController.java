package com.lcvc.new_coronavirus_report.web.action.backstage;

import com.lcvc.new_coronavirus_report.model.base.Constant;
import com.lcvc.new_coronavirus_report.model.base.JsonCode;
import com.lcvc.new_coronavirus_report.model.base.PageObject;
import com.lcvc.new_coronavirus_report.model.query.QuestionnaireQuery;
import com.lcvc.new_coronavirus_report.service.DailyReportService;
import com.lcvc.new_coronavirus_report.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/frontdesk/query")
public class QuestionnaireQueryController {

    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private DailyReportService dailyReportService;

    //获取今天的表1-1的内容
    @GetMapping("/1-1")
    public Map<String, Object> getTable1(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,dailyReportService.getDailyReportInTodayAndYesterDay());
        return map;
    }

    //获取今天的表1-2的内容
    @GetMapping("/1-2")
    public Map<String, Object> getTable2(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setComefromWuHan(true);//查询来自武汉的记录
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }


    //获取今天的表1-3的内容
    @GetMapping("/1-3")
    public Map<String, Object> getTable3(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setComefromHuBei(true);//查询来自湖北的记录
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

    //获取今天的表1-4的内容
    @GetMapping("/1-4")
    public Map<String, Object> getTable4(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setArriveWuHan(true);//查询去过武汉的记录
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

    //获取今天的表1-5的内容
    @GetMapping("/1-5")
    public Map<String, Object> getTable5(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setArriveHuBei(true);//查询去过湖北的记录
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

    //获取今天的表1-6的内容
    @GetMapping("/1-6")
    public Map<String, Object> getTable6(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setStayInHubei(true);//查询当前依旧停留在湖北的
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

    //获取今天的表1-7的内容
    @GetMapping("/1-7")
    public Map<String, Object> getTable7(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setTouchHuBeiPerson(true);//查询去过密切接触疫区人员的记录
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

    //获取今天的学生表日常记录的内容
    @GetMapping("/student")
    public Map<String, Object> getStudentTable(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setStudentQuery(true);//查询学生信息
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

    //获取今天的教师表日常记录的内容
    @GetMapping("/teacher")
    public Map<String, Object> getTeacherTable(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        QuestionnaireQuery questionnairequery=new QuestionnaireQuery();
        questionnairequery.setQueryDate(new Date());//查找今天的表内容
        questionnairequery.setTeacherQuery(true);//查询教师信息
        PageObject pageObject =questionnaireService.query(page,limit,questionnairequery);
        map.put(Constant.JSON_TOTAL,pageObject.getTotalRecords());
        map.put(Constant.JSON_DATA,pageObject.getList());
        return map;
    }

}