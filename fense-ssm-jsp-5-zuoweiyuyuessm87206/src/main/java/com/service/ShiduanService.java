package com.service;

import com.entity.Shiduan;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName ShiduanService
 * @Description 时段模块业务层
 */
public interface ShiduanService {

    //保存或更新时段表数据
    Integer saveOrUpdate(Shiduan instance);

    //查询所有时段表数据
    List<Shiduan> findAll();

    //根据条件(字符类型模糊)查询时段表数据
    List<Shiduan> find(Shiduan instance);

    //根据条件(字符类型完全匹配)查询时段表数据
    List<Shiduan> findByEqualTo(Shiduan instance);

    //根据条件(字符类型模糊)查询查询第一条时段表数据
    Shiduan findOne(Shiduan instance);

    //根据条件(字符类型完全匹配)查询查询第一条时段表数据
    Shiduan findOneByEqualTo(Shiduan instance);

    //根据id列查询时段表数据
    Shiduan findById(Integer id);

    //根据id列删除时段表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询时段表数据
    PageData<Shiduan> findPage(PageWrap<Shiduan> pageWrap);

    //根据条件(字符类型完全匹配)分页查询时段表数据
    PageData<Shiduan> findPageByEqualTo(PageWrap<Shiduan> pageWrap);
}
