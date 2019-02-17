package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.AchievementRead;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AchievementReadMapper {
    @Select("select * from achievementread where read_id=#{read_id}")
    AchievementRead findAchievementReadByRead_id(@Param("read_id") int read_id);

    @Select("select * from achievementread where ip=#{ip} and id = #{id}")
    AchievementRead getAchievementReadByIpAndId(@Param("ip")String ip, @Param("id")int id);

    @Insert("insert into achievementread(ip, id) values(#{ip}, #{id})")
    @Options(useGeneratedKeys = true, keyProperty = "read_id")
    int addAchievement(AchievementRead achievementRead);
}
