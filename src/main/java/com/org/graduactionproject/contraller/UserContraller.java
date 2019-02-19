package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import com.org.graduactionproject.token.CreatToken;
import com.org.graduactionproject.token.UserLoginToken;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class UserContraller {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String identity = jsonObject.getString("identity");
        Map<String,Object> map = userService.login(username, password, identity);
        String token = CreatToken.getToken((User)map.get("user"));
        map.put("token", token);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    @UserLoginToken
    public Map<String,Object> getUserInfo(HttpServletRequest httpServletRequest, @RequestBody String data) {
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String token = jsonObject.getString("token");
        String userId = JWT.decode(token).getAudience().get(0);
        User user = userService.findUserByUserId(Integer.parseInt(userId));
        map.put("user", user);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/updateUser")
    @UserLoginToken
    @Transactional
    public void updateUser(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int userId = Integer.parseInt(jsonObject.getString("userId"));
        String user_name = jsonObject.getString("username");
        int identity = Integer.parseInt(jsonObject.getString("identity"));
        String password = jsonObject.getString("password");
        String mailbox = jsonObject.getString("mailbox");
//        String access = jsonObject.getString("access");
        userService.updateUser(user_name,identity,mailbox,password,userId);
    }

    @RequestMapping(value = "/getUsers")
    @ResponseBody
    @UserLoginToken
    public InfoPageJSONBean getUsers(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        return userService.getInfoPage(size, page);
    }
}
