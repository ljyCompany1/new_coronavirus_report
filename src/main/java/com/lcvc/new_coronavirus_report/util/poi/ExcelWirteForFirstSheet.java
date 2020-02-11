package com.lcvc.new_coronavirus_report.util.poi;

import com.lcvc.new_coronavirus_report.model.form.DailyReportTable;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 处理1-1表
 */
@Service
public class ExcelWirteForFirstSheet {

    /**
     * 创建一个工作表，方便扩展（如果后续需要工作表合并，会容易很多）
     * @param book 传递进来的工作部对象
     * @param dailyReportTable 日志表
     * @return
     */
    public static XSSFSheet getShee1(XSSFWorkbook book, DailyReportTable dailyReportTable){
        // 创建工作表
        XSSFSheet sheet = book.createSheet("1.1");
        //在索引0的位置创建行（最顶端的行）
        XSSFRow firstRow = sheet.createRow(0);
        //记录字段（表格的列）
        String[] options = { "姓名","性别", "电话",};
        //根据集合长度创建第一行单元格数组
        XSSFCell[] firstCells = new XSSFCell[options.length];
        //根据字段，在第一行创建相应的字段值
        for (int j = 0; j < options.length; j++) {
            firstCells[j] = firstRow.createCell(j);
            //用字符串表示
            firstCells[j].setCellValue(new XSSFRichTextString(options[j]));
        }
        //从第将记录填入^……………………自己填

        return sheet;
    }
}
