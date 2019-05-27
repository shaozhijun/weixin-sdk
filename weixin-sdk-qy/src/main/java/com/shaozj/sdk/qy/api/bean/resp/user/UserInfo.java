package com.shaozj.sdk.qy.api.bean.resp.user;

import com.shaozj.sdk.qy.api.bean.req.user.Extattr;
import com.shaozj.sdk.qy.api.bean.req.user.ExternalProfile;

public class UserInfo {
    
    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     */
    private String userid;
    
    /**
     * 成员名称
     */
    private String name;
    
    /**
     * 成员所属部门id列表，仅返回该应用有查看权限的部门id
     */
    private Integer [] department;
    
    /**
     * 部门内的排序值，默认为0。数量必须和department一致，数值越大排序越前面。值范围是[0, 2^32)
     */
    private Integer [] order;
    
    /**
     * 职务信息；第三方仅通讯录应用可获取
     */
    private String position;
    
    /**
     * 手机号码，第三方仅通讯录应用可获取
     */
    private String mobile;
    
    /**
     * 性别。0表示未定义，1表示男性，2表示女性
     */
    private String gender;
    
    /**
     * 邮箱，第三方仅通讯录应用可获取
     */
    private String email;
    
    /**
     * 表示在所在的部门内是否为上级。；第三方仅通讯录应用可获取
     */
    private Integer [] is_leader_in_dept;
    
    /**
     * 头像url
     */
    private String avatar;
    
    /**
     * 座机。第三方仅通讯录应用可获取
     */
    private String telephone;
    
    /**
     *  成员启用状态。1表示启用的成员，0表示被禁用。注意，服务商调用接口不会返回此字段
     */
    private int enable;
    
    /**
     * 别名；第三方仅通讯录应用可获取
     */
    private String alias;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 扩展属性，第三方仅通讯录应用可获取
     */
    private Extattr extattr;
    
    /**
     * 激活状态: 1=已激活，2=已禁用，4=未激活。
已激活代表已激活企业微信或已关注微工作台（原企业号）。未激活代表既未激活企业微信又未关注微工作台（原企业号）。
     */
    private int status;
    
    /**
     * 员工个人二维码，扫描可添加为外部联系人；第三方仅通讯录应用可获取
     */
    private String qr_code;
    
    /**
     * 对外职务，如果设置了该值，则以此作为对外展示的职务，否则以position来展示。
     */
    private String external_position;
    
    /**
     * 成员对外属性
     */
    private ExternalProfile external_profile;

    public String getUserid() {
        return userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer[] getDepartment() {
        return department;
    }
    
    public void setDepartment(Integer[] department) {
        this.department = department;
    }
    
    public Integer[] getOrder() {
        return order;
    }

    public void setOrder(Integer[] order) {
        this.order = order;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer[] getIs_leader_in_dept() {
        return is_leader_in_dept;
    }
    
    public void setIs_leader_in_dept(Integer[] is_leader_in_dept) {
        this.is_leader_in_dept = is_leader_in_dept;
    }

    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public String getAlias() {
        return alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Extattr getExtattr() {
        return extattr;
    }
    
    public void setExtattr(Extattr extattr) {
        this.extattr = extattr;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getQr_code() {
        return qr_code;
    }
    
    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }
    
    public String getExternal_position() {
        return external_position;
    }
    
    public void setExternal_position(String external_position) {
        this.external_position = external_position;
    }
    
    public ExternalProfile getExternal_profile() {
        return external_profile;
    }
    
    public void setExternal_profile(ExternalProfile external_profile) {
        this.external_profile = external_profile;
    }
}
