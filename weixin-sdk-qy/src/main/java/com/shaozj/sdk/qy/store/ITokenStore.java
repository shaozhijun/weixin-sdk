package com.shaozj.sdk.qy.store;

import com.shaozj.sdk.qy.api.IWxTokenApi;

/**
 * 
 * 文件描述: 获取token信息 <br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午5:08:35<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public interface ITokenStore {
    
    /**
     * <p>Description: 获取token信息</p>
     * @return
     */
    public String getAccessToken();
    
    /**
     * 
     * 方法描述: 设置请求获取token API<br>
     * 完成时间: 2019年5月21日 上午10:22:41<br>
     * 作者: szj<br>
     *
     * @param wxTokenApi
     */
    public void setWxTokenApi(IWxTokenApi wxTokenApi);
}
