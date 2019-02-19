package com.org.graduactionproject.service;

import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.User;

import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String username, String password, String identity);
    User findUserByUserId(int userId);
    Integer updateUser(String username, int identity, String mialbox, String password, int userId);
    public InfoPageJSONBean getInfoPage(int size, int page);
}
