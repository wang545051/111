package com.entity;


/**
 * @ClassName Yuyue
 * @Description 预约模块实体层
 */
public class Yuyue {
    //id列
    private Integer id;


    //姓名
    private String xingming;
    //电话
    private String dianhua;
    //座位id
    private Integer zuoweiid;
    //时段id
    private Integer shiduanid;
    //日期
    private String riqi;
    //备注
    private String beizhu;
    //用户id
    private Integer usersid;
    //父表：座位表zuowei
    private Zuowei zuowei;
    //父表：时段表shiduan
    private Shiduan shiduan;
    //父表：用户表users
    private Users users;


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
    * 获取 姓名
    *
    * @return xingming 姓名
    */
    public String getXingming() {
        return this.xingming;
    }

    /**
    * 设置 姓名
    *
    * @param xingming 姓名
    */
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }
    /**
    * 获取 电话
    *
    * @return dianhua 电话
    */
    public String getDianhua() {
        return this.dianhua;
    }

    /**
    * 设置 电话
    *
    * @param dianhua 电话
    */
    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }
    /**
    * 获取 座位id
    *
    * @return zuoweiid 座位id
    */
    public Integer getZuoweiid() {
        return this.zuoweiid;
    }

    /**
    * 设置 座位id
    *
    * @param zuoweiid 座位id
    */
    public void setZuoweiid(Integer zuoweiid) {
        this.zuoweiid = zuoweiid;
    }
    /**
    * 获取 时段id
    *
    * @return shiduanid 时段id
    */
    public Integer getShiduanid() {
        return this.shiduanid;
    }

    /**
    * 设置 时段id
    *
    * @param shiduanid 时段id
    */
    public void setShiduanid(Integer shiduanid) {
        this.shiduanid = shiduanid;
    }
    /**
    * 获取 日期
    *
    * @return riqi 日期
    */
    public String getRiqi() {
        return this.riqi;
    }

    /**
    * 设置 日期
    *
    * @param riqi 日期
    */
    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }
    /**
    * 获取 备注
    *
    * @return beizhu 备注
    */
    public String getBeizhu() {
        return this.beizhu;
    }

    /**
    * 设置 备注
    *
    * @param beizhu 备注
    */
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
    /**
    * 获取 用户id
    *
    * @return usersid 用户id
    */
    public Integer getUsersid() {
        return this.usersid;
    }

    /**
    * 设置 用户id
    *
    * @param usersid 用户id
    */
    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }
    /**
    * 获取 父表：座位表zuowei
    *
    * @return zuowei 父表：座位表zuowei
    */
    public Zuowei getZuowei() {
        return this.zuowei;
    }

    /**
    * 设置 父表：座位表zuowei
    *
    * @param zuowei 父表：座位表zuowei
    */
    public void setZuowei(Zuowei zuowei) {
        this.zuowei = zuowei;
    }
    /**
    * 获取 父表：时段表shiduan
    *
    * @return shiduan 父表：时段表shiduan
    */
    public Shiduan getShiduan() {
        return this.shiduan;
    }

    /**
    * 设置 父表：时段表shiduan
    *
    * @param shiduan 父表：时段表shiduan
    */
    public void setShiduan(Shiduan shiduan) {
        this.shiduan = shiduan;
    }
    /**
    * 获取 父表：用户表users
    *
    * @return users 父表：用户表users
    */
    public Users getUsers() {
        return this.users;
    }

    /**
    * 设置 父表：用户表users
    *
    * @param users 父表：用户表users
    */
    public void setUsers(Users users) {
        this.users = users;
    }

}
