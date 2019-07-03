package com.boot.module.auth.bean;

import com.boot.repository.Au03RoleVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CodeGen
 * @Description AU01_系统用户表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@ApiModel(value = "Au01UserVoFilter", description = "AU01_系统用户表对象，过滤敏感字段")
public class Au01UserVoFilter implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID", allowEmptyValue = false)
    private String id;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名", allowEmptyValue = true)
    private String userNameCn;

     /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码", allowEmptyValue = true)
    private String phoneNumber;

    /**
     * EMAIL
     */
    @ApiModelProperty(value = "EMAIL", allowEmptyValue = true)
    private String email;

    /**
     * 直接上级
     */
    @ApiModelProperty(value = "直接上级", allowEmptyValue = true)
    private String directSuperior;

    /**
     * 扩展属性
     */
    @ApiModelProperty(value = "用户扩展属性", allowEmptyValue = true)
    private String userExtend;

    /**
     * 所属角色
     */
    @ApiModelProperty(value = "所属角色", allowEmptyValue = true)
    private Iterable<Au03RoleVO> userRoles;
}