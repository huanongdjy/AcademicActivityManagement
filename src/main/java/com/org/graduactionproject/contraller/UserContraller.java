package com.org.graduactionproject.contraller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import com.org.graduactionproject.token.CreatToken;
import com.org.graduactionproject.token.PassToken;
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
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserContraller {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    @PassToken
    public Map<String,Object> login(HttpServletRequest httpServletRequest, @RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String identity = jsonObject.getString("identity");
        Map<String,Object> map = userService.login(username, password, identity);
        HttpSession sessoin=httpServletRequest.getSession();
        sessoin.setAttribute("user", map.get("user"));
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
        String username = JWT.decode(token).getAudience().get(0);
        User user = userService.findUserByUserName(username);
        map.put("user", user);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/updateUser")
    @UserLoginToken
    @Transactional
    public Map<String,Object> updateUser(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
//        int userId = Integer.parseInt(jsonObject.getString("userId"));
        String userName = jsonObject.getString("username");
        int identity = Integer.parseInt(jsonObject.getString("identity"));
        String mailbox = jsonObject.getString("mailbox");
        String password = jsonObject.getString("password");
//        String access = jsonObject.getString("access");
        int i = userService.updateUser(userName,identity,mailbox,password);
        if(i == 1){
            map.put("message", "更新用户成功");
        }else {
            map.put("message", "更新用户失败");
        }
        return map;
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

    @RequestMapping(value = "/addUser")
    @UserLoginToken
    public Map<String,Object> addUser(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        int identity_id = Integer.parseInt(jsonObject.getString("identity"));
        String user_name = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String mailbox = jsonObject.getString("mailbox");
        int i = userService.addUser(user_name, password, identity_id, mailbox);
        if(i == 1){
            map.put("message", "新增用户成功");
        }else {
            map.put("message", "新增用户失败");
        }
        return map;
    }

    @RequestMapping(value = "/searchUser")
    @UserLoginToken
    public Map<String,Object> searchUser(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        User user = userService.findUserByUserName(data);
        map.put("user",user);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/deleteUser")
    @UserLoginToken
    public Map<String, Object> deleteUser(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        Integer issuccess = userService.deleteUser(data);
        if(issuccess == 1){
            map.put("resultCode", 200);
            map.put("message", "删除用户成功");
        }
        return map;
    }

    @RequestMapping(value = "/logout")
    @UserLoginToken
    public Map<String, Object> logout(HttpServletRequest httpServletRequest, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        HttpSession session = httpServletRequest.getSession();//获取当前session
        if(session!=null){
            session.removeAttribute("user");//从当前session中获取用户信息
            session.invalidate();//关闭session
        }
        map.put("message", "安全退出");
        return map;
    }
}
