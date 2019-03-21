package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Memu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemuMapper {
    @Select("select * from memu")
    List<Memu> getMemus();
}
