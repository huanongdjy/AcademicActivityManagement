package com.org.graduactionproject.contraller;

import com.org.graduactionproject.service.IAnalysisService;
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
    @UserLoginToken
    public Map<String, Object> getInforCardData(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        List<Integer> list = new ArrayList<>();
        String begTime = jsonObject.getString("begTime");
        String endTime = jsonObject.getString("endTime");
        // 获取阅读量
        Integer read_num = analysisService.getRangeReadNum(begTime, endTime);
        list.add(read_num);
        // 新增成果数量
        Integer achievement_num = analysisService.getAddAchievementNum(begTime, endTime);
        list.add(achievement_num);

        //举办活动数量
        Integer hold_num = analysisService.getHoldActivityNum(begTime, endTime);
        list.add(hold_num);

        //参加活动人数
        Integer attendance_num = analysisService.getAttendanceNum(begTime, endTime);
        list.add(attendance_num);
        map.put("list", list);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/getPieData")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public List<Map<String, Object>>  getPieData(@RequestBody String data){
        List<Map<String, Object>> list = new ArrayList<>();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String begTime = jsonObject.getString("begTime");
        String endTime = jsonObject.getString("endTime");

        list = analysisService.getPieData(begTime,endTime);
        return list;
    }
}
