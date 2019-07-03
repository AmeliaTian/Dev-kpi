package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au04PrivilegeVO/AU04_PRIVILEGE", description = "AU04_权限(资源表)表")
public class Au04PrivilegeVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 访问的链接和数据库资源
     */
    @ApiModelProperty(value = "访问的链接和数据库资源", allowEmptyValue = true)
    private String privType;

    /**
     * 资源路径
     */
    @ApiModelProperty(value = "资源路径", allowEmptyValue = true)
    private String privResource;

    /**
     * 访问方式
     */
    @ApiModelProperty(value = "访问方式", allowEmptyValue = true)
    private String privMethod;

    /**
     * 资源描述
     */
    @ApiModelProperty(value = "资源描述", allowEmptyValue = true)
    private String privDes;

    /**
     * 分配角色
     */
    @ApiModelProperty(value = "分配角色", allowEmptyValue = true)
    private String privRoles;

    /**
     * 是否允许非登录访问
     */
    @ApiModelProperty(value = "是否允许非登录访问", allowEmptyValue = true)
    private String privUnlogin;
}