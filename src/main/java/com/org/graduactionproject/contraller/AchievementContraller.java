package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.service.IAchievementService;
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
public class AchievementContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @Autowired
    @Qualifier("photoService")
    private IPhotoService photoService;

    @RequestMapping(value = "/updateAchievement")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> updateAchievement(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        Integer id = Integer.parseInt(jsonObject.getString("id"));
        String title = jsonObject.getString("title");
//        String author = jsonObject.getString("author");
        String member = jsonObject.getString("member");
        Boolean toshow = jsonObject.getBoolean("toshow");
        String content = jsonObject.getString("content");
        JSONArray jsonArray = jsonObject.getJSONArray("photoList");
//        List photoList = new ArrayList();
        for(int i = 0; i<jsonArray.size(); i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            String url = jsonObject1.getString("url");
            // 添加照片
            String photo_name = url.substring(13, url.length()-1);
            photoService.addAchievementPhoto(url,url,id);
        }
        Integer ordering = Integer.parseInt(jsonObject.getString("ordering"));
        Integer type_id = Integer.parseInt(jsonObject.getString("type_id"));
        String date = jsonObject.getString("date");
        date = date.substring(0,10);
        String time = jsonObject.getString("time");
        Timestamp acquisitiondate = Timestamp.valueOf(date + " " + time);

        Integer ret = achievementService.updateAchievement(title,member,content,toshow,ordering,type_id,acquisitiondate,id);
        if(ret == 1){
            map.put("message", "更新成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "/addAchievement")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> addAchievement(HttpServletRequest httpServletRequest, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        HttpSession session = httpServletRequest.getSession();
        String token = httpServletRequest.getHeader("Authorization");
//        User user = (User)session.getAttribute("user");
//        String author = user.getUsername();
        String author = JWT.decode(token).getAudience().get(0);
        JSONObject jsonObject = JSONObject.fromObject(data);
        String title = jsonObject.getString("title");
        String member = jsonObject.getString("member");
        Boolean toshow = jsonObject.getBoolean("toshow");
        String content = jsonObject.getString("content");

        Integer ordering = Integer.parseInt(jsonObject.getString("ordering"));
        Integer type_id = Integer.parseInt(jsonObject.getString("type_id"));
        String date = jsonObject.getString("date");
        date = date.substring(0,10);
        String time = jsonObject.getString("time");
        Timestamp acquisitiondate = Timestamp.valueOf(date + " " + time);
        Integer id = achievementService.addAchievement(author, title,member,content,toshow,ordering,type_id,acquisitiondate);

        JSONArray jsonArray = jsonObject.getJSONArray("photoList");

        if(id != null){
            for(int i = 0; i<jsonArray.size(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String url = jsonObject1.getString("url");
                String photo_name = url.substring(13, url.length()-1);
                photoService.addAchievementPhoto(photo_name, url, id);
            }
            map.put("message", "新增成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "/deleteAchievement")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> deleteAchievement(HttpServletRequest httpServletRequest, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        Integer id = Integer.parseInt(data);
        Integer ret1 = achievementService.deleteAchievement(id);

        Integer ret2 = photoService.deleteAchievement(id);
        if (ret1 == 1 ){
            map.put("resultCode", 200);
            map.put("message", "删除成功");
        } else {
            map.put("resultCode", 200);
            map.put("message", "该成果不存在");
        }
        return map;
    }

    @RequestMapping(value = "/searchaChievement")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String,Object> searchaChievement( @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        List<Achievement> achievements = achievementService.searchAchievementByTitle(data);
        if (achievements != null){
            map.put("resultCode", 200);
            map.put("achievements", achievements);
        }
        return map;
    }

    @RequestMapping(value = "/changeAchievementToshow")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String,Object> changeAchievementToshow( @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String toshow = jsonObject.getString("toshow");
        Integer id = jsonObject.getInt("id");
        Integer ret = achievementService.updateToshow(toshow, id);
        if(ret == null){
            map.put("message", "修改失败");
        }else {
            map.put("message", "修改成功");
        }

        return map;
    }
}
