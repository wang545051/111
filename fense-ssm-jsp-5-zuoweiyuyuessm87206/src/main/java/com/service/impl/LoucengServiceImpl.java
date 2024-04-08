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
 * @ClassName LoucengServiceImpl
 * @Description 楼层模块业务实现层
 */
@Service
public class LoucengServiceImpl implements LoucengService {

    @Autowired
    private LoucengMapper loucengMapper;



    //保存或更新楼层表louceng
    @Override
    public Integer saveOrUpdate(Louceng instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            loucengMapper.updateByPrimaryKeySelective(instance);
        }else {
            loucengMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询楼层表louceng
    @Override
    public List<Louceng> findAll() {
        List<Louceng> list = loucengMapper.selectByExample(null);
        for (Louceng info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询楼层表louceng
    @Override
    public List<Louceng> find(Louceng instance) {
        LoucengExample loucengExample = getLoucengExampleByLike(instance);
        loucengExample.setOrderByClause(" id desc");
        List<Louceng> list = loucengMapper.selectByExample(loucengExample);
        for (Louceng info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询楼层表louceng
    @Override
    public List<Louceng> findByEqualTo(Louceng instance) {
        LoucengExample loucengExample = getLoucengExampleByEqualTo(instance);
        loucengExample.setOrderByClause(" id desc");
        List<Louceng> list = loucengMapper.selectByExample(loucengExample);
        for (Louceng info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询楼层表louceng最后一条数据
    @Override
    public Louceng findOne(Louceng instance) {
        List<Louceng> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询楼层表louceng最后一条数据
    @Override
    public Louceng findOneByEqualTo(Louceng instance) {
        List<Louceng> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询楼层表louceng数据
    @Override
    public Louceng findById(Integer id) {
        Louceng info = loucengMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除楼层表louceng数据
    @Override
    public int deleteById(Integer id) {
        return loucengMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询楼层表louceng数据
    @Override
    public PageData<Louceng> findPage(PageWrap<Louceng> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LoucengExample loucengExample = getLoucengExampleByLike(pageWrap.getModel());
        loucengExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Louceng> list = loucengMapper.selectByExample(loucengExample);
        for (Louceng info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询楼层表louceng数据
    @Override
    public PageData<Louceng> findPageByEqualTo(PageWrap<Louceng> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LoucengExample loucengExample = getLoucengExampleByEqualTo(pageWrap.getModel());
        loucengExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Louceng> list = loucengMapper.selectByExample(loucengExample);
        for (Louceng info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Louceng info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private LoucengExample getLoucengExampleByLike(Louceng instance) {
        LoucengExample loucengExample = new LoucengExample();
        LoucengExample.Criteria criteria = loucengExample.createCriteria();
        //楼层id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return loucengExample;
    }

    //字符类型完全相等查询条件构造器
    private LoucengExample getLoucengExampleByEqualTo(Louceng instance) {
        LoucengExample loucengExample = new LoucengExample();
        LoucengExample.Criteria criteria = loucengExample.createCriteria();
        //楼层id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return loucengExample;
    }
}
