package com.org.graduactionproject.dao;

import com.org.graduactionproject.domain.Achievement;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
// 这块需要引入依赖 mybatis的测试依赖jar
@MybatisTest
// 这个注解的意义是指定了默认数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AchievementTest {
    @Autowired
    AchievementMapper achievementMapper;

    @Test
    public void insertSysRoleTest() {
        try {
            Achievement achievement = new Achievement();
            achievement.setTitle("测试");
            achievement.setContent("测试内容");
            achievement.setMember("教授|教师");
            // 新增用户 ,返回受影响的行数
            int result = achievementMapper.addAchievement(achievement);
            System.out.println(result);
            System.out.println("achievement 的 id" + achievement.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
