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
        return num == null ? 0 : num  ;
    }

    public Integer getHoldActivityNum(String begTime, String endTime){
        Integer num = essayMapper.getHoldActivityNum(begTime, endTime);
        return num == null ? 0 : num;
    }

    public Integer getAttendanceNum(String begTime, String endTime){
        Integer num = essayMapper.getAttendanceNum(begTime, endTime);
        return num == null ? 0 : num;
    }

    public List<Map<String, Object>> getEssayPieData(String begTime, String endTime){
        List<Map<String, Object>> list = new ArrayList<>();
        List<Type> types = typeMapper.findAll();
        for(int i=0; i< types.size(); i++){
            Type type = types.get(i);
            Map<String, Object> type_num = new HashedMap();
            StringBuffer m = new StringBuffer();
            Integer num;
            num = essayMapper.getAddEssayNum(begTime, endTime,type.getType_id());
            if (num == null) num = 0;
            type_num.put("value", num); // 以新增活动为主显示

            m.append("新增活动：<br/>类型"+ type.getType_name() + ": " + num + "<br/>");
            num = essayMapper.getHoldActivityNumByType_id(begTime, endTime,type.getType_id());
            if (num == null) num = 0;
            m.append("举办活动数量：" + num + "<br/>");
            num = essayMapper.getAttendanceNumWithType(begTime, endTime,type.getType_id());
            if (num == null) num = 0;
            m.append("参加活动人数：" + num );
            type_num.put("tip", m);
            type_num.put("name", type.getType_name());
            list.add(type_num);
        }
        return list;
    }

    public List<Map<String, Object>> getAchievementPieData(String begTime, String endTime){
        List<Map<String, Object>> list = new ArrayList<>();
        List<Type> types = typeMapper.findAll();
        for(int i=0; i< types.size(); i++) {
            Map<String, Object> type_num = new HashedMap();
            Type type = types.get(i);
            Integer num = achievementMapper.getAddAchievementNumByType_id(begTime, endTime, type.getType_id());
            type_num.put("value", num);
            type_num.put("name", type.getType_name());
            list.add(type_num);
        }
        return list;
    }

    public List<Map<String, Object>> getLineChart(String time0, String time1, String time2, String time3, String time4, String time5, String time6, String time7){
        List<Map<String, Object>> list = new ArrayList<>();
        List<Type> types = typeMapper.findAll();
        Integer num;
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i< types.size(); i++){
            Map<String, Object> type_num = new HashedMap();
            Type type = types.get(i);
            type_num.put("name", type.getType_name());

            num = essayMapper.getAttendanceNumWithType(time0, time1, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            num = essayMapper.getAttendanceNumWithType(time1, time2, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            num = essayMapper.getAttendanceNumWithType(time2, time3, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            num = essayMapper.getAttendanceNumWithType(time3, time4, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            num = essayMapper.getAttendanceNumWithType(time4, time5, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            num = essayMapper.getAttendanceNumWithType(time5, time6, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            num = essayMapper.getAttendanceNumWithType(time6, time7, type.getType_id());
            if (num == null) num = 0;
            nums.add(num);
            type_num.put("data", nums);
            list.add(type_num);
        }
        return list;
    }
}
