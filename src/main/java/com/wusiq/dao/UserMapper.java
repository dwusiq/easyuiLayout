package com.wusiq.dao;

import com.wusiq.entity.Users;

/**
 * 用户管理的数据库操作类
 */
public interface UserMapper {
    int insertUser(Users users);
    int deleteUser(int id);
    int updateUser(Users users);
    Users queryById(int id);
}
