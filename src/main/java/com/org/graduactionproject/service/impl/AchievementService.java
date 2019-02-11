package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.AchievementMapper;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("achievementService")
public class AchievementService implements IAchievementService {
    @Autowired
    AchievementMapper achievementMapper;

    public Achievement findAchievementById(int id){
        return achievementMapper.findAchievementById(id);
    }
    public int addAchievement(Achievement achievement){
        return achievementMapper.addAchievement(achievement);
    }
    public List<Achievement> findAll(){
        return achievementMapper.findAll();
    }
}
