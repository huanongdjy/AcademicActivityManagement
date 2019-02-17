package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.AchievementRead;

public interface IAchievementReadService {
    AchievementRead findAchievementReadByRead_id(int read_id);
    AchievementRead getEssayReadByIpAndId(String ip, int id);
    int addAchievement(String ip, int id);
}
