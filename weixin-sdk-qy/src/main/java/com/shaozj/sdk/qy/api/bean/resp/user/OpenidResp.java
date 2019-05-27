package com.shaozj.sdk.qy.api.bean.resp.user;

import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;

public class OpenidResp extends WxBaseResp {
    
    /**
     * 企业微信成员userid对应的openid
     */
    private String openid;

    public String getOpenid() {
        return openid;
    }
    
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    
    
}
