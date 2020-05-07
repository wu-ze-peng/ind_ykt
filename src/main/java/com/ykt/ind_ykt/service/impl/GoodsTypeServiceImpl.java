package com.ykt.ind_ykt.service.impl;

import com.ykt.ind_ykt.mapper.GoodsTypeMapper;
import com.ykt.ind_ykt.pojo.GoodsType;
import com.ykt.ind_ykt.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(GoodsType record) {
        return 0;
    }

    @Override
    public int insertSelective(GoodsType record) {
        return 0;
    }

    @Override
    public GoodsType selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsType record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return 0;
    }
}
