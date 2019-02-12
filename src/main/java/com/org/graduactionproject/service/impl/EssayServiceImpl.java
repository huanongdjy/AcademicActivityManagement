package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.EssayMapper;
import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.service.IEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("essayService")
public class EssayServiceImpl implements IEssayService {
    @Autowired
    EssayMapper essayMapper;

    public List findEssayByName(String title){
        return essayMapper.findEssayByName(title);
    }
    public int addAchievement(Essay essay){
        return essayMapper.addAchievement(essay);
    }
    public int updateIndex(int id, int index){
        return essayMapper.updateIndex(id, index);
    }
}
