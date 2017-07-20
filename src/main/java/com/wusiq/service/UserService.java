package com.wusiq.service;

import com.wusiq.entity.Users;

/**
 * 用户管理的服务类
 */
public interface UserService {
    int insertUser(Users users);
    int deleteUser(int id);
    int updateUser(Users users);
    Users queryById(int id);
}
