package com.service.impl;

import com.dao.*;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.util.ExampleBuilder;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName UsersServiceImpl
 * @Description 用户模块业务实现层
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;



    //保存或更新用户表users
    @Override
    public Integer saveOrUpdate(Users instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            usersMapper.updateByPrimaryKeySelective(instance);
        }else {
            usersMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询用户表users
    @Override
    public List<Users> findAll() {
        List<Users> list = usersMapper.selectByExample(null);
        for (Users info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询用户表users
    @Override
    public List<Users> find(Users instance) {
        UsersExample usersExample = getUsersExampleByLike(instance);
        usersExample.setOrderByClause(" id desc");
        List<Users> list = usersMapper.selectByExample(usersExample);
        for (Users info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询用户表users
    @Override
    public List<Users> findByEqualTo(Users instance) {
        UsersExample usersExample = getUsersExampleByEqualTo(instance);
        usersExample.setOrderByClause(" id desc");
        List<Users> list = usersMapper.selectByExample(usersExample);
        for (Users info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询用户表users最后一条数据
    @Override
    public Users findOne(Users instance) {
        List<Users> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询用户表users最后一条数据
    @Override
    public Users findOneByEqualTo(Users instance) {
        List<Users> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询用户表users数据
    @Override
    public Users findById(Integer id) {
        Users info = usersMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除用户表users数据
    @Override
    public int deleteById(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询用户表users数据
    @Override
    public PageData<Users> findPage(PageWrap<Users> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        UsersExample usersExample = getUsersExampleByLike(pageWrap.getModel());
        usersExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Users> list = usersMapper.selectByExample(usersExample);
        for (Users info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询用户表users数据
    @Override
    public PageData<Users> findPageByEqualTo(PageWrap<Users> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        UsersExample usersExample = getUsersExampleByEqualTo(pageWrap.getModel());
        usersExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Users> list = usersMapper.selectByExample(usersExample);
        for (Users info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Users info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private UsersExample getUsersExampleByLike(Users instance) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //用户id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //用户名称loginname模糊匹配
        if (null != instance.getLoginname() && !instance.getLoginname().equals("")) {
            criteria.andLoginnameLike("%" + instance.getLoginname() + "%");
        }
        //密码loginpw模糊匹配
        if (null != instance.getLoginpw() && !instance.getLoginpw().equals("")) {
            criteria.andLoginpwLike("%" + instance.getLoginpw() + "%");
        }
        //类型type模糊匹配
        if (null != instance.getType() && !instance.getType().equals("")) {
            criteria.andTypeLike("%" + instance.getType() + "%");
        }
        //类型名称typename模糊匹配
        if (null != instance.getTypename() && !instance.getTypename().equals("")) {
            criteria.andTypenameLike("%" + instance.getTypename() + "%");
        }
        //姓名xingming模糊匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingLike("%" + instance.getXingming() + "%");
        }
        //性别xingbie模糊匹配
        if (null != instance.getXingbie() && !instance.getXingbie().equals("")) {
            criteria.andXingbieLike("%" + instance.getXingbie() + "%");
        }
        //年龄nianling模糊匹配
        if (null != instance.getNianling() && !instance.getNianling().equals("")) {
            criteria.andNianlingLike("%" + instance.getNianling() + "%");
        }
        //地址address模糊匹配
        if (null != instance.getAddress() && !instance.getAddress().equals("")) {
            criteria.andAddressLike("%" + instance.getAddress() + "%");
        }
        //电话dianhua模糊匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaLike("%" + instance.getDianhua() + "%");
        }
        //审核shenhe模糊匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheLike("%" + instance.getShenhe() + "%");
        }

        return usersExample;
    }

    //字符类型完全相等查询条件构造器
    private UsersExample getUsersExampleByEqualTo(Users instance) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //用户id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //用户名称loginname完全匹配
        if (null != instance.getLoginname() && !instance.getLoginname().equals("")) {
            criteria.andLoginnameEqualTo(instance.getLoginname());
        }
        //密码loginpw完全匹配
        if (null != instance.getLoginpw() && !instance.getLoginpw().equals("")) {
            criteria.andLoginpwEqualTo(instance.getLoginpw());
        }
        //类型type完全匹配
        if (null != instance.getType() && !instance.getType().equals("")) {
            criteria.andTypeEqualTo(instance.getType());
        }
        //类型名称typename完全匹配
        if (null != instance.getTypename() && !instance.getTypename().equals("")) {
            criteria.andTypenameEqualTo(instance.getTypename());
        }
        //姓名xingming完全匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingEqualTo(instance.getXingming());
        }
        //性别xingbie完全匹配
        if (null != instance.getXingbie() && !instance.getXingbie().equals("")) {
            criteria.andXingbieEqualTo(instance.getXingbie());
        }
        //年龄nianling完全匹配
        if (null != instance.getNianling() && !instance.getNianling().equals("")) {
            criteria.andNianlingEqualTo(instance.getNianling());
        }
        //地址address完全匹配
        if (null != instance.getAddress() && !instance.getAddress().equals("")) {
            criteria.andAddressEqualTo(instance.getAddress());
        }
        //电话dianhua完全匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaEqualTo(instance.getDianhua());
        }
        //审核shenhe完全匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheEqualTo(instance.getShenhe());
        }

        return usersExample;
    }
}
