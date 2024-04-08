package com.entity;


/**
 * @ClassName Dx
 * @Description 介绍模块实体层
 */
public class Dx {
    //id列
    private Integer id;


    //类别
    private String leibie;
    //内容
    private String content;
    //时间
    private String addtime;


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
    * 获取 类别
    *
    * @return leibie 类别
    */
    public String getLeibie() {
        return this.leibie;
    }

    /**
    * 设置 类别
    *
    * @param leibie 类别
    */
    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }
    /**
    * 获取 内容
    *
    * @return content 内容
    */
    public String getContent() {
        return this.content;
    }

    /**
    * 设置 内容
    *
    * @param content 内容
    */
    public void setContent(String content) {
        this.content = content;
    }
    /**
    * 获取 时间
    *
    * @return addtime 时间
    */
    public String getAddtime() {
        return this.addtime;
    }

    /**
    * 设置 时间
    *
    * @param addtime 时间
    */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

}
