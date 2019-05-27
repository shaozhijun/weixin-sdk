package com.shaozj.sdk.qy.store.jedis;

import redis.clients.jedis.Jedis;

/**
 * 
 * 文件描述: 定义获取 Jedis实例 接口<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午5:08:08<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public interface JedisFactory {
    
    /**
     * 
     * 方法描述: 获取Jedis资源<br>
     * 完成时间: 2019年5月23日 上午9:55:52<br>
     * 作者: szj<br>
     *
     * @return
     */
    public Jedis getResource();
}
