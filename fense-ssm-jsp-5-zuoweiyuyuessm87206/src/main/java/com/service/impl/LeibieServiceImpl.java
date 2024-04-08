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
 * @ClassName LeibieServiceImpl
 * @Description 类别模块业务实现层
 */
@Service
public class LeibieServiceImpl implements LeibieService {

    @Autowired
    private LeibieMapper leibieMapper;



    //保存或更新类别表leibie
    @Override
    public Integer saveOrUpdate(Leibie instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            leibieMapper.updateByPrimaryKeySelective(instance);
        }else {
            leibieMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询类别表leibie
    @Override
    public List<Leibie> findAll() {
        List<Leibie> list = leibieMapper.selectByExample(null);
        for (Leibie info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询类别表leibie
    @Override
    public List<Leibie> find(Leibie instance) {
        LeibieExample leibieExample = getLeibieExampleByLike(instance);
        leibieExample.setOrderByClause(" id desc");
        List<Leibie> list = leibieMapper.selectByExample(leibieExample);
        for (Leibie info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询类别表leibie
    @Override
    public List<Leibie> findByEqualTo(Leibie instance) {
        LeibieExample leibieExample = getLeibieExampleByEqualTo(instance);
        leibieExample.setOrderByClause(" id desc");
        List<Leibie> list = leibieMapper.selectByExample(leibieExample);
        for (Leibie info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询类别表leibie最后一条数据
    @Override
    public Leibie findOne(Leibie instance) {
        List<Leibie> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询类别表leibie最后一条数据
    @Override
    public Leibie findOneByEqualTo(Leibie instance) {
        List<Leibie> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询类别表leibie数据
    @Override
    public Leibie findById(Integer id) {
        Leibie info = leibieMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除类别表leibie数据
    @Override
    public int deleteById(Integer id) {
        return leibieMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询类别表leibie数据
    @Override
    public PageData<Leibie> findPage(PageWrap<Leibie> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LeibieExample leibieExample = getLeibieExampleByLike(pageWrap.getModel());
        leibieExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Leibie> list = leibieMapper.selectByExample(leibieExample);
        for (Leibie info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询类别表leibie数据
    @Override
    public PageData<Leibie> findPageByEqualTo(PageWrap<Leibie> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LeibieExample leibieExample = getLeibieExampleByEqualTo(pageWrap.getModel());
        leibieExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Leibie> list = leibieMapper.selectByExample(leibieExample);
        for (Leibie info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Leibie info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private LeibieExample getLeibieExampleByLike(Leibie instance) {
        LeibieExample leibieExample = new LeibieExample();
        LeibieExample.Criteria criteria = leibieExample.createCriteria();
        //类别id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return leibieExample;
    }

    //字符类型完全相等查询条件构造器
    private LeibieExample getLeibieExampleByEqualTo(Leibie instance) {
        LeibieExample leibieExample = new LeibieExample();
        LeibieExample.Criteria criteria = leibieExample.createCriteria();
        //类别id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return leibieExample;
    }
}
