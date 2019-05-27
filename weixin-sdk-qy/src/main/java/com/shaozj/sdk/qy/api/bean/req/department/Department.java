package com.shaozj.sdk.qy.api.bean.req.department;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 文件描述: 部门详情<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午4:23:54<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class Department {
    
    /**
     * 部门名称。长度限制为1~32个字符，字符不能包括\:?”<>｜
     */
    private String name;
    
    /**
     * 父部门id，32位整型
     */
    private Integer parentid;
    
    /**
     * 在父部门中的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
     */
    private Integer order;
    
    /**
     * 部门id，32位整型，指定时必须大于1。若不填该参数，将自动生成id
     */
    private Integer id;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getOrder() {
        return order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
    
    
}
