package com.lcvc.new_coronavirus_report.model.form;

import com.lcvc.new_coronavirus_report.model.DailyReport;

import java.util.Date;

/**
 * 重点人群排查管理日报表
 * 提供给表1-1作为返回对象使用
 */
public class DailyReportTable {
    DailyReport dailyReportToday;//获取今天的统计数据
    DailyReport dailyReportInYesterday;//获取昨天的统计数据

    public DailyReport getDailyReportToday() {
        return dailyReportToday;
    }

    public void setDailyReportToday(DailyReport dailyReportToday) {
        this.dailyReportToday = dailyReportToday;
    }

    public DailyReport getDailyReportInYesterday() {
        return dailyReportInYesterday;
    }

    public void setDailyReportInYesterday(DailyReport dailyReportInYesterday) {
        this.dailyReportInYesterday = dailyReportInYesterday;
    }
}
