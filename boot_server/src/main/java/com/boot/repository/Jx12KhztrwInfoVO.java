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
 * @CreateDate 创建时间： 2019-02-14 16:11:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx12KhztrwInfoVO/JX12_KHZTRW_INFO",description="12考核主体任务表")
public class Jx12KhztrwInfoVO implements java.io.Serializable {

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

    /** 考核类型 */
    @ApiModelProperty(value="考核类型",allowEmptyValue=true)
    private String khlx;


    /** 指标类型 */
    @ApiModelProperty(value="指标类型",allowEmptyValue=true)
    private String zblx;

    /** 考核主体id */
    @ApiModelProperty(value="考核主体id",allowEmptyValue=true)
    private String khztid;

    /** 考核主体 */
    @ApiModelProperty(value="考核主体",allowEmptyValue=true)
    private String khzt
            ;
    /** 考核主体角色 */
    @ApiModelProperty(value="考核主体角色",allowEmptyValue=true)
    private String khztjs;

    /** 考核对象id */
    @ApiModelProperty(value="考核对象id",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象 */
    @ApiModelProperty(value="考核对象",allowEmptyValue=true)
    private String khdx;

    /** 考核对象角色 */
    @ApiModelProperty(value="考核对象角色",allowEmptyValue=true)
    private String khdxjs;

    /** 考核主体权重 */
    @ApiModelProperty(value="考核主体权重",allowEmptyValue=true)
    private String khztqz;

    /** 考核得分 */
    @ApiModelProperty(value="考核得分",allowEmptyValue=true)
    private String khdf;

    /** 更新时间 */
    @ApiModelProperty(value="更新时间",allowEmptyValue=true)
    //日期类型转换json，格式化
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyyMMddHHmmss")
    private Date updatetime;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;
    /**
     * 所属角色
     */
   /* @ApiModelProperty(value = "所属角色", allowEmptyValue = true)
    private List<Au03RolePO> khdxRoles;
    @ApiModelProperty(value = "考核结果", allowEmptyValue = true)
    private List<Jx07XjkhcjhzResultPO> jx07XjkhcjhzResultPOList;*/
}