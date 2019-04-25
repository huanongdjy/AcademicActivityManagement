package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.Photo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface AchievementMapper {
    @Select("<script>" +
            "select * from achievement where achievement_id = #{achievement_id}"
            + "<when test='college_id!=0'>"
            + "and college_id=#{college_id}"
            + "</when>"
            +"</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many  = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    Achievement findAchievementById(@Param("achievement_id")int achievement_id, @Param("college_id")Integer college_id);

    @Insert("insert into achievement(author, title, member, content, toshow, ordering, " +
            "type_id, acquisitiondate, time, college_id) values(#{author}, #{title}, #{member}, #{content}," +
            "#{toshow}, #{ordering}, #{type_id}, #{acquisitiondate}, #{time}, #{college_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addAchievement(@Param("author")String author, @Param("title")String title, @Param("member")String member,  @Param("content")String content, @Param("toshow")boolean toshow, @Param("ordering")Integer ordering,
                       @Param("type_id")Integer type_id, @Param("acquisitiondate")Timestamp acquisitiondate, @Param("time")Timestamp time,@Param("college_id")Integer college_id);

    @Select("<script>" +
            "select * from achievement where 1=1"
             + "<when test='college_id!=0'>"
             + "and college_id=#{college_id}"
             + "</when>"
             + "order by acquisitiondate"
             +"</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Achievement> findAll(@Param("college_id")Integer college_id);

    @Select("<script>" +
            "select * from achievement where title like CONCAT('%', #{title},'%')"
            + "<when test='college_id!=0'>"
            + "and college_id=#{college_id}"
            + "</when>"
            +"</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Map<String,Object>> findAchievementByTitle(@Param("title")String title, @Param("college_id")Integer college_id);

    @Select("<script>" +
            "select * from achievement where title like CONCAT('%', #{title},'%')"
            + "<when test='college_id!=0'>"
            + "and college_id=#{college_id}"
            + "</when>"
            +"</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "photoList",
                    column = "id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.PhotoMapper.findAchievementPhotoById", fetchType= FetchType.EAGER))})
    List<Achievement> searchAchievementByTitle(String title, @Param("college_id")Integer college_id);

    @Update("update achievement set read_num = read_num + 1 where id=#{id}")
    int updateRead_num(@Param("id") int id);

    @Update({"<script>",
            "update achievement",
            "<set>",
            "<if test='title!=null'>",
            "title = #{title}, ",
            "</if>",
            "<if test='member!=null'>",
            "member = #{member},",
            "</if>",
            "<if test='content!=null'>",
            "content = #{content}, ",
            "</if>",
            "<if test='toshow!=null'>",
            "toshow = #{toshow}, ",
            "</if>",
            "<if test='ordering!=null'>",
            "ordering = #{ordering}, ",
            "</if>",
            "<if test='type_id!=null'>",
            "type_id = #{type_id}, ",
            "</if>",
            "<if test='acquisitiondate!=null'>",
            "acquisitiondate = #{acquisitiondate}, ",
            "</if>",
            "<if test='time!=null'>",
            "time = #{time}, ",
            "</if>",
            "<if test='college_id!=null'>",
            "college_id = #{college_id}, ",
            "</if>",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    Integer updateAchievement(@Param("title")String title, @Param("member")String member, @Param("content")String content, @Param("toshow") Boolean toshow,
                              @Param("ordering")Integer ordering, @Param("type_id")Integer type_id, @Param("acquisitiondate")Timestamp acquisitiondate,
                              @Param("time")Timestamp time, @Param("id")Integer id, @Param("college_id")Integer college_id);

    @Update("update achievement set toshow=#{toshow} where id=#{id}")
    Integer updateToshow(@Param("toshow")Integer toshow, @Param("id")Integer id);

    @Delete("delete from achievement where id=#{id}")
    Integer deleteAchievement(@Param("id")Integer id);

    @Select("<script>" +
            "select COUNT(*) from achievement where time between #{begTime} and #{endTime}"
            + "<when test='college_id!=0'>"
            + "and college_id=#{college_id}"
            + "</when>"
            +"</script>")
    Integer getAddAchievementNum(@Param("begTime")String begTime, @Param("endTime")String endTime, @Param("college_id")Integer college_id);

    @Select("<script>" +
            "select COUNT(*) from achievement where time between #{begTime} and #{endTime} and type_id=#{type_id}"
            + "<when test='college_id!=0'>"
            + "and college_id=#{college_id}"
            + "</when>"
            +"</script>")
    Integer getAddAchievementNumByType_id(@Param("begTime")String begTime, @Param("endTime")String endTime, @Param("type_id")Integer type_id, @Param("college_id")Integer college_id);
}
