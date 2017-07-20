package com.wusiq.base;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 利用redis设计mybatis的二级缓存
 */
public class MybatisRedisCache implements Cache {
    private static Logger LOGGER =  LoggerFactory.getLogger(MybatisRedisCache.class);
    private String id = null;
    private static JedisConnectionFactory jedisConnectionFactory = null;
    private JedisConnection jedisConnection = null;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public static JedisConnectionFactory getJedisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }

    public MybatisRedisCache(String id){
        if(StringUtils.isEmpty(id)){
                throw new IllegalArgumentException("Cache instances require an ID");
        }
        LOGGER.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    @Override
    public void clear()
    {
        RedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            connection.flushDb();
            connection.flushAll();
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public Object getObject(Object key)
    {
        Object result = null;
        RedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = serializer.deserialize(connection.get(serializer.serialize(key)));
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock()
    {
        return this.readWriteLock;
    }

    @Override
    public int getSize()
    {
        int result = 0;
        RedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public void putObject(Object key, Object value)
    {
        RedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Object removeObject(Object key)
    {
        RedisConnection connection = null;
        Object result = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result =connection.expire(serializer.serialize(key), 0);
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

}