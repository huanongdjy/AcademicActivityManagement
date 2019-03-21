package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.OutcomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("outcomeService")
public class OutcomeServiceImpl {
    @Autowired
    OutcomeMapper outcomeMapper;

    public Integer addOutcome(String content,Integer id ){
        return outcomeMapper.addOutcome(content, id);
    }
}
