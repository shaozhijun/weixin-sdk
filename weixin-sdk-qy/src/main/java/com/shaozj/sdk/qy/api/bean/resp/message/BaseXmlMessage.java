package com.shaozj.sdk.qy.api.bean.resp.message;

import java.io.Serializable;

import com.shaozj.sdk.qy.api.bean.resp.message.converter.CDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public class BaseXmlMessage implements Serializable {

    /**
     * <p>Field serialVersionUID: TODO</p>
     */
    private static final long serialVersionUID = -5422765935677031827L;
    
    /**
     * 企业微信CorpID
     */
    @XStreamAlias("ToUserName")
    @XStreamConverter(value = CDataConverter.class)
    protected String toUserName;

    /**
     * 成员UserID
     */
    @XStreamAlias("FromUserName")
    @XStreamConverter(value = CDataConverter.class)
    protected String fromUserName;

    /**
     * 消息创建时间（整型）
     */
    @XStreamAlias("CreateTime")
    protected Long createTime;

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    @XStreamConverter(value = CDataConverter.class)
    protected String msgType;

    /**
     * 消息id，64位整型
     */
    @XStreamAlias("MsgId")
    protected Long msgId;
    
    /**
     * 企业应用的id
     */
    @XStreamAlias("AgentID")
    private Long agentId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Long getMsgId() {
        return msgId;
    }
    
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
    
    public Long getAgentId() {
        return agentId;
    }
    
    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }
}
