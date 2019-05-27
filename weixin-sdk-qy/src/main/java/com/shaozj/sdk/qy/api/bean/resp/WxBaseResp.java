package com.shaozj.sdk.qy.api.bean.resp;


public class WxBaseResp {
    
    /**
     * 微信响应错误码
     */
    private String errcode;
    
    /**
     * 微信响应错误信息
     */
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }
    
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    
    public String getErrmsg() {
        return errmsg;
    }
    
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
