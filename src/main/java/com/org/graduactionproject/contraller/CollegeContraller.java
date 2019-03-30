package com.org.graduactionproject.contraller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.College;
import com.org.graduactionproject.service.ICollegeService;
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
public class CollegeContraller {
    @Autowired
    @Qualifier("collegeService")
    ICollegeService collegeService;

    @RequestMapping(value = "/getCollegesWithPage")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public InfoPageJSONBean getCollegesWithPage(@RequestBody String data){
        JSONObject jsonObject = JSONObject.fromObject(data);
        int page = jsonObject.getInt("currentPage");
        int size = jsonObject.getInt("pageSize");
        PageHelper.startPage(page, size);
        List<College> collegeList =  collegeService.getAllCollege();
        PageInfo<College> pageInfo = new PageInfo<>(collegeList);
        InfoPageJSONBean infoPageJSONBean = new InfoPageJSONBean();
        infoPageJSONBean.setPage(pageInfo);
        infoPageJSONBean.setResultCode("200");
        return infoPageJSONBean;
    }

    @RequestMapping(value = "/getAllCollege")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> getAllCollege(){
        Map<String,Object> map = new HashedMap();
        List<College> collegeList =  collegeService.getAllCollege();
        map.put("collegeList", collegeList);
        map.put("resultCode", 200);
        return map;
    }

    @RequestMapping(value = "/addCollege")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> addCollege(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String college_name = jsonObject.getString("college_name");
        String description = jsonObject.getString("description");
        //添加前查看学院名称是否已存在
        College college = collegeService.getCollegeByName(college_name);
        if (college != null){
            map.put("message", "该学院名称已存在");
            return map;
        }
        Integer ret = collegeService.addCollege(college_name, description);
        if (ret!=null){
            map.put("message", "新增成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "/deleteCollege")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> deleteCollege(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        Integer id = Integer.parseInt(data);
        Integer ret = collegeService.deleteCollege(id);
        if (ret == 1 ){
            map.put("resultCode", 200);
            map.put("message", "删除成功");
        } else {
            map.put("resultCode", 200);
            map.put("message", "该学院不存在");
        }
        return map;
    }

    @RequestMapping(value = "/updateCollege")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> updateCollege(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String college_name = jsonObject.getString("college_name");
        String description = jsonObject.getString("description");
        int college_id = jsonObject.getInt("college_id");
        Integer ret = collegeService.updateCollege(college_name, description, college_id);
        if (ret!=null){
            map.put("message", "更新成功");
            map.put("resultCode", 200);
        }else {
            map.put("message", "更新失败");
        }
        return map;
    }

    @RequestMapping(value = "/searchCollege")
    @ResponseBody
    @Transactional
    @UserLoginToken
    public Map<String, Object> searchCollege(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        List<College> essays = collegeService.findCollegeByName(data);
        if (essays != null){
            map.put("resultCode", 200);
            map.put("essays", essays);
        }
        return map;
    }
}
