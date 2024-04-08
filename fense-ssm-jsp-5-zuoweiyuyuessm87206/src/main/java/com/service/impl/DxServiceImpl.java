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
 * @ClassName DxServiceImpl
 * @Description 介绍模块业务实现层
 */
@Service
public class DxServiceImpl implements DxService {

    @Autowired
    private DxMapper dxMapper;



    //保存或更新介绍表dx
    @Override
    public Integer saveOrUpdate(Dx instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            dxMapper.updateByPrimaryKeySelective(instance);
        }else {
            dxMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询介绍表dx
    @Override
    public List<Dx> findAll() {
        List<Dx> list = dxMapper.selectByExample(null);
        for (Dx info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询介绍表dx
    @Override
    public List<Dx> find(Dx instance) {
        DxExample dxExample = getDxExampleByLike(instance);
        dxExample.setOrderByClause(" id desc");
        List<Dx> list = dxMapper.selectByExample(dxExample);
        for (Dx info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询介绍表dx
    @Override
    public List<Dx> findByEqualTo(Dx instance) {
        DxExample dxExample = getDxExampleByEqualTo(instance);
        dxExample.setOrderByClause(" id desc");
        List<Dx> list = dxMapper.selectByExample(dxExample);
        for (Dx info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询介绍表dx最后一条数据
    @Override
    public Dx findOne(Dx instance) {
        List<Dx> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询介绍表dx最后一条数据
    @Override
    public Dx findOneByEqualTo(Dx instance) {
        List<Dx> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询介绍表dx数据
    @Override
    public Dx findById(Integer id) {
        Dx info = dxMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除介绍表dx数据
    @Override
    public int deleteById(Integer id) {
        return dxMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询介绍表dx数据
    @Override
    public PageData<Dx> findPage(PageWrap<Dx> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        DxExample dxExample = getDxExampleByLike(pageWrap.getModel());
        dxExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Dx> list = dxMapper.selectByExample(dxExample);
        for (Dx info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询介绍表dx数据
    @Override
    public PageData<Dx> findPageByEqualTo(PageWrap<Dx> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        DxExample dxExample = getDxExampleByEqualTo(pageWrap.getModel());
        dxExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Dx> list = dxMapper.selectByExample(dxExample);
        for (Dx info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Dx info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private DxExample getDxExampleByLike(Dx instance) {
        DxExample dxExample = new DxExample();
        DxExample.Criteria criteria = dxExample.createCriteria();
        //介绍id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //类别leibie模糊匹配
        if (null != instance.getLeibie() && !instance.getLeibie().equals("")) {
            criteria.andLeibieLike("%" + instance.getLeibie() + "%");
        }
        //内容content模糊匹配
        if (null != instance.getContent() && !instance.getContent().equals("")) {
            criteria.andContentLike("%" + instance.getContent() + "%");
        }
        //时间addtime模糊匹配
        if (null != instance.getAddtime() && !instance.getAddtime().equals("")) {
            criteria.andAddtimeLike("%" + instance.getAddtime() + "%");
        }

        return dxExample;
    }

    //字符类型完全相等查询条件构造器
    private DxExample getDxExampleByEqualTo(Dx instance) {
        DxExample dxExample = new DxExample();
        DxExample.Criteria criteria = dxExample.createCriteria();
        //介绍id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //类别leibie完全匹配
        if (null != instance.getLeibie() && !instance.getLeibie().equals("")) {
            criteria.andLeibieEqualTo(instance.getLeibie());
        }
        //内容content完全匹配
        if (null != instance.getContent() && !instance.getContent().equals("")) {
            criteria.andContentEqualTo(instance.getContent());
        }
        //时间addtime完全匹配
        if (null != instance.getAddtime() && !instance.getAddtime().equals("")) {
            criteria.andAddtimeEqualTo(instance.getAddtime());
        }

        return dxExample;
    }
}
