package com.org.graduactionproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.dao.EssayMapper;
import com.org.graduactionproject.dao.TypeMapper;
import com.org.graduactionproject.dao.UserMapper;
import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.domain.User;
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

    @Autowired
    UserMapper userMapper;

    public List<Map<String,Object>> findEssayByTitle(String username, String title){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();
        return essayMapper.findEssayByTitle(title, college_id);
    }
    public int addEssay(String username, String title, String author, String summary, Timestamp holdtime, String location,
                        String content, String fund, String organizer, Integer planned_attendance,
                        Integer type_id){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();

        Timestamp time = new Timestamp(System.currentTimeMillis());
        Integer ordering = 0;
        return essayMapper.addEssay(title,author, summary, time, holdtime, location,content
        , fund, organizer, planned_attendance, ordering, type_id, college_id);
    }
    public int updateIndex(int id, int index){
        return essayMapper.updateIndex(id, index);
    }
    public List<Essay> findEssayByType_name(String username,String type_name){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();

        int type_id = typeMapper.findType_idByType_name(type_name);
        if(type_id == -1) return null;
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(calendar.getTime()));
        String  curr_tinme = dateFormat.format(calendar.getTime());
        return essayMapper.findEssayByType_id(type_id, curr_tinme, college_id);
    }
    public InfoPageJSONBean getInfoPage(String username, int size, int page, String type_name){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();

        PageHelper.startPage(page, size);
        //先获取类型 type_id
//        int type_id = typeMapper.findType_idByType_name(type_name);
//        if(type_id == -1) return null;
        //根据当前时间戳，查询活动是否已举办
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println(dateFormat.format(calendar.getTime()));
        String  curr_tinme = dateFormat.format(calendar.getTime());
        List<Essay> essays = null;
        if ("newactivity".equals(type_name)){
            essays = essayMapper.findNewActivity(curr_tinme, college_id);
        }else if("oldactivity".equals(type_name)){
            essays = essayMapper.findOldActivity(curr_tinme, college_id);
        }else if("activity".equals(type_name)){
            essays = essayMapper.getAllEssays(college_id);
        }

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
    public List<Essay> searchEssayByTitle(String username, String title){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();
        return essayMapper.searchEssayByTitle(title, college_id);
    }
    public Integer deleteEssay(Integer id){
        return essayMapper.deleteEssay(id);
    }

    public Integer updateEssay(String username, String title, String author, String summary, Timestamp hold_time, String location,
                        String content, String fund, String organizer, Integer planned_attendance,
                        Integer ordering, Integer type_id, Integer id){
        User user = userMapper.findUserByUserName(username);
        Integer college_id = user.getCollege_id();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return essayMapper.updateEssay(title, author, summary, time, hold_time, location,content,fund, organizer, planned_attendance
                    ,ordering,type_id,id, college_id);
    }

    public Integer updateToshow(String toshow, Integer id){
        int i = 1;
        if ("false".equals(toshow)){
            i = 2;
        }
        return essayMapper.updateToshow(i, id);
    }
}
