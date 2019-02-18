package com.org.graduactionproject.contraller;

import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginContraller {
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
        map.put("resultCode", 200);
        return map;
    }
}
