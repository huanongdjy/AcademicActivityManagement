package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.AchievementRead;
import com.org.graduactionproject.domain.EssayRead;
import org.apache.ibatis.annotations.Param;

public interface IEssayReadService {
    EssayRead findEssayReadByRead_id(int read_id);
    EssayRead getEssayReadByIpAndId(String ip, int id);
    int addEssayRead(String ip, int id);
}
