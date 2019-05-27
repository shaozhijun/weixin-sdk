
### 企业微信SDK

调用示例

-- 初始化微信配置、设置token存储方式
```
 
        WxQyConfig config = new WxQyConfig("XXXXXXXXXXXXX", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
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
        
        
        WxQyApiFactory factory = new WxQyApiFactory(config);
        IWxQyApi wxApi = factory.createQyWxApi();
        TextMessage message = new TextMessage();
        wxApi.sendMessage(message);
        
        
       
        IMessageHandler msgHandler = factory.createWxMessageHandler("xxxx", "xxxxxx");
        WxRequest wxReq = new WxRequest();
        msgHandler.handleMessage(wxReq);
```
