package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-14 10:33:27
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au02OrganizationVO/AU02_ORGANIZATION", description = "AU02_组织机构表")
public class Au02OrganizationVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称", allowEmptyValue = true)
    private String orgName;

    /**
     * 机构说明
     */
    @ApiModelProperty(value = "机构说明", allowEmptyValue = true)
    private String orgDesc;


    /**
     * 分管领导
     */
    @ApiModelProperty(value = "分管领导", allowEmptyValue = true)
    private String orgLeader;
}