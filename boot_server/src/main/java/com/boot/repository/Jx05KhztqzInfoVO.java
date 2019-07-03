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
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx05KhztqzInfoVO/JX05_KHZTQZ_INFO",description="05考核主体权重表")
public class Jx05KhztqzInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** KHDXJSID */
    @ApiModelProperty(value="KHDXJSID",allowEmptyValue=true)
    private String khdxjsid;

    /** 考核对象角色 */
    @ApiModelProperty(value="考核对象角色",allowEmptyValue=true)
    private String khdxjs;

    /** 指标大类 */
    @ApiModelProperty(value="指标大类",allowEmptyValue=true)
    private String zbdl;

    /** 指标类型 */
    /*@ApiModelProperty(value="指标类型",allowEmptyValue=true)
    private String zblx;*/

    /** KHZTJSID */
    @ApiModelProperty(value="KHZTJSID",allowEmptyValue=true)
    private String khztjsid;

    /** 考核主体角色 */
    @ApiModelProperty(value="考核主体角色",allowEmptyValue=true)
    private String khztjs;

    /** 权重 */
    @ApiModelProperty(value="权重",allowEmptyValue=true)
    private String qz;

    /** 考核年份 */
    /*@ApiModelProperty(value="考核年份",allowEmptyValue=true)
    private String khnf;*/

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