package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.College;

import java.util.List;

public interface ICollegeService {
    Integer addCollege(String college_name, String descritpion);
    List<College> getAllCollege();
    List<College> findCollegeByName(String college_name);
    Integer updateCollege(String college_name, String description, Integer college_id);
    Integer deleteCollege(Integer college_id);
    College getCollegeByName(String college_name);
}
