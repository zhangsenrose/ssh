package com.zhang.common;

import java.io.Serializable;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public class PageDto<T> implements Serializable {

    private Integer currentPage;
    private Integer pageSize;
    private Integer pageTotal;
    private T data;


    public PageDto() {
    }

    public PageDto(Integer pageTotal, T data) {
        this.pageTotal = pageTotal;
        this.data = data;
    }

    public PageDto(Integer currentPage, Integer pageSize, Integer pageTotal, T data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.data = data;
    }

    public PageDto(Integer currentPage, Integer pageSize, T data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.data = data;
    }


    public static <T> PageDto<T> creat(Integer pageTotal, T data){
        return  new PageDto<>(pageTotal, data);
    }
    public static PageDto nodata(){
        return new PageDto(0, null);
    }

    public static <T> PageDto<T> create(Integer currentPage, Integer pageSize, Integer pageTotal, T data){
        return new PageDto<>(currentPage, pageSize, pageTotal, data);
    }

    public static <T> PageDto<T> create(Integer currentPage, Integer pageSize, T data){
        return new PageDto<>(currentPage, pageSize, data);
    }

    //get and set
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "data=" + data +
                '}';
    }
}
