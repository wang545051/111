package com.service;

import com.entity.Users;
import com.util.PageData;
import com.util.PageWrap;

import java.util.List;

/**
 * @ClassName UsersService
 * @Description 用户模块业务层
 */
public interface UsersService {

    //保存或更新用户表数据
    Integer saveOrUpdate(Users instance);

    //查询所有用户表数据
    List<Users> findAll();

    //根据条件(字符类型模糊)查询用户表数据
    List<Users> find(Users instance);

    //根据条件(字符类型完全匹配)查询用户表数据
    List<Users> findByEqualTo(Users instance);

    //根据条件(字符类型模糊)查询查询第一条用户表数据
    Users findOne(Users instance);

    //根据条件(字符类型完全匹配)查询查询第一条用户表数据
    Users findOneByEqualTo(Users instance);

    //根据id列查询用户表数据
    Users findById(Integer id);

    //根据id列删除用户表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询用户表数据
    PageData<Users> findPage(PageWrap<Users> pageWrap);

    //根据条件(字符类型完全匹配)分页查询用户表数据
    PageData<Users> findPageByEqualTo(PageWrap<Users> pageWrap);
}
