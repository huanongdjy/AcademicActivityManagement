package com.org.graduactionproject.contraller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Identity;
import com.org.graduactionproject.service.IIdentityService;
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
public class IdentityCotraller {
    @Autowired
    @Qualifier("identityService")
    IIdentityService identityService;

    @RequestMapping(value = "/getIdentitysWithPage")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public InfoPageJSONBean getIdentitysWithPage(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        PageHelper.startPage(page, size);
        List<Identity> identities =  identityService.getIdentitys();
        PageInfo<Identity> pageInfo = new PageInfo<>(identities);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    @RequestMapping(value = "/getAllIdentitys")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> getAllIdentitys(){
        Map<String,Object> map = new HashedMap();
        List<Identity> identities =  identityService.getIdentitys();
        map.put("identities", identities);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/addIdentity")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> addIdentity(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String identity_name = jsonObject.getString("identity_name");
        String access = jsonObject.getString("access");
        //添加前查看学院名称是否已存在
        Identity identity = identityService.getIdentityByName(identity_name);
        if (identity != null){
            map.put("message", "该学院角色名称已存在");
            return map;
        }
        Integer ret = identityService.addIdentityu(identity_name, access);
        if (ret!=null){
            map.put("message", "新增成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "/deleteIdentity")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> deleteIdentity(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        Integer id = Integer.parseInt(data);
        Integer ret = identityService.deleteIdentity(id);
        if (ret == 1 ){
            map.put("resultCode", 200);
            map.put("message", "删除成功");
        } else {
            map.put("resultCode", 200);
            map.put("message", "该角色不存在");
        }
        return map;
    }

    @RequestMapping(value = "/updateIdentity")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> updateIdentity(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String identity_name = jsonObject.getString("identity_name");
        String caccess = jsonObject.getString("access");
        int identity_id = jsonObject.getInt("identity_id");
        Integer ret = identityService.updateIdentity(identity_name, caccess, identity_id);
        if (ret!=null){
            map.put("message", "更新成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "/searchIdentity")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> searchIdentity(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        List<Identity> essays = identityService.findIdentityByName(data);
        if (essays != null){
            map.put("resultCode", 200);
            map.put("essays", essays);
        }
        return map;
    }
}
