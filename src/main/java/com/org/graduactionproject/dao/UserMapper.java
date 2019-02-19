package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Identity;
import com.org.graduactionproject.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    @Select("select * from users where username = #{username} and identity_id = #{identity_id}")
            @Results({
                @Result(property = "identity",
                column = "identity_id",
                javaType = Identity.class,
                jdbcType = JdbcType.INTEGER,
                one = @One(select ="com.org.graduactionproject.dao.IdentityMapper.findIdentityByIdentity"))})
    User findWithLoginNameAndIdentity(String username, int identity_id);

    @Select("select * from users where userId=#{userId}")
    @Results({
            @Result(property = "identity",
                    column = "identity_id",
                    javaType = Identity.class,
                    jdbcType = JdbcType.INTEGER,
                    one = @One(select ="com.org.graduactionproject.dao.IdentityMapper.findIdentityByIdentity"))})
    User findUserByUserId(int userId);

    @Update({"{<script>",
                "update users",
                "<set>",
                    "<if test='username!=null>'",
                    "username = #{username} , ",
                    "</if>",
                    "<if test='password!=null>'",
                    "password = #{password} , ",
                    "</if>",
                    "<if test='mialbox!=null>'",
                    "mialbox = #{mialbox} , ",
                    "</if>",
                    "<if test='identity!=null>'",
                    "identity = #{identity} , ",
                    "</if>",
                    " 1 = 1 ",
                "</set>",
                "where userId = #{userId}",
                "</script>"
             })
    Integer updateUser(String username, int identity, String mailbox, String password, int userId);

    @Select("select * from users")
    @Results({
            @Result(property = "identity",
                    column = "identity_id",
                    javaType = Identity.class,
                    jdbcType = JdbcType.INTEGER,
                    one = @One(select ="com.org.graduactionproject.dao.IdentityMapper.findIdentityByIdentity"))})
    List<User> findAll();
}
