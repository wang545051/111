package com.dao;

import com.entity.Gonggao;
import com.entity.GonggaoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GonggaoMapper
 * @Description 公告模块数据持久层
 */
public interface GonggaoMapper {

    //根据条件获取公告表gonggao的数据数量
    int countByExample(GonggaoExample example);

    //根据条件删除公告表gonggao的数据
    int deleteByExample(GonggaoExample example);

    //根据主键ID列删除公告表gonggao的数据
    int deleteByPrimaryKey(Integer id);

    //插入公告表gonggao的实体数据（包含null值）
    int insert(Gonggao record);

    //插入公告表gonggao的实体数据（不包含null值）
    int insertSelective(Gonggao record);

    //根据条件获取公告表gonggao的数据列表
    List<Gonggao> selectByExample(GonggaoExample example);

    //根据主键ID列获取公告表gonggao的数据实体
    Gonggao selectByPrimaryKey(Integer id);

    //根据条件更新公告表gonggao的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Gonggao record, @Param("example") GonggaoExample example);

    //根据条件更新公告表gonggao的实体数据（包含null值）
    int updateByExample(@Param("record") Gonggao record, @Param("example") GonggaoExample example);

    //根据主键ID列更新公告表gonggao的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Gonggao record);

    //根据主键ID列更新公告表gonggao的实体数据（包含null值）
    int updateByPrimaryKey(Gonggao record);
}
