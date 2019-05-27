package com.shaozj.sdk.qy.api.base;

import com.shaozj.sdk.qy.api.IWxQyApi;
import com.shaozj.sdk.qy.api.WxQyConfig;
import com.shaozj.sdk.qy.api.impl.WxQyApiImpl;
import com.shaozj.sdk.qy.api.impl.WxTokenApiImpl;
import com.shaozj.sdk.qy.handler.IMessageHandler;
import com.shaozj.sdk.qy.handler.WxMessageHandler;
import com.shaozj.sdk.qy.store.ITokenStore;

/**
 * 
 * 文件描述: 创建微信Api对象<br>
 * 版权所有: Copyright (c) 2019年5月17日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月17日 下午5:09:45<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class WxQyApiFactory {
    
    private final WxQyConfig wxQyConfig;
    
    private ITokenStore tokenStore;
    
    public WxQyApiFactory (WxQyConfig wxQyConfig) {
        this.wxQyConfig = wxQyConfig;
        buildStore();
    }
    
    /**
     * 
     * 方法描述: 创建企业微信API接口请求实例<br>
     * 完成时间: 2019年5月21日 上午10:21:10<br>
     * 作者: szj<br>
     *
     * @param config
     * @return
     */
    public IWxQyApi createQyWxApi() {
        WxQyApiImpl wxQyApi = new WxQyApiImpl();
        wxQyApi.setWxClient(wxQyConfig.getWxClient());
        wxQyApi.setTokenStore(tokenStore);
        return wxQyApi;
    }
    
    /**
     * 
     * 方法描述: 生成微信消息处理实例<br>
     * 完成时间: 2019年5月22日 下午5:50:50<br>
     * 作者: szj<br>
     *
     * @param token
     * @param encodingAesKey
     * @return
     */
    public IMessageHandler createWxMessageHandler(String token, String encodingAesKey) {
        WxMessageHandler messageHandler = new WxMessageHandler(token, encodingAesKey);
        messageHandler.setCorpid(wxQyConfig.getCorpid());
        return messageHandler;
    }
    
    /**
     * 
     * 方法描述: 设置token请求方式<br>
     * 完成时间: 2019年5月21日 上午10:20:29<br>
     * 作者: szj<br>
     *
     * @param config
     * @return
     */
    private void buildStore() {
        tokenStore = wxQyConfig.getTokenStore();
        if (tokenStore != null) {
            WxTokenApiImpl tokenApi = new WxTokenApiImpl(wxQyConfig.getCorpid(), wxQyConfig.getCorpsecret());
            tokenApi.setWxClient(wxQyConfig.getWxClient());
            tokenStore.setWxTokenApi(tokenApi);
        }
    }
}
