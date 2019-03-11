package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PhotoMapper {
    @Select("select * from achievementphoto where id =#{id}")
    List<Photo> findAchievementPhotoById(@Param("id")Integer id);

    @Select("select * from essayphoto where id =#{id}")
    List<Photo> findEssayPhotoById(@Param("id")Integer id);

    @Insert("insert into achievementphoto(photo_name, url, id) values(#{photo_name}, #{url}, #{id})")
    @Options(useGeneratedKeys = true, keyProperty = "photo_id")
    Integer addAchievementPhoto(@Param("photo_name")String photo_name, @Param("url")String url,  @Param("id")Integer id);

    @Delete("delete from achievementphoto where id=#{id}")
    Integer deleteAchievementPhoto( @Param("id")Integer id);

    @Insert("insert into essayphoto(photo_name, url, id) values(#{photo_name}, #{url}, #{id})")
    @Options(useGeneratedKeys = true, keyProperty = "photo_id")
    Integer addEssayPhoto(@Param("photo_name")String photo_name,  @Param("url")String url,  @Param("id")Integer id);

    @Delete("delete from essayphoto where id=#{id}")
    Integer deleteEssay(@Param("id")Integer id);

}
