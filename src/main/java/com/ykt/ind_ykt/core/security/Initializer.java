package com.ykt.ind_ykt.core.security;

import com.ykt.ind_ykt.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
/**
 * @Autor guoyh
 * @Date 20120-02-08 0011
 * @Usage 初始化
 */
@Component
public class Initializer implements ApplicationRunner {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!redisTemplate.hasKey(Constants.DEPT_AUTH) && !redisTemplate.hasKey(Constants.ROLE_AUTH)) {
//            List<Map> deptResult = authorityService.getDeptResource();
//            List<Map> roleResult = authorityService.getRoleResource();
//            deptResult.forEach(item->{
//                    redisTemplate.opsForHash().put(Constants.DEPT_AUTH , item.get("URL"), item.get("DEPT_ID"));
//            });
//            roleResult.forEach(item->{
//                    redisTemplate.opsForHash().put(Constants.ROLE_AUTH , item.get("URL"), item.get("ROLE_ID"));
//            });
        }
    }
}