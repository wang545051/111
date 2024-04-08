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
 * @ClassName LiuyanServiceImpl
 * @Description 留言反馈模块业务实现层
 */
@Service
public class LiuyanServiceImpl implements LiuyanService {

    @Autowired
    private LiuyanMapper liuyanMapper;

    @Autowired
    private UsersMapper usersMapper;


    //保存或更新留言反馈表liuyan
    @Override
    public Integer saveOrUpdate(Liuyan instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            liuyanMapper.updateByPrimaryKeySelective(instance);
        }else {
            liuyanMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询留言反馈表liuyan
    @Override
    public List<Liuyan> findAll() {
        List<Liuyan> list = liuyanMapper.selectByExample(null);
        for (Liuyan info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询留言反馈表liuyan
    @Override
    public List<Liuyan> find(Liuyan instance) {
        LiuyanExample liuyanExample = getLiuyanExampleByLike(instance);
        liuyanExample.setOrderByClause(" id desc");
        List<Liuyan> list = liuyanMapper.selectByExample(liuyanExample);
        for (Liuyan info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询留言反馈表liuyan
    @Override
    public List<Liuyan> findByEqualTo(Liuyan instance) {
        LiuyanExample liuyanExample = getLiuyanExampleByEqualTo(instance);
        liuyanExample.setOrderByClause(" id desc");
        List<Liuyan> list = liuyanMapper.selectByExample(liuyanExample);
        for (Liuyan info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询留言反馈表liuyan最后一条数据
    @Override
    public Liuyan findOne(Liuyan instance) {
        List<Liuyan> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询留言反馈表liuyan最后一条数据
    @Override
    public Liuyan findOneByEqualTo(Liuyan instance) {
        List<Liuyan> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询留言反馈表liuyan数据
    @Override
    public Liuyan findById(Integer id) {
        Liuyan info = liuyanMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除留言反馈表liuyan数据
    @Override
    public int deleteById(Integer id) {
        return liuyanMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询留言反馈表liuyan数据
    @Override
    public PageData<Liuyan> findPage(PageWrap<Liuyan> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LiuyanExample liuyanExample = getLiuyanExampleByLike(pageWrap.getModel());
        liuyanExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Liuyan> list = liuyanMapper.selectByExample(liuyanExample);
        for (Liuyan info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询留言反馈表liuyan数据
    @Override
    public PageData<Liuyan> findPageByEqualTo(PageWrap<Liuyan> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LiuyanExample liuyanExample = getLiuyanExampleByEqualTo(pageWrap.getModel());
        liuyanExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Liuyan> list = liuyanMapper.selectByExample(liuyanExample);
        for (Liuyan info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //父表信息
    private void setFatherInfo(Liuyan info){
        if (null != info){
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private LiuyanExample getLiuyanExampleByLike(Liuyan instance) {
        LiuyanExample liuyanExample = new LiuyanExample();
        LiuyanExample.Criteria criteria = liuyanExample.createCriteria();
        //留言反馈id完全匹配
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
        //留言时间liuyanshijian模糊匹配
        if (null != instance.getLiuyanshijian() && !instance.getLiuyanshijian().equals("")) {
            criteria.andLiuyanshijianLike("%" + instance.getLiuyanshijian() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }
        //回复huifu模糊匹配
        if (null != instance.getHuifu() && !instance.getHuifu().equals("")) {
            criteria.andHuifuLike("%" + instance.getHuifu() + "%");
        }

        return liuyanExample;
    }

    //字符类型完全相等查询条件构造器
    private LiuyanExample getLiuyanExampleByEqualTo(Liuyan instance) {
        LiuyanExample liuyanExample = new LiuyanExample();
        LiuyanExample.Criteria criteria = liuyanExample.createCriteria();
        //留言反馈id完全匹配
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
        //留言时间liuyanshijian完全匹配
        if (null != instance.getLiuyanshijian() && !instance.getLiuyanshijian().equals("")) {
            criteria.andLiuyanshijianEqualTo(instance.getLiuyanshijian());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }
        //回复huifu完全匹配
        if (null != instance.getHuifu() && !instance.getHuifu().equals("")) {
            criteria.andHuifuEqualTo(instance.getHuifu());
        }

        return liuyanExample;
    }
}
