package com.org.graduactionproject.service;


import java.util.List;
import java.util.Map;

public interface IAnalysisService {
    Integer getRangeReadNum(String begTime, String endTime);
    Integer getAddAchievementNum(String begTime, String endTime);
    Integer getHoldActivityNum(String begTime, String endTime);
    Integer getAttendanceNum(String begTime, String endTime);

    List<Map<String, Object>> getPieData(String begTime, String endTime);
}
