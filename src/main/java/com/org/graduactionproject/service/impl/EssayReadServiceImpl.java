package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.AchievementReadMapper;
import com.org.graduactionproject.dao.EssayReadMapper;
import com.org.graduactionproject.domain.AchievementRead;
import com.org.graduactionproject.domain.EssayRead;
import com.org.graduactionproject.service.IEssayReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("essayreadService")
public class EssayReadServiceImpl implements IEssayReadService {
    @Autowired
    EssayReadMapper essayReadMapper;



   public EssayRead findEssayReadByRead_id(int read_id){
        EssayRead essayread = essayReadMapper.findEssayReadByRead_id(read_id);
        return essayread;
    }
    public EssayRead getEssayReadByIpAndId(String ip, int id){
        EssayRead essayread = essayReadMapper.getEssayReadByIpAndId(ip, id);
        return essayread;
    }
    public int addEssayRead(String ip, int id){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        EssayRead essayread = new EssayRead(id, ip, time);
       return essayReadMapper.addReaded(essayread);
    }


}
