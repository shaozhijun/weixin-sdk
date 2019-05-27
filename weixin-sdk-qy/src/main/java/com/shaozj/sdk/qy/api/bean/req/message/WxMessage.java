package com.shaozj.sdk.qy.api.bean.req.message;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 文件描述: 应用消息体<br>
 * 版权所有: Copyright (c) 2019年5月21日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月21日 下午2:55:11<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class WxMessage {
    
    /**
     * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）
     * 特殊情况：指为@all，则向企业应用的全部成员发送
     */
    protected String touser;
    
    /**
     * 部分ID列表，多个接受者用'|'分隔，最多支持100个，当touser为@all时忽略本参数
     */
    protected String toparty;
    
    /**
     * 标签列表，多个接收者用‘|’分隔，最多支持100个，当touser为@all时忽略本参数
     */
    protected String totag;
    
    /**
     * 消息类型
     */
    protected String msgtype;
    
    /**
     * 企业应用id，整型，企业内部开发，可在应用设置页面查看；第三方服务商，可通过接口获取该参数值
     */
    protected int agentid;
    
    /**
     * 表示是否是保密信息，0表示否，1表示是，默认为0
     */
    protected int safe;

    
    public String getTouser() {
        return touser;
    }
    
    public void setTouser(String touser) {
        this.touser = touser;
    }
    
    public String getToparty() {
        return toparty;
    }
    
    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }
    
    public void setTotag(String totag) {
        this.totag = totag;
    }
    
    public String getMsgtype() {
        return msgtype;
    }
    
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    
    public int getAgentid() {
        return agentid;
    }
    
    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }
    
    public int getSafe() {
        return safe;
    }
    
    public void setSafe(int safe) {
        this.safe = safe;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
