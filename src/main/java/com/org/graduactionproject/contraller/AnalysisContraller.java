package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
import com.org.graduactionproject.service.IAnalysisService;
import com.org.graduactionproject.token.PassToken;
import com.org.graduactionproject.token.UserLoginToken;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AnalysisContraller {
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    @Qualifier("analysisService")
    IAnalysisService analysisService;

    @RequestMapping(value = "/getInforCardData")
    @ResponseBody
    @Transactional
    @PassToken
    public Map<String, Object> getInforCardData(HttpServletRequest httpServletRequest, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
//        String token = httpServletRequest.getHeader("Authorization");
//        String author = JWT.decode(token).getAudience().get(0);

        JSONObject jsonObject = JSONObject.fromObject(data);
        List<Integer> list = new ArrayList<>();
        String begTime = jsonObject.getString("begTime");
        String endTime = jsonObject.getString("endTime");
        String college_id = jsonObject.getString("college_id");
        Integer co_id = Integer.parseInt(college_id);
        // 获取阅读量
        Integer read_num = analysisService.getRangeReadNum(begTime, endTime);
        list.add(read_num);
        // 新增成果数量
        Integer achievement_num = analysisService.getAddAchievementNum(co_id, begTime, endTime);
        list.add(achievement_num);

        //举办活动数量
        Integer hold_num = analysisService.getHoldActivityNum(co_id, begTime, endTime);
        list.add(hold_num);

        //参加活动人数
        Integer attendance_num = analysisService.getAttendanceNum(co_id, begTime, endTime);
        list.add(attendance_num);
        map.put("list", list);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/getEssayPieData")
    @ResponseBody
    @Transactional
    @PassToken
    public List<Map<String, Object>>  getEssayPieData(HttpServletRequest httpServletRequest, @RequestBody String data){
        List<Map<String, Object>> list = new ArrayList<>();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String begTime = jsonObject.getString("begTime");
        String endTime = jsonObject.getString("endTime");
        String college_id = jsonObject.getString("college_id");
        Integer co_id = Integer.parseInt(college_id);
        list = analysisService.getEssayPieData(co_id, begTime,endTime);
        return list;
    }

    @RequestMapping(value = "/getAchievementPieData")
    @ResponseBody
    @Transactional
    @PassToken
    public List<Map<String, Object>>  getAchievementPieData(HttpServletRequest httpServletRequest, @RequestBody String data){
        List<Map<String, Object>> list = new ArrayList<>();

        JSONObject jsonObject = JSONObject.fromObject(data);
        String begTime = jsonObject.getString("begTime");
        String endTime = jsonObject.getString("endTime");
        String college_id = jsonObject.getString("college_id");
        Integer co_id = Integer.parseInt(college_id);
        list = analysisService.getAchievementPieData(co_id, begTime,endTime);
        return list;
    }

    @RequestMapping(value = "/getLineChart")
    @ResponseBody
    @Transactional
    @PassToken
    public List<Map<String, Object>>  getLineChart(HttpServletRequest httpServletRequest, @RequestBody String data){
        List<Map<String, Object>> list = new ArrayList<>();

        JSONObject jsonObject = JSONObject.fromObject(data);
        String time0 = jsonObject.getString("time0");
        String time1 = jsonObject.getString("time1");
        String time2 = jsonObject.getString("time2");;
        String time3 = jsonObject.getString("time3");;
        String time4 = jsonObject.getString("time4");;
        String time5 = jsonObject.getString("time5");;
        String time6 = jsonObject.getString("time6");;
        String time7 = jsonObject.getString("time7");
        Integer college_id = jsonObject.getInt("college_id");
        list = analysisService.getLineChart(college_id, time0, time1,time2, time3, time4, time5, time6, time7);
        return list;
    }
}
