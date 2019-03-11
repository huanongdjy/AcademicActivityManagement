package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TypeMapper {
    @Select("select IFNULL(MAX(type_id), -1)type_id from type where type_name=#{type_name}")
    int findType_idByType_name(@Param("type_name")String type_name);

    @Insert("insert into type(type_name, description) values(#{type_name}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "type_id")
    Integer addType(@Param("type_name")String type_name, @Param("description")String description);

    @Update({"<script>",
            "update type",
            "<set>",
            "<if test='type_name!=null'>",
            "type_name = #{type_name}, ",
            "</if>",
            "<if test='description!=null'>",
            "description = #{description}, ",
            "</if>",
            "</set>",
            "where type_id = #{type_id}",
            "</script>"
    })
    Integer updateType(@Param("type_name")String type_name,@Param("description")String description, @Param("type_id")int type_id);

    @Delete("delete from type where type_id=#{type_id}")
    Integer deleteType(int type_id);

    @Select("select * from type where type_name like CONCAT('%', #{type_name},'%')")
    List<Type> searchByType_name(String type_name);

    @Select("select * from type")
    List<Type> findAll();
}
