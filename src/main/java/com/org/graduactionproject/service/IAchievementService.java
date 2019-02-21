package com.org.graduactionproject.service;

import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface IAchievementService {
    Achievement findAchievementById(int id);
    int addAchievement(Achievement achievement);
    List<Achievement> findAll();
    List<Map<String,Object>> findAchievementByTitle(String title);
    InfoPageJSONBean getInfoPage(int size, int page, String type);
    int updateRead_num(int id);
    Integer updateAchievement(String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate, Integer id);
    Integer addAchievement(String author, String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate, Integer id);
}
