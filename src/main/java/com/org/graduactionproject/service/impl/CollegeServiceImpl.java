package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.CollegeMapper;
import com.org.graduactionproject.domain.College;
import com.org.graduactionproject.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("collegeService")
public class CollegeServiceImpl implements ICollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public Integer addCollege(String college_name, String descritpion) {
        return collegeMapper.addCollege(college_name, descritpion);
    }

    @Override
    public List<College> getAllCollege() {
        return collegeMapper.getAllCollege();
    }

    @Override
    public List<College> findCollegeByName(String college_name) {
        return collegeMapper.findCollegeByName(college_name);
    }

    @Override
    public Integer updateCollege(String college_name, String description, Integer college_id) {
        return collegeMapper.updateCollege(college_name, description, college_id);
    }

    @Override
    public Integer deleteCollege(Integer college_id) {
        return collegeMapper.deleteCollege(college_id);
    }

    @Override
    public College getCollegeByName(String college_name) {
        return collegeMapper.getCollegeByName(college_name);
    }
}
