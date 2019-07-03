package com.boot.module.websocket.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.websocket.service.WebSocketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-07-26 12:29
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
@RestController
@RequestMapping("/websocket")
@Api(tags = "Websocket消息推送", description = "调用Websocket向客户端发送消息")
public class WebSocketCtl {

    @Autowired
    private WebSocketService webSocketService;

    @ApiOperation(value = "向所有用户发送消息", notes = "向所有用户发送消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", required = true, value = "要发送的消息", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "wstype", value = "websocket类别，即前端连接webscoket时，连接地址中的内容;当同一个系统，有多个页面以不同类型连接wbs时使用", dataType = "string", paramType = "query")}
    )
    @RequestMapping(value = "/sendToAll", method = RequestMethod.POST)
    public HttpOutMsgBean sendToAll(@RequestParam(value = "message") String message, @RequestParam(value = "wstype", required = false) String wsType) {
        try {
            webSocketService.sendMessageToAll(message, wsType);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgContent("消息已发送!").build();
        } catch (IOException e) {
            log.error("sendToAll", e);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgContent("批量发送消息出错!").build();
        }
    }

    @ApiOperation(value = "向指定用户发送消息", notes = "向指定用户发送消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", required = true, value = "要发送的消息", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "userId", required = true, value = "向此用户发送消息，输入用户ID", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "wstype", value = "websocket类别，即前端连接webscoket时，连接地址中的内容;当同一个系统，有多个页面以不同类型连接wbs时使用", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/sendToOne", method = RequestMethod.POST)
    public HttpOutMsgBean sendToOne(@RequestParam(value = "message") String message, @RequestParam(value = "userId") String userId, @RequestParam(value = "wstype", required = false) String wsType) {
        try {
            boolean sendState = webSocketService.sendMessage(userId, message, wsType);
            if (sendState) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgContent("消息已发送!").build();
            }
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgContent("未找到对应用户，用户未登录或用户不存在!").build();
        } catch (IOException e) {
            log.error("sendToOne", e);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgContent("发送消息出错!").build();
        }
    }
}
