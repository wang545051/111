package com.dao;

import com.entity.Shiduan;
import com.entity.ShiduanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ShiduanMapper
 * @Description 时段模块数据持久层
 */
public interface ShiduanMapper {

    //根据条件获取时段表shiduan的数据数量
    int countByExample(ShiduanExample example);

    //根据条件删除时段表shiduan的数据
    int deleteByExample(ShiduanExample example);

    //根据主键ID列删除时段表shiduan的数据
    int deleteByPrimaryKey(Integer id);

    //插入时段表shiduan的实体数据（包含null值）
    int insert(Shiduan record);

    //插入时段表shiduan的实体数据（不包含null值）
    int insertSelective(Shiduan record);

    //根据条件获取时段表shiduan的数据列表
    List<Shiduan> selectByExample(ShiduanExample example);

    //根据主键ID列获取时段表shiduan的数据实体
    Shiduan selectByPrimaryKey(Integer id);

    //根据条件更新时段表shiduan的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Shiduan record, @Param("example") ShiduanExample example);

    //根据条件更新时段表shiduan的实体数据（包含null值）
    int updateByExample(@Param("record") Shiduan record, @Param("example") ShiduanExample example);

    //根据主键ID列更新时段表shiduan的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Shiduan record);

    //根据主键ID列更新时段表shiduan的实体数据（包含null值）
    int updateByPrimaryKey(Shiduan record);
}
