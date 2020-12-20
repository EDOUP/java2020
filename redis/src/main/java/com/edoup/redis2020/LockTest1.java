package com.edoup.redis2020;

import redis.clients.jedis.Jedis;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/1 23:24
 */
public class LockTest1 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("www.huaxia.city", 6389);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("a"));
    }
}
