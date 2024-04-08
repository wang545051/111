package com.dao;

import com.entity.Yuyue;
import com.entity.YuyueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName YuyueMapper
 * @Description 预约模块数据持久层
 */
public interface YuyueMapper {

    //根据条件获取预约表yuyue的数据数量
    int countByExample(YuyueExample example);

    //根据条件删除预约表yuyue的数据
    int deleteByExample(YuyueExample example);

    //根据主键ID列删除预约表yuyue的数据
    int deleteByPrimaryKey(Integer id);

    //插入预约表yuyue的实体数据（包含null值）
    int insert(Yuyue record);

    //插入预约表yuyue的实体数据（不包含null值）
    int insertSelective(Yuyue record);

    //根据条件获取预约表yuyue的数据列表
    List<Yuyue> selectByExample(YuyueExample example);

    //根据主键ID列获取预约表yuyue的数据实体
    Yuyue selectByPrimaryKey(Integer id);

    //根据条件更新预约表yuyue的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Yuyue record, @Param("example") YuyueExample example);

    //根据条件更新预约表yuyue的实体数据（包含null值）
    int updateByExample(@Param("record") Yuyue record, @Param("example") YuyueExample example);

    //根据主键ID列更新预约表yuyue的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Yuyue record);

    //根据主键ID列更新预约表yuyue的实体数据（包含null值）
    int updateByPrimaryKey(Yuyue record);
}
