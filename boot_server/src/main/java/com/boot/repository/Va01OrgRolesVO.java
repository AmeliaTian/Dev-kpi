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
@ApiModel(value = "Va01OrgRolesVO/VA01_ORG_ROLES", description = "VIEW")
public class Va01OrgRolesVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "D", allowEmptyValue = false)
    private String id;

    /**
     * 机构ID
     */
    @ApiModelProperty(value = "机构ID", allowEmptyValue = false)
    private String orgId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID", allowEmptyValue = true)
    private String roleId;

}