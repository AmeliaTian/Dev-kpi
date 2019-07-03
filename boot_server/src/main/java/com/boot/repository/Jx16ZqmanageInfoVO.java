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
 * @CreateDate 创建时间： 2019-03-06 10:16:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx16ZqmanageInfoVO/JX16_ZQMANAGE_INFO",description="考核周期阶段管理")
public class Jx16ZqmanageInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** JDBH */
    @ApiModelProperty(value="JDBH",allowEmptyValue=true)
    private String jdbh;

    /** JDMC */
    @ApiModelProperty(value="JDMC",allowEmptyValue=true)
    private String jdmc;

    /** YXBS */
    @ApiModelProperty(value="YXBS",allowEmptyValue=true)
    private String yxbs;

    /** UPDATE_TIME */
    @ApiModelProperty(value="UPDATE_TIME",allowEmptyValue=true)
    //日期类型转换json，格式化
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyyMMddHHmmss")
    private Date updateTime;

    /** BZ */
    @ApiModelProperty(value="BZ",allowEmptyValue=true)
    private String bz;

}