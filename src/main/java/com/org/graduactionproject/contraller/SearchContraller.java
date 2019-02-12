package com.org.graduactionproject.contraller;

import com.org.graduactionproject.service.IAchievementService;
import com.org.graduactionproject.service.IEssayService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @Autowired
    @Qualifier("essayService")
    private IEssayService essayService;

    @RequestMapping("/search")
    public List search(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);

        String type = jsonObject.getString("type");
        String title = jsonObject.getString("title");
        if("activity".equals(type)){
            return essayService.findEssayByName(title);
        }else if("achievement".equals(type)){
            return null;
        }
        return null;
    }
}
