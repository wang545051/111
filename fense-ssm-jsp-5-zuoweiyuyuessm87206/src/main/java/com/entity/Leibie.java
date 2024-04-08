package com.entity;


/**
 * @ClassName Leibie
 * @Description 类别模块实体层
 */
public class Leibie {
    //id列
    private Integer id;


    //名称
    private String mingcheng;


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
    * 获取 名称
    *
    * @return mingcheng 名称
    */
    public String getMingcheng() {
        return this.mingcheng;
    }

    /**
    * 设置 名称
    *
    * @param mingcheng 名称
    */
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

}
