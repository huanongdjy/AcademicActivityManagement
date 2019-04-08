package com.org.graduactionproject.token;

import com.org.graduactionproject.domain.Menu;
import com.org.graduactionproject.domain.User;
import com.org.graduactionproject.service.IIdentityService;
import com.org.graduactionproject.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accessService")
public class AccessService{
    @Autowired
    IMenuService menuService;


    public boolean verifyAccess(User user, String classname){
        Menu menu = menuService.getMenuByClassName(classname);
        String useraccess = user.getIdentity().getAccess();
        String[] useraccesses = useraccess.split(",");
        int len = useraccesses.length;
        for (int i = 0; i<len; i++){
            String temp = useraccesses[i];
            if(temp.equals(menu.getMenu_id())){
                return true;
            }
        }
        return false;
    }

}
