package com.lcvc.new_coronavirus_report.dao;

import com.lcvc.new_coronavirus_report.model.DailyReport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository//为了不让idea报错加上
public interface DailyReportDao extends IBaseDao<DailyReport>{


}
