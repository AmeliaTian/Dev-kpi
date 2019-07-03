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
 * @CreateDate 创建时间： 2019-04-28 11:37:24
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx06XjkhjgResultVO/JX06_XJKHJG_RESULT",description="06绩效考核结果明细表")
public class Jx06XjkhjgResultVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 考核年份 */
    @ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    /** 考核周期 */
    @ApiModelProperty(value="考核周期",allowEmptyValue=true)
    private String khzq;

    /** 考核对象类别 */
    @ApiModelProperty(value="考核对象类别",allowEmptyValue=true)
    private String khdxlb;

    /** 考核对象id */
    @ApiModelProperty(value="考核对象id",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象名称 */
    @ApiModelProperty(value="考核对象名称",allowEmptyValue=true)
    private String khdxmc;

    /** 指标类型*/
    @ApiModelProperty(value="指标类型",allowEmptyValue=true)
    private String zblx;

    /** 指标id */
    @ApiModelProperty(value="指标id",allowEmptyValue=true)
    private String zbid;

    /** 指标得分 */
    @ApiModelProperty(value="指标得分",allowEmptyValue=true)
    private String zbdf;

    /** 评分原因 */
    @ApiModelProperty(value="评分原因",allowEmptyValue=true)
    private String pfyy;

    /** 考核主体id */
    @ApiModelProperty(value="考核主体id",allowEmptyValue=true)
    private String khztid;

    /** 考核主体名称 */
    @ApiModelProperty(value="考核主体名称",allowEmptyValue=true)
    private String khztmc;

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