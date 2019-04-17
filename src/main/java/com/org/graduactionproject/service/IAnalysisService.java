package com.org.graduactionproject.service;


import java.util.List;
import java.util.Map;

public interface IAnalysisService {
    Integer getRangeReadNum(String begTime, String endTime);
    Integer getAddAchievementNum(Integer college_id, String begTime, String endTime);
    Integer getHoldActivityNum(Integer college_id, String begTime, String endTime);
    Integer getAttendanceNum(Integer college_id, String begTime, String endTime);

    List<Map<String, Object>> getEssayPieData(Integer college_id,  String begTime, String endTime);
    List<Map<String, Object>> getAchievementPieData(Integer college_id, String begTime, String endTime);
    List<Map<String, Object>> getLineChart(Integer college_id, String time0, String time1, String time2, String time3, String time4, String time5, String time6, String time7);
}
