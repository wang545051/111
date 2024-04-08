package com.dao;

import com.entity.Lizuo;
import com.entity.LizuoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName LizuoMapper
 * @Description 离座模块数据持久层
 */
public interface LizuoMapper {

    //根据条件获取离座表lizuo的数据数量
    int countByExample(LizuoExample example);

    //根据条件删除离座表lizuo的数据
    int deleteByExample(LizuoExample example);

    //根据主键ID列删除离座表lizuo的数据
    int deleteByPrimaryKey(Integer id);

    //插入离座表lizuo的实体数据（包含null值）
    int insert(Lizuo record);

    //插入离座表lizuo的实体数据（不包含null值）
    int insertSelective(Lizuo record);

    //根据条件获取离座表lizuo的数据列表
    List<Lizuo> selectByExample(LizuoExample example);

    //根据主键ID列获取离座表lizuo的数据实体
    Lizuo selectByPrimaryKey(Integer id);

    //根据条件更新离座表lizuo的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Lizuo record, @Param("example") LizuoExample example);

    //根据条件更新离座表lizuo的实体数据（包含null值）
    int updateByExample(@Param("record") Lizuo record, @Param("example") LizuoExample example);

    //根据主键ID列更新离座表lizuo的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Lizuo record);

    //根据主键ID列更新离座表lizuo的实体数据（包含null值）
    int updateByPrimaryKey(Lizuo record);
}
