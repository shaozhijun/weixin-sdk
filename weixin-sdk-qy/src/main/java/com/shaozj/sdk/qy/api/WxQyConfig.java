package com.shaozj.sdk.qy.api;

import com.shaozj.sdk.qy.client.HttpClient;
import com.shaozj.sdk.qy.client.IWxClient;
import com.shaozj.sdk.qy.store.ITokenStore;

/**
 * 
 * 文件描述:  配置企业微信API属性
 * 装饰器模式
 * <br>
 * 版权所有: Copyright (c) 2019年5月17日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月17日 下午4:42:56<br>
 *
 * @author Administrator
 * @since 1.1.0
 *
 */
public class WxQyConfig {
    
    /**
     * 企业ID
     */
    private final String corpid;
    
    /**
     * 应用的凭证密钥
     */
    private final String corpsecret;
    
    /**
     * 默认调用接口工具类
     */
    private IWxClient wxClient = new HttpClient();
    
    /**
     * token存储方式
     */
    private ITokenStore tokenStore;
    
    public WxQyConfig(String corpid, String corpsecret) {
        this.corpid = corpid;
        this.corpsecret = corpsecret;
    }
    
    public void setWxClient(IWxClient wxClient) {
        this.wxClient = wxClient;
    }
    
    public IWxClient getWxClient() {
        return wxClient;
    }
    
    public ITokenStore getTokenStore() {
        return tokenStore;
    }
    
   
    public void setTokenStore(ITokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }
    
    public String getCorpid() {
        return corpid;
    }
    
    public String getCorpsecret() {
        return corpsecret;
    }
}
