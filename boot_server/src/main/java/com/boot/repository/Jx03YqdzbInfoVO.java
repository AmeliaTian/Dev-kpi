package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-04-04 10:38:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx03YqdzbInfoVO/JX03_YQDZB_INFO",description="03已签订指标表")
public class Jx03YqdzbInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 考核年份 */
    @ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    /** 考核对象Id */
    @ApiModelProperty(value="考核对象Id",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象 */
    @ApiModelProperty(value="考核对象",allowEmptyValue=true)
    private String khdx;

    /** 指标大类 */
    @ApiModelProperty(value="指标大类",allowEmptyValue=true)
    private String zbdl;

    /** 指标定义 */
    @ApiModelProperty(value="指标定义",allowEmptyValue=true)
    private String zbdy;

    /** 目标值 */
    @ApiModelProperty(value="目标值",allowEmptyValue=true)
    private String mbz;

    /** 指标权重 */
    @ApiModelProperty(value="指标权重",allowEmptyValue=true)
    private String qz;

    /** 关联指标明细 */
    @ApiModelProperty(value="关联指标明细",allowEmptyValue=true)
    private String gid;

    /** 考核周期 */
    @ApiModelProperty(value="考核周期",allowEmptyValue=true)
    private String khzq;

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

    /** 创建人 */
    @ApiModelProperty(value="创建人",allowEmptyValue=true)
    private String createUser;

    /** 指标名称 */
    @ApiModelProperty(value="指标名称",allowEmptyValue=true)
    private String zbmc;

    /** 更新人 */
    @ApiModelProperty(value="更新人",allowEmptyValue=true)
    private String updateUser;

    /** 评分标准 */
    @ApiModelProperty(value="评分标准",allowEmptyValue=true)
    private String pfbz;

    /** 单个指标退回原因 */
    @ApiModelProperty(value="退回原因",allowEmptyValue=true)
    //private String thyy;
    private Iterable<Jx19ZbthyyInfoVO> jx19ZbthyyInfoVOS;

    /** 整体退回原因*/
    /*@ApiModelProperty(value="整体退回原因",allowEmptyValue=true)
    private String thuserid;
    private String  ztthyy;*/
    /** 退回人员名称 */
    /*@ApiModelProperty(value="退回人员名称",allowEmptyValue=true)
    private String thuser;*/

    /** 算法模板id */
    /*@ApiModelProperty(value="算法模板id",allowEmptyValue=true)
    private String sfmbid;*/

    /** 考核对象部门id */
    @ApiModelProperty(value="考核对象部门id",allowEmptyValue=true)
    private String khdxbmid;
    /** 考核对象部门名称 */
    @ApiModelProperty(value="考核对象部门名称",allowEmptyValue=true)
    private String khdxbm;

    /** 评分类型 */
    @ApiModelProperty(value="评分类型",allowEmptyValue=true)
    private String pflx;
}