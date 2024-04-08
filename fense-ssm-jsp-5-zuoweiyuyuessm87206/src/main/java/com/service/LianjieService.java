package com.service;

import com.entity.Lianjie;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName LianjieService
 * @Description 友情链接模块业务层
 */
public interface LianjieService {

    //保存或更新友情链接表数据
    Integer saveOrUpdate(Lianjie instance);

    //查询所有友情链接表数据
    List<Lianjie> findAll();

    //根据条件(字符类型模糊)查询友情链接表数据
    List<Lianjie> find(Lianjie instance);

    //根据条件(字符类型完全匹配)查询友情链接表数据
    List<Lianjie> findByEqualTo(Lianjie instance);

    //根据条件(字符类型模糊)查询查询第一条友情链接表数据
    Lianjie findOne(Lianjie instance);

    //根据条件(字符类型完全匹配)查询查询第一条友情链接表数据
    Lianjie findOneByEqualTo(Lianjie instance);

    //根据id列查询友情链接表数据
    Lianjie findById(Integer id);

    //根据id列删除友情链接表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询友情链接表数据
    PageData<Lianjie> findPage(PageWrap<Lianjie> pageWrap);

    //根据条件(字符类型完全匹配)分页查询友情链接表数据
    PageData<Lianjie> findPageByEqualTo(PageWrap<Lianjie> pageWrap);
}
