package com.shaozj.sdk.qy.api;

import com.shaozj.sdk.qy.api.bean.req.department.Department;
import com.shaozj.sdk.qy.api.bean.req.message.WxMessage;
import com.shaozj.sdk.qy.api.bean.req.user.User;
import com.shaozj.sdk.qy.api.bean.resp.WxBaseResp;
import com.shaozj.sdk.qy.api.bean.resp.department.DepartmentResp;
import com.shaozj.sdk.qy.api.bean.resp.message.MessageResp;
import com.shaozj.sdk.qy.api.bean.resp.user.DepUserInfoListResp;
import com.shaozj.sdk.qy.api.bean.resp.user.DepUserListResp;
import com.shaozj.sdk.qy.api.bean.resp.user.OpenidResp;
import com.shaozj.sdk.qy.api.bean.resp.user.UserInfoResp;
import com.shaozj.sdk.qy.api.bean.resp.user.UserResp;

public interface IWxQyApi  {
    
    /**
     * 
     * 方法描述: <br>
     * 完成时间: 2019年5月23日 下午12:24:56<br>
     * 作者: szj<br>
     *
     * @param code
     * @return
     */
    public UserResp getUserId(String code);
    
    /**
     * 
     * 方法描述: 获取用户详细信息<br>
     * 完成时间: 2019年5月23日 下午2:46:12<br>
     * 作者: szj<br>
     *
     * @param userId
     * @return
     */
    public UserInfoResp getUserInfo(String userId);
    
    /**
     * 
     * 方法描述: 创建成员<br>
     * 完成时间: 2019年5月23日 下午2:51:57<br>
     * 作者: szj<br>
     *
     * @param user
     * @return
     */
    public WxBaseResp createUser(User user);
    
    /**
     * 
     * 方法描述: 更新成员<br>
     * 完成时间: 2019年5月23日 下午2:52:43<br>
     * 作者: szj<br>
     *
     * @param user
     * @return
     */
    public WxBaseResp updateUser(User user);
    
    /**
     * 
     * 方法描述: 删除用户<br>
     * 完成时间: 2019年5月23日 下午3:02:16<br>
     * 作者: szj<br>
     *
     * @param userId
     * @return
     */
    public WxBaseResp deleteUser(String userId);
    
    /**
     * 
     * 方法描述: 批量删除成员<br>
     * 完成时间: 2019年5月23日 下午3:11:09<br>
     * 作者: szj<br>
     *
     * @param userIds
     * @return
     */
    public WxBaseResp batchDeleteUser(String [] userIds);
    
    /**
     * 
     * 方法描述: 获取部门下的成员<br>
     * 完成时间: 2019年5月23日 下午3:33:22<br>
     * 作者: szj<br>
     *
     * @param departmentId 部门ID
     * @param fetchChild 是否递归获取子部门下的成员
     * @return
     */
    public DepUserListResp getDepUserList(Integer departmentId,  Integer fetchChild);
    
    /**
     * 
     * 方法描述: 获取部门下成员详情<br>
     * 完成时间: 2019年5月23日 下午3:34:57<br>
     * 作者: szj<br>
     *
     * @param departmentId 部门ID
     * @param fetchChild 是否递归获取子部门下的成员
     * @return
     */
    public DepUserInfoListResp getDepUserInfoList(Integer departmentId,  Integer fetchChild);
    
    /**
     * 
     * 方法描述: userid转openid<br>
     * 完成时间: 2019年5月23日 下午3:43:53<br>
     * 作者: szj<br>
     *
     * @param userId
     * @return
     */
    public OpenidResp convertToOpenid(String userId);
    
    /**
     * 
     * 方法描述: 验证<br>
     * 完成时间: 2019年5月23日 下午3:49:24<br>
     * 作者: szj<br>
     *
     * @param userId
     * @return
     */
    public WxBaseResp authsucc(String userId);
    
    
    /**
     * 
     * 方法描述: 创建部门<br>
     * 完成时间: 2019年5月23日 下午4:29:12<br>
     * 作者: szj<br>
     *
     * @param department
     * @return
     */
    public WxBaseResp createDepartment(Department department);
    
    /**
     * 
     * 方法描述: 更新部门<br>
     * 完成时间: 2019年5月23日 下午4:29:24<br>
     * 作者: szj<br>
     *
     * @param department
     * @return
     */
    public WxBaseResp updateDepartment(Department department);
    
    /**
     * 
     * 方法描述: 删除部门<br>
     * 完成时间: 2019年5月23日 下午4:29:37<br>
     * 作者: szj<br>
     *
     * @param department
     * @return
     */
    public WxBaseResp deleteDepartment(Integer id);
    
    /**
     * 
     * 方法描述: 获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构 <br>
     * 完成时间: 2019年5月23日 下午4:30:01<br>
     * 作者: szj<br>
     *
     * @param id 部门id
     * @return
     */
    public DepartmentResp getDepartmentList(Integer id);
    
    /**
     * 
     * 方法描述: 发送信息<br>
     * 完成时间: 2019年5月23日 下午12:25:14<br>
     * 作者: szj<br>
     *
     * @param message
     * @return
     */
    public MessageResp sendMessage(WxMessage message);
    
    
}
