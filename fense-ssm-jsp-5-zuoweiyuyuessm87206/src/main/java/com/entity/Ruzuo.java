package com.entity;


/**
 * @ClassName Ruzuo
 * @Description 入座模块实体层
 */
public class Ruzuo {
    //id列
    private Integer id;


    //姓名
    private String xingming;
    //电话
    private String dianhua;
    //座位id
    private Integer zuoweiid;
    //时间
    private String shijian;
    //备注
    private String beizhu;
    //用户id
    private Integer usersslid;
    //父表：座位表zuowei
    private Zuowei zuowei;
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
    * @return usersslid 用户id
    */
    public Integer getUsersslid() {
        return this.usersslid;
    }

    /**
    * 设置 用户id
    *
    * @param usersslid 用户id
    */
    public void setUsersslid(Integer usersslid) {
        this.usersslid = usersslid;
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
