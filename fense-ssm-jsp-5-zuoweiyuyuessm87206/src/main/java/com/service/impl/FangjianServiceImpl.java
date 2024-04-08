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
 * @ClassName FangjianServiceImpl
 * @Description 房间模块业务实现层
 */
@Service
public class FangjianServiceImpl implements FangjianService {

    @Autowired
    private FangjianMapper fangjianMapper;



    //保存或更新房间表fangjian
    @Override
    public Integer saveOrUpdate(Fangjian instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            fangjianMapper.updateByPrimaryKeySelective(instance);
        }else {
            fangjianMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询房间表fangjian
    @Override
    public List<Fangjian> findAll() {
        List<Fangjian> list = fangjianMapper.selectByExample(null);
        for (Fangjian info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询房间表fangjian
    @Override
    public List<Fangjian> find(Fangjian instance) {
        FangjianExample fangjianExample = getFangjianExampleByLike(instance);
        fangjianExample.setOrderByClause(" id desc");
        List<Fangjian> list = fangjianMapper.selectByExample(fangjianExample);
        for (Fangjian info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询房间表fangjian
    @Override
    public List<Fangjian> findByEqualTo(Fangjian instance) {
        FangjianExample fangjianExample = getFangjianExampleByEqualTo(instance);
        fangjianExample.setOrderByClause(" id desc");
        List<Fangjian> list = fangjianMapper.selectByExample(fangjianExample);
        for (Fangjian info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询房间表fangjian最后一条数据
    @Override
    public Fangjian findOne(Fangjian instance) {
        List<Fangjian> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询房间表fangjian最后一条数据
    @Override
    public Fangjian findOneByEqualTo(Fangjian instance) {
        List<Fangjian> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询房间表fangjian数据
    @Override
    public Fangjian findById(Integer id) {
        Fangjian info = fangjianMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除房间表fangjian数据
    @Override
    public int deleteById(Integer id) {
        return fangjianMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询房间表fangjian数据
    @Override
    public PageData<Fangjian> findPage(PageWrap<Fangjian> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        FangjianExample fangjianExample = getFangjianExampleByLike(pageWrap.getModel());
        fangjianExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Fangjian> list = fangjianMapper.selectByExample(fangjianExample);
        for (Fangjian info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询房间表fangjian数据
    @Override
    public PageData<Fangjian> findPageByEqualTo(PageWrap<Fangjian> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        FangjianExample fangjianExample = getFangjianExampleByEqualTo(pageWrap.getModel());
        fangjianExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Fangjian> list = fangjianMapper.selectByExample(fangjianExample);
        for (Fangjian info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Fangjian info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private FangjianExample getFangjianExampleByLike(Fangjian instance) {
        FangjianExample fangjianExample = new FangjianExample();
        FangjianExample.Criteria criteria = fangjianExample.createCriteria();
        //房间id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return fangjianExample;
    }

    //字符类型完全相等查询条件构造器
    private FangjianExample getFangjianExampleByEqualTo(Fangjian instance) {
        FangjianExample fangjianExample = new FangjianExample();
        FangjianExample.Criteria criteria = fangjianExample.createCriteria();
        //房间id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return fangjianExample;
    }
}
