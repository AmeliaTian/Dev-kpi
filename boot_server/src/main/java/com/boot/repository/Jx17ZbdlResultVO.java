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
 * @CreateDate 创建时间： 2019-05-29 13:47:02
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx17ZbdlResultVO/JX17_ZBDL_RESULT",description="考核得分中间表(指标大类得分)")
public class Jx17ZbdlResultVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 考核对象ID */
    @ApiModelProperty(value="考核对象ID",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象名称 */
    @ApiModelProperty(value="考核对象名称",allowEmptyValue=true)
    private String khdxmc;

    /** 考核对象角色id */
    @ApiModelProperty(value="考核对象角色id",allowEmptyValue=true)
    private String khdxjsid;

    /** 指标大类   业绩类 态度类 胜任力 */
    @ApiModelProperty(value="指标大类   业绩类 态度类 胜任力",allowEmptyValue=true)
    private String zbdl;

    /** 指标大类权重 */
    @ApiModelProperty(value="指标大类权重",allowEmptyValue=true)
    private String zbdlqz;

    /** 考核得分 */
    @ApiModelProperty(value="考核得分",allowEmptyValue=true)
    private String df;

    /** 考核年份 */
    @ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;

    /** 考核周期 */
    @ApiModelProperty(value="考核周期",allowEmptyValue=true)
    private String khzq;

    /** 更新时间 */
    @ApiModelProperty(value="更新时间",allowEmptyValue=true)
    //日期类型转换json，格式化
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyyMMddHHmmss")
    private Date updatetime;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}