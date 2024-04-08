package com.entity;


/**
 * @ClassName Lianjie
 * @Description 友情链接模块实体层
 */
public class Lianjie {
    //id列
    private Integer id;


    //名称
    private String name;
    //链接地址
    private String url;


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
    * @return name 名称
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置 名称
    *
    * @param name 名称
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * 获取 链接地址
    *
    * @return url 链接地址
    */
    public String getUrl() {
        return this.url;
    }

    /**
    * 设置 链接地址
    *
    * @param url 链接地址
    */
    public void setUrl(String url) {
        this.url = url;
    }

}
