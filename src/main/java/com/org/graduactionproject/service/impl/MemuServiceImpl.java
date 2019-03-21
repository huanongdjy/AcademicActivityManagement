package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.MemuMapper;
import com.org.graduactionproject.domain.Memu;
import com.org.graduactionproject.service.IMemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memuService")
public class MemuServiceImpl implements IMemuService {
    @Autowired
    MemuMapper memuMapper;

    public List<Memu> getMemus(){
        return memuMapper.getMemus();
    }
}
