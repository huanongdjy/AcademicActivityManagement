package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.User;

public interface IUserService {
    User login(String username, String password);
}
