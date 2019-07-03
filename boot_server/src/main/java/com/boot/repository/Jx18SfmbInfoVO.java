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
 * @CreateDate 创建时间： 2019-04-04 10:40:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx18SfmbInfoVO/JX18_SFMB_INFO",description="算法模板表")
public class Jx18SfmbInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 算法名称 */
    @ApiModelProperty(value="算法名称",allowEmptyValue=true)
    private String sfmc;

    /** 算法标识 */
    @ApiModelProperty(value="算法类型",allowEmptyValue=true)
    private String sflx;

    /** 算法 */
    @ApiModelProperty(value="算法",allowEmptyValue=true)
    private String sf;

    /** 有效标识 */
    @ApiModelProperty(value="有效标识",allowEmptyValue=true)
    private String yxbs;

    /** 备注 */
    @ApiModelProperty(value="备注",allowEmptyValue=true)
    private String bz;

}