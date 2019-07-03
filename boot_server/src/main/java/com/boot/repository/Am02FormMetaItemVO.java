package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-06 11:12:30
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Am02FormMetaItemVO/AM02_FORM_META_ITEM", description = "AM02_表单内容")
public class Am02FormMetaItemVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 表单ID
     */
    @ApiModelProperty(value = "表单ID", allowEmptyValue = true)
    private String formId;

    /**
     * 顺序号
     */
    @ApiModelProperty(value = "顺序号", allowEmptyValue = true)
    private Integer metaSeq;

    /**
     * 表单项名称
     */
    @ApiModelProperty(value = "表单项名称", allowEmptyValue = true)
    private String metaName;

    /**
     * 表单项编码
     */
    @ApiModelProperty(value = "表单项编码", allowEmptyValue = true)
    private String metaCode;

    /**
     * 表单项类型
     */
    @ApiModelProperty(value = "表单项类型", allowEmptyValue = true)
    private String metaHtmlType;

    /**
     * 是否必填项
     */
    @ApiModelProperty(value = "是否必填项", allowEmptyValue = true)
    private String ifRequired;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示", allowEmptyValue = true)
    private String ifShow;

    /**
     * 是否可编辑
     */
    @ApiModelProperty(value = "是否可编辑", allowEmptyValue = true)
    private String ifCanEdit;

    /**
     * 是否可修改
     */
    @ApiModelProperty(value = "是否可修改", allowEmptyValue = true)
    private String ifCanModify;

    /**
     * 内容校验正则表达式
     */
    @ApiModelProperty(value = "内容校验正则表达式", allowEmptyValue = true)
    private String metaValidate;

    /**
     * 内容校验提示
     */
    @ApiModelProperty(value = "内容校验提示", allowEmptyValue = true)
    private String metaValidateTip;
    /**
     * 自定义样式
     */
    @ApiModelProperty(value = "自定义样式", allowEmptyValue = true)
    private String metaCusClass;

    /**
     * 内容长度
     */
    @ApiModelProperty(value = "内容长度", allowEmptyValue = true)
    private Integer metaValueLength;

    /**
     * 默认值
     */
    @ApiModelProperty(value = "默认值", allowEmptyValue = true)
    private String metaDefaultValue;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", allowEmptyValue = true)
    private String metaDes;

    /**
     * 信息提示
     */
    @ApiModelProperty(value = "信息提示", allowEmptyValue = true)
    private String metaPlaceholder;

    /**
     * 显示宽度
     */
    @ApiModelProperty(value = "显示宽度", allowEmptyValue = true)
    private Integer metaHtmlWidth;

    /**
     * 待选内容
     */
    @ApiModelProperty(value = "待选内容", allowEmptyValue = true)
    private String metaValueList;

    /**
     * 扩展属性
     */
    @ApiModelProperty(value = "扩展属性", allowEmptyValue = true)
    private String metaExtend;
}