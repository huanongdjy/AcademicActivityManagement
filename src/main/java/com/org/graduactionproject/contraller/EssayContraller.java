package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
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
        String location = jsonObject.getString("localtion");
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
}
