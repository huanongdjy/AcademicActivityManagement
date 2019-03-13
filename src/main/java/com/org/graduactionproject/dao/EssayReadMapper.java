package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.EssayRead;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

public interface EssayReadMapper {
    @Select("select * from essayread where read_id=#{read_id}")
    EssayRead findEssayReadByRead_id(@Param("read_id") int read_id);

    @Select("select * from essayread where ip=#{ip} and id = #{id}")
    EssayRead getEssayReadByIpAndId(@Param("ip")String ip, @Param("id")int id);

    @Insert("insert into essayread(ip, id) values(#{ip}, #{id})")
    @Options(useGeneratedKeys = true, keyProperty = "read_id")
    Integer addReaded(EssayRead essayread);

    @Select("select COUNT(*) from essayread where read_time between #{begTime} and #{endTime}")
    Integer getRandEssayNum(@Param("begTime")String begTime, @Param("endTime")String endTime);
}
