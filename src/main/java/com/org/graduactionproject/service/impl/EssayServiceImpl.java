package com.org.graduactionproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.dao.EssayMapper;
import com.org.graduactionproject.dao.TypeMapper;
import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.service.IEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service("essayService")
public class EssayServiceImpl implements IEssayService {
    @Autowired
    EssayMapper essayMapper;

    @Autowired
    TypeMapper typeMapper;

    public List<Map<String,Object>> findEssayByTitle(String title){
        return essayMapper.findEssayByTitle(title);
    }
    public int addAchievement(Essay essay){
        return essayMapper.addAchievement(essay);
    }
    public int updateIndex(int id, int index){
        return essayMapper.updateIndex(id, index);
    }
    public List<Essay> findEssayByType_name(String type_name){
        int type_id = typeMapper.findType_idByType_name(type_name);
        if(type_id == -1) return null;
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(calendar.getTime()));
        String  curr_tinme = dateFormat.format(calendar.getTime());
        return essayMapper.findEssayByType_id(type_id, curr_tinme);
    }
    public InfoPageJSONBean getInfoPage(int size, int page, String type_name){
//        PageHelper pageHelper = new PageHelper();
        PageHelper.startPage(page, size);
        //先获取类型 type_id
        int type_id = typeMapper.findType_idByType_name(type_name);
        if(type_id == -1) return null;
        //根据当前时间戳，查询活动是否已举办
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(calendar.getTime()));
        String  curr_tinme = dateFormat.format(calendar.getTime());
        List<Essay> essays = essayMapper.findEssayByType_id(type_id, curr_tinme);
        PageInfo<Essay> pageInfo = new PageInfo<>(essays);
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Essay> result = pageInfo.getList();//和上面的users结果相同
        System.out.println("pageNum： " + pageNum);
        System.out.println("pageSize: " + pageSize);
        System.out.println("total: " + total);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    public int updateRead_num(int id){
        return essayMapper.updateRead_num(id);
    }
}
