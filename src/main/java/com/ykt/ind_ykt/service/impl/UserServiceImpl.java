package com.ykt.ind_ykt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ykt.ind_ykt.core.ResultBean;
import com.ykt.ind_ykt.mapper.UserMapper;
import com.ykt.ind_ykt.pojo.User;
import com.ykt.ind_ykt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public ResultBean query_user(Map params) {
        PageHelper.startPage(Integer.parseInt(params.get("pageNo").toString()),Integer.parseInt(params.get("pageSize").toString()));
        List<User> users = userMapper.query_user(params);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return new ResultBean(pageInfo, ResultBean.SUCCESS);
    }
}
