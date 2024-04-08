package com.service;

import com.entity.Liuyan;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName LiuyanService
 * @Description 留言反馈模块业务层
 */
public interface LiuyanService {

    //保存或更新留言反馈表数据
    Integer saveOrUpdate(Liuyan instance);

    //查询所有留言反馈表数据
    List<Liuyan> findAll();

    //根据条件(字符类型模糊)查询留言反馈表数据
    List<Liuyan> find(Liuyan instance);

    //根据条件(字符类型完全匹配)查询留言反馈表数据
    List<Liuyan> findByEqualTo(Liuyan instance);

    //根据条件(字符类型模糊)查询查询第一条留言反馈表数据
    Liuyan findOne(Liuyan instance);

    //根据条件(字符类型完全匹配)查询查询第一条留言反馈表数据
    Liuyan findOneByEqualTo(Liuyan instance);

    //根据id列查询留言反馈表数据
    Liuyan findById(Integer id);

    //根据id列删除留言反馈表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询留言反馈表数据
    PageData<Liuyan> findPage(PageWrap<Liuyan> pageWrap);

    //根据条件(字符类型完全匹配)分页查询留言反馈表数据
    PageData<Liuyan> findPageByEqualTo(PageWrap<Liuyan> pageWrap);
}
