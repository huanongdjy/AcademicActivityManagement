package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.UserMapper;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String,Object> login(String username, String password, String identity){
        int iden ;
        if("admin".equals(identity)){
            iden = 1;
        }else if("sysamdin".equals(identity)){
            iden = 2;
        }else {
            return null;
        }
        User user =  userMapper.findWithLoginNameAndIdentity(username, iden);
        Map<String, Object> map = new HashedMap();
        if(user!=null){
            if(user.getPassword().equals(password)){
                map.put("user", user);
            }else{
                map.put("message", "密码错误");
            }
        }else{
            map.put("message", "用户不存在");
        }
        return map;
    }

}
