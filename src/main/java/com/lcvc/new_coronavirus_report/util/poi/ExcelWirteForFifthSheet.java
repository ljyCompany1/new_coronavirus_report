package com.lcvc.new_coronavirus_report.util.poi;


import com.lcvc.new_coronavirus_report.model.Questionnaire;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class ExcelWirteForFifthSheet {

    /**
     * 1.5我市到过湖北省（除武汉市）的人员排查日报表（四）
     *
     * @param book 传递进来的工作部对象
     * @param list 要遍历的数据集合
     * @return
     */
    public static XSSFSheet getShee(XSSFWorkbook book,List<Questionnaire> list) {
        String header[]={"我市到过湖北省（除武汉市）的人员排查日报表（四）"};
        String title[]={"序号","姓名","身份证号","联系电话","户口住址","电话排查内容","入户排查内容","管控措施（如为居家隔离，请询问是否有社区每日随访、是否有外出买菜、下楼活动等情况）","备注"};
        String title1[]={"离开湖北省的时间","目前在柳居住地","是否有咳嗽、胸闷、发烧等不适症状","离开湖北省的时间","到柳时间","目前在柳居住地","是否有咳嗽、胸闷、发烧等不适症状","车次/航班/汽车/自驾等回柳方式","同行人姓名"};

        // 创建一个工作表
        XSSFSheet sheet = book.createSheet("表五");


        // 设置单元格表单头部样式
        XSSFCellStyle headerStyle = book.createCellStyle();
        XSSFFont headerFont = book.createFont();
        headerFont.setFontHeightInPoints((short) 16);
        headerStyle.setFont(headerFont);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER); //
        headerStyle.setWrapText(true);//自动换行


        // 设置单元格表单标题样式
        XSSFCellStyle titleStyle = book.createCellStyle();
        XSSFFont titlefont = book.createFont();
        titlefont.setFontHeightInPoints((short) 12);
        titleStyle.setFont(titlefont);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); //
        titleStyle.setWrapText(true);//自动换行

        //第二行标题栏样式
        XSSFCellStyle title1Style = book.createCellStyle();
        title1Style.setFont(titlefont);
        title1Style.setBorderBottom(BorderStyle.THIN);
        title1Style.setBorderTop(BorderStyle.THIN);
        title1Style.setBorderLeft(BorderStyle.THIN);
        title1Style.setBorderRight(BorderStyle.THIN);
        title1Style.setAlignment(HorizontalAlignment.CENTER);
        title1Style.setVerticalAlignment(VerticalAlignment.CENTER); //
        title1Style.setWrapText(true);//自动换行


        //
        //设置行
        //header
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(30);//设置行的高度是50个点
        //titie
        XSSFRow titleRow = sheet.createRow(1);
        titleRow.setHeightInPoints(25);//设置行的高度是50个点
        XSSFRow titleRow1 = sheet.createRow(2);
        titleRow1.setHeightInPoints(35);//设置行的高度是50个点

        //跨行跨列
        //header行
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 14);
        //列
        CellRangeAddress region0 = new CellRangeAddress(1, 2, 0, 0);
        CellRangeAddress region1 = new CellRangeAddress(1, 2, 1, 1);
        CellRangeAddress region2 = new CellRangeAddress(1, 2, 2, 2);
        CellRangeAddress region3 = new CellRangeAddress(1, 2, 3, 3);
        CellRangeAddress region4 = new CellRangeAddress(1, 2, 4, 4);

        //电话排查
        CellRangeAddress region5 = new CellRangeAddress(1, 1, 5, 7);
        //户口排查
        CellRangeAddress region6 = new CellRangeAddress(1, 1, 8, 13);
        //管控
        CellRangeAddress region7 = new CellRangeAddress(1, 2, 14, 14);
        //备注
        CellRangeAddress region8 = new CellRangeAddress(1, 2, 15, 15);

        sheet.addMergedRegion(region);
        sheet.addMergedRegion(region0);
        sheet.addMergedRegion(region1);
        sheet.addMergedRegion(region2);
        sheet.addMergedRegion(region3);
        sheet.addMergedRegion(region4);
        sheet.addMergedRegion(region5);
        sheet.addMergedRegion(region6);
        sheet.addMergedRegion(region7);
        sheet.addMergedRegion(region8);

        //添加表头栏
        for (int i = 0; i <16 ; i++) {
            XSSFCell headerCell= headerRow.createCell(i);
            sheet.setColumnWidth(i, 15 * 256);//设置第i列的宽度是31个字符宽度
            headerCell.setCellStyle(headerStyle);
            if (i==0){
                headerCell.setCellValue(header[0]);
            }
        }

        int j=0;
        for (int i = 0; i <16 ; i++) {
            XSSFCell titleCell= titleRow.createCell(i);
            XSSFCell titleCell1= titleRow1.createCell(i);
            sheet.setColumnWidth(i, 15 * 256);//设置第i列的宽度是31个字符宽度
            titleCell.setCellStyle(titleStyle);
            titleCell1.setCellStyle(titleStyle);
            if (i<5){
                titleCell.setCellValue(title[i]);

            }
            if (i==5){
                titleCell.setCellValue(title[5]);
            }
            if (i>=5&&i<=13&&j<title1.length){
                titleCell1.setCellValue(title1[j]);
                j++;
            }

            if (i==8){
                titleCell.setCellValue(title[6]);
            }
            if (i==14){
                titleCell.setCellValue(title[7]);
            }
            if (i==15)titleCell.setCellValue(title[8]);
        }

        for (int i = 0; i <list.size() ; i++) {
            XSSFRow listRow = sheet.createRow(i+3);
            listRow.setHeightInPoints(35);//设置行的高度是50个点

            XSSFCell id= listRow.createCell(0);
            id.setCellValue(list.get(i).getId());
            id.setCellStyle(titleStyle);

            XSSFCell name= listRow.createCell(1);
            name.setCellValue(list.get(i).getName());
            name.setCellStyle(titleStyle);

            XSSFCell identityCard= listRow.createCell(2);
            identityCard.setCellValue(list.get(i).getIdentityCard());
            identityCard.setCellStyle(titleStyle);

            XSSFCell tel= listRow.createCell(3);
            tel.setCellValue(list.get(i).getTel());
            tel.setCellStyle(titleStyle);

            XSSFCell registeredPlace= listRow.createCell(4);
            registeredPlace.setCellValue(list.get(i).getRegisteredPlace());
            registeredPlace.setCellStyle(titleStyle);
            //电话排查内容
            XSSFCell telLeaveHubei= listRow.createCell(5);
            if (list.get(i).getLeaveHubei()!=null){
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                telLeaveHubei.setCellValue(formatter.format(list.get(i).getLeaveHubei()));
            }
            telLeaveHubei.setCellStyle(titleStyle);

            XSSFCell telAddressInLiuZhou= listRow.createCell(6);
            telAddressInLiuZhou.setCellValue(list.get(i).getAddressInLiuZhou());
            telAddressInLiuZhou.setCellStyle(titleStyle);

            XSSFCell telMyHealth= listRow.createCell(7);
            telMyHealth.setCellValue(list.get(i).getMyHealth());
            telMyHealth.setCellStyle(titleStyle);
            //入户排查内容
            XSSFCell intoLeaveHubei= listRow.createCell(8);
            if (list.get(i).getLeaveHubei()!=null){
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                intoLeaveHubei.setCellValue(formatter.format(list.get(i).getLeaveHubei()));
            }
            intoLeaveHubei.setCellStyle(titleStyle);

            XSSFCell intoArriveLiuZhou= listRow.createCell(9);
            intoArriveLiuZhou.setCellValue(list.get(i).getArriveLiuZhou());
            if (list.get(i).getArriveLiuZhou()!=null){
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                intoArriveLiuZhou.setCellValue(formatter.format(list.get(i).getArriveLiuZhou()));
            }
            intoArriveLiuZhou.setCellStyle(titleStyle);

            XSSFCell intoAddressInLiuZhou= listRow.createCell(10);
            intoAddressInLiuZhou.setCellValue(list.get(i).getAddressInLiuZhou());
            intoAddressInLiuZhou.setCellStyle(titleStyle);

            XSSFCell intoMyHealth= listRow.createCell(11);
            intoMyHealth.setCellValue(list.get(i).getMyHealth());
            intoMyHealth.setCellStyle(titleStyle);

            XSSFCell intoLeaveHubeiWay= listRow.createCell(12);
            intoLeaveHubeiWay.setCellValue(list.get(i).getLeaveHubeiWay());
            intoLeaveHubeiWay.setCellStyle(titleStyle);

            XSSFCell intoLeaveTogetherPersonName= listRow.createCell(13);
            intoLeaveTogetherPersonName.setCellValue(list.get(i).getLeaveTogetherPersonName());
            intoLeaveTogetherPersonName.setCellStyle(titleStyle);

            //管控措施  备注
            XSSFCell manageMethods= listRow.createCell(14);
            manageMethods.setCellValue(list.get(i).getManageMethods());
            manageMethods.setCellStyle(titleStyle);

            XSSFCell intro= listRow.createCell(15);
            intro.setCellValue(list.get(i).getIntro());
            intro.setCellStyle(titleStyle);
        }



        return sheet;
    }
}
