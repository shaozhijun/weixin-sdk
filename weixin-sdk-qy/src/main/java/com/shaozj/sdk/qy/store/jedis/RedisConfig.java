package com.shaozj.sdk.qy.store.jedis;

public class RedisConfig {
    
    /**
     * Redis主机
     */
    private String host;
    
    /**
     * Redis端口
     */
    private Integer port;
    
    /**
     * Redis密码
     */
    private String password;
    
    /**
     * 指定数据库
     */
    private int database;
    
    /**
     * 最大连接数
     */
    private Integer MaxTotal = 20;
    
    /**
     * 在jedispool中最大的idle状态(空闲的)的jedis实例的个数
     */
    private Integer MaxIdle = 10;
    
    /**
     * 在jedispool中最小的idle状态(空闲的)的jedis实例的个数
     */
    private Integer MinIdle = 2;
    
    /**
     * 在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
     */
    private Boolean testOnBorrow = true;
    
    /**
     * 在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。
     */
    private Boolean testReturn = false;

    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getMaxTotal() {
        return MaxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        MaxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return MaxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        MaxIdle = maxIdle;
    }
    
    public Integer getMinIdle() {
        return MinIdle;
    }
    
    public void setMinIdle(Integer minIdle) {
        MinIdle = minIdle;
    }
    
    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }
    
    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
    
    public Boolean getTestReturn() {
        return testReturn;
    }
    
    public void setTestReturn(Boolean testReturn) {
        this.testReturn = testReturn;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }
}
