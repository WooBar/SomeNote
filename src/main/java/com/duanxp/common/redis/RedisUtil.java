package com.duanxp.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: RedisUtil
 * @Description:
 * @Author duanxp
 * @Date 2019/11/22 13:30
 */
@Component
public class RedisUtil {


    @Autowired
    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private static Jedis jedis ;


    public static String get(String key){

        return jedis.get(key);
    }

    public static String set(String key, String value){

        return jedis.set(key , value);
    }

    public static void main(String[] args) {

        set("1","2");

        String s = get("1");
        System.out.println("---------> "+s);


    }


}
