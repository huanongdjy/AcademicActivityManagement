package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.PhotoMapper;
import com.org.graduactionproject.domain.Photo;
import com.org.graduactionproject.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("photoService")
public class PhotoServiceImpl implements IPhotoService {
    @Autowired
    PhotoMapper photoMapper;
    public List<Photo> findAchievementPhotoById(Integer id){
        return photoMapper.findAchievementPhotoById(id);
    }

    @Override
    public Integer addAchievementPhoto(String photo_name, String url, Integer id){
        return photoMapper.addAchievementPhoto(photo_name, url, id);
    }

    @Override
    public Integer deleteAchievement(Integer id){
        return photoMapper.deleteAchievementPhoto(id);
    }

    @Override
    public List<Photo> findEssayPhotoById(Integer id){
        return photoMapper.findEssayPhotoById(id);
    }

    @Override
    public Integer addEssayPhoto(String photo_name, String url, Integer id){
        return photoMapper.addEssayPhoto(photo_name, url, id);
    }

    @Override
    public Integer deleteEssay(Integer id){
        return photoMapper.deleteEssay(id);
    }
}
