package com.yappam.sdk.qywx.test;

import com.shaozj.sdk.qy.api.IWxQyApi;
import com.shaozj.sdk.qy.api.WxQyConfig;
import com.shaozj.sdk.qy.api.base.WxQyApiFactory;
import com.shaozj.sdk.qy.api.bean.req.WxRequest;
import com.shaozj.sdk.qy.api.bean.req.message.TextMessage;
import com.shaozj.sdk.qy.handler.IMessageHandler;
import com.shaozj.sdk.qy.store.RedisTokenStore;
import com.shaozj.sdk.qy.store.jedis.RedisConfig;

public class Test {

    
    public static void main(String[] args) {
        
        //QyWx配置
        WxQyConfig config = new WxQyConfig("XXXXXXX", "XXXXXXXXXXXXXXXXXXXXXXXXX");
        config.setTokenStore(new RedisTokenStore() {
            @Override
            public RedisConfig initConfig() {
                RedisConfig redisConf = new RedisConfig();
                redisConf.setHost("127.0.0.1");
                redisConf.setPort(6379);
//              redisConf.setPassword("123456");
                return redisConf;
            }
        });
        
        //工厂方法创建WxQyApi
        WxQyApiFactory factory = new WxQyApiFactory(config);
        IWxQyApi wxApi = factory.createQyWxApi();
        TextMessage message = new TextMessage();
        wxApi.sendMessage(message);
        
        
        //注入消息处理类
        IMessageHandler msgHandler = factory.createWxMessageHandler("xxxx", "xxxxxx");
        WxRequest wxReq = new WxRequest();
        msgHandler.handleMessage(wxReq);
    }
}
