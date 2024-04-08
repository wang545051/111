package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页请求参数
 */
public class PageWrap<M> {

    private M model;

    private int pageNum;

    private int pageSize;

    private List<SortData> sorts;

    /**
     * 处理异常排序对象
     */
    public List<SortData> getSorts () {
        List<SortData> sorts = new ArrayList<>();
        if (this.sorts == null) {
            return sorts;
        }
        for (SortData sort: this.sorts) {
            if (sort.getProperty() == null || sort.getProperty().trim().length() == 0) {
                continue;
            }
            if (sort.getDirection() == null || sort.getDirection().trim().length() == 0 || (!sort.getDirection().trim().equalsIgnoreCase("asc") && !sort.getDirection().trim().equalsIgnoreCase("desc"))) {
                continue;
            }
            sorts.add(sort);
        }
        return sorts;
    }

    public void setSorts(List<SortData> sorts) {
        this.sorts = sorts;
    }

    /**
     * 处理异常页码
     */
    public int getPageNum() {
        return pageNum <= 0 ? 1 : pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 处理异常页容量
     */
    public int getPageSize() {
        return pageSize <= 0 ? 8 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取排序字符串
     */
    public String getOrderByClause () {
        List<SortData> sorts = this.getSorts();
        if (sorts.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (SortData sortData: sorts) {
            stringBuilder.append(sortData.getProperty().trim());
            stringBuilder.append(" ");
            stringBuilder.append(sortData.getDirection().trim());
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    /**
     * 获取
     *
     * @return model
     */
    public M getModel() {
        return this.model;
    }

    /**
     * 设置
     *
     * @param model
     */
    public void setModel(M model) {
        this.model = model;
    }

    /**
     * 排序对象
     */
    public static class SortData {

        private String property;

        private String direction;

        /**
         * 获取
         *
         * @return property
         */
        public String getProperty() {
            return this.property;
        }

        /**
         * 设置
         *
         * @param property
         */
        public void setProperty(String property) {
            this.property = property;
        }

        /**
         * 获取
         *
         * @return direction
         */
        public String getDirection() {
            return this.direction;
        }

        /**
         * 设置
         *
         * @param direction
         */
        public void setDirection(String direction) {
            this.direction = direction;
        }
    }
}