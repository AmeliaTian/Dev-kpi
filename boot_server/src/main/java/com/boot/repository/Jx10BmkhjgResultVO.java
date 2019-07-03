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
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx10BmkhjgResultVO/JX10_BMKHJG_RESULT",description="10部门考核结果汇总表（包括各等级人数）")
public class Jx10BmkhjgResultVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 部门id */
    @ApiModelProperty(value="部门id",allowEmptyValue=true)
    private String bmid;

    /** 部门名称 */
    @ApiModelProperty(value="部门名称",allowEmptyValue=true)
    private String bmmc;

    /** 考核年份 */
    @ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    /** 考核周期 */
    @ApiModelProperty(value="考核周期",allowEmptyValue=true)
    private String khzq;

    /** 关键业绩类初始得分 */
    @ApiModelProperty(value="关键业绩类初始得分",allowEmptyValue=true)
    private BigDecimal gjyjlcsdf;

    /** 关键业绩类最终得分 */
    @ApiModelProperty(value="关键业绩类最终得分",allowEmptyValue=true)
    private BigDecimal gjyjlzzdf;

    /** 部门最终考核得分 */
    @ApiModelProperty(value="部门最终考核得分",allowEmptyValue=true)
    private BigDecimal bmkhdf;

    /** 等级名称 */
    @ApiModelProperty(value="等级名称",allowEmptyValue=true)
    private String djmc;

    /** 预算人数 */
    @ApiModelProperty(value="预算人数",allowEmptyValue=true)
    private String ysrs;

    /** 实际调整人数 */
    @ApiModelProperty(value="实际调整人数",allowEmptyValue=true)
    private String sjtzrs;

    /** 剩余可调人数 */
    @ApiModelProperty(value="剩余可调人数",allowEmptyValue=true)
    private String syktrs;

    /** 考核系数 */
    @ApiModelProperty(value="考核系数",allowEmptyValue=true)
    private String khxs;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 更新时间 */
    @ApiModelProperty(value="更新时间",allowEmptyValue=true)
    //日期类型转换json，格式化
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyyMMddHHmmss")
    private Date updatetime;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}