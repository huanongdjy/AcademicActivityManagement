package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Identity;

import java.util.List;

public interface IIdentityService {
    List<Identity> getIdentitys();
    Integer addIdentityu(String access, String identity_name);
    Integer updateIdentity(String identity_name, String access, Integer identity_id);
    Integer deleteIdentity(Integer identity_id);
    List<Identity> findIdentityByName(String identity_name);
    Identity getIdentityByName(String identity_name);
}
