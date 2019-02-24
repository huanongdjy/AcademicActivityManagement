package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PhotoMapper {
    @Select("select * from achievementphoto where id =#{id}")
    List<Photo> findAchievementPhotoById(Integer id);

    @Select("select * from essayphoto where id =#{id}")
    List<Photo> findEssayPhotoById(Integer id);

    @Insert("insert into achievementphoto(photo_name, url, id) values(#{photo_name}, #{url}, #{id})")
    @Options(useGeneratedKeys = true, keyProperty = "photo_id")
    Integer addAchievementPhoto(String photo_name, String url, Integer id);

    @Delete("delete from achievementphoto where id=#{id}")
    Integer deleteAchievementPhoto(Integer id);
}
