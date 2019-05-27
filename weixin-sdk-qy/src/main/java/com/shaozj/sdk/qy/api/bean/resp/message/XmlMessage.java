package com.shaozj.sdk.qy.api.bean.resp.message;


public abstract class XmlMessage {
    
    private String toUserName;
    
    private String fromUserName;
    
    private String msgType;
    
    public abstract String subXml();
    
    public String createXml() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + System.currentTimeMillis()/1000 + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
        sb.append(subXml());
        sb.append("</xml>");
        return sb.toString();
    }

    public String getToUserName() {
        return toUserName;
    }
    
    public String getFromUserName() {
        return fromUserName;
    }

    public String getMsgType() {
        return msgType;
    }
}
