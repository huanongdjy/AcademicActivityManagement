package com.org.graduactionproject.service;

import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface IAchievementService {
    Achievement findAchievementById(String username, int id);
//    int addAchievement(Achievement achievement);
    List<Achievement> findAll(String username);
    List<Map<String,Object>> findAchievementByTitle(String username, String title);
    List<Achievement> searchAchievementByTitle(String username, String title);
    InfoPageJSONBean getInfoPage(String username, int size, int page);
    int updateRead_num(int id);
    Integer updateAchievement(String author, String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate, Integer id);
    Integer addAchievement(String author, String title, String member, String content, boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate);
    Integer deleteAchievement(Integer id);
    Integer updateToshow(String toshow, Integer id);
}
