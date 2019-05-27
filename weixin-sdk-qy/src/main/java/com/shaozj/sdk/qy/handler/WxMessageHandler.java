package com.shaozj.sdk.qy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shaozj.sdk.qy.api.bean.req.WxRequest;
import com.shaozj.sdk.qy.api.bean.resp.message.MessageConstant;
import com.shaozj.sdk.qy.utils.wxaes.SHA1;
import com.shaozj.sdk.qy.utils.wxaes.WXBizMsgCrypt;
import com.shaozj.sdk.qy.utils.xml.Dom4jUtil;

/**
 * 
 * 文件描述: 微信响应消息 ，事件处理类 （待完善）<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午3:02:57<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class WxMessageHandler implements IMessageHandler {

    private final Logger logger = LoggerFactory.getLogger(WxMessageHandler.class);
    /**
     * 用于接收微信推送的token验证
     */
    private final String token;
    
    /**
     * 消息加解密Key
     */
    private final String encodingAesKey;
    
    /**
     * 企业应用ID
     */
    private String corpid;
    
    /**
     * 构造方法 
     *
     * @param token
     * @param encodingAesKey
     */
    public WxMessageHandler(String token, String encodingAesKey) {
        this.token = token;
        this.encodingAesKey = encodingAesKey;
    }
    
    
    @Override
    public void handleMessage(WxRequest wxReq) {
        if (wxReq != null && checkSign(wxReq)) {
            String messageXml = wxReq.getMessage();
            //获取消息类型
            String msgType = Dom4jUtil.getElementText(messageXml, "MsgType");
            if ("event".equals(msgType)) {
                String event = Dom4jUtil.getElementText(messageXml, "Event");
                handleEvent(event, messageXml);//处理事件
            } else {
                handleMessage(msgType, messageXml);//处理消息
            }
        }
    }
    
    /**
     * 
     * 方法描述: 处理事件<br>
     * 完成时间: 2019年5月23日 上午10:35:04<br>
     * 作者: szj<br>
     *
     * @param event
     * @param message
     * @return
     */
    private String handleEvent(String event, String message) {
        switch (event) {
            case MessageConstant.EVENT_SUBSCRIBE:
                             
                break; 
            case MessageConstant.EVENT_ENTER_AGENT:
                
                break; 
            case MessageConstant.EVENT_LOCATION:
                
                break; 
            default:
                break;
        }
        
        return null;
    }
    
    /**
     * 
     * 方法描述: 处理消息<br>
     * 完成时间: 2019年5月23日 上午10:34:50<br>
     * 作者: szj<br>
     *
     * @param msgType
     * @param message
     * @return
     */
    private String handleMessage(String msgType, String message) {
        switch (msgType) {
            case MessageConstant.MSG_TEXT:
                
                break;
            case MessageConstant.MSG_IMAGE:
                
                break;
            case MessageConstant.MSG_VOICE:
                
                break; 
            default:
                break;
        }
        return null;
    }
    
    //提供消息处理方法,分事件和消息，抽象，外部实现
    
    
    
    /**
     * 
     * 方法描述: 校验签名<br>
     * 完成时间: 2019年5月22日 下午4:27:13<br>
     * 作者: szj<br>
     *
     * @param wxRequest
     * @return
     */
    private boolean checkSign(WxRequest wxRequest) {
        try {
            String newSign = SHA1.getSHA1(token, wxRequest.getTimestamp(), wxRequest.getNonce());
            return newSign.equals(wxRequest.getSignature());
        } catch (Exception e) {
            logger.info("验证签名确认请求是否来自微信服务器：token = {}, timestamp = {}, nonce = {}", token, wxRequest.getTimestamp(), wxRequest.getNonce(), wxRequest.getSignature());
            e.printStackTrace();
            return false;
        }
    }
    
    
    /**
     * 
     * 方法描述: 加密响应信息 <br>
     * 完成时间: 2019年5月22日 下午5:53:26<br>
     * 作者: szj<br>
     *
     * @param wxrq
     * @return
     */
    public String verifyUrl(WxRequest wxrq) {
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAesKey, corpid);
            return wxcpt.decryptMsg(wxrq.getMsg_signature(), wxrq.getTimestamp(), wxrq.getNonce(), wxrq.getMessage());
        } catch (Exception e) {
            
        }
        return null;
    }
    
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }
}
