package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Type;
import org.apache.ibatis.annotations.*;

public interface TypeMapper {
    @Select("select IFNULL(MAX(type_id), -1)type_id from type where type_name=#{type_name}")
    int findType_idByType_name(@Param("type_name")String type_name);

    @Insert("insert into type values(type_name, description)")
    @Options(useGeneratedKeys = true, keyProperty = "type_id")
    int addType(Type type);

    @Update("update type set type_name=#{type_name} where type_id=#{type_id}")
    int updateType(@Param("type_name")String type, @Param("type_id")int type_id);
}
