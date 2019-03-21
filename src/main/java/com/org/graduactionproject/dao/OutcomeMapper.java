package com.org.graduactionproject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface OutcomeMapper {
    @Insert("insert into outcome(content, id) values(#{content}, #{id})")
    Integer addOutcome(@Param("content")String content,@Param("id")Integer id );
}
