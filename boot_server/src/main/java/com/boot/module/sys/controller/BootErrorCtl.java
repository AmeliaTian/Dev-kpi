package com.boot.module.sys.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author h3dwy
 * @Description spring boot后台出错，默认显示Whitelabel Error Page，json格式也与规定不一致，因此覆盖原始方法，用于生成统一反馈错误格式
 * @CreateDate 创建时间：2018-07-09 9:30
 * @ModifiedBy
 * @ModifiedDate
 */

@Controller
public class BootErrorCtl implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * 覆盖默认的 Json 响应
     */
    @RequestMapping(value = "/error", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String error(HttpServletRequest request) {
        //false,不显示堆栈信息
        Map<String, Object> errorAttributes = getErrorAttributes(request, false);
        String status = errorAttributes.get("status").toString();
        String message = (String) errorAttributes.get("message");
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgDes(status).msgContent(message).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).build().toString();
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        WebRequest webRequest = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }
}
