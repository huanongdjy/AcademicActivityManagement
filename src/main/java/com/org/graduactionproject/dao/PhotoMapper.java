package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PhotoMapper {
    @Select("select * from achievementphoto where id =#{id}")
    List<Photo> findAchievementPhotoById(Integer id);

    @Select("select * from essayphoto where id =#{id}")
    List<Photo> findEssayPhotoById(Integer id);
}
