package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Achievement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AchievementMapper {
    @Select("select * from achievement where achievement_id = #{achievement_id}")
    Achievement findAchievementById(@Param("achievement_id")int achievement_id);

    @Insert("insert into achievement(title, member, content, acquisitiondate, time, read, index) values(#{achievement_name}, #{member}, #{content}," +
            "#{acquisitiondate}, #{time}, #{read}, #{index}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAchievement(Achievement achievement);

    @Select("select * from achievement order by acquisitiondate")//根据获得成功的日期排序
    List<Achievement> findAll();
}
