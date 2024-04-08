package com.util;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 */
public class PageData<T> implements Serializable {

    // 目标页
    private int pageNum;

    // 一页多少行
    private int pageSize;

    //总页码
    private long pageCount;

    // 总记录数
    private long total;

    // 当前的数据
    private List<T> records;

    public PageData(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public static <T> PageData<T> from(PageInfo<T> pageInfo) {
        PageData<T> pageData = new PageData<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        pageData.setTotal(pageInfo.getTotal());
        pageData.setRecords(pageInfo.getList());
        long pc = pageData.getTotal() / pageData.getPageSize();
        pageData.setPageCount(1);
        if (pageData.getTotal() % pageData.getPageSize() == 0) {
            pageData.setPageCount(pc == 0 ? 1 : pc);
        } else {
            pageData.setPageCount(pc + 1);
        }
        return pageData;
    }

    /**
     * 处理异常页容量
     */
    public int getPageSize() {
        return pageSize <= 0 ? 10 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 计算总页码
     */
    public long getPageCount() {
        if (this.getTotal() % this.getPageSize() == 0) {
            long pc = this.getTotal() / this.getPageSize();
            return pc == 0 ? 1 : pc;
        }
        return this.getTotal() / this.getPageSize() + 1;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 获取 目标页
     *
     * @return pageNum 目标页
     */
    public int getPageNum() {
        return this.pageNum;
    }

    /**
     * 设置 目标页
     *
     * @param pageNum 目标页
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取 总记录数
     *
     * @return total 总记录数
     */
    public long getTotal() {
        return this.total;
    }

    /**
     * 设置 总记录数
     *
     * @param total 总记录数
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 获取 当前的数据
     *
     * @return records 当前的数据
     */
    public List<T> getRecords() {
        return this.records;
    }

    /**
     * 设置 当前的数据
     *
     * @param records 当前的数据
     */
    public void setRecords(List<T> records) {
        this.records = records;
    }
}
