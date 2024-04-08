package com.service;

import com.entity.Fangjian;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName FangjianService
 * @Description 房间模块业务层
 */
public interface FangjianService {

    //保存或更新房间表数据
    Integer saveOrUpdate(Fangjian instance);

    //查询所有房间表数据
    List<Fangjian> findAll();

    //根据条件(字符类型模糊)查询房间表数据
    List<Fangjian> find(Fangjian instance);

    //根据条件(字符类型完全匹配)查询房间表数据
    List<Fangjian> findByEqualTo(Fangjian instance);

    //根据条件(字符类型模糊)查询查询第一条房间表数据
    Fangjian findOne(Fangjian instance);

    //根据条件(字符类型完全匹配)查询查询第一条房间表数据
    Fangjian findOneByEqualTo(Fangjian instance);

    //根据id列查询房间表数据
    Fangjian findById(Integer id);

    //根据id列删除房间表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询房间表数据
    PageData<Fangjian> findPage(PageWrap<Fangjian> pageWrap);

    //根据条件(字符类型完全匹配)分页查询房间表数据
    PageData<Fangjian> findPageByEqualTo(PageWrap<Fangjian> pageWrap);
}
