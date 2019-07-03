package com.boot.module.sys.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;

/**
 * @author h3dwy
 * @Description 全局Web访问异常处理类
 * @CreateDate 创建时间：2018-04-27 13:36
 * @ModifiedBy
 * @ModifiedDate
 */

@ControllerAdvice
@ResponseBody
public class WebExceptionCtl {
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public HttpOutMsgBean handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("请求无法解析").msgContent(e.getMessage()).build();
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public HttpOutMsgBean handleValidationException(MethodArgumentNotValidException e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("输入参数错误").msgContent(e.getMessage()).build();
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public HttpOutMsgBean handleValidationException(ValidationException e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("参数验证错误").msgContent(e.getMessage()).build();
    }

    /**
     * 401 -UNAUTHORIZED
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public HttpOutMsgBean handleUnAuthorizedException(Exception e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("未授权访问").msgContent(e.getMessage()).build();
    }

    /**
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public HttpOutMsgBean handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("不支持的请求方法").msgContent(e.getMessage()).build();
    }

    /**
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public HttpOutMsgBean handleHttpMediaTypeNotSupportedException(Exception e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("不支持的请求类型").msgContent(e.getMessage()).build();
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public HttpOutMsgBean handleException(Exception e) {
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("服务访问错误").msgContent(e.getMessage()).build();
    }
}
