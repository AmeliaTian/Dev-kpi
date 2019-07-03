package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-13 16:00:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au13OrgRoleVO/AU13_ORG_ROLE", description = "AU13_机构角色映射表")
public class Au13OrgRoleVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 组织机构ID
     */
    @ApiModelProperty(value = "组织机构ID", allowEmptyValue = true)
    private String orgId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID", allowEmptyValue = true)
    private String roleId;

}