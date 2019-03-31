package com.org.graduactionproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.dao.UserMapper;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        }else if("sysadmin".equals(identity)){
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

    @Override
    public User findUserByUserName(String username){
        return userMapper.findUserByUserName(username);
    }

    @Override
    public Integer updateUser(String username, int identity, String mailbox, String password){
        return userMapper.updateUser(username, identity, mailbox, password);
    }

    @Override
    public InfoPageJSONBean getInfoPage(int size, int page){
        PageHelper.startPage(page, size);
        List<User> achievements = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(achievements);
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
//        int pageNum = pageInfo.getPageNum();
//        int pageSize = pageInfo.getPageSize();
//        long total = pageInfo.getTotal();
        List<User> result = pageInfo.getList();//和上面的users结果相同
//        System.out.println("pageNum： " + pageNum);
//        System.out.println("pageSize: " + pageSize);
//        System.out.println("total: " + total);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    @Override
    public Integer addUser(String userName, String password, int identity_id, String mailbox){
        return userMapper.addUser(userName, password, identity_id, mailbox);
    }

    @Override
    public Integer deleteUser(String username){
        return userMapper.deleteUser(username);
    }
}
