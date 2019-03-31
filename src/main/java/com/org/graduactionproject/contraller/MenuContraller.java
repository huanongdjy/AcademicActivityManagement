package com.org.graduactionproject.contraller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Menu;
import com.org.graduactionproject.domain.Type;
import com.org.graduactionproject.service.IMenuService;
import com.org.graduactionproject.token.PassToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
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
        List<Menu> menuList = menuService.getMenus();
        map.put("menuList", menuList);
        return map;
    }

    @RequestMapping(value = "/getMenusWithPage")
    @ResponseBody
    @PassToken
    public InfoPageJSONBean getMenusWithPage(@RequestBody String data){
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        PageHelper.startPage(page, size);
        List<Menu> menuList = menuService.getchilMenus();
        PageInfo<Menu> pageInfo = new PageInfo<>(menuList);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    @RequestMapping(value = "/updateMenu")
    @ResponseBody
    @PassToken
    public Map<String, Object> updateMenu(@RequestBody String data){
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(data);

        Integer menu_id = jsonObject.getInt("menu_id");
        String title = jsonObject.getString("title");
        String access = jsonObject.getString("access");
        String parent_id = jsonObject.getString("parent_id");
        Integer pid = Integer.parseInt(parent_id);
        Integer ret = menuService.updateMenu(menu_id, title, access);
        if(ret!=null){
            ret = menuService.updateMenu(pid, null, access);
            if (ret!=null){
                map.put("message", "更新成功");
                map.put("resultCode", 200);
                return map;
            }
        }
        map.put("message", "更新失败");
        return map;
    }

    @RequestMapping(value = "/searchMenu")
    @ResponseBody
    @PassToken
    public Map<String, Object> searchMenu(@RequestBody String data){
        Map<String, Object> map = new HashMap<>();
//        JSONObject jsonObject = JSONObject.fromObject(data);
//        String title = jsonObject.getString("title");
        List<Menu> menus = menuService.searchMenuByTile(data);
        map.put("resultCode", 200);
        map.put("menus", menus);
        return map;
    }
}
