package com.dao;

import com.entity.Zuowei;
import com.entity.ZuoweiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ZuoweiMapper
 * @Description 座位模块数据持久层
 */
public interface ZuoweiMapper {

    //根据条件获取座位表zuowei的数据数量
    int countByExample(ZuoweiExample example);

    //根据条件删除座位表zuowei的数据
    int deleteByExample(ZuoweiExample example);

    //根据主键ID列删除座位表zuowei的数据
    int deleteByPrimaryKey(Integer id);

    //插入座位表zuowei的实体数据（包含null值）
    int insert(Zuowei record);

    //插入座位表zuowei的实体数据（不包含null值）
    int insertSelective(Zuowei record);

    //根据条件获取座位表zuowei的数据列表
    List<Zuowei> selectByExample(ZuoweiExample example);

    //根据主键ID列获取座位表zuowei的数据实体
    Zuowei selectByPrimaryKey(Integer id);

    //根据条件更新座位表zuowei的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Zuowei record, @Param("example") ZuoweiExample example);

    //根据条件更新座位表zuowei的实体数据（包含null值）
    int updateByExample(@Param("record") Zuowei record, @Param("example") ZuoweiExample example);

    //根据主键ID列更新座位表zuowei的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Zuowei record);

    //根据主键ID列更新座位表zuowei的实体数据（包含null值）
    int updateByPrimaryKey(Zuowei record);
}
