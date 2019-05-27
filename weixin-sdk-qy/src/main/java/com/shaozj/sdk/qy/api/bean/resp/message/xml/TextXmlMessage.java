package com.shaozj.sdk.qy.api.bean.resp.message.xml;

import com.shaozj.sdk.qy.api.bean.resp.message.BaseXmlMessage;
import com.shaozj.sdk.qy.utils.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 
 * 文件描述: 文本消息<br>
 * 版权所有: Copyright (c) 2019年5月22日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月22日 下午3:50:40<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class TextXmlMessage extends BaseXmlMessage {

    /**
     * 
     */
    private static final long serialVersionUID = 5302131475991751432L;
    
    /**
     * 消息内容
     */
    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String content;

    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
