package com.lcvc.new_coronavirus_report.util.poi;

import com.lcvc.new_coronavirus_report.model.Questionnaire;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 处理1-2表
 */
@Service
public class ExcelWirteForSecondTable {

    /**
     * 将数据导出
     * @param output 输出
     * @param list 要遍历的数据集合
     */
    public static void writeExcel(ByteArrayOutputStream output, List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        getShee1(book,list);
        //创建工作表2——班级列表
        //getSheetOfSchoolClass(book,schoolClassList);
        try {
            book.write(output);
        }  catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                output.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                output=null;
            }
        }
    }


    /**
     * 将数据导出
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getExcel(List<Questionnaire> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        getShee1(book,list);
        //创建工作表2——班级列表
        //getSheetOfSchoolClass(book,schoolClassList);
        return book;
    }

    /**
     * 创建第一个工作表，方便扩展（如果后续需要工作表合并，会容易很多）
     * @param book 传递进来的工作部对象
     * @param list 要遍历的数据集合
     * @return
     */
    private static XSSFSheet getShee1(XSSFWorkbook book, List<Questionnaire> list){
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
        //从第二行开始将记录填入
        int countColumnNum=list.size();
        for (int i = 0; i < countColumnNum; i++) {
            XSSFRow row = sheet.createRow(i + 1);
            Questionnaire questionnaire = list.get(i);
            XSSFCell name = row.createCell(0);
            XSSFCell sex = row.createCell(1);
            XSSFCell tel = row.createCell(2);
            name.setCellValue(questionnaire.getName());
            sex.setCellValue(questionnaire.getSex());
            tel.setCellValue(questionnaire.getTel());
        }
        return sheet;
    }
}
