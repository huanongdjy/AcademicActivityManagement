package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Menu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MenuMapper {
    @Select("select * from menu where component='Main' order by orderIndex")
    @Results({
            @Result(property = "menu_id", column = "menu_id"),
            @Result(property = "children",
                    column = "menu_id",
                    javaType = List.class,
                    jdbcType = JdbcType.INTEGER,
                    many = @Many(select ="com.org.graduactionproject.dao.MenuMapper.findMenuByMenu_id", fetchType= FetchType.EAGER))})
    List<Menu> getMenus();

    @Select("select * from menu where component  <> 'Main' order by orderIndex")
    List<Menu> getchilMenus();

    @Select("select * from menu where parent_id = #{menu_id}")
    List<Menu> findMenuByMenu_id(@Param("menu_id") Integer menu_id);

    @Update({"<script>",
            "update menu",
            "<set>",
            "<if test='title!=null'>",
            "title = #{title}, ",
            "</if>",
            "<if test='access!=null'>",
            "access = #{access}, ",
            "</if>",
            "</set>",
            "where menu_id = #{menu_id}",
            "</script>"
    })
    Integer updateMenu(@Param("menu_id")Integer menu_id, @Param("title")String title, @Param("access")String access);

    @Select("select * from menu where title like CONCAT('%', #{title},'%')")
    List<Menu> searchMenuByTitle(@Param("title")String title);

    @Select("select * from menu where classname=#{className}")
    Menu getMenuByClassName(@Param("className") String className);
}
