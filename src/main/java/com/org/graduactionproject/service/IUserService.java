package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.User;

import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String username, String password, String identity);
    User findUserByUserId(int userId);
}
