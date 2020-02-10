package com.lcvc.new_coronavirus_report.schedule;

import com.lcvc.new_coronavirus_report.service.DailyReportService;
import com.lcvc.new_coronavirus_report.util.date.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class AutomationSchedule {


    @Autowired
    private DailyReportService dailyReportService;

    /**
     * 统计昨天的重点人群排查管理日报表，存入数据库
     * 设计为每天上午5点10分执行自动购买
     */
    @Scheduled(cron = "0 34 15 ? * *")
    public void saveDailyReportYesterday(){
        Date yesterday= MyDateUtil.getDateBefore(new Date(),1);//获取昨天的日期
        dailyReportService.saveDailyReportInOneDay(yesterday);//保存昨天的日志表
    }

}
