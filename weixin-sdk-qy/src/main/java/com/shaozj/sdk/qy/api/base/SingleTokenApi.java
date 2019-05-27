package com.shaozj.sdk.qy.api.base;

import com.shaozj.sdk.qy.api.impl.WxTokenApiImpl;

/**
 * 
 * 文件描述: 创建tokenapi实例<br>
 * 版权所有: Copyright (c) 2019年5月21日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月21日 下午6:20:08<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class SingleTokenApi {
    
    private static volatile WxTokenApiImpl tokenApi = null;
    
    private SingleTokenApi() {
    }
    
    /**
     * 
     * 方法描述: 单例获取tokenApi<br>
     * 完成时间: 2019年5月21日 下午6:20:30<br>
     * 作者: szj<br>
     *
     * @param corpid
     * @param corpsecret
     * @return
     */
    public static WxTokenApiImpl getInstance(String corpid, String corpsecret) {
        if (tokenApi == null) {
            synchronized (SingleTokenApi.class) {
                if (tokenApi == null) {
                    tokenApi = new WxTokenApiImpl(corpid, corpsecret);
                }
            }
        }
        return tokenApi;
    }
}
