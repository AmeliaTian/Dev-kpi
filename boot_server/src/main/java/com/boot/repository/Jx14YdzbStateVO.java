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
 * @CreateDate 创建时间： 2019-04-04 10:38:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx14YdzbStateVO/JX14_YDZB_STATE",description="JX14_YDZB_STATE")
public class Jx14YdzbStateVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 考核年份 */
    @ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    /** 考核对象 */
    @ApiModelProperty(value="考核对象",allowEmptyValue=true)
    private String khdx;

    /** 考核对象ID */
    @ApiModelProperty(value="考核对象ID",allowEmptyValue=true)
    private String khdxid;

    /** 状态 0：提交    1：一级审核    2：二级审核   3：一级退回 4：二级退回 */
    @ApiModelProperty(value="状态 0：提交    1：一级审核    2：二级审核   3：一级退回 4：二级退回",allowEmptyValue=true)
    private String zt;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 退回原因 */
    @ApiModelProperty(value="退回原因",allowEmptyValue=true)
    private String thyy;

    /** 退回人员id */
    @ApiModelProperty(value="退回人员id",allowEmptyValue=true)
    private String thuserid;

    /** 退回人名称 */
    @ApiModelProperty(value="退回人名称",allowEmptyValue=true)
    private String thuser;

}