package com.ykt.ind_ykt.service.impl;

import com.ykt.ind_ykt.mapper.AdvisoryMapper;
import com.ykt.ind_ykt.pojo.Advisory;
import com.ykt.ind_ykt.service.AdvisoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvisoryServiceImpl implements AdvisoryService {
    @Autowired
    AdvisoryMapper advisoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Advisory record) {
        return 0;
    }

    @Override
    public int insertSelective(Advisory record) {
        return 0;
    }

    @Override
    public Advisory selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Advisory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Advisory record) {
        return 0;
    }
}
