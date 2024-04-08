package com.dao;

import com.entity.Lunbo;
import com.entity.LunboExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName LunboMapper
 * @Description 轮播图模块数据持久层
 */
public interface LunboMapper {

    //根据条件获取轮播图表lunbo的数据数量
    int countByExample(LunboExample example);

    //根据条件删除轮播图表lunbo的数据
    int deleteByExample(LunboExample example);

    //根据主键ID列删除轮播图表lunbo的数据
    int deleteByPrimaryKey(Integer id);

    //插入轮播图表lunbo的实体数据（包含null值）
    int insert(Lunbo record);

    //插入轮播图表lunbo的实体数据（不包含null值）
    int insertSelective(Lunbo record);

    //根据条件获取轮播图表lunbo的数据列表
    List<Lunbo> selectByExample(LunboExample example);

    //根据主键ID列获取轮播图表lunbo的数据实体
    Lunbo selectByPrimaryKey(Integer id);

    //根据条件更新轮播图表lunbo的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Lunbo record, @Param("example") LunboExample example);

    //根据条件更新轮播图表lunbo的实体数据（包含null值）
    int updateByExample(@Param("record") Lunbo record, @Param("example") LunboExample example);

    //根据主键ID列更新轮播图表lunbo的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Lunbo record);

    //根据主键ID列更新轮播图表lunbo的实体数据（包含null值）
    int updateByPrimaryKey(Lunbo record);
}
