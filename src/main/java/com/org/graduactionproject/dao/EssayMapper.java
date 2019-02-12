package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Essay;
import org.apache.ibatis.annotations.*;

public interface EssayMapper {
    @Select("select * from Essay where essay_name = #{essay_name}")
    Essay findEssayByName(@Param("essay_name")String essay_name);

    @Insert("insert into essay values(title, theme, summary, time, location," +
            "content, precautions, fund, oranizer, planned_attendance,actual_attendance,photo,outcome, index, read)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAchievement(Essay essay);

    @Update("update essay set index = #{index} where id=#{id}")
    int updateIndex(@Param("id") int id, @Param("index")int index);
}
