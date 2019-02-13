package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Essay;

import java.util.List;
import java.util.Map;

public interface IEssayService {
    List<Map<String,Object>> findEssayByName(String title);
    int addAchievement(Essay essay);
    int updateIndex(int id, int index);
}
