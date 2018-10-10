package com.zhang.common.utils;

/**
 * Create By ZhangSenWei on 2018/8/20
 **/


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * write title  write data  dispose
 */
public class ExportExcel2007Utils {

    //默认列宽度
    private final int DEFAULT_COLUMN_SIZE = 20;
    //刷新写入磁盘的阈值
    private final int flushRows = 100;
    //声明工作本
    private  Workbook writeDateWorkBook;
    //样式列表
    private Map<String, CellStyle> cellStyleMap;
    //Excel当前数据的行数(将要写进数据的索引数)
    private int currentRowNum = 0;
    //数据输出流
    private OutputStream outputStream;


    /**
     * 断言Excel文件写入之前的条件
     * @param directory 目录
     * @param fileName 文件名
     * @return
     */
    private File assertFile(String directory, String fileName) throws IOException {
        File tmpFile = new File(directory + File.separator + fileName + ".xlsx");
        if (tmpFile.exists()){
            if (tmpFile.isDirectory()){
                throw  new IOException("File '" + tmpFile + "' exists but is a directory");
            }
            if (!tmpFile.canWrite()){
                throw  new IOException("File '" + tmpFile + "' cannot be written to");
            }
        }else {
            File parent = tmpFile.getParentFile();
            if (parent != null){
                if (!parent.mkdirs() && !parent.isDirectory()){
                    throw  new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }
        return tmpFile;
    }

    /**
     * 日期转化为字符串，格式为 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    private String getCnDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * Excel表头写入
     * @param directory
     * @param fileName
     * @param sheetName
     * @param columnNames
     * @param sheetTitle 表格标题，可空
     * @throws IOException
     */
    public void writeExcelTitle(String directory, String fileName, String sheetName, List<String> columnNames,
                                String sheetTitle)throws IOException{
            File tmpFile = assertFile(directory, fileName);
            exportExcelTitle(tmpFile, sheetName, columnNames, sheetTitle, null);
            loadTpWorkbook(tmpFile);
    }


    private void exportExcelTitle(File file, String sheetName, List<String> columnNames, String sheetTitle, String secondTitle){

    }

    private void loadTpWorkbook(File file) throws IOException {
        try {
            XSSFWorkbook tplWorkBook = new XSSFWorkbook(new FileInputStream(file));
            writeDateWorkBook = new SXSSFWorkbook(tplWorkBook, flushRows);
//            cellStyleMap = styleMap(writeDateWorkBook);
        } catch (IOException e) {
            throw new IOException("Excel模板文件不存在");
        }
    }





}
