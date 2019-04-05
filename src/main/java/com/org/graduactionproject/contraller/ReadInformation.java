package com.org.graduactionproject.contraller;

import com.org.graduactionproject.domain.AchievementRead;
import com.org.graduactionproject.domain.EssayRead;
import com.org.graduactionproject.service.IAchievementReadService;
import com.org.graduactionproject.service.IAchievementService;
import com.org.graduactionproject.service.IEssayService;
import com.org.graduactionproject.service.IEssayReadService;
import com.org.graduactionproject.token.PassToken;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

@RestController
@Transactional
public class ReadInformation {
    @Autowired
    @Qualifier("essayreadService")
    IEssayReadService essayreadService;

    @Autowired
    @Qualifier("achievementReadService")
    IAchievementReadService achievementReadService;

    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @Autowired
    @Qualifier("essayService")
    private IEssayService essayService;

//    @Autowired
//    private HttpServletRequest request;

    @RequestMapping("/readInformation")
    @PassToken
    public void readInformation(HttpServletRequest request, @RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
//        int read_id = jsonObject.getInt("read_id");
        int id = jsonObject.getInt("id");
        String  type = jsonObject.getString("type");
        // 查询read表中该文章，该ip是否存在
//        String ip = ReadInformation.getIpAddr(request);
//        Readed read = readService.getReadByIpAndRead_id(ip, id);
        if("achievements".equals(type)){
//            AchievementRead achievementRead = achievementReadService.getEssayReadByIpAndId(ip, id);
//            if(achievementRead == null){
                achievementService.updateRead_num(id);
                achievementReadService.addAchievement(id);
//            }
        }else if("newactivity".equals(type) || "oldactivity".equals(type)){
//            EssayRead essayRead = essayreadService.getEssayReadByIpAndId(ip, id);
//            if(essayRead == null){
                essayService.updateRead_num(id);
                essayreadService.addEssayRead(id);
//            }
        }

    }

    private static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }
}
