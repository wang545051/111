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
 * @ClassName LizuoServiceImpl
 * @Description 离座模块业务实现层
 */
@Service
public class LizuoServiceImpl implements LizuoService {

    @Autowired
    private LizuoMapper lizuoMapper;

    @Autowired
    private ZuoweiMapper zuoweiMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新离座表lizuo
    @Override
    public Integer saveOrUpdate(Lizuo instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            lizuoMapper.updateByPrimaryKeySelective(instance);
        }else {
            lizuoMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询离座表lizuo
    @Override
    public List<Lizuo> findAll() {
        List<Lizuo> list = lizuoMapper.selectByExample(null);
        for (Lizuo info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询离座表lizuo
    @Override
    public List<Lizuo> find(Lizuo instance) {
        LizuoExample lizuoExample = getLizuoExampleByLike(instance);
        lizuoExample.setOrderByClause(" id desc");
        List<Lizuo> list = lizuoMapper.selectByExample(lizuoExample);
        for (Lizuo info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询离座表lizuo
    @Override
    public List<Lizuo> findByEqualTo(Lizuo instance) {
        LizuoExample lizuoExample = getLizuoExampleByEqualTo(instance);
        lizuoExample.setOrderByClause(" id desc");
        List<Lizuo> list = lizuoMapper.selectByExample(lizuoExample);
        for (Lizuo info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询离座表lizuo最后一条数据
    @Override
    public Lizuo findOne(Lizuo instance) {
        List<Lizuo> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询离座表lizuo最后一条数据
    @Override
    public Lizuo findOneByEqualTo(Lizuo instance) {
        List<Lizuo> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询离座表lizuo数据
    @Override
    public Lizuo findById(Integer id) {
        Lizuo info = lizuoMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除离座表lizuo数据
    @Override
    public int deleteById(Integer id) {
        return lizuoMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询离座表lizuo数据
    @Override
    public PageData<Lizuo> findPage(PageWrap<Lizuo> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LizuoExample lizuoExample = getLizuoExampleByLike(pageWrap.getModel());
        lizuoExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Lizuo> list = lizuoMapper.selectByExample(lizuoExample);
        for (Lizuo info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询离座表lizuo数据
    @Override
    public PageData<Lizuo> findPageByEqualTo(PageWrap<Lizuo> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LizuoExample lizuoExample = getLizuoExampleByEqualTo(pageWrap.getModel());
        lizuoExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Lizuo> list = lizuoMapper.selectByExample(lizuoExample);
        for (Lizuo info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Lizuo info){
        if (null != info){
            Zuowei zuowei= zuoweiMapper.selectByPrimaryKey(info.getZuoweiid());
            info.setZuowei(zuowei);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersslid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private LizuoExample getLizuoExampleByLike(Lizuo instance) {
        LizuoExample lizuoExample = new LizuoExample();
        LizuoExample.Criteria criteria = lizuoExample.createCriteria();
        //离座id完全匹配
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
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }
        //备注beizhu模糊匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuLike("%" + instance.getBeizhu() + "%");
        }
        //用户idusersslid完全匹配
        if (null != instance.getUsersslid()) {
            criteria.andUsersslidEqualTo(instance.getUsersslid());
        }

        return lizuoExample;
    }

    //字符类型完全相等查询条件构造器
    private LizuoExample getLizuoExampleByEqualTo(Lizuo instance) {
        LizuoExample lizuoExample = new LizuoExample();
        LizuoExample.Criteria criteria = lizuoExample.createCriteria();
        //离座id完全匹配
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
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }
        //备注beizhu完全匹配
        if (null != instance.getBeizhu() && !instance.getBeizhu().equals("")) {
            criteria.andBeizhuEqualTo(instance.getBeizhu());
        }
        //用户idusersslid完全匹配
        if (null != instance.getUsersslid()) {
            criteria.andUsersslidEqualTo(instance.getUsersslid());
        }

        return lizuoExample;
    }
}
