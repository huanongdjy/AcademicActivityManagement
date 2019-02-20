package com.org.graduactionproject.service;

import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.User;

import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String username, String password, String identity);
    User findUserByUserName(String username);
    Integer updateUser(String username, int identity, String mailbox, String password);
    public InfoPageJSONBean getInfoPage(int size, int page);
    Integer addUser(String userName, String password, int identity_id, String mailbox);
    Integer deleteUser(String username);
}
