package com.example.Fibonacii.resources;

import com.example.Fibonacii.core.CalculateFibIterative;
import com.example.Fibonacii.core.CalculateFibRedis;
import com.google.inject.Inject;
import com.yammer.dropwizard.auth.Auth;
import com.example.Fibonacii.core.CalculateFib;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/kuldeep")
public class Fibonacii {
    private final JedisPool jedisPool;
    @Inject
    public Fibonacii(JedisPool jedisPool)
    {
        this.jedisPool=jedisPool;
    }
    @GET
    @Path("{fib}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getFibNumber(@PathParam("fib") Integer n) throws Exception {

        System.out.println("Connection to server sucessfully");
        //check whether server is running or not

        Jedis jedis = jedisPool.getResource();
        System.out.println("Server is running: ");

        System.out.println("crazy stuff: ");

        System.out.println("KD niks you are awesome");
        //FibonaciiResultSet set ;
        if(n<0 || n>92)
            return Long.valueOf(-1);
        return CalculateFibRedis.Fib(n,jedis);
    }
}
