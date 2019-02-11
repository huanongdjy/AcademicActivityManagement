package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Achievement;

import java.util.List;

public interface IAchievementService {
    Achievement findAchievementById(int id);
    int addAchievement(Achievement achievement);
    List<Achievement> findAll();
}
