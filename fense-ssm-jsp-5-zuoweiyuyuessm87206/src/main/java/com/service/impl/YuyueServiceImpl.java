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
 * @ClassName YuyueServiceImpl
 * @Description 预约模块业务实现层
 */
@Service
public class YuyueServiceImpl implements YuyueService {

    @Autowired
    private YuyueMapper yuyueMapper;

    @Autowired
    private ZuoweiMapper zuoweiMapper;
    @Autowired
    private ShiduanMapper shiduanMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新预约表yuyue
    @Override
    public Integer saveOrUpdate(Yuyue instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            yuyueMapper.updateByPrimaryKeySelective(instance);
        }else {
            yuyueMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询预约表yuyue
    @Override
    public List<Yuyue> findAll() {
        List<Yuyue> list = yuyueMapper.selectByExample(null);
        for (Yuyue info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询预约表yuyue
    @Override
    public List<Yuyue> find(Yuyue instance) {
        YuyueExample yuyueExample = getYuyueExampleByLike(instance);
        yuyueExample.setOrderByClause(" id desc");
        List<Yuyue> list = yuyueMapper.selectByExample(yuyueExample);
        for (Yuyue info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询预约表yuyue
    @Override
    public List<Yuyue> findByEqualTo(Yuyue instance) {
        YuyueExample yuyueExample = getYuyueExampleByEqualTo(instance);
        yuyueExample.setOrderByClause(" id desc");
        List<Yuyue> list = yuyueMapper.selectByExample(yuyueExample);
        for (Yuyue info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询预约表yuyue最后一条数据
    @Override
    public Yuyue findOne(Yuyue instance) {
        List<Yuyue> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询预约表yuyue最后一条数据
    @Override
    public Yuyue findOneByEqualTo(Yuyue instance) {
        List<Yuyue> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询预约表yuyue数据
    @Override
    public Yuyue findById(Integer id) {
        Yuyue info = yuyueMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除预约表yuyue数据
    @Override
    public int deleteById(Integer id) {
        return yuyueMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询预约表yuyue数据
    @Override
    public PageData<Yuyue> findPage(PageWrap<Yuyue> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        YuyueExample yuyueExample = getYuyueExampleByLike(pageWrap.getModel());
        yuyueExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Yuyue> list = yuyueMapper.selectByExample(yuyueExample);
        for (Yuyue info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询预约表yuyue数据
    @Override
    public PageData<Yuyue> findPageByEqualTo(PageWrap<Yuyue> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        YuyueExample yuyueExample = getYuyueExampleByEqualTo(pageWrap.getModel());
        yuyueExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Yuyue> list = yuyueMapper.selectByExample(yuyueExample);
        for (Yuyue info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Yuyue info){
        if (null != info){
            Zuowei zuowei= zuoweiMapper.selectByPrimaryKey(info.getZuoweiid());
            info.setZuowei(zuowei);
            Shiduan shiduan= shiduanMapper.selectByPrimaryKey(info.getShiduanid());
            info.setShiduan(shiduan);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private YuyueExample getYuyueExampleByLike(Yuyue instance) {
        YuyueExample yuyueExample = new YuyueExample();
        YuyueExample.Criteria criteria = yuyueExample.createCriteria();
        //预约id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //姓名xingming模糊匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingLike("%" + instance.getXingming() + "%");
        }
        //电话dianhua模糊匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaLike("%" + instance.getDianhua() + "%");
        }
        //座位idzuoweiid完全匹配
        if (null != instance.getZuoweiid()) {
            criteria.andZuoweiidEqualTo(instance.getZuoweiid());
        }
        //时段idshiduanid完全匹配
        if (null != instance.getShiduanid()) {
            criteria.andShiduanidEqualTo(instance.getShiduanid());
        }
        //日期riqi模糊匹配
        if (null != instance.getRiqi() && !instance.getRiqi().equals("")) {
            criteria.andRiqiLike("%" + instance.getRiqi() + "%");
        }
        //备注beizhu模糊匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuLike("%" + instance.getBeizhu() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return yuyueExample;
    }

    //字符类型完全相等查询条件构造器
    private YuyueExample getYuyueExampleByEqualTo(Yuyue instance) {
        YuyueExample yuyueExample = new YuyueExample();
        YuyueExample.Criteria criteria = yuyueExample.createCriteria();
        //预约id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //姓名xingming完全匹配
        if (null != instance.getXingming() && !instance.getXingming().equals("")) {
            criteria.andXingmingEqualTo(instance.getXingming());
        }
        //电话dianhua完全匹配
        if (null != instance.getDianhua() && !instance.getDianhua().equals("")) {
            criteria.andDianhuaEqualTo(instance.getDianhua());
        }
        //座位idzuoweiid完全匹配
        if (null != instance.getZuoweiid()) {
            criteria.andZuoweiidEqualTo(instance.getZuoweiid());
        }
        //时段idshiduanid完全匹配
        if (null != instance.getShiduanid()) {
            criteria.andShiduanidEqualTo(instance.getShiduanid());
        }
        //日期riqi完全匹配
        if (null != instance.getRiqi() && !instance.getRiqi().equals("")) {
            criteria.andRiqiEqualTo(instance.getRiqi());
        }
        //备注beizhu完全匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuEqualTo(instance.getBeizhu());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return yuyueExample;
    }
}
