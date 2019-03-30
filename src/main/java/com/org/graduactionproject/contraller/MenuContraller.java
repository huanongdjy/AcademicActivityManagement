package com.org.graduactionproject.contraller;

import com.org.graduactionproject.domain.Menu;
import com.org.graduactionproject.service.IMenuService;
import com.org.graduactionproject.token.PassToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuContraller {
    @Autowired
    @Qualifier("menuService")
    IMenuService menuService;

    @RequestMapping(value = "/getMenuList")
    @ResponseBody
    @PassToken
    public Map<String, Object> getMenuList(){
        Map<String, Object> map = new HashMap<>();
        List<Menu> menuList = menuService.getAllMenus();
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.element(menuList);
//        JSONObject jsonObject = new JSONObject();

        map.put("menuList", menuList);
        return map;
    }

    public static void main(String[] args) {
        String menuList = "[{" +
                "'path': '/usermanage'," +
                "'name': 'usermanage'," +
                "'meta': {" +
                "'hideInBread': true" +
                "}," +
                "'children': [" +
                "{" +
                "'path': 'usermanage_page'," +
                "'name': 'usermanage_page'," +
                "'meta': {" +
                "'title': '用户管理'," +
                "'icon': 'ios-book'" +
                "}," +
                "'component': () => import('@/view/directive/myUserMananger')" +
                "}" +
                "]" +
                "}]";
        JSONObject jsonObject1 = JSONObject.fromObject(menuList);
        System.out.println(jsonObject1);
    }
}
