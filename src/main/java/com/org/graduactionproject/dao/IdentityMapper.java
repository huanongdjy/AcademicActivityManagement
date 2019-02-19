package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Identity;
import org.apache.ibatis.annotations.Select;

public interface IdentityMapper {
    @Select("select * from identity where identity_id=#{identity_id}")
    Identity findIdentityByIdentity(Integer identity_id);
}
