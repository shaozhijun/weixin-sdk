package com.shaozj.sdk.qy.api.bean.req.user;

/**
 * 
 * 文件描述: 扩展属性<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午2:05:51<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class Attrs {
    
    private Integer type;
    
    private String name;
    
    private Text text;
    
    private Web web;
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Text getText() {
        return text;
    }
    
    public void setText(Text text) {
        this.text = text;
    }
    
    public Web getWeb() {
        return web;
    }
    
    public void setWeb(Web web) {
        this.web = web;
    }
}
