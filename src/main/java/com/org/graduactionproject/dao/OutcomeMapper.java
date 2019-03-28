package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.OutCome;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OutcomeMapper {
    @Insert("insert into outcome(content, id) values(#{content}, #{id})")
    Integer addOutcome(@Param("content")String content,@Param("id")Integer id );

    @Select("select * from outcome where id=#{id}")
    OutCome getOutcome(@Param("id")Integer id);
}
