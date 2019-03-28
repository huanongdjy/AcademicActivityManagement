package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.OutcomeMapper;
import com.org.graduactionproject.domain.OutCome;
import com.org.graduactionproject.service.IOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("outcomeService")
public class OutcomeServiceImpl implements IOutcomeService {
    @Autowired
    OutcomeMapper outcomeMapper;



    public Integer addOutcome(String content,Integer id ){
        return outcomeMapper.addOutcome(content, id);
    }

    public OutCome getOutcome(Integer id){
        return outcomeMapper.getOutcome(id);
    }
}
