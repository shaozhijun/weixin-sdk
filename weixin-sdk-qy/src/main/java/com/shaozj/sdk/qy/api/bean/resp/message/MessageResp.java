package com.shaozj.sdk.qy.api.bean.resp.message;

import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;

/**
 * 
 * 文件描述: 发送消息响应实体<br>
 * 版权所有: Copyright (c) 2019年5月21日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月21日 下午2:58:59<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class MessageResp extends WxBaseResp {
    
    private String invaliduser;
    
    private String invalidparty;
    
    private String invalidtag;
    
    public String getInvaliduser() {
        return invaliduser;
    }
    
    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }

    public String getInvalidtag() {
        return invalidtag;
    }

    public void setInvalidtag(String invalidtag) {
        this.invalidtag = invalidtag;
    }
}
