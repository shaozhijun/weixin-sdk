package com.shaozj.sdk.qy.store;

import org.apache.commons.lang.StringUtils;

import com.shaozj.sdk.qy.api.IWxTokenApi;
import com.shaozj.sdk.qy.api.bean.resp.AccessToken;

/**
 * 
 * 文件描述: 存储token抽象类、自定义存储方式可以继承此类（桥接）<br>
 * 版权所有: Copyright (c) 2019年5月17日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月17日 下午4:44:47<br>
 *
 * @author Administrator
 * @since 1.1.0
 *
 */
public abstract class AbstractTokenStore implements ITokenStore {
    
    private IWxTokenApi wxTokenApi;
    
    @Override
    public String getAccessToken() {
        String token = getToken();
        if (!StringUtils.isEmpty(token)) {
            return token;
        }
        AccessToken accessToken = wxTokenApi.getAccessToken();
        saveToken(accessToken);
        return accessToken.getAccess_token();
    }
    
    @Override
    public void setWxTokenApi(IWxTokenApi wxTokenApi) {
        this.wxTokenApi = wxTokenApi;
    }
    
    /**
     * 
     * <p>Description: 子类实现获取token方式</p>
     * @return
     */
    public abstract String getToken();
    
    /**
     * 
     * <p>Description: 子类实现保存token方式</p>
     * @param accessToken
     */
    public abstract void saveToken(AccessToken accessToken);
}
