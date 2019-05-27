package com.shaozj.sdk.qy.api.bean.req;

/**
 * 
 * 文件描述: 更新任务卡片消息状态<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午12:12:06<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class TaskCard {
    
    /**
     * 企业会员ID列表(消息接收者,最多支持1000)
     */
    private String [] userids;
    
    /**
     * 应用的agentid
     */
    private Integer agentid;
    
    /**
     *  发送任务卡片消息是指定task_id
     */
    private String task_id;
    
    /**
     *  设置指定的按钮为选择状态
     */
    private String clicked_key;

    
    public String[] getUserids() {
        return userids;
    }
    
    public void setUserids(String[] userids) {
        this.userids = userids;
    }
    
    public Integer getAgentid() {
        return agentid;
    }
    
    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }
    
    public String getTask_id() {
        return task_id;
    }
    
    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }
    
    public String getClicked_key() {
        return clicked_key;
    }
    
    public void setClicked_key(String clicked_key) {
        this.clicked_key = clicked_key;
    }
}
