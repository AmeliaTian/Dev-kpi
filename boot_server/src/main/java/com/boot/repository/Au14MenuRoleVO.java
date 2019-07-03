package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @CreateDate 创建时间： 2019-01-15 17:56:52
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Au14MenuRoleVO/AU14_MENU_ROLE",description="AU14_菜单角色映射表")
public class Au14MenuRoleVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 菜单ID */
    @ApiModelProperty(value="菜单ID",allowEmptyValue=true)
    private String menuId;

    /** 角色ID */
    @ApiModelProperty(value="角色ID",allowEmptyValue=true)
    private String roleId;

}