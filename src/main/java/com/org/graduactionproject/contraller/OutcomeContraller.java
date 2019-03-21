package com.org.graduactionproject.contraller;

import com.org.graduactionproject.service.IOutcomeService;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OutcomeContraller {
    @Autowired
    @Qualifier("outcomeService")
    IOutcomeService outcomeService;

    @RequestMapping(value = "/addOutcome")
    @ResponseBody
    @Transactional
    public Map<String, Object> addOutcome(@RequestBody String data){
        Map<String,Object> map = new HashedMap();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String content = jsonObject.getString("content");
        Integer id = jsonObject.getInt("id");
        Integer ret = outcomeService.addOutcome(content, id);
        if (ret != null && ret != -1){
            map.put("message", "新增总结成功");
            map.put("resultCode", 200);
        } else {
            map.put("message", "新增总结失败");
            map.put("resultCode", 200);
        }
        return map;
    }
}
