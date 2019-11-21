package com.demo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author Y
 */
public class Test_Jedis {

    @Test
    public void test1() {
       Jedis jedis = new Jedis("192.168.131.128", 6379);
       String username = jedis.get("set");
        System.out.println(username);
        List<String> list1 = jedis.lrange("name",0,-1);
        for (String v : list1){
            System.out.println(v);
        }
    }

    @Test
    public void test2() {
        JedisPool jedisPool = new JedisPool("192.168.131.128",6379);
        Jedis jedis = jedisPool.getResource();
        String name = jedis.set("name","lucy");
        System.out.println(jedis.get("name"));
    }
}
