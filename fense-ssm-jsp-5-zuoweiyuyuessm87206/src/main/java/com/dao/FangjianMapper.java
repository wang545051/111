package com.dao;

import com.entity.Fangjian;
import com.entity.FangjianExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName FangjianMapper
 * @Description 房间模块数据持久层
 */
public interface FangjianMapper {

    //根据条件获取房间表fangjian的数据数量
    int countByExample(FangjianExample example);

    //根据条件删除房间表fangjian的数据
    int deleteByExample(FangjianExample example);

    //根据主键ID列删除房间表fangjian的数据
    int deleteByPrimaryKey(Integer id);

    //插入房间表fangjian的实体数据（包含null值）
    int insert(Fangjian record);

    //插入房间表fangjian的实体数据（不包含null值）
    int insertSelective(Fangjian record);

    //根据条件获取房间表fangjian的数据列表
    List<Fangjian> selectByExample(FangjianExample example);

    //根据主键ID列获取房间表fangjian的数据实体
    Fangjian selectByPrimaryKey(Integer id);

    //根据条件更新房间表fangjian的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Fangjian record, @Param("example") FangjianExample example);

    //根据条件更新房间表fangjian的实体数据（包含null值）
    int updateByExample(@Param("record") Fangjian record, @Param("example") FangjianExample example);

    //根据主键ID列更新房间表fangjian的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Fangjian record);

    //根据主键ID列更新房间表fangjian的实体数据（包含null值）
    int updateByPrimaryKey(Fangjian record);
}
