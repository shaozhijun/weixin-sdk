package com.shaozj.sdk.qy.api.bean.resp.user;

import java.util.List;

import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;

/**
 * 
 * 文件描述: 部门成员详情<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午3:29:56<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class DepUserInfoListResp extends WxBaseResp {
    
    private List<UserInfo>  userlist;

    public List<UserInfo> getUserlist() {
        return userlist;
    }
    
    public void setUserlist(List<UserInfo> userlist) {
        this.userlist = userlist;
    }
}
