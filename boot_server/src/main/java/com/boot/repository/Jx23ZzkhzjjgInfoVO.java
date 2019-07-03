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
 * @CreateDate 创建时间： 2019-06-20 11:47:03
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx23ZzkhzjjgInfoVO/JX23_ZZKHZJJG_INFO",description="23组织考核中间结果表")
public class Jx23ZzkhzjjgInfoVO implements java.io.Serializable {

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

    /** 考核主体id */
    @ApiModelProperty(value="考核主体id",allowEmptyValue=true)
    private String khztid;

    /** 考核主体 */
    @ApiModelProperty(value="考核主体",allowEmptyValue=true)
    private String khztmc;

    /** 考核对象id */
    @ApiModelProperty(value="考核对象id",allowEmptyValue=true)
    private String khdxid;

    /** 考核对象 */
    @ApiModelProperty(value="考核对象",allowEmptyValue=true)
    private String khdxmc;

    /** 考核主体权重 */
    @ApiModelProperty(value="考核主体权重",allowEmptyValue=true)
    private String khztqz;

    /** 考核得分 */
    @ApiModelProperty(value="考核得分",allowEmptyValue=true)
    private String khdf;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}