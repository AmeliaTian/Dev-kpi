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
 * @CreateDate 创建时间： 2019-03-13 11:30:29
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx11KhzqInfoVO/JX11_KHZQ_INFO",description="11绩效考核周期管理")
public class Jx11KhzqInfoVO implements java.io.Serializable {

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

    /** 考核阶段编号 */
    @ApiModelProperty(value="考核阶段编号",allowEmptyValue=true)
    private String khjdbh;

    /** 考核阶段名称 */
    @ApiModelProperty(value="考核阶段名称",allowEmptyValue=true)
    private String khjdmc;

    /** 阶段预计开始时间 */
    @ApiModelProperty(value="阶段预计开始时间",allowEmptyValue=true)
    private String jdyjkssj;

    /** 阶段实际开始时间 */
    @ApiModelProperty(value="阶段实际开始时间",allowEmptyValue=true)
    private String jdsjkssj;

    /** 阶段预计结束时间 */
    @ApiModelProperty(value="阶段预计结束时间",allowEmptyValue=true)
    private String jdyjjsdj;

    /** 阶段实际结束时间 */
    @ApiModelProperty(value="阶段实际结束时间",allowEmptyValue=true)
    private String jdsjjssj;

    /** 阶段状态 点击按钮 前一个阶段结束 后一个阶段开始  0：未完成 ；1：进行中 ；2：已完成 */
    @ApiModelProperty(value="阶段状态 点击按钮 前一个阶段结束 后一个阶段开始  0：未完成 ；1：进行中 ；2：已完成",allowEmptyValue=true)
    private String jdzt;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 更新时间 */
    @ApiModelProperty(value="更新时间",allowEmptyValue=true)
    //日期类型转换json，格式化
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyyMMdd")
    private Date updatetime;

    /** 创建时间 */
    @ApiModelProperty(value="更新时间",allowEmptyValue=true)
    //日期类型转换json，格式化
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyyMMdd")
    private Date oprCrtTime;
    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}