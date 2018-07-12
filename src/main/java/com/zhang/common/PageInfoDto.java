package com.zhang.common;

import java.io.Serializable;
import java.util.List;

/**
 * Create By ZhangSenWei on 2018/7/12
 * 分页类
 **/
public class PageInfoDto<T> implements Serializable {

    private Long totalCount;
    private List<T> resultList;

    public PageInfoDto(Long totalCount, List<T> resultList) {
        this.totalCount = totalCount;
        this.resultList = resultList;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
