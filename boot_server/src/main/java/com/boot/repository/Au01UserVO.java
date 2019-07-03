package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author CodeGen
 * @Description AU01_系统用户表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au01UserVO/AU01_USER", description = "AU01_系统用户表对象")
public class Au01UserVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名", allowEmptyValue = true)
    private String userNameCn;

    /**
     * 登录用户名
     */
    @ApiModelProperty(value = "登录用户名", allowEmptyValue = true)
    private String userName;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码", allowEmptyValue = true)
    private String password;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码", allowEmptyValue = true)
    private String phoneNumber;

    /**
     * EMAIL
     */
    @ApiModelProperty(value = "EMAIL", allowEmptyValue = true)
    private String email;

    /**
     * 直接上级
     */
    @ApiModelProperty(value = "直接上级", allowEmptyValue = true)
    private String directSuperior;

    /**
     * 用户访问Key
     */
    @ApiModelProperty(value = "用户访问Key", allowEmptyValue = true)
    private String userAskKey;

    /**
     * 扩展属性
     */
    @ApiModelProperty(value = "用户扩展属性", allowEmptyValue = true)
    private String userExtend;


    /**
     * 帐号是否过期
     */
    @ApiModelProperty(value = "帐号是否过期", allowEmptyValue = true)
    private String accountExpired;

    /**
     * 账号是否锁定
     */
    @ApiModelProperty(value = "账号是否锁定", allowEmptyValue = true)
    private String accountLocked;

    /**
     * 用户是否启用
     */
    @ApiModelProperty(value = "用户是否启用", allowEmptyValue = true)
    private String accountEnabled;

    /**
     * 所属角色
     */
    @ApiModelProperty(value = "所属角色", allowEmptyValue = true)
    private Iterable<Au03RoleVO> userRoles;

    @ApiModelProperty(value = "签订状态", allowEmptyValue = true)
    private String YdzbState;

    /*@ApiModelProperty(value = "考核状态", allowEmptyValue = true)
    private String  jxkhzt;*/
    /*@ApiModelProperty(value = "考核等级", allowEmptyValue = true)
    private String  jxdj;*/
    @ApiModelProperty(value = "考核结果", allowEmptyValue = true)
    private List<Jx07XjkhcjhzResultPO> jx07XjkhcjhzResultPOList;

    @ApiModelProperty(value = "签订状态", allowEmptyValue = true)
    private Jx14YdzbStatePO jx14YdzbStatePO;
}