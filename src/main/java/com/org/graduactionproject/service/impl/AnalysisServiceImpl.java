package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.*;
import com.org.graduactionproject.domain.Type;
import com.org.graduactionproject.service.IAnalysisService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("analysisService")
public class AnalysisServiceImpl implements IAnalysisService {
    @Autowired
    AchievementReadMapper achievementReadMapper;

    @Autowired
    EssayReadMapper essayReadMapper;

    @Autowired
    AchievementMapper achievementMapper;

    @Autowired
    EssayMapper essayMapper;

    @Autowired
    TypeMapper typeMapper;

    public Integer getRangeReadNum(String begTime, String endTime){
//        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        Integer ac_num = achievementReadMapper.getRandAchievementNum(begTime, endTime);
        Integer es_num = essayReadMapper.getRandEssayNum(begTime, endTime);
        return ac_num + es_num;
    }

    public Integer getAddAchievementNum(String begTime, String endTime){
        Integer num = achievementMapper.getAddAchievementNum(begTime, endTime);
        return num;
    }

    public Integer getHoldActivityNum(String begTime, String endTime){
        Integer num = essayMapper.getHoldActivityNum(begTime, endTime);
        return num;
    }

    public Integer getAttendanceNum(String begTime, String endTime){
        Integer num = essayMapper.getAttendanceNum(begTime, endTime);
        return num;
    }

    public List<Map<String, Object>> getPieData(String begTime, String endTime){
        List<Map<String, Object>> list = new ArrayList<>();
        List<Type> types = typeMapper.findAll();
        for(int i=0; i< types.size(); i++){
            Map<String, Object> type_num = new HashedMap();
            Type type = types.get(i);
            Integer num = essayMapper.getAttendanceNumWithType(begTime, endTime,type.getType_id());
            if (num == null) num = 0;
            type_num.put("value", num);
            type_num.put("name", type.getType_name());
            list.add(type_num);
        }
        return list;
    }
}
