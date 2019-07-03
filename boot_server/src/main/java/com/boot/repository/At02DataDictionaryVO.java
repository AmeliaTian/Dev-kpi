package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description AT02_数据字典表
 * @CreateDate 创建时间：2018-08-13 12:41:06
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "At02DataDictionaryVO/AT02_DATA_DICTIONARY", description = "AT02_数据字典表对象")
public class At02DataDictionaryVO implements java.io.Serializable {

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
    private String dictTid;

    /**
     * 顺序号
     */
    @ApiModelProperty(value = "顺序号", allowEmptyValue = true)
    private Integer dictSeq;

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称", allowEmptyValue = true)
    private String dictName;

    /**
     * 字典编码
     */
    @ApiModelProperty(value = "字典编码", allowEmptyValue = true)
    private String dictCode;

    /**
     * 字典项描述
     */
    @ApiModelProperty(value = "字典项描述", allowEmptyValue = true)
    private String dictDes;

}