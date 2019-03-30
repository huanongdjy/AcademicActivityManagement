package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Identity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IdentityMapper {
    @Select("select * from identity where identity_id=#{identity_id}")
    Identity findIdentityByIdentity(@Param("identity_id")Integer identity_id);

    @Select("select * from identity")
    List<Identity> getIdentitys();

    @Insert("insert into identity(access, identity_name) values(#{access}, #{identity_name})")
    @Options(useGeneratedKeys = true, keyProperty = "identity_id", keyColumn = "identity_id")
    Integer addIdentityu(@Param("access")String access, @Param("identity_name")String identity_name);

    @Update({"<script>",
            "update identity",
            "<set>",
            "<if test='identity_name!=null'>",
            "identity_name = #{identity_name}",
            "</if>",
            "<if test='access!=null'>",
            "access = #{access}",
            "</if>",
            "</set>",
            "where identity_id = #{identity_id}",
            "</script>"
    })
    Integer updateIdentity(@Param("identity_name")String identity_name, @Param("access")String access, @Param("identity_id")Integer identity_id);

    @Delete("delete from identity where identity_id=#{identity}")
    Integer deleteIdentity(@Param("identity_id")Integer identity_id);

    @Select("select * from identity where identity_name like CONCAT('%', #{identity_name},'%')")
    List<Identity> findIdentityByName(String identity_name);

    @Select("select * from identity where identity_name=#{identiy_name}")
    Identity getIdentityByName(String identity_name);

}
