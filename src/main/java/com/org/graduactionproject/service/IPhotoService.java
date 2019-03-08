package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Photo;

import java.util.List;

public interface IPhotoService {
    List<Photo> findAchievementPhotoById(Integer id);
    Integer addAchievementPhoto(String photo_name, String url, Integer id);
    Integer deleteAchievement(Integer id);

    List<Photo> findEssayPhotoById(Integer id);
    Integer addEssayPhoto(String photo_name, String url, Integer id);
    Integer deleteEssay(Integer id);
}
