package com.service;

import com.entity.Lizuo;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName LizuoService
 * @Description 离座模块业务层
 */
public interface LizuoService {

    //保存或更新离座表数据
    Integer saveOrUpdate(Lizuo instance);

    //查询所有离座表数据
    List<Lizuo> findAll();

    //根据条件(字符类型模糊)查询离座表数据
    List<Lizuo> find(Lizuo instance);

    //根据条件(字符类型完全匹配)查询离座表数据
    List<Lizuo> findByEqualTo(Lizuo instance);

    //根据条件(字符类型模糊)查询查询第一条离座表数据
    Lizuo findOne(Lizuo instance);

    //根据条件(字符类型完全匹配)查询查询第一条离座表数据
    Lizuo findOneByEqualTo(Lizuo instance);

    //根据id列查询离座表数据
    Lizuo findById(Integer id);

    //根据id列删除离座表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询离座表数据
    PageData<Lizuo> findPage(PageWrap<Lizuo> pageWrap);

    //根据条件(字符类型完全匹配)分页查询离座表数据
    PageData<Lizuo> findPageByEqualTo(PageWrap<Lizuo> pageWrap);
}
