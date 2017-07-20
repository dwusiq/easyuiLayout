package com.wusiq.service.impl;

import com.wusiq.dao.UserMapper;
import com.wusiq.entity.Users;
import com.wusiq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理的实现类
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(Users users) {
        return this.userMapper.insertUser(users);
    }

    @Override
    public int deleteUser(int id) {
        return this.userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(Users users) {
        return this.userMapper.updateUser(users);
    }

    @Override
    public Users queryById(int id) {
        return this.userMapper.queryById(id);
    }
}
