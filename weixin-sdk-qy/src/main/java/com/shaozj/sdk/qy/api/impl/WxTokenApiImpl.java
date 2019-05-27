package com.shaozj.sdk.qy.api.impl;

import com.shaozj.sdk.qy.api.IWxTokenApi;
import com.shaozj.sdk.qy.api.base.BaseWxQyApi;
import com.shaozj.sdk.qy.api.bean.resp.AccessToken;

/**
 * 
 * 文件描述: 获取accesstoken<br>
 * 版权所有: Copyright (c) 2019年5月17日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月17日 下午5:17:24<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class WxTokenApiImpl extends BaseWxQyApi implements IWxTokenApi {

    //获取token URL
    private static final String GET_ACCESSTOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%1$s&corpsecret=%2$s";
    
    public WxTokenApiImpl(String corpid, String corpsecret) {
        this.corpid = corpid;
        this.corpsecret = corpsecret;
    }
    
    @Override
    public AccessToken getAccessToken() {
        return wxClient.get(String.format(GET_ACCESSTOKEN_URL, corpid, corpsecret), AccessToken.class);
    }
}
