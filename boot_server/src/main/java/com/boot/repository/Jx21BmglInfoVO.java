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
 * @CreateDate 创建时间： 2019-05-29 13:46:33
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx21BmglInfoVO/JX21_BMGL_INFO",description="部门管理表")
public class Jx21BmglInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 考核对象id （ 部门） */
    @ApiModelProperty(value="考核对象id （ 部门）",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象名称（部门） */
    @ApiModelProperty(value="考核对象名称（部门）",allowEmptyValue=true)
    private String khdxmc;

    /** 关联部门id */
    @ApiModelProperty(value="关联部门id",allowEmptyValue=true)
    private String glbmid;

    /** 关联部门名称 */
    @ApiModelProperty(value="关联部门名称",allowEmptyValue=true)
    private String glbmmc;

    /** 权重 */
    @ApiModelProperty(value="权重",allowEmptyValue=true)
    private String qz;

    /** 考核年份 */
    @ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    /** 考核周期 */
    @ApiModelProperty(value="考核周期",allowEmptyValue=true)
    private String khzq;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}