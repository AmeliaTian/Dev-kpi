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
 * @CreateDate 创建时间： 2019-05-30 14:55:19
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx13KhdjgjInfoVO/JX13_KHDJGJ_INFO",description="13考核等级系数管理表")
public class Jx13KhdjgjInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 考核年份 */
    /*@ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    *//** KHZQ *//*
    @ApiModelProperty(value="KHZQ",allowEmptyValue=true)
    private String khzq;*/

    /** 考核等级 */
    @ApiModelProperty(value="考核等级",allowEmptyValue=true)
    private String khdj;

    /** 绩效积分 */
    @ApiModelProperty(value="绩效积分",allowEmptyValue=true)
    private String jxjf;

    /** 部门考核得分最低值 */
    @ApiModelProperty(value="部门考核得分最低值",allowEmptyValue=true)
    private String minbmdf;

    /** 部门考核得分最高值 */
    @ApiModelProperty(value="部门考核得分最高值",allowEmptyValue=true)
    private String maxbmdf;

    /** 绩效系数 */
    @ApiModelProperty(value="绩效系数",allowEmptyValue=true)
    private String jxxs;

    /** 等级人数所占百分比 */
    @ApiModelProperty(value="等级人数所占百分比",allowEmptyValue=true)
    private String djrsbfb;

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