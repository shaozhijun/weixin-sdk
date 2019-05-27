package com.shaozj.sdk.qy.api.bean.req.message;

/**
 * 
 * 文件描述: 图片消息<br>
 * 版权所有: Copyright (c) 2019年5月21日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月21日 下午3:27:22<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class ImageMessage extends WxMessage{
    
    private Image image;
    
    public ImageMessage() {
        this.msgtype = "image";
    }
    
    static class Image {
        
        /**
         * 图片文件媒体ID，可以调用上传临时素材接口获取
         */
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
}
