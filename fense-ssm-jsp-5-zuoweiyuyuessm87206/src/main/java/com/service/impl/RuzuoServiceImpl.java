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
 * @ClassName RuzuoServiceImpl
 * @Description 入座模块业务实现层
 */
@Service
public class RuzuoServiceImpl implements RuzuoService {

    @Autowired
    private RuzuoMapper ruzuoMapper;

    @Autowired
    private ZuoweiMapper zuoweiMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新入座表ruzuo
    @Override
    public Integer saveOrUpdate(Ruzuo instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            ruzuoMapper.updateByPrimaryKeySelective(instance);
        }else {
            ruzuoMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询入座表ruzuo
    @Override
    public List<Ruzuo> findAll() {
        List<Ruzuo> list = ruzuoMapper.selectByExample(null);
        for (Ruzuo info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询入座表ruzuo
    @Override
    public List<Ruzuo> find(Ruzuo instance) {
        RuzuoExample ruzuoExample = getRuzuoExampleByLike(instance);
        ruzuoExample.setOrderByClause(" id desc");
        List<Ruzuo> list = ruzuoMapper.selectByExample(ruzuoExample);
        for (Ruzuo info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询入座表ruzuo
    @Override
    public List<Ruzuo> findByEqualTo(Ruzuo instance) {
        RuzuoExample ruzuoExample = getRuzuoExampleByEqualTo(instance);
        ruzuoExample.setOrderByClause(" id desc");
        List<Ruzuo> list = ruzuoMapper.selectByExample(ruzuoExample);
        for (Ruzuo info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询入座表ruzuo最后一条数据
    @Override
    public Ruzuo findOne(Ruzuo instance) {
        List<Ruzuo> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询入座表ruzuo最后一条数据
    @Override
    public Ruzuo findOneByEqualTo(Ruzuo instance) {
        List<Ruzuo> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询入座表ruzuo数据
    @Override
    public Ruzuo findById(Integer id) {
        Ruzuo info = ruzuoMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除入座表ruzuo数据
    @Override
    public int deleteById(Integer id) {
        return ruzuoMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询入座表ruzuo数据
    @Override
    public PageData<Ruzuo> findPage(PageWrap<Ruzuo> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        RuzuoExample ruzuoExample = getRuzuoExampleByLike(pageWrap.getModel());
        ruzuoExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Ruzuo> list = ruzuoMapper.selectByExample(ruzuoExample);
        for (Ruzuo info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询入座表ruzuo数据
    @Override
    public PageData<Ruzuo> findPageByEqualTo(PageWrap<Ruzuo> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        RuzuoExample ruzuoExample = getRuzuoExampleByEqualTo(pageWrap.getModel());
        ruzuoExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Ruzuo> list = ruzuoMapper.selectByExample(ruzuoExample);
        for (Ruzuo info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Ruzuo info){
        if (null != info){
            Zuowei zuowei= zuoweiMapper.selectByPrimaryKey(info.getZuoweiid());
            info.setZuowei(zuowei);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersslid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private RuzuoExample getRuzuoExampleByLike(Ruzuo instance) {
        RuzuoExample ruzuoExample = new RuzuoExample();
        RuzuoExample.Criteria criteria = ruzuoExample.createCriteria();
        //入座id完全匹配
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

        return ruzuoExample;
    }

    //字符类型完全相等查询条件构造器
    private RuzuoExample getRuzuoExampleByEqualTo(Ruzuo instance) {
        RuzuoExample ruzuoExample = new RuzuoExample();
        RuzuoExample.Criteria criteria = ruzuoExample.createCriteria();
        //入座id完全匹配
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

        return ruzuoExample;
    }
}
