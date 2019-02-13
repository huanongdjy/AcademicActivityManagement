package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Essay;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface EssayMapper {
    @Select("select * from Essay where title like CONCAT('%', #{title},'%')")
    List<Map<String, Object>> findEssayByName(@Param("title") String title);

    @Insert("insert into essay values(title, theme, summary, time, location," +
            "content, precautions, fund, oranizer, planned_attendance,actual_attendance,photo,outcome, index, read)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAchievement(Essay essay);

    @Update("update essay set index = #{index} where id=#{id}")
    int updateIndex(@Param("id") int id, @Param("index")int index);
}
