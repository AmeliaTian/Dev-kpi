package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description AU03_角色表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au03RoleVO/AU03_ROLE", description = "AU03_角色表对象")
public class Au03RoleVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", allowEmptyValue = true)
    private String roleName;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码", allowEmptyValue = true)
    private String roleCode;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述", allowEmptyValue = true)
    private String roleDesc;

}