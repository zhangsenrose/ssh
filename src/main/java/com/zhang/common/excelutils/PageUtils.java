package com.zhang.common.excelutils;

/**
 * Created by YanjieG on 2017/8/24.
 */
public class PageUtils {
    public static final Integer DEFAULT_PAGE_START = 1;
    public static final Integer NO_PAGE_COUNT = -1;
    public static final Integer DEFAULT_PAGE_SIZE = 100;

    public static Integer getForEachCount(Integer pageSize,Long total){
        if(total < pageSize){
            return 1;
        }
        Integer pages = new Long(total/pageSize).intValue();
        if(total % pageSize == 0){
            return pages;
        }
        return pages + 1;
    }

    public static Integer getForEachCount(Long total){
        return getForEachCount(DEFAULT_PAGE_SIZE,total);
    }
}
