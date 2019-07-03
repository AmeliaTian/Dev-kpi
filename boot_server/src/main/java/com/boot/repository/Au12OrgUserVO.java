package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-13 16:00:19
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au12OrgUserVO/AU12_ORG_USER", description = "AU12_机构人员映射表")
public class Au12OrgUserVO implements java.io.Serializable {

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
     * 人员ID
     */
    @ApiModelProperty(value = "人员ID", allowEmptyValue = true)
    private String userId;

}