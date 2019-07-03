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
 * @CreateDate 创建时间： 2019-04-12 10:34:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx19ZbthyyInfoVO/JX19_ZBTHYY_INFO",description="JX19_ZBTHYY_INFO")
public class Jx19ZbthyyInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 已签订指标id */
    @ApiModelProperty(value="已签订指标id",allowEmptyValue=true)
    private String zbid;

    /** 退回原因 */
    @ApiModelProperty(value="退回原因",allowEmptyValue=true)
    private String thyy;

    /** 退回人id */
    @ApiModelProperty(value="退回人id",allowEmptyValue=true)
    private String thuserid;

    /** 退回人 */
    @ApiModelProperty(value="退回人",allowEmptyValue=true)
    private String thuser;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

    @ApiModelProperty(value = "退回日期",allowEmptyValue=true)
    private Date oprCrtTime;


}