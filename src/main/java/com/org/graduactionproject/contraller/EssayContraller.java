package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.service.IEssayService;
import com.org.graduactionproject.service.IPhotoService;
import com.org.graduactionproject.token.UserLoginToken;
import net.sf.json.JSONArray;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class EssayContraller {
    @Autowired
    @Qualifier("essayService")
    private IEssayService essayService;

    @Autowired
    @Qualifier("photoService")
    private IPhotoService photoService;

    @RequestMapping(value = "/addEssay")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> addEssay(HttpServletRequest httpServletRequest, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        HttpSession session = httpServletRequest.getSession();
        String token = httpServletRequest.getHeader("Authorization");
        String author = JWT.decode(token).getAudience().get(0);

        JSONObject jsonObject = JSONObject.fromObject(data);
        String title = jsonObject.getString("title");
//        String theme = jsonObject.getString("theme");
        String summary = jsonObject.getString("summary");
        String location = jsonObject.getString("location");
//        Boolean toshow = jsonObject.getBoolean("toshow");// 暂时不需要
        String content = jsonObject.getString("content");
//        String precautions = jsonObject.getString("precautions");// 是否需要
        String fund = jsonObject.getString("fund");
        String organizer = jsonObject.getString("organizer");
        Integer planned_attendance = jsonObject.getInt("planned_attendance");
//        Integer ordering = Integer.parseInt(jsonObject.getString("ordering"));
        Integer type_id = Integer.parseInt(jsonObject.getString("type_id"));
        String date = jsonObject.getString("date");
        date = date.substring(0,10);
        String time = jsonObject.getString("time");
        Timestamp hold_time = Timestamp.valueOf(date + " " + time);

        Integer id = essayService.addEssay(title, author, summary, hold_time, location,content
                , fund, organizer, planned_attendance, type_id);

        JSONArray jsonArray = jsonObject.getJSONArray("photoList");

        if(id != null){
            for(int i = 0; i<jsonArray.size(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String url = jsonObject1.getString("url");
                String photo_name = url.substring(13, url.length()-1);
                photoService.addEssayPhoto(photo_name, url, id);
            }
            map.put("message", "新增成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "/searchEssays")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String,Object> searchEssays( @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        List<Essay> essays = essayService.searchEssayByTitle(data);
        if (essays != null){
            map.put("resultCode", 200);
            map.put("essays", essays);
        }
        return map;
    }


    @RequestMapping(value = "/deleteEssay")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String,Object> deleteEssay( @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        Integer id = Integer.parseInt(data);
        Integer ret = essayService.deleteEssay(id);

        Integer ret2 = photoService.deleteAchievement(id);
        if (ret == 1 ){
            map.put("resultCode", 200);
            map.put("message", "删除成功");
        } else {
            map.put("resultCode", 200);
            map.put("message", "该文章不存在");
        }
        return map;
    }

    @RequestMapping(value = "/updateEssay")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> updateEssay(HttpServletRequest httpServletRequest, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
//        JSONObject jsonObject = JSONObject.fromObject(data);
        HttpSession session = httpServletRequest.getSession();
        String token = httpServletRequest.getHeader("Authorization");
        String author = JWT.decode(token).getAudience().get(0);

        JSONObject jsonObject = JSONObject.fromObject(data);
        Integer id = jsonObject.getInt("id");
        String title = jsonObject.getString("title");
//        String theme = jsonObject.getString("theme");
        String summary = jsonObject.getString("summary");
        String location = jsonObject.getString("location");
//        Boolean toshow = jsonObject.getBoolean("toshow");// 暂时不需要
        String content = jsonObject.getString("content");
//        String precautions = jsonObject.getString("precautions");// 是否需要
        String fund = jsonObject.getString("fund");
        String organizer = jsonObject.getString("organizer");
        Integer ordering = jsonObject.getInt("ordering");
        Integer planned_attendance = jsonObject.getInt("planned_attendance");
//        Integer ordering = Integer.parseInt(jsonObject.getString("ordering"));
        Integer type_id = Integer.parseInt(jsonObject.getString("type_id"));
        String date = jsonObject.getString("date");
        date = date.substring(0,10);
        String time = jsonObject.getString("time");
        Timestamp hold_time = Timestamp.valueOf(date + " " + time);

        Integer retId = essayService.updateEssay(title, author, summary, hold_time, location,content
                , fund, organizer, planned_attendance, ordering, type_id, id);

        JSONArray jsonArray = jsonObject.getJSONArray("photoList");

        if(retId != null){
            for(int i = 0; i<jsonArray.size(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String url = jsonObject1.getString("url");
                String photo_name = url.substring(13, url.length()-1);
                photoService.addEssayPhoto(photo_name, url, id);
            }
            map.put("message", "更新成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "更新失败");
        }
        return map;
    }
}
