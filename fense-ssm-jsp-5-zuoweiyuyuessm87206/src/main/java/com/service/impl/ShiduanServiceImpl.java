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
 * @ClassName ShiduanServiceImpl
 * @Description 时段模块业务实现层
 */
@Service
public class ShiduanServiceImpl implements ShiduanService {

    @Autowired
    private ShiduanMapper shiduanMapper;



    //保存或更新时段表shiduan
    @Override
    public Integer saveOrUpdate(Shiduan instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            shiduanMapper.updateByPrimaryKeySelective(instance);
        }else {
            shiduanMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询时段表shiduan
    @Override
    public List<Shiduan> findAll() {
        List<Shiduan> list = shiduanMapper.selectByExample(null);
        for (Shiduan info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询时段表shiduan
    @Override
    public List<Shiduan> find(Shiduan instance) {
        ShiduanExample shiduanExample = getShiduanExampleByLike(instance);
        shiduanExample.setOrderByClause(" id desc");
        List<Shiduan> list = shiduanMapper.selectByExample(shiduanExample);
        for (Shiduan info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询时段表shiduan
    @Override
    public List<Shiduan> findByEqualTo(Shiduan instance) {
        ShiduanExample shiduanExample = getShiduanExampleByEqualTo(instance);
        shiduanExample.setOrderByClause(" id desc");
        List<Shiduan> list = shiduanMapper.selectByExample(shiduanExample);
        for (Shiduan info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询时段表shiduan最后一条数据
    @Override
    public Shiduan findOne(Shiduan instance) {
        List<Shiduan> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询时段表shiduan最后一条数据
    @Override
    public Shiduan findOneByEqualTo(Shiduan instance) {
        List<Shiduan> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询时段表shiduan数据
    @Override
    public Shiduan findById(Integer id) {
        Shiduan info = shiduanMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除时段表shiduan数据
    @Override
    public int deleteById(Integer id) {
        return shiduanMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询时段表shiduan数据
    @Override
    public PageData<Shiduan> findPage(PageWrap<Shiduan> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShiduanExample shiduanExample = getShiduanExampleByLike(pageWrap.getModel());
        shiduanExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shiduan> list = shiduanMapper.selectByExample(shiduanExample);
        for (Shiduan info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询时段表shiduan数据
    @Override
    public PageData<Shiduan> findPageByEqualTo(PageWrap<Shiduan> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShiduanExample shiduanExample = getShiduanExampleByEqualTo(pageWrap.getModel());
        shiduanExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shiduan> list = shiduanMapper.selectByExample(shiduanExample);
        for (Shiduan info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Shiduan info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private ShiduanExample getShiduanExampleByLike(Shiduan instance) {
        ShiduanExample shiduanExample = new ShiduanExample();
        ShiduanExample.Criteria criteria = shiduanExample.createCriteria();
        //时段id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //时间段jianduan模糊匹配
        if (null != instance.getJianduan() && !instance.getJianduan().equals("")) {
            criteria.andJianduanLike("%" + instance.getJianduan() + "%");
        }

        return shiduanExample;
    }

    //字符类型完全相等查询条件构造器
    private ShiduanExample getShiduanExampleByEqualTo(Shiduan instance) {
        ShiduanExample shiduanExample = new ShiduanExample();
        ShiduanExample.Criteria criteria = shiduanExample.createCriteria();
        //时段id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //时间段jianduan完全匹配
        if (null != instance.getJianduan() && !instance.getJianduan().equals("")) {
            criteria.andJianduanEqualTo(instance.getJianduan());
        }

        return shiduanExample;
    }
}
