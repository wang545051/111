package com.entity;


/**
 * @ClassName Gonggao
 * @Description 公告模块实体层
 */
public class Gonggao {
    //id列
    private Integer id;


    //标题
    private String biaoti;
    //内容
    private String neirong;
    //图片
    private String image;
    //时间
    private String shijian;


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
    * 获取 内容
    *
    * @return neirong 内容
    */
    public String getNeirong() {
        return this.neirong;
    }

    /**
    * 设置 内容
    *
    * @param neirong 内容
    */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
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
    /**
    * 获取 时间
    *
    * @return shijian 时间
    */
    public String getShijian() {
        return this.shijian;
    }

    /**
    * 设置 时间
    *
    * @param shijian 时间
    */
    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

}
