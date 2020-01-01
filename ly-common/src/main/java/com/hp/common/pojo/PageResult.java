package com.hp.common.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description 分页bean
 * @Author Ankhci
 * @Date 2020/1/2 0:16
 **/
@Data
public class PageResult<T> {

    private Long total;     //总条数
    private Long totalPage; //总页数
    private List<T> items;  //当前页面数

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}
