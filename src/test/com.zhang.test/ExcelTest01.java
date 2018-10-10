package com.zhang.test;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Create By ZhangSenWei on 2018/7/18
 **/
public class ExcelTest01 {
    public static void main(String[] args) throws IOException {
        String sheetNmae = "用车统计表单";
        String titleName = "用车申请数据统计表";
        String fileName = "用车申请统计表单";
        int columnNumber = 3;
        int[] columnWidth = {10, 20 ,30};
        String[][] dataList = {{"001","2018-07-18","IT"},{"002","2018-07-19","市场部门"},{"003","2018-07-20","测试"}};
        String[] columnName = {"单号","申请时间", "申请部门"};

        new ExcelTest01().EportNoRespnse(sheetNmae, titleName, fileName, columnNumber, columnWidth,columnName, dataList);
    }



    public  void EportNoRespnse(String sheetNmae,String titleName,String fileName,
                                int columnNumber, int[] columnWidth, String[] columnName, String[][] dataList) throws IOException {
        if(columnNumber == columnWidth.length && columnWidth.length == columnName.length){
            //第一步,创建一个webbook，对应一个Excel
            HSSFWorkbook wb =new HSSFWorkbook();
            //第二步，在webbook中添加一个sheet,对应的Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet();
            for (int i = 0; i < columnNumber; i++){
                for (int j = 0; j <= i; j++){
                    if (i == j){
                        //单独设置列宽
                        sheet.setColumnWidth(i, columnWidth[j]*256);
                    }
                }
            }
            //创建第0行，也就是标题
            HSSFRow row1 = sheet.createRow(0);
            //设置标题高度
            row1.setHeightInPoints(50);
            //创建标题的单元格样式style2以及字体样式headFont1
            HSSFCellStyle style2 = wb.createCellStyle();
            style2.setAlignment(HorizontalAlignment.CENTER);
            style2.setVerticalAlignment(VerticalAlignment.CENTER);
            style2.setFillForegroundColor(HSSFColor.TURQUOISE.index);
            style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //创建字体样式
            HSSFFont headerFont1 = (HSSFFont)wb.createFont();
            //字体加粗
            headerFont1.setBold(true);
            headerFont1.setFontName("黑体");
            headerFont1.setFontHeightInPoints((short) 15);
            //为标题设置字体样式
            style2.setFont(headerFont1);
            //创建标题第一列
            HSSFCell cell1 = row1.createCell(0);
            //合并第0到第17列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnNumber - 1));
            //设置标题
            cell1.setCellValue(titleName);
            //设置标题样式
            cell1.setCellStyle(style2);
            //创建第一行，表头
            HSSFRow row = sheet.createRow((int)1);
            //设置表头高度
            row.setHeightInPoints(37);
            //创建表头的单元格样式以及表头的字体样式
            HSSFCellStyle style = wb.createCellStyle();
            //设置自动换行
            style.setWrapText(true);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            style.setBottomBorderColor(HSSFColor.BLACK.index);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            //设置字体样式
            HSSFFont headerFont = (HSSFFont)wb.createFont();
            //字体加粗
            headerFont.setBold(true);
            headerFont.setFontName("黑体");
            headerFont.setFontHeightInPoints((short) 10);
            style.setFont(headerFont);

            //创建表头的列
            for (int i = 0; i < columnNumber; i++){
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(columnName[i]);
                cell.setCellStyle(style);

            }
            //创建单元格并设置值
            for (int i = 0; i < dataList.length; i++){
                row = sheet.createRow((int) i + 2);
                //自动换行，上下居中
                HSSFCellStyle autoLine = wb.createCellStyle();
                autoLine.setWrapText(true);
                autoLine.setVerticalAlignment(VerticalAlignment.CENTER);
                //设置边框
                autoLine.setBottomBorderColor(HSSFColor.BLACK.index);
                autoLine.setBorderBottom(BorderStyle.THIN);
                autoLine.setBorderLeft(BorderStyle.THIN);
                autoLine.setBorderRight(BorderStyle.THIN);
                autoLine.setBorderTop(BorderStyle.THIN);
                //设置新的样式，上下左右也换行
                HSSFCellStyle autoLine2 = wb.createCellStyle();
                autoLine2.setWrapText(true);
                autoLine2.setVerticalAlignment(VerticalAlignment.CENTER);
                autoLine2.setAlignment(HorizontalAlignment.CENTER);
                autoLine.setBottomBorderColor(HSSFColor.BLACK.index);
                autoLine.setBorderBottom(BorderStyle.THIN);
                autoLine.setBorderLeft(BorderStyle.THIN);
                autoLine.setBorderRight(BorderStyle.THIN);
                autoLine.setBorderTop(BorderStyle.THIN);

                HSSFCell dataCell = null;
                for (int j = 0; j < columnNumber; j++){
                    dataCell = row.createCell(j);
                    dataCell.setCellValue(dataList[i][j]);
                    dataCell.setCellStyle(autoLine2);
                }
            }
            //将文件输出制定位置
            FileOutputStream out = new FileOutputStream(new File("D:zsw.xls"));
            wb.write(out);
            out.flush();
            out.close();




        }else{
            System.out.println("列数目长度要和三个数组长度一致");
        }
    }
}
