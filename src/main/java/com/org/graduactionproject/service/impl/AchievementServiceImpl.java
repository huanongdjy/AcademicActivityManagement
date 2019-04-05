package com.org.graduactionproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.dao.AchievementMapper;
import com.org.graduactionproject.dao.UserMapper;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service("achievementService")
public class AchievementServiceImpl implements IAchievementService {
    @Autowired
    AchievementMapper achievementMapper;

    @Autowired
    UserMapper userMapper;

    public Achievement findAchievementById(String username, int id){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();
        return achievementMapper.findAchievementById(id, college_id);
    }

    public List<Achievement> findAll(String username){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();
        return achievementMapper.findAll(college_id);
    }

    @Override
    public List<Map<String,Object>> findAchievementByTitle(String username,String title) {
        Integer college_id = null;
        if (username != null){
            User user = userMapper.findUserByUserName(username);
            college_id = user.getCollege_id();
        }
        return achievementMapper.findAchievementByTitle(title, college_id);
    }

    public InfoPageJSONBean getInfoPage(String username, int size, int page){
        Integer college_id = null;
        if (username!=null){
            User user = userMapper.findUserByUserName(username);
            college_id = user.getCollege_id();
        }

        //分页并查询
        PageHelper.startPage(page, size);
        List<Achievement> achievements = achievementMapper.findAll(college_id);
        PageInfo<Achievement> pageInfo = new PageInfo<>(achievements);
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    @Override
    public int updateRead_num(int id){
        return achievementMapper.updateRead_num(id);
    }

    @Override
    public Integer updateAchievement(String author, String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate, Integer id){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        User user = userMapper.findUserByUserName(author);
        Integer college_id = user.getCollege_id();
        return achievementMapper.updateAchievement(title,member,content,toshow,ordering,type_id,acquisitiondate,time,id, college_id);
    }

    @Override
    public Integer updateToshow(String toshow, Integer id){
        int i = 1;
        if (!"true".equals(toshow))
            i = 2;
        return achievementMapper.updateToshow(i, id);
    }
    @Override
    public Integer addAchievement(String author, String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        User user = userMapper.findUserByUserName(author);
        Integer college_id = user.getCollege_id();
        return achievementMapper.addAchievement(author, title, member, content, toshow, ordering, type_id, acquisitiondate, time, college_id);
    }

    @Override
    public Integer deleteAchievement(Integer id){
        return achievementMapper.deleteAchievement(id);
    }

    @Override
    public List<Achievement> searchAchievementByTitle(String username, String title){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();
        return achievementMapper.searchAchievementByTitle(title, college_id);
    }
}
