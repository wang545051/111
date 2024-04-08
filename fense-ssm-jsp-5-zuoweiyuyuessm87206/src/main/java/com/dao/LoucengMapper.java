package com.dao;

import com.entity.Louceng;
import com.entity.LoucengExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName LoucengMapper
 * @Description 楼层模块数据持久层
 */
public interface LoucengMapper {

    //根据条件获取楼层表louceng的数据数量
    int countByExample(LoucengExample example);

    //根据条件删除楼层表louceng的数据
    int deleteByExample(LoucengExample example);

    //根据主键ID列删除楼层表louceng的数据
    int deleteByPrimaryKey(Integer id);

    //插入楼层表louceng的实体数据（包含null值）
    int insert(Louceng record);

    //插入楼层表louceng的实体数据（不包含null值）
    int insertSelective(Louceng record);

    //根据条件获取楼层表louceng的数据列表
    List<Louceng> selectByExample(LoucengExample example);

    //根据主键ID列获取楼层表louceng的数据实体
    Louceng selectByPrimaryKey(Integer id);

    //根据条件更新楼层表louceng的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Louceng record, @Param("example") LoucengExample example);

    //根据条件更新楼层表louceng的实体数据（包含null值）
    int updateByExample(@Param("record") Louceng record, @Param("example") LoucengExample example);

    //根据主键ID列更新楼层表louceng的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Louceng record);

    //根据主键ID列更新楼层表louceng的实体数据（包含null值）
    int updateByPrimaryKey(Louceng record);
}
