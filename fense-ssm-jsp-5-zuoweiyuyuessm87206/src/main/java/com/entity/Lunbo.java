package com.entity;


/**
 * @ClassName Lunbo
 * @Description 轮播图模块实体层
 */
public class Lunbo {
    //id列
    private Integer id;


    //标题
    private String biaoti;
    //图片
    private String image;


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
    * 获取 标题
    *
    * @return biaoti 标题
    */
    public String getBiaoti() {
        return this.biaoti;
    }

    /**
    * 设置 标题
    *
    * @param biaoti 标题
    */
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }
    /**
    * 获取 图片
    *
    * @return image 图片
    */
    public String getImage() {
        return this.image;
    }

    /**
    * 设置 图片
    *
    * @param image 图片
    */
    public void setImage(String image) {
        this.image = image;
    }

}
