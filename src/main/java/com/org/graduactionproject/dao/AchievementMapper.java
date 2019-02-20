package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface AchievementMapper {
    @Select("select * from achievement where achievement_id = #{achievement_id}")
    @Results({
            @Result(property = "photolist",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many  = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    Achievement findAchievementById(@Param("achievement_id")int achievement_id);

    @Insert("insert into achievement(title, member, content, acquisitiondate, time, read, index) values(#{achievement_name}, #{member}, #{content}," +
            "#{acquisitiondate}, #{time}, #{read}, #{index}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAchievement(Achievement achievement);

    @Select("select * from achievement order by acquisitiondate")//根据获得成果的日期排序
    @Results({
            @Result(property = "photolist",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Achievement> findAll();

    @Select("select * from achievement where title like CONCAT('%', #{title},'%')")
    @Results({
            @Result(property = "photolist",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Map<String,Object>> findAchievementByTitle(@Param("title")String title);


    @Update("update achievement set read_num = read_num + 1 where id=#{id}")
    int updateRead_num(@Param("id") int id);
}
