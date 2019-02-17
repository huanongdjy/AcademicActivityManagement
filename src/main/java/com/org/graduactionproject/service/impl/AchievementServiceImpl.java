package com.org.graduactionproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.dao.AchievementMapper;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("achievementService")
public class AchievementServiceImpl implements IAchievementService {
    @Autowired
    AchievementMapper achievementMapper;

    public Achievement findAchievementById(int id){
        return achievementMapper.findAchievementById(id);
    }
    public int addAchievement(Achievement achievement){
        return achievementMapper.addAchievement(achievement);
    }
    public List<Achievement> findAll(){
        return achievementMapper.findAll();
    }

    @Override
    public List<Map<String,Object>> findAchievementByTitle(String title) {
        return achievementMapper.findAchievementByTitle(title);
    }

    public InfoPageJSONBean getInfoPage(int size, int page, String type){
        //分页并查询
//        PageHelper pageHelper = new PageHelper();
        PageHelper.startPage(page, size);
        List<Achievement> achievements = achievementMapper.findAll();
        PageInfo<Achievement> pageInfo = new PageInfo<>(achievements);
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Achievement> result = pageInfo.getList();//和上面的users结果相同
        System.out.println("pageNum： " + pageNum);
        System.out.println("pageSize: " + pageSize);
        System.out.println("total: " + total);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    public int updateRead_num(int id){
        return achievementMapper.updateRead_num(id);
    }
}
