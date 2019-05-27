package com.shaozj.sdk.qy.api.bean.req.user;


public class ExternalAttr {
    
    private Integer type;
    
    private String name;
    
    private Text text;
    
    private Web web;
    
    private Miniprogram miniprogram;
    
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
    
    public Miniprogram getMiniprogram() {
        return miniprogram;
    }
    
    public void setMiniprogram(Miniprogram miniprogram) {
        this.miniprogram = miniprogram;
    }
}
