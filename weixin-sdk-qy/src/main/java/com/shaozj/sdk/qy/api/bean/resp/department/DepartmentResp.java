package com.shaozj.sdk.qy.api.bean.resp.department;

import java.util.List;

import com.shaozj.sdk.qy.api.bean.req.department.Department;
import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;

/**
 * 
 * 文件描述: 获取部门列表响应实体<br>
 * 版权所有: Copyright (c) 2019年5月23日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月23日 下午4:26:39<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class DepartmentResp extends WxBaseResp {
    
    /**
     * 部门列表
     */
    private List<Department> department;

    public List<Department> getDepartment() {
        return department;
    }
    
    public void setDepartment(List<Department> department) {
        this.department = department;
    }
}
