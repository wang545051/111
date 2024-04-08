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
 * @ClassName LianjieServiceImpl
 * @Description 友情链接模块业务实现层
 */
@Service
public class LianjieServiceImpl implements LianjieService {

    @Autowired
    private LianjieMapper lianjieMapper;



    //保存或更新友情链接表lianjie
    @Override
    public Integer saveOrUpdate(Lianjie instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            lianjieMapper.updateByPrimaryKeySelective(instance);
        }else {
            lianjieMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询友情链接表lianjie
    @Override
    public List<Lianjie> findAll() {
        List<Lianjie> list = lianjieMapper.selectByExample(null);
        for (Lianjie info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询友情链接表lianjie
    @Override
    public List<Lianjie> find(Lianjie instance) {
        LianjieExample lianjieExample = getLianjieExampleByLike(instance);
        lianjieExample.setOrderByClause(" id desc");
        List<Lianjie> list = lianjieMapper.selectByExample(lianjieExample);
        for (Lianjie info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询友情链接表lianjie
    @Override
    public List<Lianjie> findByEqualTo(Lianjie instance) {
        LianjieExample lianjieExample = getLianjieExampleByEqualTo(instance);
        lianjieExample.setOrderByClause(" id desc");
        List<Lianjie> list = lianjieMapper.selectByExample(lianjieExample);
        for (Lianjie info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询友情链接表lianjie最后一条数据
    @Override
    public Lianjie findOne(Lianjie instance) {
        List<Lianjie> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询友情链接表lianjie最后一条数据
    @Override
    public Lianjie findOneByEqualTo(Lianjie instance) {
        List<Lianjie> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询友情链接表lianjie数据
    @Override
    public Lianjie findById(Integer id) {
        Lianjie info = lianjieMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除友情链接表lianjie数据
    @Override
    public int deleteById(Integer id) {
        return lianjieMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询友情链接表lianjie数据
    @Override
    public PageData<Lianjie> findPage(PageWrap<Lianjie> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LianjieExample lianjieExample = getLianjieExampleByLike(pageWrap.getModel());
        lianjieExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Lianjie> list = lianjieMapper.selectByExample(lianjieExample);
        for (Lianjie info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询友情链接表lianjie数据
    @Override
    public PageData<Lianjie> findPageByEqualTo(PageWrap<Lianjie> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LianjieExample lianjieExample = getLianjieExampleByEqualTo(pageWrap.getModel());
        lianjieExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Lianjie> list = lianjieMapper.selectByExample(lianjieExample);
        for (Lianjie info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Lianjie info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private LianjieExample getLianjieExampleByLike(Lianjie instance) {
        LianjieExample lianjieExample = new LianjieExample();
        LianjieExample.Criteria criteria = lianjieExample.createCriteria();
        //友情链接id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称name模糊匹配
        if (null != instance.getName() && !instance.getName().equals("")) {
            criteria.andNameLike("%" + instance.getName() + "%");
        }
        //链接地址url模糊匹配
        if (null != instance.getUrl() && !instance.getUrl().equals("")) {
            criteria.andUrlLike("%" + instance.getUrl() + "%");
        }

        return lianjieExample;
    }

    //字符类型完全相等查询条件构造器
    private LianjieExample getLianjieExampleByEqualTo(Lianjie instance) {
        LianjieExample lianjieExample = new LianjieExample();
        LianjieExample.Criteria criteria = lianjieExample.createCriteria();
        //友情链接id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称name完全匹配
        if (null != instance.getName() && !instance.getName().equals("")) {
            criteria.andNameEqualTo(instance.getName());
        }
        //链接地址url完全匹配
        if (null != instance.getUrl() && !instance.getUrl().equals("")) {
            criteria.andUrlEqualTo(instance.getUrl());
        }

        return lianjieExample;
    }
}
