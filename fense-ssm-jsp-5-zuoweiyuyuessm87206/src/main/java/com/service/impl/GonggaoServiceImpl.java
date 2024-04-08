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
 * @ClassName GonggaoServiceImpl
 * @Description 公告模块业务实现层
 */
@Service
public class GonggaoServiceImpl implements GonggaoService {

    @Autowired
    private GonggaoMapper gonggaoMapper;



    //保存或更新公告表gonggao
    @Override
    public Integer saveOrUpdate(Gonggao instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            gonggaoMapper.updateByPrimaryKeySelective(instance);
        }else {
            gonggaoMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询公告表gonggao
    @Override
    public List<Gonggao> findAll() {
        List<Gonggao> list = gonggaoMapper.selectByExample(null);
        for (Gonggao info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询公告表gonggao
    @Override
    public List<Gonggao> find(Gonggao instance) {
        GonggaoExample gonggaoExample = getGonggaoExampleByLike(instance);
        gonggaoExample.setOrderByClause(" id desc");
        List<Gonggao> list = gonggaoMapper.selectByExample(gonggaoExample);
        for (Gonggao info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询公告表gonggao
    @Override
    public List<Gonggao> findByEqualTo(Gonggao instance) {
        GonggaoExample gonggaoExample = getGonggaoExampleByEqualTo(instance);
        gonggaoExample.setOrderByClause(" id desc");
        List<Gonggao> list = gonggaoMapper.selectByExample(gonggaoExample);
        for (Gonggao info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询公告表gonggao最后一条数据
    @Override
    public Gonggao findOne(Gonggao instance) {
        List<Gonggao> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询公告表gonggao最后一条数据
    @Override
    public Gonggao findOneByEqualTo(Gonggao instance) {
        List<Gonggao> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询公告表gonggao数据
    @Override
    public Gonggao findById(Integer id) {
        Gonggao info = gonggaoMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除公告表gonggao数据
    @Override
    public int deleteById(Integer id) {
        return gonggaoMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询公告表gonggao数据
    @Override
    public PageData<Gonggao> findPage(PageWrap<Gonggao> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        GonggaoExample gonggaoExample = getGonggaoExampleByLike(pageWrap.getModel());
        gonggaoExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Gonggao> list = gonggaoMapper.selectByExample(gonggaoExample);
        for (Gonggao info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询公告表gonggao数据
    @Override
    public PageData<Gonggao> findPageByEqualTo(PageWrap<Gonggao> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        GonggaoExample gonggaoExample = getGonggaoExampleByEqualTo(pageWrap.getModel());
        gonggaoExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Gonggao> list = gonggaoMapper.selectByExample(gonggaoExample);
        for (Gonggao info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Gonggao info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private GonggaoExample getGonggaoExampleByLike(Gonggao instance) {
        GonggaoExample gonggaoExample = new GonggaoExample();
        GonggaoExample.Criteria criteria = gonggaoExample.createCriteria();
        //公告id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //标题biaoti模糊匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiLike("%" + instance.getBiaoti() + "%");
        }
        //内容neirong模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }
        //图片image模糊匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageLike("%" + instance.getImage() + "%");
        }
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }

        return gonggaoExample;
    }

    //字符类型完全相等查询条件构造器
    private GonggaoExample getGonggaoExampleByEqualTo(Gonggao instance) {
        GonggaoExample gonggaoExample = new GonggaoExample();
        GonggaoExample.Criteria criteria = gonggaoExample.createCriteria();
        //公告id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //标题biaoti完全匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiEqualTo(instance.getBiaoti());
        }
        //内容neirong完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }
        //图片image完全匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageEqualTo(instance.getImage());
        }
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }

        return gonggaoExample;
    }
}
