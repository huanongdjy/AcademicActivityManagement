package com.org.graduactionproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.dao.AchievementMapper;
import com.org.graduactionproject.domain.Achievement;
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

    public Achievement findAchievementById(int id){
        return achievementMapper.findAchievementById(id);
    }

    public List<Achievement> findAll(){
        return achievementMapper.findAll();
    }

    @Override
    public List<Map<String,Object>> findAchievementByTitle(String title) {
        return achievementMapper.findAchievementByTitle(title);
    }

    public InfoPageJSONBean getInfoPage(int size, int page){
        //分页并查询
        PageHelper.startPage(page, size);
        List<Achievement> achievements = achievementMapper.findAll();
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
    public Integer updateAchievement(String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate, Integer id){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return achievementMapper.updateAchievement(title,member,content,toshow,ordering,type_id,acquisitiondate,time,id);
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
        return achievementMapper.addAchievement(author, title, member, content, toshow, ordering, type_id, acquisitiondate, time);
    }

    @Override
    public Integer deleteAchievement(Integer id){
        return achievementMapper.deleteAchievement(id);
    }

    @Override
    public List<Achievement> searchAchievementByTitle(String title){
        return achievementMapper.searchAchievementByTitle(title);
    }
}
