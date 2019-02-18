package com.org.graduactionproject.service;

import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String username, String password, String identity);
}
