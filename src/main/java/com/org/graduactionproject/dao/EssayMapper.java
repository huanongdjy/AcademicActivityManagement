package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface EssayMapper {
    @Select("select * from Essay where title like CONCAT('%', #{title},'%')")
    @Results({
            @Result(property = "photolist",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Map<String, Object>> findEssayByTitle(@Param("title") String title);

    @Insert("insert into essay(title, author, summary, time, hold_time, location,content, fund, organizer, " +
            "planned_attendance, ordering, type_id) " +
            "values(#{title}, #{author}, #{summary}, #{time}, #{holdtime}, #{location}," +
            "#{content},  #{fund}, #{organizer}, #{planned_attendance}, " +
            "#{ordering}, #{type_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer addEssay(String title, String author, String summary, Timestamp time, Timestamp holdtime, String location,
                     String content, String fund, String organizer, Integer planned_attendance,
                     Integer ordering, Integer type_id);
    @Update("update essay set index = #{index} where id=#{id}")
    int updateIndex(@Param("id") int id, @Param("index")int index);

    @Select("select * from essay where type_id=#{type_id} and hold_time >= #{hold_time}" )
    @Results({
            @Result(property = "photolist",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Essay> findEssayByType_id(@Param("type_id")int type, @Param("hold_time")String hold_time);

    @Update("update essay set read_num = read_num + 1 where id=#{id}")
    int updateRead_num(@Param("id") int id);
}
