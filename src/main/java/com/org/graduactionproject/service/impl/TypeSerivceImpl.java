package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.TypeMapper;
import com.org.graduactionproject.domain.Type;
import com.org.graduactionproject.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeSerivce")
public class TypeSerivceImpl implements ITypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public Integer addType(String type_name, String description){
        Integer id = typeMapper.findType_idByType_name(type_name);
        if (id!=null)
            return typeMapper.addType(type_name, description);
        else
            return  -1;//类型名称不能重复
    }

    @Override
    public int updateType(String type_name,String description, int type_id) {
        return typeMapper.updateType(type_name, description, type_id);
    }

    @Override
    public int findType_idByType_name(String type_name) {
        return typeMapper.findType_idByType_name(type_name);
    }

    @Override
    public Integer deleteType(int type_id) {
        return typeMapper.deleteType(type_id);
    }

    @Override
    public List<Type> searchByType_name(String type_name) {
        return typeMapper.searchByType_name(type_name);
    }

    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }
}
