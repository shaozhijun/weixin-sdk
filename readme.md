
### 企业微信SDK

调用示例

```
 
        WxQyConfig config = new WxQyConfig("wxccc07f3096d4fd05", "PJBezEZLjeXmF1mK4llbP48YDJ9UYeORb_kBN0jJkEM");
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
