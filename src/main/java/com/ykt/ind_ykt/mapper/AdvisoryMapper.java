package com.ykt.ind_ykt.mapper;

import com.ykt.ind_ykt.pojo.Advisory;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvisoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advisory record);

    int insertSelective(Advisory record);

    Advisory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advisory record);

    int updateByPrimaryKey(Advisory record);
}