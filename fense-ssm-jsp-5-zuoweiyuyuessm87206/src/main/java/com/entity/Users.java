package com.entity;


/**
 * @ClassName Users
 * @Description 用户模块实体层
 */
public class Users {
    //id列
    private Integer id;


    //用户名称
    private String loginname;
    //密码
    private String loginpw;
    //类型
    private String type;
    //类型名称
    private String typename;
    //姓名
    private String xingming;
    //性别
    private String xingbie;
    //年龄
    private String nianling;
    //地址
    private String address;
    //电话
    private String dianhua;
    //审核
    private String shenhe;


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
    * 获取 用户名称
    *
    * @return loginname 用户名称
    */
    public String getLoginname() {
        return this.loginname;
    }

    /**
    * 设置 用户名称
    *
    * @param loginname 用户名称
    */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    /**
    * 获取 密码
    *
    * @return loginpw 密码
    */
    public String getLoginpw() {
        return this.loginpw;
    }

    /**
    * 设置 密码
    *
    * @param loginpw 密码
    */
    public void setLoginpw(String loginpw) {
        this.loginpw = loginpw;
    }
    /**
    * 获取 类型
    *
    * @return type 类型
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置 类型
    *
    * @param type 类型
    */
    public void setType(String type) {
        this.type = type;
    }
    /**
    * 获取 类型名称
    *
    * @return typename 类型名称
    */
    public String getTypename() {
        return this.typename;
    }

    /**
    * 设置 类型名称
    *
    * @param typename 类型名称
    */
    public void setTypename(String typename) {
        this.typename = typename;
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
    * 获取 性别
    *
    * @return xingbie 性别
    */
    public String getXingbie() {
        return this.xingbie;
    }

    /**
    * 设置 性别
    *
    * @param xingbie 性别
    */
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }
    /**
    * 获取 年龄
    *
    * @return nianling 年龄
    */
    public String getNianling() {
        return this.nianling;
    }

    /**
    * 设置 年龄
    *
    * @param nianling 年龄
    */
    public void setNianling(String nianling) {
        this.nianling = nianling;
    }
    /**
    * 获取 地址
    *
    * @return address 地址
    */
    public String getAddress() {
        return this.address;
    }

    /**
    * 设置 地址
    *
    * @param address 地址
    */
    public void setAddress(String address) {
        this.address = address;
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
    * 获取 审核
    *
    * @return shenhe 审核
    */
    public String getShenhe() {
        return this.shenhe;
    }

    /**
    * 设置 审核
    *
    * @param shenhe 审核
    */
    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

}
