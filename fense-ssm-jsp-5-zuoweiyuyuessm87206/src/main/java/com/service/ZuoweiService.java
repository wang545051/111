package com.service;

import com.entity.Zuowei;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName ZuoweiService
 * @Description 座位模块业务层
 */
public interface ZuoweiService {

    //保存或更新座位表数据
    Integer saveOrUpdate(Zuowei instance);

    //查询所有座位表数据
    List<Zuowei> findAll();

    //根据条件(字符类型模糊)查询座位表数据
    List<Zuowei> find(Zuowei instance);

    //根据条件(字符类型完全匹配)查询座位表数据
    List<Zuowei> findByEqualTo(Zuowei instance);

    //根据条件(字符类型模糊)查询查询第一条座位表数据
    Zuowei findOne(Zuowei instance);

    //根据条件(字符类型完全匹配)查询查询第一条座位表数据
    Zuowei findOneByEqualTo(Zuowei instance);

    //根据id列查询座位表数据
    Zuowei findById(Integer id);

    //根据id列删除座位表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询座位表数据
    PageData<Zuowei> findPage(PageWrap<Zuowei> pageWrap);

    //根据条件(字符类型完全匹配)分页查询座位表数据
    PageData<Zuowei> findPageByEqualTo(PageWrap<Zuowei> pageWrap);
}
