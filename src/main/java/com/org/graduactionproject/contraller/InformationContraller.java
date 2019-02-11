package com.org.graduactionproject.contraller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.org.graduactionproject.domain.Achievement;
import com.org.graduactionproject.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Controller
public class InformationContraller {
    @Autowired
    @Qualifier("achievementService")
    private IAchievementService achievementService;

    @RequestMapping("/getInformationWithPage")
    public Page getInformationWithPage(String data){
        int page =1;
        int size = 5;
        //分页并查询
        Page<Achievement> pageInfo = PageHelper.startPage(page, size);
//        List<User> users = userRepository.listUser();
        List<Achievement> achievements = achievementService.findAll();
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Achievement> result = pageInfo.getResult();//和上面的users结果相同
        System.out.println("pageNum： " + pageNum);
        System.out.println("pageSize: " + pageSize);
        System.out.println("total: " + total);
        return pageInfo;
    }
}
