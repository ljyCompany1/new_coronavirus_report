package com.lcvc.new_coronavirus_report.util.poi;

import com.lcvc.new_coronavirus_report.model.DailyReport;
import com.lcvc.new_coronavirus_report.model.Questionnaire;
import com.lcvc.new_coronavirus_report.model.form.DailyReportTable;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 负责处理所有要导出的表格
 */
@Service
public class ExcelWirteForTable {

    /**
     * 1.1重点人群排查管理日报表
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel1(DailyReportTable list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForFisrtSheet.getShee1(book,list);
        return book;
    }

    /**
     * 1.2来自武汉市的市外人员排查日报表（一）
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel2(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForSecondSheet.getShee2(book,list);
        return book;
    }

    /**
     * 1.3来自湖北省（除武汉市）的市外人员排查日报表（二）
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel3(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForThirdSheet.getShee3(book,list);
        return book;
    }
    /**
     * 1.4我市到过武汉市的人员排查日报表（三）
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel4(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForFourthSheet.getShee4(book,list);
        return book;
    }
    /**
     * 1.5我市到过湖北省（除武汉市）的人员排查日报表（四）
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel5(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForFifthSheet.getShee5(book,list);
        return book;
    }
    /**
     * 1.5我市到过湖北省（除武汉市）的人员排查日报表（四）
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel6(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForFifthSheet.getShee5(book,list);
        return book;
    }
}
