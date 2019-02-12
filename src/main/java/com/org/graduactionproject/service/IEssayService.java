package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Essay;

import java.util.List;

public interface IEssayService {
    List findEssayByName(String title);
    int addAchievement(Essay essay);
    int updateIndex(int id, int index);
}
