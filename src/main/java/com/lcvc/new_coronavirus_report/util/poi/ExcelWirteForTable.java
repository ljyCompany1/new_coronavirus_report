package com.lcvc.new_coronavirus_report.util.poi;

import com.lcvc.new_coronavirus_report.model.Questionnaire;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 负责处理所有要导出的表格
 */
@Service
public class ExcelWirteForTable {


    /**
     * 将数据表1.2
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel2(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForSecondSheet.getShee1(book,list);
        //创建工作表2——班级列表
        //getSheetOfSchoolClass(book,schoolClassList);
        return book;
    }

    /**
     * 将数据表1.3——张峰，后续自己添加
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel3(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForSecondSheet.getShee1(book,list);
        //创建工作表2——班级列表
        //getSheetOfSchoolClass(book,schoolClassList);
        return book;
    }
}
