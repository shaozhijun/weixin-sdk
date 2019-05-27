package com.shaozj.sdk.qy.api.bean.resp.message.xml;

import com.shaozj.sdk.qy.api.bean.resp.message.BaseXmlMessage;
import com.shaozj.sdk.qy.utils.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 
 * 文件描述: 图片消息<br>
 * 版权所有: Copyright (c) 2019年5月22日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月22日 下午3:51:33<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class ImageXmlMessage extends BaseXmlMessage {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4668150498699072609L;

    /**
     * 图片媒体文件id，可以调用获取媒体文件接口拉取，仅三天内有效
     */
    @XStreamAlias("PicUrl")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String picUrl;
    
    /**
     * 图片链接
     */
    @XStreamAlias("MediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String mediaId;
    
    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
