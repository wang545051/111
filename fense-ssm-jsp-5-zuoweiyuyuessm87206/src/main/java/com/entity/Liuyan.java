package com.entity;


/**
 * @ClassName Liuyan
 * @Description 留言反馈模块实体层
 */
public class Liuyan {
    //id列
    private Integer id;


    //标题
    private String biaoti;
    //内容
    private String neirong;
    //留言时间
    private String liuyanshijian;
    //用户id
    private Integer usersid;
    //回复
    private String huifu;
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
    * 获取 留言时间
    *
    * @return liuyanshijian 留言时间
    */
    public String getLiuyanshijian() {
        return this.liuyanshijian;
    }

    /**
    * 设置 留言时间
    *
    * @param liuyanshijian 留言时间
    */
    public void setLiuyanshijian(String liuyanshijian) {
        this.liuyanshijian = liuyanshijian;
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
    * 获取 回复
    *
    * @return huifu 回复
    */
    public String getHuifu() {
        return this.huifu;
    }

    /**
    * 设置 回复
    *
    * @param huifu 回复
    */
    public void setHuifu(String huifu) {
        this.huifu = huifu;
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
