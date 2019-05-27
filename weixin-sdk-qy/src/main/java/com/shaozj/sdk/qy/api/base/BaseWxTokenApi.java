package com.shaozj.sdk.qy.api.base;

import com.shaozj.sdk.qy.store.ITokenStore;

public class BaseWxTokenApi extends BaseWxQyApi {
    
    /**
     *  存储token接口
     */
    protected ITokenStore tokenStore;
    
    /**
     * <p>Description: 获取accesstoken</p>
     * @return
     */
    protected String getAccessToken() {
        return tokenStore.getAccessToken();
    }
    
    public void setTokenStore(ITokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }
}
