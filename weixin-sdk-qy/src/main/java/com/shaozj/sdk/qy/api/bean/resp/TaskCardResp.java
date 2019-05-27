package com.shaozj.sdk.qy.api.bean.resp;


public class TaskCardResp extends WxBaseResp {
    
    /**
     * 成功用户列表
     */
    private String [] invaliduser;

    public String[] getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String[] invaliduser) {
        this.invaliduser = invaliduser;
    }
}
