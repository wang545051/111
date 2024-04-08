package com.entity;


/**
 * @ClassName Zuowei
 * @Description 座位模块实体层
 */
public class Zuowei {
    //id列
    private Integer id;


    //编号
    private String bianhao;
    //类别id
    private Integer leibieid;
    //楼层id
    private Integer loucengid;
    //房间id
    private Integer fangjianid;
    //座位介绍
    private String neirong;
    //是否空闲
    private String shenhe;
    //环境图片
    private String image;
    //父表：类别表leibie
    private Leibie leibie;
    //父表：楼层表louceng
    private Louceng louceng;
    //父表：房间表fangjian
    private Fangjian fangjian;


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
    * 获取 编号
    *
    * @return bianhao 编号
    */
    public String getBianhao() {
        return this.bianhao;
    }

    /**
    * 设置 编号
    *
    * @param bianhao 编号
    */
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }
    /**
    * 获取 类别id
    *
    * @return leibieid 类别id
    */
    public Integer getLeibieid() {
        return this.leibieid;
    }

    /**
    * 设置 类别id
    *
    * @param leibieid 类别id
    */
    public void setLeibieid(Integer leibieid) {
        this.leibieid = leibieid;
    }
    /**
    * 获取 楼层id
    *
    * @return loucengid 楼层id
    */
    public Integer getLoucengid() {
        return this.loucengid;
    }

    /**
    * 设置 楼层id
    *
    * @param loucengid 楼层id
    */
    public void setLoucengid(Integer loucengid) {
        this.loucengid = loucengid;
    }
    /**
    * 获取 房间id
    *
    * @return fangjianid 房间id
    */
    public Integer getFangjianid() {
        return this.fangjianid;
    }

    /**
    * 设置 房间id
    *
    * @param fangjianid 房间id
    */
    public void setFangjianid(Integer fangjianid) {
        this.fangjianid = fangjianid;
    }
    /**
    * 获取 座位介绍
    *
    * @return neirong 座位介绍
    */
    public String getNeirong() {
        return this.neirong;
    }

    /**
    * 设置 座位介绍
    *
    * @param neirong 座位介绍
    */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    /**
    * 获取 是否空闲
    *
    * @return shenhe 是否空闲
    */
    public String getShenhe() {
        return this.shenhe;
    }

    /**
    * 设置 是否空闲
    *
    * @param shenhe 是否空闲
    */
    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }
    /**
    * 获取 环境图片
    *
    * @return image 环境图片
    */
    public String getImage() {
        return this.image;
    }

    /**
    * 设置 环境图片
    *
    * @param image 环境图片
    */
    public void setImage(String image) {
        this.image = image;
    }
    /**
    * 获取 父表：类别表leibie
    *
    * @return leibie 父表：类别表leibie
    */
    public Leibie getLeibie() {
        return this.leibie;
    }

    /**
    * 设置 父表：类别表leibie
    *
    * @param leibie 父表：类别表leibie
    */
    public void setLeibie(Leibie leibie) {
        this.leibie = leibie;
    }
    /**
    * 获取 父表：楼层表louceng
    *
    * @return louceng 父表：楼层表louceng
    */
    public Louceng getLouceng() {
        return this.louceng;
    }

    /**
    * 设置 父表：楼层表louceng
    *
    * @param louceng 父表：楼层表louceng
    */
    public void setLouceng(Louceng louceng) {
        this.louceng = louceng;
    }
    /**
    * 获取 父表：房间表fangjian
    *
    * @return fangjian 父表：房间表fangjian
    */
    public Fangjian getFangjian() {
        return this.fangjian;
    }

    /**
    * 设置 父表：房间表fangjian
    *
    * @param fangjian 父表：房间表fangjian
    */
    public void setFangjian(Fangjian fangjian) {
        this.fangjian = fangjian;
    }

}
