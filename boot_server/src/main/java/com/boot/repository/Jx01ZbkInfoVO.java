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
 * @CreateDate 创建时间： 2019-03-25 15:53:17
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="Jx01ZbkInfoVO/JX01_ZBK_INFO",description="01指标库")
public class Jx01ZbkInfoVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 指标类别 */
    @ApiModelProperty(value="指标类别",allowEmptyValue=true)
    private String zblb;

    /** 指标所属部门 */
    @ApiModelProperty(value="指标所属部门",allowEmptyValue=true)
    private String zblsbm;

    /** 所属大类 */
    @ApiModelProperty(value="所属大类",allowEmptyValue=true)
    private String ssdl;

    /** 指标类型 */
    @ApiModelProperty(value="指标类型",allowEmptyValue=true)
    private String zblx;

    /** 指标序号 */
    @ApiModelProperty(value="指标序号",allowEmptyValue=true)
    private Integer zbxh;

    /** 指标名称 */
    @ApiModelProperty(value="指标名称",allowEmptyValue=true)
    private String zbmc;

    /** 指标定义 */
    @ApiModelProperty(value="指标定义",allowEmptyValue=true)
    private String zbdy;

    /** 目标值 */
    @ApiModelProperty(value="目标值",allowEmptyValue=true)
    private String mbz;

    /** 权重 */
    @ApiModelProperty(value="权重",allowEmptyValue=true)
    private String qz;

    /** 评分标准 */
    @ApiModelProperty(value="评分标准",allowEmptyValue=true)
    private String pfbz;

    /** 数据来源 */
    @ApiModelProperty(value="数据来源",allowEmptyValue=true)
    private String sjly;

    /** 指标展现类型 */
    @ApiModelProperty(value="指标展现类型",allowEmptyValue=true)
    private String zbzxlx;

    /** 考核周期 */
    @ApiModelProperty(value="考核周期",allowEmptyValue=true)
    private String khzq;

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

    @ApiModelProperty(value="考核明细",allowEmptyValue=true)
    private List<Jx02ZbpfxzInfoPO> jx02ZbpfxzInfoPOList;

}