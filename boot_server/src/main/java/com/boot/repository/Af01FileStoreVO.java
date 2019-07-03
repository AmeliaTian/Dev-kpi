package com.boot.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description AF01_文件存储
 * @CreateDate 创建时间：2018-07-16 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Af01FileStoreVO/AF01_FILE_STORE", description = "AF01_文件存储对象")
public class Af01FileStoreVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称", allowEmptyValue = true)
    private String fileName;

    /**
     * 文件存储ID
     */
    @ApiModelProperty(value = "文件存储ID", allowEmptyValue = true)
    private String fileUuid;

    /**
     * 文件描述
     */
    @ApiModelProperty(value = "文件描述", allowEmptyValue = true)
    private String fileDesc;

    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型", allowEmptyValue = true)
    private String fileType;

    /**
     * 文件大小(字节)
     */
    @ApiModelProperty(value = "文件大小(字节)", allowEmptyValue = true)
    private Integer fileSize;

    /**
     * 文件后缀名
     */
    @ApiModelProperty(value = "文件后缀名", allowEmptyValue = true)
    private String fileSuffix;

    /**
     * 上传人
     */
    @ApiModelProperty(value = "上传人", allowEmptyValue = true)
    private String fileUploadPerson;

}