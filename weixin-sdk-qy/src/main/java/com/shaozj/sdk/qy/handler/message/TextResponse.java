package com.shaozj.sdk.qy.handler.message;

import com.shaozj.sdk.qy.utils.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 
 * 文件描述: 微信文本消息，响应信息处理<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 上午10:09:29<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
@XStreamAlias("xml")
public class TextResponse {
    
    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String content;
    
    public TextResponse content(String content){
        this.content=content;
        return this;
    }
    
    
    public String builder(String message) {
        return null;
    }
}
