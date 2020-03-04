package com.duanxp.module.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Version
 * @Author dxp
 * @Date 2019/7/30 0030
 */
@Controller
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/redis")
    public void index2(){

//        RedisUtil.set("2","2");
//
//        String s = RedisUtil.get("2");
        stringRedisTemplate.opsForValue().set("test2", "1");
        String s = stringRedisTemplate.opsForValue().get("test2");

        System.out.println(s);

    }

}
