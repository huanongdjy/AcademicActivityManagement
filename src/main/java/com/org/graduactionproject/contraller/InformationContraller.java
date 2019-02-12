package com.org.graduactionproject.contraller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.service.IAchievementService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class InformationContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @RequestMapping(value = "/getInformationWithPage")
    @ResponseBody
    public InfoPageJSONBean getInformationWithPage(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        String type = jsonObject.getString("type");
        //分页并查询
        Page<Achievement> pageInfo = PageHelper.startPage(page, size);
        List<Achievement> achievements = achievementService.findAll();
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Achievement> result = pageInfo.getResult();//和上面的users结果相同
        System.out.println("pageNum： " + pageNum);
        System.out.println("pageSize: " + pageSize);
        System.out.println("total: " + total);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }
}
