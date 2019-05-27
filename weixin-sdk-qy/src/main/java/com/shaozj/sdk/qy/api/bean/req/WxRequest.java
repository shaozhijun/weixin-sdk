package com.shaozj.sdk.qy.api.bean.req;


public class WxRequest extends Message {
    
    /**
     * 微信加密签名
     */
    private String signature;
    
    /**
     * 企业微信加密签名，msg_signature结合了企业填写的token、请求中的timestamp、nonce参数、加密消息体
     */
    private String msg_signature;
    
    /**
     * 时间戳
     */
    private String timestamp;
    
    /**
     *  随机数
     */
    private String nonce;
    
    /**
     *  加密的字符串，需要解密得到消息内的明文、解密有有random、msg_len、msg、receiveid四个字段
     *  其中msg即为消息内容明文
     */
    private String echostr;
    
    /**
     *  加密类型（置为aes）
     */
    private String encrypt_type;
    
    public String getMsg_signature() {
        return msg_signature;
    }
    
    public void setMsg_signature(String msg_signature) {
        this.msg_signature = msg_signature;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getNonce() {
        return nonce;
    }
    
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }
    
    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    public String getEncrypt_type() {
        return encrypt_type;
    }

    public void setEncrypt_type(String encrypt_type) {
        this.encrypt_type = encrypt_type;
    }
}
