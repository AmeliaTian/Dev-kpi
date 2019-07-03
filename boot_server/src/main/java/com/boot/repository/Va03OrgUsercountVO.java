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
 * @CreateDate 创建时间： 2019-06-24 15:29:27
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Va03OrgUsercountVO/VA03_ORG_USERCOUNT",description="VIEW")
public class Va03OrgUsercountVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String orgId;

    /** 机构名称 */
    @ApiModelProperty(value="机构名称",allowEmptyValue=true)
    private String orgName;

    /** PEOPLECOUNT */
    @ApiModelProperty(value="PEOPLECOUNT",allowEmptyValue=false)
    private Long peoplecount;

}