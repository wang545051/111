package com.dao;

import com.entity.Ruzuo;
import com.entity.RuzuoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName RuzuoMapper
 * @Description 入座模块数据持久层
 */
public interface RuzuoMapper {

    //根据条件获取入座表ruzuo的数据数量
    int countByExample(RuzuoExample example);

    //根据条件删除入座表ruzuo的数据
    int deleteByExample(RuzuoExample example);

    //根据主键ID列删除入座表ruzuo的数据
    int deleteByPrimaryKey(Integer id);

    //插入入座表ruzuo的实体数据（包含null值）
    int insert(Ruzuo record);

    //插入入座表ruzuo的实体数据（不包含null值）
    int insertSelective(Ruzuo record);

    //根据条件获取入座表ruzuo的数据列表
    List<Ruzuo> selectByExample(RuzuoExample example);

    //根据主键ID列获取入座表ruzuo的数据实体
    Ruzuo selectByPrimaryKey(Integer id);

    //根据条件更新入座表ruzuo的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Ruzuo record, @Param("example") RuzuoExample example);

    //根据条件更新入座表ruzuo的实体数据（包含null值）
    int updateByExample(@Param("record") Ruzuo record, @Param("example") RuzuoExample example);

    //根据主键ID列更新入座表ruzuo的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Ruzuo record);

    //根据主键ID列更新入座表ruzuo的实体数据（包含null值）
    int updateByPrimaryKey(Ruzuo record);
}
