package com.shaozj.sdk.qy.api.bean.req.message;


public class TextMessage extends WxMessage {
    
    /**
     * 文本消息
     */
    private Text text;
    
    public TextMessage() {
        this.msgtype = "text";
    }
    
    
    static class Text {
        
        /**
         * 下坡新欧毛绒泡面哥，最长不超过2048字节，超过将截断
         */
        private String content;
        
        public String getContent() {
            return content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
    }
    
    public Text getText() {
        return text;
    }
    
    public void setText(Text text) {
        this.text = text;
    }
}
