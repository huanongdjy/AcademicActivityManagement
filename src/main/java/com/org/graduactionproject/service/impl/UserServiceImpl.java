package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.UserMapper;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password){
        return userMapper.findWithLoginNameAndPassword(username, password);
    }

}
