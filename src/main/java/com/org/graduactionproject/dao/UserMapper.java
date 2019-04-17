package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Identity;
import com.org.graduactionproject.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    @Select("select * from users where username = #{username}")
            @Results({
                @Result(property = "identity",
                column = "identity_id",
                javaType = Identity.class,
                jdbcType = JdbcType.INTEGER,
                one = @One(select ="com.org.graduactionproject.dao.IdentityMapper.findIdentityByIdentity"))})
    User findWithLoginNameAndIdentity(@Param("username") String username);

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(property = "identity",
                    column = "identity_id",
                    javaType = Identity.class,
                    jdbcType = JdbcType.INTEGER,
                    one = @One(select ="com.org.graduactionproject.dao.IdentityMapper.findIdentityByIdentity"))})
    User findUserByUserName(String username);

    @Update({"<script>",
                "update users",
                "<set>",
//                    "<if test='username!=null'>",
//                    "username = #{username} , ",
//                    "</if>",
                    "<if test='password!=null'>",
                    "password = #{password}",
                    "</if>",
                    "<if test='mailbox!=null'>",
                    ", mailbox = #{mailbox}",
                    "</if>",
                    "<if test='identity_id!=null'>",
                    ", identity_id = #{identity_id} ",
                    "</if>",
                "</set>",
                "where username = #{username}",
                "</script>"
             })
    Integer updateUser(@Param("username")String username, @Param("identity_id")int identity_id, @Param("mailbox")String mailbox, @Param("password")String password);

    @Select("select * from users ")
    @Results({
            @Result(property = "identity",
                    column = "identity_id",
                    javaType = Identity.class,
                    jdbcType = JdbcType.INTEGER,
                    one = @One(select ="com.org.graduactionproject.dao.IdentityMapper.findIdentityByIdentity"))})
    List<User> findAll();

    @Insert("insert into users(username, password, identity_id, mailbox) values(#{userName}, #{password}, #{identity_id}, #{mailbox})")
    Integer addUser(String userName, String password, int identity_id, String mailbox);

    @Delete("delete from users where username = #{username}")
    Integer deleteUser(String username);
}
