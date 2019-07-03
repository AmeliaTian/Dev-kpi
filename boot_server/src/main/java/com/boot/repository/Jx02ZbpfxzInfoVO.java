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
 * @CreateDate 创建时间： 2019-04-09 15:30:22
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx02ZbpfxzInfoVO/JX02_ZBPFXZ_INFO",description="02指标评分细则")
public class Jx02ZbpfxzInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 指标ID 关联指标 */
    @ApiModelProperty(value="指标ID 关联指标",allowEmptyValue=true)
    private String zbgid;

    /** 算法 */
    @ApiModelProperty(value="算法",allowEmptyValue=true)
    private String sfid;

    /** 明细编号 */
    @ApiModelProperty(value="明细编号",allowEmptyValue=true)
    private String mxbh;

    /** 明细分值 */
    @ApiModelProperty(value="明细分值",allowEmptyValue=true)
    private String mxfz;

    /** 明细名称 */
    @ApiModelProperty(value="明细名称",allowEmptyValue=true)
    private String mxmc;

    /** SFINFO */
    @ApiModelProperty(value="SFINFO",allowEmptyValue=true)
    private String sfinfo;

    /** 算法变量分值  减加分 */
   /* @ApiModelProperty(value="算法变量分值  减加分",allowEmptyValue=true)
    private Double sfblfz;
*/
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