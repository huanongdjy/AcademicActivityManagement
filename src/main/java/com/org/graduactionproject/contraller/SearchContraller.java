package com.org.graduactionproject.contraller;

import com.org.graduactionproject.service.IAchievementService;
import com.org.graduactionproject.service.IEssayService;
import com.org.graduactionproject.token.PassToken;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @Autowired
    @Qualifier("essayService")
    private IEssayService essayService;

    @RequestMapping("/search")
    @PassToken
    public List<Map<String,Object>> search(@RequestBody String data){
        List<Map<String,Object>> list = new ArrayList<>();


        List<Map<String,Object>> result = null;
        JSONObject jsonObject = JSONObject.fromObject(data);

        String type = jsonObject.getString("type");
        String title = jsonObject.getString("title");
        if("activity".equals(type)){
            result = essayService.findEssayByTitle(null, title);
        }else if("achievement".equals(type)){
            result = achievementService.findAchievementByTitle(null, title);
        }
        if(result != null){
            Map<String,Object> map = new HashMap<>();
            map.put("resultCode", "200");
            list.add(map);
            list.addAll(result);
        }
        return list;
    }
}
