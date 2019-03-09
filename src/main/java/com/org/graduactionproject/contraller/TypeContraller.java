package com.org.graduactionproject.contraller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Type;
import com.org.graduactionproject.service.ITypeService;
import com.org.graduactionproject.token.UserLoginToken;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TypeContraller {
    @Autowired
    @Qualifier("typeSerivce")
    ITypeService typeService;

    @RequestMapping(value = "/getTypesWithPage")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public InfoPageJSONBean getTypesWithPage(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        PageHelper.startPage(page, size);
        List<Type> typeList =  typeService.findAll();
        PageInfo<Type> pageInfo = new PageInfo<>(typeList);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    @RequestMapping(value = "/getAllType")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> getAllType(){
        Map<String,Object> map = new HashedMap();
        List<Type> typeList =  typeService.findAll();
        map.put("typeList", typeList);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/addType")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> addType(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String type_name = jsonObject.getString("type_name");
        String description = jsonObject.getString("description");
        Integer ret = typeService.addType(type_name, description);
        if (ret!=null){
            map.put("message", "新增成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "/deleteType")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> deleteType(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        Integer id = Integer.parseInt(data);
        Integer ret = typeService.deleteType(id);
        if (ret == 1 ){
            map.put("resultCode", 200);
            map.put("message", "删除成功");
        } else {
            map.put("resultCode", 200);
            map.put("message", "该类型不存在");
        }
        return map;
    }

    @RequestMapping(value = "/updateType")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> updateType(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String type_name = jsonObject.getString("type_name");
        String description = jsonObject.getString("description");
        int type_id = jsonObject.getInt("type_id");
        Integer ret = typeService.updateType(type_name, description, type_id);
        if (ret!=null){
            map.put("message", "更新成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "/searchType")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> searchType(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        List<Type> essays = typeService.searchByType_name(data);
        if (essays != null){
            map.put("resultCode", 200);
            map.put("essays", essays);
        }
        return map;
    }
}

