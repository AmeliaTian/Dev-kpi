package com.boot.common;

import com.boot.constant.WebConstants;
import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author h3dwy
 * @CreateDate 生成消息, 向view进行反馈，用于统一消息格式
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Builder
@ApiModel(value = "统一返回对象", description = "向前端提交的统一封装对象")
public class HttpOutMsgBean implements Serializable {

    @ApiModelProperty(value = "返回状态", required = true)
    private WebConstants.RET_MSG_STATE_ENUM msgState;

    @ApiModelProperty(value = "返回类型,(STR字符类描述性文字,OBJ可json解析的对象,ARR可json转为数组或list的对象列表)", allowEmptyValue = true)
    private WebConstants.RET_MSG_TYPE_ENUM msgType;

    @ApiModelProperty(value = "描述", allowEmptyValue = true)
    private String msgDes;

    @ApiModelProperty(value = "返回的具体信息", allowEmptyValue = true)
    private Object msgContent;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
