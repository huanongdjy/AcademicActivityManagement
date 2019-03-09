package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITypeService {
    Integer addType(String type_name, String description);
    int updateType(@Param("type_name")String type_name, String description, @Param("type_id")int type_id);
    int findType_idByType_name(@Param("type_name")String type_name);
    Integer deleteType(int type_id);
    List<Type> searchByType_name(String type_name);
    List<Type> findAll();
}
