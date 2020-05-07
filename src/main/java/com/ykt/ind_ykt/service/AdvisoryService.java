package com.ykt.ind_ykt.service;

import com.ykt.ind_ykt.pojo.Advisory;

public interface AdvisoryService {

    int deleteByPrimaryKey(Integer id);

    int insert(Advisory record);

    int insertSelective(Advisory record);

    Advisory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advisory record);

    int updateByPrimaryKey(Advisory record);

}
