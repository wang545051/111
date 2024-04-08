package com.dao;

import com.entity.Liuyan;
import com.entity.LiuyanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName LiuyanMapper
 * @Description 留言反馈模块数据持久层
 */
public interface LiuyanMapper {

    //根据条件获取留言反馈表liuyan的数据数量
    int countByExample(LiuyanExample example);

    //根据条件删除留言反馈表liuyan的数据
    int deleteByExample(LiuyanExample example);

    //根据主键ID列删除留言反馈表liuyan的数据
    int deleteByPrimaryKey(Integer id);

    //插入留言反馈表liuyan的实体数据（包含null值）
    int insert(Liuyan record);

    //插入留言反馈表liuyan的实体数据（不包含null值）
    int insertSelective(Liuyan record);

    //根据条件获取留言反馈表liuyan的数据列表
    List<Liuyan> selectByExample(LiuyanExample example);

    //根据主键ID列获取留言反馈表liuyan的数据实体
    Liuyan selectByPrimaryKey(Integer id);

    //根据条件更新留言反馈表liuyan的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Liuyan record, @Param("example") LiuyanExample example);

    //根据条件更新留言反馈表liuyan的实体数据（包含null值）
    int updateByExample(@Param("record") Liuyan record, @Param("example") LiuyanExample example);

    //根据主键ID列更新留言反馈表liuyan的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Liuyan record);

    //根据主键ID列更新留言反馈表liuyan的实体数据（包含null值）
    int updateByPrimaryKey(Liuyan record);
}
