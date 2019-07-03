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
 * @CreateDate 创建时间： 2019-06-18 17:10:28
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx22UserFileVO/JX22_USER_FILE",description="用户-工作总结文件表")
public class Jx22UserFileVO implements java.io.Serializable {

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

    /** 考核对象 */
    @ApiModelProperty(value="考核对象",allowEmptyValue=true)
    private String khdx;

    /** 考核对象ID */
    @ApiModelProperty(value="考核对象ID",allowEmptyValue=true)
    private String khdxid;

    /** 所属部门 */
    @ApiModelProperty(value="所属部门",allowEmptyValue=true)
    private String ssbm;

    /** 所属部门ID */
    @ApiModelProperty(value="所属部门ID",allowEmptyValue=true)
    private String ssbmid;

    /** 文件名 */
    @ApiModelProperty(value="文件名",allowEmptyValue=true)
    private String fjmc;

    /** 文件地址 */
    @ApiModelProperty(value="文件地址",allowEmptyValue=true)
    private String fjpath;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}