package com.shaozj.sdk.qy.api.bean.resp.user;

import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;

public class UserResp extends WxBaseResp {
    
    /**
     *  非企业成员标识,对当前企业唯一
     */
    private String OpenId;
    
    /**
     * 手机设备号（由企业微信在安装时随机生成，删除重装会改变，升级不受影响）
     */
    private String DeviceId;
    
    /**
     * 成员用户ID,若需要获取用户详细信息,可调用通讯录接口(为企业成员的时候返回)
     */
    private String UserId;

    public String getOpenId() {
        return OpenId;
    }
    
    public void setOpenId(String openId) {
        OpenId = openId;
    }
    
    public String getDeviceId() {
        return DeviceId;
    }
    
    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getUserId() {
        return UserId;
    }
    
    public void setUserId(String userId) {
        UserId = userId;
    }
}
