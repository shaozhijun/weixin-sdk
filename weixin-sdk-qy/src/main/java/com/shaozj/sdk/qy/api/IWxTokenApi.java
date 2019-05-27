package com.shaozj.sdk.qy.api;

import com.shaozj.sdk.qy.api.bean.resp.AccessToken;

public interface IWxTokenApi {
    
    /**
     * 
     * <p>Description: 获取微信accesstoken</p>
     * @return
     */
    public AccessToken getAccessToken();
}
