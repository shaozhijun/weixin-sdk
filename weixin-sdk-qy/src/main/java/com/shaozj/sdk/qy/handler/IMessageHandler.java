package com.shaozj.sdk.qy.handler;

import com.shaozj.sdk.qy.api.bean.req.WxRequest;

public interface IMessageHandler {
    
    /**
     * 
     * 方法描述: 处理微信推送消息<br>
     * 完成时间: 2019年5月22日 下午4:31:04<br>
     * 作者: szj<br>
     *
     * @param wxReq
     */
    public void handleMessage(WxRequest wxReq);
}
