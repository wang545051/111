package com.service;

import com.entity.Gonggao;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName GonggaoService
 * @Description 公告模块业务层
 */
public interface GonggaoService {

    //保存或更新公告表数据
    Integer saveOrUpdate(Gonggao instance);

    //查询所有公告表数据
    List<Gonggao> findAll();

    //根据条件(字符类型模糊)查询公告表数据
    List<Gonggao> find(Gonggao instance);

    //根据条件(字符类型完全匹配)查询公告表数据
    List<Gonggao> findByEqualTo(Gonggao instance);

    //根据条件(字符类型模糊)查询查询第一条公告表数据
    Gonggao findOne(Gonggao instance);

    //根据条件(字符类型完全匹配)查询查询第一条公告表数据
    Gonggao findOneByEqualTo(Gonggao instance);

    //根据id列查询公告表数据
    Gonggao findById(Integer id);

    //根据id列删除公告表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询公告表数据
    PageData<Gonggao> findPage(PageWrap<Gonggao> pageWrap);

    //根据条件(字符类型完全匹配)分页查询公告表数据
    PageData<Gonggao> findPageByEqualTo(PageWrap<Gonggao> pageWrap);
}
