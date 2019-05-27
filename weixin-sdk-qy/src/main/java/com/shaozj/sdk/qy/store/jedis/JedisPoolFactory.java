package com.shaozj.sdk.qy.store.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * 文件描述: Jedis连接池工厂<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午3:56:49<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class JedisPoolFactory implements JedisFactory {
    
    private JedisPool jedisPool;
    
    public JedisPoolFactory (RedisConfig redisConfig) {
        this.initJedisPool(redisConfig);
    }
    
    @Override
    public Jedis getResource() {
        return jedisPool == null ? null : jedisPool.getResource();
    }

    
    /**
     * <p>
     * Description: 初始化jedis连接池
     * </p>
     * 
     * @param redisConfig
     */
    private void initJedisPool(RedisConfig redisConfig) {
        try {
            this.jedisPool = new JedisPool(getJedisPoolConfig(redisConfig), redisConfig.getHost(),
                    redisConfig.getPort(), 1000 * 2, redisConfig.getPassword(), redisConfig.getDatabase());
        } catch (Exception e) {
            // 初始化jedis连接池失败
            e.printStackTrace();
        }
    }
    
    /**
     * <p>
     * Description: Redis连接池配置
     * </p>
     * 
     * @param redisConfig
     * @return
     */
    private JedisPoolConfig getJedisPoolConfig(RedisConfig redisConfig) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(redisConfig.getMaxIdle());
        config.setMaxIdle(redisConfig.getMaxIdle());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setTestOnBorrow(redisConfig.getTestOnBorrow());
        config.setTestOnReturn(redisConfig.getTestReturn());
        return config;
    }
}
