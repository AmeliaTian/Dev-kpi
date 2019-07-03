package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-30 13:32:33
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "At03CustomSqlVO/AT03_CUSTOM_SQL", description = "AT03_自定义SQL")
public class At03CustomSqlVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * SQL标题
     */
    @ApiModelProperty(value = "SQL标题", allowEmptyValue = true)
    private String sqlTitle;

    /**
     * SQL语句
     */
    @ApiModelProperty(value = "SQL语句", allowEmptyValue = true)
    private String sqlContent;

    /**
     * SQL描述
     */
    @ApiModelProperty(value = "SQL描述", allowEmptyValue = true)
    private String sqlDes;

    /**
     * SQL操作
     */
    @ApiModelProperty(value = "SQL操作,QUERY/EDIT", allowEmptyValue = true)
    private String sqlAction;
}