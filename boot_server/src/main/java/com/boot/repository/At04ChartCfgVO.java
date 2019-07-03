package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @CreateDate 创建时间： 2018-11-21 16:27:47
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@ApiModel(value="At04ChartCfgVO/AT04_CHART_CFG",description="AT04_图表配置")
public class At04ChartCfgVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty(value="ID",allowEmptyValue=false)
    private String id;

    /** 图表标题 */
    @ApiModelProperty(value="图表标题",allowEmptyValue=true)

    private String chartTitle;

    /** 图表OPTION */
    @ApiModelProperty(value="图表OPTION",allowEmptyValue=true)

    private String chartOption;

    /** 图表描述 */
    @ApiModelProperty(value="图表描述",allowEmptyValue=true)

    private String chartDes;

}