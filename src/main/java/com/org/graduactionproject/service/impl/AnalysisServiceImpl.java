package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.AchievementReadMapper;
import com.org.graduactionproject.dao.EssayReadMapper;
import com.org.graduactionproject.domain.AchievementRead;
import com.org.graduactionproject.domain.EssayRead;
import com.org.graduactionproject.service.IAnaalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.sql.Timestamp;

@Service("analysisService")
public class AnalysisServiceImpl implements IAnaalysisService {
    @Autowired
    AchievementReadMapper achievementReadMapper;

    @Autowired
    EssayReadMapper essayReadMapper;

    public Integer getRangeReadNum(String begTime, String endTime){
//        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        Integer ac_num = achievementReadMapper.getRandAchievementNum(begTime, endTime);
        Integer es_num = essayReadMapper.getRandEssayNum(begTime, endTime);
        return ac_num + es_num;
    }
}
