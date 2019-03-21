package com.org.graduactionproject.contraller;

import com.org.graduactionproject.domain.Identity;
import com.org.graduactionproject.domain.Memu;
import com.org.graduactionproject.service.IIdentityService;
import com.org.graduactionproject.service.IMemuService;
import com.org.graduactionproject.token.UserLoginToken;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MemuContraller {
    @Autowired
    @Qualifier("memuService")
    private IMemuService memuService;

    @RequestMapping(value = "/getAccess")
    @ResponseBody
    @Transactional
    public Map<String, Object> getAccess(){
        Map<String,Object> map = new HashedMap();
        List<Memu> memus = memuService.getMemus();
        map.put("memus", memus);
        return map;
    }
}
