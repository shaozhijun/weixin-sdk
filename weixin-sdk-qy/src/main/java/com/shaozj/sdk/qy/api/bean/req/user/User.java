package com.shaozj.sdk.qy.api.bean.req.user;

import com.alibaba.fastjson.JSON;

public class User {
    
    /**
     * 成员UserId,对应管理端的账号,企业内必须唯一,不区分大小写
     * 长度1~64个字节，只能有数字、字母和“_-@.”四种字符组成，且第一个字符必须是数字和字母
     */
    private String userid;
    
    /**
     * 成员名称，长度为1~64个utf-8字符
     */
    private String name;
    
    /**
     * 成员别名。长度为1~32个utf-8字符
     */
    private String alias;
    
    /**
     * 手机号码，企业内必须唯一，mobile/email二者不能同时为空
     */
    private String mobile;
    
    /**
     * 成员所属部门列表，不超过20个
     */
    private Integer [] department;
    
    /**
     * 部门内的排序值，默认为0，成员次序以创建时间从小到大排列
     * 数量必须和department一致，数值越大排序越前面，有效范围是[0, 2^32)
     */
    private Integer [] order;
    
    /**
     * 职务信息。长度为0~128个字符
     */
    private String position;
    
    /**
     * 性别。1表示男性，2表示女性
     */
    private String gender;
    
    /**
     * 邮箱。长度6~64个字节，且为有效的email格式。企业内必须唯一，mobile/email二者不能同时为空
     */
    private String email;
    
    /**
     * 座机。32字节以内，由纯数字或’-‘号组成。
     */
    private String telephone;
    
    /**
     * 个数必须和department一致，表示在所在的部门内是否为上级。1表示为上级，0表示非上级。在审批等应用里可以用来标识上级审批人
     */
    private Integer [] is_leader_in_dept;
    
    /**
     * 启用/禁用成员。1表示启用成员，0表示禁用成员
     */
    private int enable;
    
    /**
     * 成员头像的mediaid，通过素材管理接口上传图片获得的mediaid
     */
    private String avatar_mediaid;
    
    /**
     * 地址。长度最大128个字符
     */
    private String address;
    
    /**
     * 自定义字段。自定义字段需要先在WEB管理端添加，见扩展属性添加方法，否则忽略未知属性的赋值。与对外属性一致，不过只支持type=0的文本和type=1的网页类型，详细描述查看对外属性
     */
    private Extattr extattr;
    
    /**
     * 是否邀请该成员使用企业微信（将通过微信服务通知或短信或邮件下发邀请，每天自动下发一次，最多持续3个工作日），默认值为true。
     */
    private boolean to_invite;
    
    /**
     * 对外职务，如果设置了该值，则以此作为对外展示的职务，否则以position来展示。长度12个汉字内
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getAvatar_mediaid() {
        return avatar_mediaid;
    }
    
    public void setAvatar_mediaid(String avatar_mediaid) {
        this.avatar_mediaid = avatar_mediaid;
    }

    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
    
    public boolean isTo_invite() {
        return to_invite;
    }
    
    public void setTo_invite(boolean to_invite) {
        this.to_invite = to_invite;
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

    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public void setEnable(int enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
