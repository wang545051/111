package com.dao;

import com.entity.Leibie;
import com.entity.LeibieExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName LeibieMapper
 * @Description 类别模块数据持久层
 */
public interface LeibieMapper {

    //根据条件获取类别表leibie的数据数量
    int countByExample(LeibieExample example);

    //根据条件删除类别表leibie的数据
    int deleteByExample(LeibieExample example);

    //根据主键ID列删除类别表leibie的数据
    int deleteByPrimaryKey(Integer id);

    //插入类别表leibie的实体数据（包含null值）
    int insert(Leibie record);

    //插入类别表leibie的实体数据（不包含null值）
    int insertSelective(Leibie record);

    //根据条件获取类别表leibie的数据列表
    List<Leibie> selectByExample(LeibieExample example);

    //根据主键ID列获取类别表leibie的数据实体
    Leibie selectByPrimaryKey(Integer id);

    //根据条件更新类别表leibie的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Leibie record, @Param("example") LeibieExample example);

    //根据条件更新类别表leibie的实体数据（包含null值）
    int updateByExample(@Param("record") Leibie record, @Param("example") LeibieExample example);

    //根据主键ID列更新类别表leibie的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Leibie record);

    //根据主键ID列更新类别表leibie的实体数据（包含null值）
    int updateByPrimaryKey(Leibie record);
}
