package com.shaozj.sdk.qy.api.bean.req.user;

/**
 * 
 * 文件描述: 成员对外属性<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午2:12:18<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class ExternalProfile {
    
    /**
     * 企业简称
     */
    private String external_corp_name;
    
    /**
     * 
     */
    private ExternalAttr [] external_attr;

    
    public String getExternal_corp_name() {
        return external_corp_name;
    }
    
    public void setExternal_corp_name(String external_corp_name) {
        this.external_corp_name = external_corp_name;
    }

    public ExternalAttr[] getExternal_attr() {
        return external_attr;
    }
    
    public void setExternal_attr(ExternalAttr[] external_attr) {
        this.external_attr = external_attr;
    }
}
