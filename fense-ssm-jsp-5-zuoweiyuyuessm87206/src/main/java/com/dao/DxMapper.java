package com.dao;

import com.entity.Dx;
import com.entity.DxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DxMapper
 * @Description 介绍模块数据持久层
 */
public interface DxMapper {

    //根据条件获取介绍表dx的数据数量
    int countByExample(DxExample example);

    //根据条件删除介绍表dx的数据
    int deleteByExample(DxExample example);

    //根据主键ID列删除介绍表dx的数据
    int deleteByPrimaryKey(Integer id);

    //插入介绍表dx的实体数据（包含null值）
    int insert(Dx record);

    //插入介绍表dx的实体数据（不包含null值）
    int insertSelective(Dx record);

    //根据条件获取介绍表dx的数据列表
    List<Dx> selectByExample(DxExample example);

    //根据主键ID列获取介绍表dx的数据实体
    Dx selectByPrimaryKey(Integer id);

    //根据条件更新介绍表dx的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Dx record, @Param("example") DxExample example);

    //根据条件更新介绍表dx的实体数据（包含null值）
    int updateByExample(@Param("record") Dx record, @Param("example") DxExample example);

    //根据主键ID列更新介绍表dx的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Dx record);

    //根据主键ID列更新介绍表dx的实体数据（包含null值）
    int updateByPrimaryKey(Dx record);
}
