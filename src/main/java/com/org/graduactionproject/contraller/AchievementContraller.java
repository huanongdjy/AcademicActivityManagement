package com.org.graduactionproject.contraller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.service.IAchievementService;
import com.org.graduactionproject.token.PassToken;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AchievementContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @RequestMapping(value = "/updateAchievement")
    @ResponseBody
    @PassToken
    public Map<String, Object> updateAchievement(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String title = jsonObject.getString("title");
        String author = jsonObject.getString("author");
        String member = jsonObject.getString("member");
        String acquisitiondate = jsonObject.getString("acquisitiondate");
        int index = Integer.parseInt(jsonObject.getString("index"));
        boolean toshow = jsonObject.getBoolean("toshow");
//        byte[] photo
        return null;
    }
}
