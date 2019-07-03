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
 * @CreateDate 创建时间： 2019-01-15 17:47:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Au05MenuVO/AU05_MENU",description="AU05_菜单表")
public class Au05MenuVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 父级ID */
    @ApiModelProperty(value="父级ID",allowEmptyValue=true)
    private String parentId;

    /** 菜单图标 */
    @ApiModelProperty(value="菜单图标",allowEmptyValue=true)
    private String menuIcon;

    /** 菜单名称 */
    @ApiModelProperty(value="菜单名称",allowEmptyValue=true)
    private String menuName;

    /** 菜单链接 */
    @ApiModelProperty(value="菜单链接",allowEmptyValue=true)
    private String menuUrl;

}