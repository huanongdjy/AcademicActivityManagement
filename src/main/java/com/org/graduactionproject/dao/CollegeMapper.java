package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.College;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollegeMapper {
    @Insert("insert into college(college_name,description) values(#{college_name}, #{description})")
    Integer addCollege(@Param("college_name")String college_name, @Param("description")String descritpion);

    @Select("select * from college")
    List<College> getAllCollege();

    @Select("select * from college where college_name like CONCAT('%', #{college_name},'%')")
    List<College> findCollegeByName(@Param("college_name")String college_name);

    @Select("select * from college where college_name= #{college_name}")
    College getCollegeByName(@Param("college_name")String college_name);

    @Update({"<script>",
            "update college",
            "<set>",
            "<if test='college_name!=null'>",
            "college_name = #{college_name}",
            "</if>",
            "<if test='description!=null'>",
            "description = #{description} ",
            "</if>",
            "</set>",
            "where college_id = #{college_id}",
            "</script>"
    })
    Integer updateCollege(@Param("college_name")String college_name, @Param("description")String description, @Param("college_id")Integer college_id);

    @Delete("delete from college where college_id=#{college_id}")
    Integer deleteCollege(@Param("college_id")Integer college_id);
}
