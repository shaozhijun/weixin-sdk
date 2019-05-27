package com.shaozj.sdk.qy.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shaozj.sdk.qy.api.bean.resp.AccessToken;
import com.shaozj.sdk.qy.store.jedis.JedisFactory;
import com.shaozj.sdk.qy.store.jedis.JedisPoolFactory;
import com.shaozj.sdk.qy.store.jedis.RedisConfig;

import redis.clients.jedis.Jedis;

/**
 * 文件描述: Redis存储token信息（ 待优化 策略）<br>
 * 版权所有: Copyright (c) 2019年5月17日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月17日 下午4:49:21<br>
 *
 * @author szj
 * @since 1.1.0
 */
public abstract class RedisTokenStore extends AbstractTokenStore {

    private final Logger logger = LoggerFactory.getLogger(RedisTokenStore.class);
    
    private static final String ACCESS_TOKEN_CATCH_KEY = "qywx_acess_token:";
    
    private JedisFactory jedisFactory;

    public RedisTokenStore() {
        RedisConfig redisConfig = initConfig();
        jedisFactory = new JedisPoolFactory(redisConfig);
    }
    
    public abstract RedisConfig initConfig();
    
    @Override
    public void saveToken(AccessToken token) {
        Jedis jedis = jedisFactory.getResource();
        if (jedis != null) {
            try {
                jedis.set(ACCESS_TOKEN_CATCH_KEY, token.getAccess_token());
                jedisFactory.getResource().expire(ACCESS_TOKEN_CATCH_KEY, token.getExpires_in());
            } catch (Exception e) {
                logger.error("jedis保存token信息报错！");
            } finally {
                close(jedis);
            }
        }
    }

    @Override
    public String getToken() {
        Jedis jedis = jedisFactory.getResource();
        if (jedis != null) {
            try {
                return jedis.get("ACCESS_TOKEN_CATCH_KEY");
            } catch (Exception e) {
                logger.error("jedis获取token信息报错！");
            } finally {
                close(jedis);
            }
        }
        return null;
    }
    
    /**
     * 
     * 方法描述: 释放jedis<br>
     * 完成时间: 2019年5月23日 上午9:53:38<br>
     * 作者: szj<br>
     *
     * @param jedis
     */
    private void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
            jedis = null;
        }
    }
}
