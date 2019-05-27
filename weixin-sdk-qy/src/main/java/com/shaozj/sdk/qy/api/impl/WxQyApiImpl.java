package com.shaozj.sdk.qy.api.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.shaozj.sdk.qy.api.IWxQyApi;
import com.shaozj.sdk.qy.api.base.BaseWxTokenApi;
import com.shaozj.sdk.qy.api.bean.req.department.Department;
import com.shaozj.sdk.qy.api.bean.req.message.WxMessage;
import com.shaozj.sdk.qy.api.bean.req.user.User;
import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;
import com.shaozj.sdk.qy.api.bean.resp.department.DepartmentResp;
import com.shaozj.sdk.qy.api.bean.resp.message.MessageResp;
import com.shaozj.sdk.qy.api.bean.resp.user.DepUserInfoListResp;
import com.shaozj.sdk.qy.api.bean.resp.user.DepUserListResp;
import com.shaozj.sdk.qy.api.bean.resp.user.OpenidResp;
import com.shaozj.sdk.qy.api.bean.resp.user.UserInfoResp;
import com.shaozj.sdk.qy.api.bean.resp.user.UserResp;

/**
 * 
 * 文件描述: 调用企业微信API实现
 *  AbstractWxQyApi 适配获取token
 * <br>
 * 版权所有: Copyright (c) 2019年5月17日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月17日 下午4:31:25<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class WxQyApiImpl extends BaseWxTokenApi implements IWxQyApi {
    
    
    //企业微信-成员-授权获取用户ID URL
    private static final String GET_USER_ID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=%1$s&code=%2$s";
    //企业微信-成员-获取成员信息 URL
    private static final String GET_USER_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=%1$s&userid=%2$s";
    //企业微信-成员-创建成员 URL
    private static final String CREATE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=%1$s";
    //企业微信-成员-更新成员 URL
    private static final String UPDATE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=%1$s";
    //企业微信-成员-删除成员 URL
    private static final String DELETE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%1$s&userid=%2$s";
    //企业微信-成员-批量删除成员 URL
    private static final String BATCH_DELETE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=%1$s";
    //企业微信-成员-获取部门成员 URL
    private static final String GET_DEP_USERLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=%1$s&department_id=%2$s&fetch_child=%3$s";
    //企业微信-成员-获取部门成员详情 URL
    private static final String GET_DEP_USERINFOLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=%1$s&department_id=%2$s&fetch_child=%3$s";
    //企业微信-成员-userid转openid URL
    private static final String CONVERT_TO_OPENID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=%1$s";
    //企业微信-成员-二次验证 URL
    private static final String AUTHSUCC_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=%1$s&userid=%2$s";

    
    //企业微信-部门-创建部门 URL
    private static final String CREATE_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=%1$s";
    //企业微信-部门-更新部门 URL
    private static final String UPDATE_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=%1$s";
    //企业微信-部门-删除部门 URL
    private static final String DELETE_DEPARTMENT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=%1$s&id=%2$s";
    //企业微信-部门-获取部门列表 URL
    private static final String GET_DEPARTMENT_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%1$s&id=%2$s";
    
    
    //企业微信-发送消息URL
    private static final String SEND_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%1$s";
    
    //成员
    @Override
    public UserResp getUserId(String code) {
        return wxClient.get(String.format(GET_USER_ID_URL, getAccessToken()), UserResp.class);
    }
    
    @Override
    public UserInfoResp getUserInfo(String userId) {
        return wxClient.get(String.format(GET_USER_INFO_URL, getAccessToken(), userId), UserInfoResp.class);
    }
    
    @Override
    public WxBaseResp createUser(User user) {
        return wxClient.post(String.format(CREATE_USER_URL, getAccessToken()),  user.toString(), WxBaseResp.class);
    }

    @Override
    public WxBaseResp updateUser(User user) {
        return wxClient.post(String.format(UPDATE_USER_URL, getAccessToken()),  user.toString(), WxBaseResp.class);
    }
    
    @Override
    public WxBaseResp deleteUser(String userId) {
        return wxClient.get(String.format(DELETE_USER_URL, getAccessToken(), userId), WxBaseResp.class);
    }
    
    @Override
    public WxBaseResp batchDeleteUser(String[] userIds) {
        Map<String, Object> map = new HashMap<String, Object> (1);
        map.put("useridlist", userIds);
        return wxClient.post(String.format(BATCH_DELETE_USER_URL, getAccessToken()), JSON.toJSONString(map), WxBaseResp.class);
    }
    
    @Override
    public DepUserListResp getDepUserList(Integer departmentId, Integer fetchChild) {
        fetchChild = fetchChild == null ? 0 : fetchChild;
        return wxClient.get(String.format(GET_DEP_USERLIST_URL, getAccessToken(), departmentId, fetchChild), DepUserListResp.class);
    }

    @Override
    public DepUserInfoListResp getDepUserInfoList(Integer departmentId, Integer fetchChild) {
        fetchChild = fetchChild == null ? 0 : fetchChild;
        return wxClient.get(String.format(GET_DEP_USERINFOLIST_URL, getAccessToken(), departmentId, fetchChild), DepUserInfoListResp.class);
    }
    
    @Override
    public OpenidResp convertToOpenid(String userId) {
        Map<String, Object> map = new HashMap<String, Object> (1);
        map.put("userid", userId);
        return wxClient.post(String.format(CONVERT_TO_OPENID_URL, getAccessToken()), JSON.toJSONString(map), OpenidResp.class);
    }
    
    @Override
    public WxBaseResp authsucc(String userId) {
        return wxClient.get(String.format(AUTHSUCC_URL, getAccessToken(), userId), WxBaseResp.class);
    }
    
    
    //部门
    @Override
    public WxBaseResp createDepartment(Department department) {
        return wxClient.post(String.format(CREATE_DEPARTMENT_URL, getAccessToken()), department.toString(), WxBaseResp.class);
    }

    @Override
    public WxBaseResp updateDepartment(Department department) {
        return wxClient.post(String.format(UPDATE_DEPARTMENT_URL, getAccessToken()), department.toString(), WxBaseResp.class);
    }

    @Override
    public WxBaseResp deleteDepartment(Integer id) {
        return wxClient.get(String.format(DELETE_DEPARTMENT_URL, getAccessToken(), id), WxBaseResp.class);
    }

    @Override
    public DepartmentResp getDepartmentList(Integer id) {
        return wxClient.get(String.format(GET_DEPARTMENT_LIST_URL, getAccessToken(), id), DepartmentResp.class);
    }
    
    
    //标签
    
    
    
    @Override
    public MessageResp sendMessage(WxMessage message) {
        return wxClient.post(String.format(SEND_MESSAGE_URL, getAccessToken()), message.toString(), MessageResp.class);
    }
}
