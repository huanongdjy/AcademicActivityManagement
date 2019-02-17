package com.org.graduactionproject.service;

import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;

import java.util.List;
import java.util.Map;

public interface IAchievementService {
    Achievement findAchievementById(int id);
    int addAchievement(Achievement achievement);
    List<Achievement> findAll();
    List<Map<String,Object>> findAchievementByTitle(String title);
    InfoPageJSONBean getInfoPage(int size, int page, String type);
    int updateRead_num(int id);
}
