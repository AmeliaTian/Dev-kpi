package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-17 11:27:41
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Va02UserOrgsRolesVO/VA02_USER_ORGS_ROLES", description = "VIEW")
public class Va02UserOrgsRolesVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", allowEmptyValue = false)
    private String userId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID", allowEmptyValue = true)
    private String roleId;

    /**
     * 机构ID
     */
    @ApiModelProperty(value = "机构ID", allowEmptyValue = true)
    private String orgId;

}