package com.zhang.common.excelutils;

import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author zxx
 * @date 2018/4/8.
 */
public class ExcelDataVo {

    private boolean isLock = false;

    private short background = HSSFColor.WHITE.index;

    private Object data ;

    public ExcelDataVo() {
    }

    public ExcelDataVo(Object data) {
        this.data = data;
    }


    public ExcelDataVo(short background, Object data) {
        this.background = background;
        this.data = data;
    }

    public ExcelDataVo(boolean isLock, short background, Object data) {
        this.isLock = isLock;
        this.background = background;
        this.data = data;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public short getBackground() {
        return background;
    }

    public void setBackground(short background) {
        this.background = background;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
