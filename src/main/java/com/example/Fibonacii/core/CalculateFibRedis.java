package com.example.Fibonacii.core;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;

/**
 * Created by kuldeep.ashok on 11/03/15.
 */
public class CalculateFibRedis {
    public static Long Fib(int n, Jedis jedis) throws Exception {
        try {
            jedis.set("0","0");
            jedis.set("1","1");

            for (int i = 2; i <= n; i++) {
                Long n1 = Long.parseLong(jedis.get(String.valueOf(i - 1)), 10);
                Long n2 = Long.parseLong(jedis.get(String.valueOf(i - 2)), 10);
                jedis.set(String.valueOf(i), String.valueOf(n1 + n2));
            }

            return Long.parseLong(jedis.get(String.valueOf(n)),10);
        }
        catch(Exception e) {
            throw new Exception();
        }
        finally {
            jedis.flushAll();
        }
    }
}
