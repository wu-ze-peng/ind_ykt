package com.ykt.ind_ykt.service;

import com.ykt.ind_ykt.core.ResultBean;
import com.ykt.ind_ykt.pojo.User;

import java.util.Map;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    ResultBean query_user(Map params);
}