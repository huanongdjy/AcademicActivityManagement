package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.IdentityMapper;
import com.org.graduactionproject.domain.Identity;
import com.org.graduactionproject.service.IIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("identityService")
public class IdentityServiceImpl implements IIdentityService {
    @Autowired
    IdentityMapper identityMapper;

    public List<Identity> getIdentitys(){
        return identityMapper.getIdentitys();
    }
}
