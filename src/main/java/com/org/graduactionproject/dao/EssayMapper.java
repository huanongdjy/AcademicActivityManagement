package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Essay;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface EssayMapper {
    @Select("select * from Essay where title like CONCAT('%', #{title},'%')")
//    @Results({
//            @Result(property = "read",
//            column = "read_id",
//            javaType = Read.class,
//            jdbcType = JdbcType.INTEGER,
//            one = @One(select ="com.org.graduactionproject.dao.EssayReadMapper.findReadByRead_id"))})
    List<Map<String, Object>> findEssayByTitle(@Param("title") String title);

    @Insert("insert into essay values(title, theme, summary, time, location," +
            "content, precautions, fund, oranizer, planned_attendance,actual_attendance,photo,outcome, index, read)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAchievement(Essay essay);

    @Update("update essay set index = #{index} where id=#{id}")
    int updateIndex(@Param("id") int id, @Param("index")int index);

    @Select("select * from essay where type_id=#{type_id} and hold_time >= #{hold_time}" )
//    @Results({
//            @Result(property = "read",
//                    column = "read_id",
//                    javaType = Read.class,
//                    jdbcType = JdbcType.INTEGER,
//                    one = @One(select ="com.org.graduactionproject.dao.EssayReadMapper.findReadByRead_id"))
//            })
    List<Essay> findEssayByType_id(@Param("type_id")int type, @Param("hold_time")String hold_time);

    @Update("update essay set read_num = read_num + 1 where id=#{id}")
    int updateRead_num(@Param("id") int id);
}
