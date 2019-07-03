package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description AU11_用户角色映射表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au11UserRoleVO/AU11_USER_ROLE", description = "AU11_用户角色映射表对象")
public class Au11UserRoleVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", allowEmptyValue = true)
    private String userId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID", allowEmptyValue = true)
    private String roleId;

}