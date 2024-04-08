package com.entity;


/**
 * @ClassName Shiduan
 * @Description 时段模块实体层
 */
public class Shiduan {
    //id列
    private Integer id;


    //时间段
    private String jianduan;


    /**
    * 获取 id列
    *
    * @return id id列
    */
    public Integer getId() {
        return this.id;
    }

    /**
    * 设置 id列
    *
    * @param id id列
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * 获取 时间段
    *
    * @return jianduan 时间段
    */
    public String getJianduan() {
        return this.jianduan;
    }

    /**
    * 设置 时间段
    *
    * @param jianduan 时间段
    */
    public void setJianduan(String jianduan) {
        this.jianduan = jianduan;
    }

}
