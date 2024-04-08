package com.service;

import com.entity.Louceng;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName LoucengService
 * @Description 楼层模块业务层
 */
public interface LoucengService {

    //保存或更新楼层表数据
    Integer saveOrUpdate(Louceng instance);

    //查询所有楼层表数据
    List<Louceng> findAll();

    //根据条件(字符类型模糊)查询楼层表数据
    List<Louceng> find(Louceng instance);

    //根据条件(字符类型完全匹配)查询楼层表数据
    List<Louceng> findByEqualTo(Louceng instance);

    //根据条件(字符类型模糊)查询查询第一条楼层表数据
    Louceng findOne(Louceng instance);

    //根据条件(字符类型完全匹配)查询查询第一条楼层表数据
    Louceng findOneByEqualTo(Louceng instance);

    //根据id列查询楼层表数据
    Louceng findById(Integer id);

    //根据id列删除楼层表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询楼层表数据
    PageData<Louceng> findPage(PageWrap<Louceng> pageWrap);

    //根据条件(字符类型完全匹配)分页查询楼层表数据
    PageData<Louceng> findPageByEqualTo(PageWrap<Louceng> pageWrap);
}
