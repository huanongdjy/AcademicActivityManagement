package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface AchievementMapper {
    @Select("select * from achievement where achievement_id = #{achievement_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many  = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    Achievement findAchievementById(@Param("achievement_id")int achievement_id);

    @Insert("insert into achievement(author, title, member, content, toshow, ordering, " +
            "type_id, acquisitiondate, time) values(#{author}, #{title}, #{member}, #{content}," +
            "#{toshow}, #{ordering}, #{type_id}, #{acquisitiondate}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addAchievement(String author, String title, String member, String content, boolean toshow, Integer ordering,
                       Integer type_id, Timestamp acquisitiondate, Timestamp time);

    @Select("select * from achievement order by acquisitiondate")//根据获得成果的日期排序
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Achievement> findAll();

    @Select("select * from achievement where title like CONCAT('%', #{title},'%')")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Map<String,Object>> findAchievementByTitle(@Param("title")String title);

    @Select("select * from achievement where title like CONCAT('%', #{title},'%')")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Achievement> searchAchievementByTitle(String title);

    @Update("update achievement set read_num = read_num + 1 where id=#{id}")
    int updateRead_num(@Param("id") int id);

    @Update({"<script>",
            "update achievement",
            "<set>",
            "<if test='title!=null'>",
            "title = #{title}, ",
            "</if>",
            "<if test='member!=null'>",
            "member = #{member}, ",
            "</if>",
            "<if test='content!=null'>",
            "content = #{content}, ",
            "</if>",
            "<if test='toshow!=null'>",
            "toshow = #{toshow},  ",
            "</if>",
            "<if test='ordering!=null'>",
            "ordering = #{ordering},  ",
            "</if>",
            "<if test='type_id!=null'>",
            "type_id = #{type_id},  ",
            "</if>",
            "<if test='acquisitiondate!=null'>",
            "acquisitiondate = #{acquisitiondate},  ",
            "</if>",
            "<if test='time!=null'>",
            "time = #{time},  ",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    Integer updateAchievement(String title, String member, String content, @Param("toshow") Boolean toshow, Integer ordering, Integer type_id, Timestamp acquisitiondate,Timestamp time, Integer id);

    @Delete("delete from achievement where id=#{id}")
    Integer deleteAchievement(Integer id);
}
