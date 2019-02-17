package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.AchievementReadMapper;
import com.org.graduactionproject.domain.AchievementRead;
import com.org.graduactionproject.service.IAchievementReadService;
import com.org.graduactionproject.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("achievementReadService")
public class AchievementReadServiceImpl implements IAchievementReadService {
    @Autowired
    AchievementReadMapper achievementReadMapper;

    public AchievementRead findAchievementReadByRead_id(int read_id){
        AchievementRead achievementRead = achievementReadMapper.findAchievementReadByRead_id(read_id);
        return achievementRead;
    }
    public AchievementRead getEssayReadByIpAndId(String ip, int id){
        AchievementRead achievementRead = achievementReadMapper.getAchievementReadByIpAndId(ip, id);
        return achievementRead;
    }
    public int addAchievement(String ip, int id){
        AchievementRead achievementRead = new AchievementRead(id, ip);
        return achievementReadMapper.addAchievement(achievementRead);
    }
}
