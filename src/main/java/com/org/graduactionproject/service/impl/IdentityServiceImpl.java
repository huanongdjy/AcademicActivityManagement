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

    @Override
    public Integer addIdentityu(String access, String identity_name) {
        return identityMapper.addIdentityu(access, identity_name);
    }

    @Override
    public Integer updateIdentity(String identity_name, String access, Integer identity_id) {
        return identityMapper.updateIdentity(identity_name, access, identity_id);
    }

    @Override
    public Integer deleteIdentity(Integer identity_id) {
        return identityMapper.deleteIdentity(identity_id);
    }

    @Override
    public List<Identity> findIdentityByName(String identity_name) {
        return identityMapper.findIdentityByName(identity_name);
    }

    @Override
    public Identity getIdentityByName(String identity_name) {
        return identityMapper.getIdentityByName(identity_name);
    }
}
