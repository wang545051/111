package com.service;

import com.entity.Lunbo;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName LunboService
 * @Description 轮播图模块业务层
 */
public interface LunboService {

    //保存或更新轮播图表数据
    Integer saveOrUpdate(Lunbo instance);

    //查询所有轮播图表数据
    List<Lunbo> findAll();

    //根据条件(字符类型模糊)查询轮播图表数据
    List<Lunbo> find(Lunbo instance);

    //根据条件(字符类型完全匹配)查询轮播图表数据
    List<Lunbo> findByEqualTo(Lunbo instance);

    //根据条件(字符类型模糊)查询查询第一条轮播图表数据
    Lunbo findOne(Lunbo instance);

    //根据条件(字符类型完全匹配)查询查询第一条轮播图表数据
    Lunbo findOneByEqualTo(Lunbo instance);

    //根据id列查询轮播图表数据
    Lunbo findById(Integer id);

    //根据id列删除轮播图表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询轮播图表数据
    PageData<Lunbo> findPage(PageWrap<Lunbo> pageWrap);

    //根据条件(字符类型完全匹配)分页查询轮播图表数据
    PageData<Lunbo> findPageByEqualTo(PageWrap<Lunbo> pageWrap);
}
