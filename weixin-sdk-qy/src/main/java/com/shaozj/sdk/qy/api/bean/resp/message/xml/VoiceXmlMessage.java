package com.shaozj.sdk.qy.api.bean.resp.message.xml;

import com.shaozj.sdk.qy.api.bean.resp.message.BaseXmlMessage;
import com.shaozj.sdk.qy.utils.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 
 * 文件描述: 语音消息<br>
 * 版权所有: Copyright (c) 2019年5月22日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月22日 下午3:49:56<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class VoiceXmlMessage extends BaseXmlMessage {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8057083941895744853L;

    /**
     * 语音媒体文件id，可以调用获取媒体文件接口拉取数据，仅三天内有效
     */
    @XStreamAlias("MediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String mediaId;
    
    /**
     * 语音格式，如amr，speex等
     */
    @XStreamAlias("Format")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String format;

    
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    
    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
}
