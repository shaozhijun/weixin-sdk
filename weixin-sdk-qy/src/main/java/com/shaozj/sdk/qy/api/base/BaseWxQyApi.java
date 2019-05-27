package com.shaozj.sdk.qy.api.base;

import com.shaozj.sdk.qy.client.IWxClient;

public abstract class BaseWxQyApi {
    
    /**
     * 企业ID
     */
    protected String corpid;
    
    /**
     * 应用的凭证密钥
     */
    protected String corpsecret;
    
    /**
     * 调用微信API工具接口
     */
    protected IWxClient wxClient;
    
    public IWxClient getWxClient() {
        return wxClient;
    }
    
    public void setWxClient(IWxClient wxClient) {
        this.wxClient = wxClient;
    }
    
    public String getCorpid() {
        return corpid;
    }
    
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }
    
    public String getCorpsecret() {
        return corpsecret;
    }
    
    public void setCorpsecret(String corpsecret) {
        this.corpsecret = corpsecret;
    }
}
