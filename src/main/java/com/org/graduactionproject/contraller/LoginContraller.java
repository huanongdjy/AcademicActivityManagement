package com.org.graduactionproject.contraller;

import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginContraller {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping("/login")
    public String login( String username, String password){

        User user = userService.login(username, password);

        if(user!=null)return "success";
        return "login";
    }
}
