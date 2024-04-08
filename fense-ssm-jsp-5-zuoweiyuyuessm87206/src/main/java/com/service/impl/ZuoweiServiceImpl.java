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
 * @ClassName ZuoweiServiceImpl
 * @Description 座位模块业务实现层
 */
@Service
public class ZuoweiServiceImpl implements ZuoweiService {

    @Autowired
    private ZuoweiMapper zuoweiMapper;

    @Autowired
    private LeibieMapper leibieMapper;
    @Autowired
    private LoucengMapper loucengMapper;
    @Autowired
    private FangjianMapper fangjianMapper;


    //保存或更新座位表zuowei
    @Override
    public Integer saveOrUpdate(Zuowei instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            zuoweiMapper.updateByPrimaryKeySelective(instance);
        }else {
            zuoweiMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询座位表zuowei
    @Override
    public List<Zuowei> findAll() {
        List<Zuowei> list = zuoweiMapper.selectByExample(null);
        for (Zuowei info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询座位表zuowei
    @Override
    public List<Zuowei> find(Zuowei instance) {
        ZuoweiExample zuoweiExample = getZuoweiExampleByLike(instance);
        zuoweiExample.setOrderByClause(" id desc");
        List<Zuowei> list = zuoweiMapper.selectByExample(zuoweiExample);
        for (Zuowei info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询座位表zuowei
    @Override
    public List<Zuowei> findByEqualTo(Zuowei instance) {
        ZuoweiExample zuoweiExample = getZuoweiExampleByEqualTo(instance);
        zuoweiExample.setOrderByClause(" id desc");
        List<Zuowei> list = zuoweiMapper.selectByExample(zuoweiExample);
        for (Zuowei info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询座位表zuowei最后一条数据
    @Override
    public Zuowei findOne(Zuowei instance) {
        List<Zuowei> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询座位表zuowei最后一条数据
    @Override
    public Zuowei findOneByEqualTo(Zuowei instance) {
        List<Zuowei> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询座位表zuowei数据
    @Override
    public Zuowei findById(Integer id) {
        Zuowei info = zuoweiMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除座位表zuowei数据
    @Override
    public int deleteById(Integer id) {
        return zuoweiMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询座位表zuowei数据
    @Override
    public PageData<Zuowei> findPage(PageWrap<Zuowei> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ZuoweiExample zuoweiExample = getZuoweiExampleByLike(pageWrap.getModel());
        zuoweiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Zuowei> list = zuoweiMapper.selectByExample(zuoweiExample);
        for (Zuowei info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询座位表zuowei数据
    @Override
    public PageData<Zuowei> findPageByEqualTo(PageWrap<Zuowei> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ZuoweiExample zuoweiExample = getZuoweiExampleByEqualTo(pageWrap.getModel());
        zuoweiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Zuowei> list = zuoweiMapper.selectByExample(zuoweiExample);
        for (Zuowei info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Zuowei info){
        if (null != info){
            Leibie leibie= leibieMapper.selectByPrimaryKey(info.getLeibieid());
            info.setLeibie(leibie);
            Louceng louceng= loucengMapper.selectByPrimaryKey(info.getLoucengid());
            info.setLouceng(louceng);
            Fangjian fangjian= fangjianMapper.selectByPrimaryKey(info.getFangjianid());
            info.setFangjian(fangjian);

        }
    }

    //字符类型模糊查询条件构造器
    private ZuoweiExample getZuoweiExampleByLike(Zuowei instance) {
        ZuoweiExample zuoweiExample = new ZuoweiExample();
        ZuoweiExample.Criteria criteria = zuoweiExample.createCriteria();
        //座位id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //编号bianhao模糊匹配
        if (null != instance.getBianhao() && !instance.getBianhao().equals("")) {
            criteria.andBianhaoLike("%" + instance.getBianhao() + "%");
        }
        //类别idleibieid完全匹配
        if (null != instance.getLeibieid()) {
            criteria.andLeibieidEqualTo(instance.getLeibieid());
        }
        //楼层idloucengid完全匹配
        if (null != instance.getLoucengid()) {
            criteria.andLoucengidEqualTo(instance.getLoucengid());
        }
        //房间idfangjianid完全匹配
        if (null != instance.getFangjianid()) {
            criteria.andFangjianidEqualTo(instance.getFangjianid());
        }
        //座位介绍neirong模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }
        //是否空闲shenhe模糊匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheLike("%" + instance.getShenhe() + "%");
        }
        //环境图片image模糊匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageLike("%" + instance.getImage() + "%");
        }

        return zuoweiExample;
    }

    //字符类型完全相等查询条件构造器
    private ZuoweiExample getZuoweiExampleByEqualTo(Zuowei instance) {
        ZuoweiExample zuoweiExample = new ZuoweiExample();
        ZuoweiExample.Criteria criteria = zuoweiExample.createCriteria();
        //座位id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //编号bianhao完全匹配
        if (null != instance.getBianhao() && !instance.getBianhao().equals("")) {
            criteria.andBianhaoEqualTo(instance.getBianhao());
        }
        //类别idleibieid完全匹配
        if (null != instance.getLeibieid()) {
            criteria.andLeibieidEqualTo(instance.getLeibieid());
        }
        //楼层idloucengid完全匹配
        if (null != instance.getLoucengid()) {
            criteria.andLoucengidEqualTo(instance.getLoucengid());
        }
        //房间idfangjianid完全匹配
        if (null != instance.getFangjianid()) {
            criteria.andFangjianidEqualTo(instance.getFangjianid());
        }
        //座位介绍neirong完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }
        //是否空闲shenhe完全匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheEqualTo(instance.getShenhe());
        }
        //环境图片image完全匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageEqualTo(instance.getImage());
        }

        return zuoweiExample;
    }
}
