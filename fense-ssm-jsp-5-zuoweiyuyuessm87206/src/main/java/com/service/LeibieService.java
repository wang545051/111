package com.service;

import com.entity.Leibie;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName LeibieService
 * @Description 类别模块业务层
 */
public interface LeibieService {

    //保存或更新类别表数据
    Integer saveOrUpdate(Leibie instance);

    //查询所有类别表数据
    List<Leibie> findAll();

    //根据条件(字符类型模糊)查询类别表数据
    List<Leibie> find(Leibie instance);

    //根据条件(字符类型完全匹配)查询类别表数据
    List<Leibie> findByEqualTo(Leibie instance);

    //根据条件(字符类型模糊)查询查询第一条类别表数据
    Leibie findOne(Leibie instance);

    //根据条件(字符类型完全匹配)查询查询第一条类别表数据
    Leibie findOneByEqualTo(Leibie instance);

    //根据id列查询类别表数据
    Leibie findById(Integer id);

    //根据id列删除类别表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询类别表数据
    PageData<Leibie> findPage(PageWrap<Leibie> pageWrap);

    //根据条件(字符类型完全匹配)分页查询类别表数据
    PageData<Leibie> findPageByEqualTo(PageWrap<Leibie> pageWrap);
}
