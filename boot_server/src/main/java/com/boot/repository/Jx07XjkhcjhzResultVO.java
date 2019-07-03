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
 * @CreateDate 创建时间： 2019-05-31 18:09:39
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx07XjkhcjhzResultVO/JX07_XJKHCJHZ_RESULT",description="07绩效考核汇总表")
public class Jx07XjkhcjhzResultVO implements java.io.Serializable {

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

    /** 考核对象名称 */
    @ApiModelProperty(value="考核对象名称",allowEmptyValue=true)
    private String khdxmc;

    /** 考核对象id */
    @ApiModelProperty(value="考核对象id",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象角色id */
    @ApiModelProperty(value="考核对象角色id",allowEmptyValue=true)
    private String khdxjsid;

    /** 考核对象角色 */
    @ApiModelProperty(value="考核对象角色",allowEmptyValue=true)
    private String khdxjs;

    /** 部门名称 */
    @ApiModelProperty(value="部门名称",allowEmptyValue=true)
    private String bmmc;

    /** 考核得分 */
    @ApiModelProperty(value="考核得分",allowEmptyValue=true)
    private String khdf;

    /** 考核系数 */
    @ApiModelProperty(value="考核系数",allowEmptyValue=true)
    private String khxs;

    /** 考核等级 */
    @ApiModelProperty(value="考核等级",allowEmptyValue=true)
    private String khdj;

    /** 最终等级 */
    @ApiModelProperty(value="最终等级",allowEmptyValue=true)
    private String zzdj;

    /** 考核等级调整人 */
    @ApiModelProperty(value="考核等级调整人",allowEmptyValue=true)
    private String kedjtzr;

    /** 绩效积分 */
    @ApiModelProperty(value="绩效积分",allowEmptyValue=true)
    private String jxjf;

    /** 是否调薪 */
    @ApiModelProperty(value="是否调薪",allowEmptyValue=true)
    private String sftx;

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