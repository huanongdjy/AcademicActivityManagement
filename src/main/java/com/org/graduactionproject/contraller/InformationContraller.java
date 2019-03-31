package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.domain.Essay;
import com.org.graduactionproject.service.IAchievementService;
import com.org.graduactionproject.service.IEssayService;
import com.org.graduactionproject.token.PassToken;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @PassToken
    public InfoPageJSONBean getInformationWithPage(HttpServletRequest httpServletRequest, @RequestBody String data){
        HttpSession session = httpServletRequest.getSession();
        String token = httpServletRequest.getHeader("Authorization");
        String author = JWT.decode(token).getAudience().get(0);

        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        String type = jsonObject.getString("type");

        if("achievements".equals(type)){
            return achievementService.getInfoPage(author,size, page);
        }else if ("activity".equals(type)){
            return essayService.getInfoPage(author, size, page, type);
        }else if("newactivity".equals(type) || "oldactivity".equals(type)){
            return essayService.getInfoPage(author, size, page, type);
        }
        return null;
    }
}
