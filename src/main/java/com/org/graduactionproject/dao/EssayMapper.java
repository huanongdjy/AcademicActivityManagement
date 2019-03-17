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
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Map<String, Object>> findEssayByTitle(@Param("title") String title);

    @Insert("insert into essay(title, author, summary, time, hold_time, location,content, fund, organizer, " +
            "planned_attendance, ordering, type_id) " +
            "values(#{title}, #{author}, #{summary}, #{time}, #{hold_time}, #{location}," +
            "#{content},  #{fund}, #{organizer}, #{planned_attendance}, " +
            "#{ordering}, #{type_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer addEssay(@Param("title")String title, @Param("author")String author, @Param("summary")String summary, @Param("time")Timestamp time, @Param("hold_time")Timestamp hold_time,  @Param("location")String location,
                     @Param("content")String content, @Param("fund")String fund,  @Param("organizer")String organizer, @Param("planned_attendance")Integer planned_attendance,
                     @Param("ordering")Integer ordering, @Param("type_id")Integer type_id);

    @Update("update essay set index = #{index} where id=#{id}")
    int updateIndex(@Param("id") int id, @Param("index")int index);

    @Select("select * from essay where type_id=#{type_id} and hold_time >= #{hold_time}" )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Essay> findEssayByType_id(@Param("type_id")int type, @Param("hold_time")String hold_time);

    @Select("select * from essay " )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Essay> getAllEssays();

    @Select("select * from essay where hold_time <= #{hold_time}" )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Essay> findOldActivity(@Param("hold_time")String hold_time);

    @Select("select * from essay where hold_time > #{hold_time}" )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Essay> findNewActivity(@Param("hold_time")String hold_time);

    @Select("select * from essay where title like CONCAT('%', #{title},'%') order by time" )
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = Photo.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findEssayPhotoById", fetchType= FetchType.EAGER))})
    List<Essay> searchEssayByTitle(@Param("title")String title);

    @Update("update essay set read_num = read_num + 1 where id=#{id}")
    int updateRead_num(@Param("id")int id);

    @Delete("delete from essay where id=#{id}")
    Integer deleteEssay(@Param("id")Integer id);

    @Update({"<script>",
            "update essay",
            "<set>",
            "<if test='title!=null'>",
            "title = #{title}, ",
            "</if>",
            "<if test='author!=null'>",
            "author = #{author}, ",
            "</if>",
            "<if test='summary!=null'>",
            "summary = #{summary}, ",
            "</if>",
            "<if test='time!=null'>",
            "time = #{time},  ",
            "</if>",
            "<if test='hold_time!=null'>",
            "hold_time = #{hold_time},  ",
            "</if>",
            "<if test='location!=null'>",
            "location = #{location},  ",
            "</if>",
            "<if test='content!=null'>",
            "content = #{content},  ",
            "</if>",
            "<if test='fund!=null'>",
            "fund = #{fund},  ",
            "</if>",
            "<if test='organizer!=null'>",
            "organizer = #{organizer},  ",
            "</if>",
            "<if test='planned_attendance!=null'>",
            "planned_attendance = #{planned_attendance},  ",
            "</if>",
            "<if test='ordering!=null'>",
            "ordering = #{ordering},  ",
            "</if>",
            "<if test='type_id!=null'>",
            "type_id = #{type_id},  ",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    Integer updateEssay(@Param("title")String title, @Param("author")String author, @Param("summary")String summary, @Param("time")Timestamp time, @Param("hold_time")Timestamp hold_time, @Param("location")String location,
                        @Param("content")String content, @Param("fund")String fund,  @Param("organizer")String organizer,  @Param("planned_attendance")Integer planned_attendance,
                        @Param("ordering")Integer ordering, @Param("type_id")Integer type_id, @Param("id")Integer id);

    @Select("select COUNT(*) from essay where time between #{begTime} and #{endTime}")
    Integer getHoldActivityNum(@Param("begTime")String begTime, @Param("endTime")String endTime);

    @Select("select sum(actual_attendance) from essay where time between #{begTime} and #{endTime}")
    Integer getAttendanceNum(@Param("begTime")String begTime, @Param("endTime")String endTime);

    @Select("select sum(actual_attendance) from essay where time between #{begTime} and #{endTime} and type_id=#{type_id}")
    Integer getAttendanceNumWithType(@Param("begTime")String begTime, @Param("endTime")String endTime, @Param("type_id")Integer type_id);
}
