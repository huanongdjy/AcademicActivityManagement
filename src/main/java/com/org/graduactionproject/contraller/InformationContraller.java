package com.org.graduactionproject.contraller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.service.IAchievementService;
import com.org.graduactionproject.service.IEssayService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InformationContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @Autowired
    @Qualifier("essayService")
    private IEssayService essayService;

    @RequestMapping(value = "/getInformationWithPage")
    @ResponseBody
    public InfoPageJSONBean getInformationWithPage(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        String type = jsonObject.getString("type");

        if("achievements".equals(type)){
            return achievementService.getInfoPage(size, page, type);
        }else if("newactivity".equals(type) || "oldactivity".equals(type)){
            return essayService.getInfoPage(size, page, type);
        }
        return null;
    }
}
