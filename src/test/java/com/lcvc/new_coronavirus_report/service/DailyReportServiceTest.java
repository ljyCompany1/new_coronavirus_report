package com.lcvc.new_coronavirus_report.service;

import com.lcvc.new_coronavirus_report.model.DailyReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DailyReportServiceTest {
    @Autowired
    private DailyReportService dailyReportService;



    @Test
    public void testSaveDailyReportInToday(){
        DailyReport dailyReport=dailyReportService.countDailyReportInOneDay(new Date());
        System.out.println(dailyReport.getComefromWuHanNumber());
        System.out.println(dailyReport.getComefromWuHanNumber());
        System.out.println(dailyReport.getArriveWuHanNumber());
        System.out.println(dailyReport.getArriveHuBeiNumber());
        System.out.println(dailyReport.getTouchHuBeiPersonNumber());
        System.out.println(dailyReport.getStayInHubeiNumber());
    }

    @Test
    public void testSaveDailyReportInOneDay(){
        dailyReportService.saveDailyReportInOneDay(new Date());
    }
}
