package com.service;

import com.entity.Ruzuo;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName RuzuoService
 * @Description 入座模块业务层
 */
public interface RuzuoService {

    //保存或更新入座表数据
    Integer saveOrUpdate(Ruzuo instance);

    //查询所有入座表数据
    List<Ruzuo> findAll();

    //根据条件(字符类型模糊)查询入座表数据
    List<Ruzuo> find(Ruzuo instance);

    //根据条件(字符类型完全匹配)查询入座表数据
    List<Ruzuo> findByEqualTo(Ruzuo instance);

    //根据条件(字符类型模糊)查询查询第一条入座表数据
    Ruzuo findOne(Ruzuo instance);

    //根据条件(字符类型完全匹配)查询查询第一条入座表数据
    Ruzuo findOneByEqualTo(Ruzuo instance);

    //根据id列查询入座表数据
    Ruzuo findById(Integer id);

    //根据id列删除入座表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询入座表数据
    PageData<Ruzuo> findPage(PageWrap<Ruzuo> pageWrap);

    //根据条件(字符类型完全匹配)分页查询入座表数据
    PageData<Ruzuo> findPageByEqualTo(PageWrap<Ruzuo> pageWrap);
}
