package com.ykt.ind_ykt.service;

import com.ykt.ind_ykt.pojo.GoodsType;

public interface GoodsTypeService {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}