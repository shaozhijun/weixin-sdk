package com.shaozj.sdk.qy.api.bean.resp.user;

import java.util.List;

import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;

public class DepUserListResp extends WxBaseResp {
    
    /**
     * 成员列表
     */
    private List<DepUser> userlist;
    
    static class DepUser {
        /**
         * 成员UserID。对应管理端的帐号
         */
        private String userId;
        
        /**
         * 成员名称
         */
        private String name;
        
        /**
         * 成员所属部门列表。列表项为部门ID，32位整型
         */
        private Integer department;

        
        public String getUserId() {
            return userId;
        }
        
        public void setUserId(String userId) {
            this.userId = userId;
        }
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        public Integer getDepartment() {
            return department;
        }

        public void setDepartment(Integer department) {
            this.department = department;
        }
    }
    
    public List<DepUser> getUserlist() {
        return userlist;
    }
    
    public void setUserlist(List<DepUser> userlist) {
        this.userlist = userlist;
    }
}
