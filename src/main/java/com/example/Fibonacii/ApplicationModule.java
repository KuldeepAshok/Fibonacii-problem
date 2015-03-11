package com.example.Fibonacii;

/**
 * Created by kuldeep.ashok on 11/03/15.
 */
import com.example.Fibonacii.resources.Fibonacii;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.yammer.dropwizard.config.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ApplicationModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Fibonacii.class).in(Singleton.class);
    }

    @Provides
    public FibonaciiConfiguration configuration(Configuration configuration)
    {
        return (FibonaciiConfiguration) configuration;
    }

    @Provides
    public JedisPool provideJedisPool(FibonaciiConfiguration applicationConfiguration)
    {
        RedisConfiguration redisConfig = applicationConfiguration.getRedis();
        return new JedisPool(
                new JedisPoolConfig(),
                redisConfig.getHostname(),
                redisConfig.getPort() );
    }
}