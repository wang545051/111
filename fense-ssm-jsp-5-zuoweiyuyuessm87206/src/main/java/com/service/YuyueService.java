package com.service;

import com.entity.Yuyue;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName YuyueService
 * @Description 预约模块业务层
 */
public interface YuyueService {

    //保存或更新预约表数据
    Integer saveOrUpdate(Yuyue instance);

    //查询所有预约表数据
    List<Yuyue> findAll();

    //根据条件(字符类型模糊)查询预约表数据
    List<Yuyue> find(Yuyue instance);

    //根据条件(字符类型完全匹配)查询预约表数据
    List<Yuyue> findByEqualTo(Yuyue instance);

    //根据条件(字符类型模糊)查询查询第一条预约表数据
    Yuyue findOne(Yuyue instance);

    //根据条件(字符类型完全匹配)查询查询第一条预约表数据
    Yuyue findOneByEqualTo(Yuyue instance);

    //根据id列查询预约表数据
    Yuyue findById(Integer id);

    //根据id列删除预约表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询预约表数据
    PageData<Yuyue> findPage(PageWrap<Yuyue> pageWrap);

    //根据条件(字符类型完全匹配)分页查询预约表数据
    PageData<Yuyue> findPageByEqualTo(PageWrap<Yuyue> pageWrap);
}
