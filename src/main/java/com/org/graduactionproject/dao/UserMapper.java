package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from users where username = #{username} and identity = #{identity}")
    User findWithLoginNameAndIdentity(@Param("username")String username, @Param("identity")int identity);
}
