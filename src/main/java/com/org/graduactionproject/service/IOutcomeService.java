package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.OutCome;

public interface IOutcomeService {
    Integer addOutcome(String content,Integer id );
    OutCome getOutcome(Integer id);
}
