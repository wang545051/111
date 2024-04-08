package com.dao;

import com.entity.Lianjie;
import com.entity.LianjieExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName LianjieMapper
 * @Description 友情链接模块数据持久层
 */
public interface LianjieMapper {

    //根据条件获取友情链接表lianjie的数据数量
    int countByExample(LianjieExample example);

    //根据条件删除友情链接表lianjie的数据
    int deleteByExample(LianjieExample example);

    //根据主键ID列删除友情链接表lianjie的数据
    int deleteByPrimaryKey(Integer id);

    //插入友情链接表lianjie的实体数据（包含null值）
    int insert(Lianjie record);

    //插入友情链接表lianjie的实体数据（不包含null值）
    int insertSelective(Lianjie record);

    //根据条件获取友情链接表lianjie的数据列表
    List<Lianjie> selectByExample(LianjieExample example);

    //根据主键ID列获取友情链接表lianjie的数据实体
    Lianjie selectByPrimaryKey(Integer id);

    //根据条件更新友情链接表lianjie的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Lianjie record, @Param("example") LianjieExample example);

    //根据条件更新友情链接表lianjie的实体数据（包含null值）
    int updateByExample(@Param("record") Lianjie record, @Param("example") LianjieExample example);

    //根据主键ID列更新友情链接表lianjie的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Lianjie record);

    //根据主键ID列更新友情链接表lianjie的实体数据（包含null值）
    int updateByPrimaryKey(Lianjie record);
}
