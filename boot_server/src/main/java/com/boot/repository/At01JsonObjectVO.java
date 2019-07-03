package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description AT01_对象存储表
 * @CreateDate 创建时间：2018-08-13 11:27:27
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "At01JsonObjectVO/AT01_JSON_OBJECT", description = "AT01_对象存储表对象")
public class At01JsonObjectVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称", allowEmptyValue = true)
    private String objType;

    /**
     * 子类别名称
     */
    @ApiModelProperty(value = "子类别名称", allowEmptyValue = true)
    private String objSubType;

    /**
     * 对象描述
     */
    @ApiModelProperty(value = "对象描述", allowEmptyValue = true)
    private String objDes;

    /**
     * 对象内容
     */
    @ApiModelProperty(value = "对象内容", allowEmptyValue = true)
    private String objJson;

}