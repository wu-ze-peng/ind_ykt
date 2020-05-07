package com.ykt.ind_ykt.mapper;

import com.ykt.ind_ykt.pojo.GoodsType;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}