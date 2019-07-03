package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author CodeGen
 * @Description AM01_表单列表
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Am01FormMetaVO/AM01_FORM_META", description = "AM01_表单列表对象")
public class Am01FormMetaVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 表单名称
     */
    @ApiModelProperty(value = "表单名称", allowEmptyValue = true)
    private String formName;

    /**
     * 所属分类
     */
    @ApiModelProperty(value = "所属分类", allowEmptyValue = true)
    private String formType;

    /**
     * 表单编码
     */
    @ApiModelProperty(value = "表单编码", allowEmptyValue = true)
    private String formCode;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", allowEmptyValue = true)
    private String formDes;

    /**
     * 字段
     */
    @ApiModelProperty(value = "字段列表", allowEmptyValue = true)
    private List<Am02FormMetaItemVO> formItems;
}