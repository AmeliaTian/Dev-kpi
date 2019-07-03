package com.boot.module.websocket.service;

import com.boot.config.WebSocketConfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-07-26 8:49
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
@ServerEndpoint(value = "/websocket/{wsType}", configurator = WebSocketConfig.class)
@Component
public class WebSocketService {

    /**
     * 线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
     */
    private static CopyOnWriteArraySet<Session> webSocketSessionSet = new CopyOnWriteArraySet<>();

    /**
     * 连接建立成功调用的方法
     * wsType从连接url中获取，用于区分同一个系统，不同类型的websocket
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("wsType") String wsType) {
        //用于区分连接的种类
        session.getUserProperties().put("wsType", wsType);
        webSocketSessionSet.add(session);
        log.error(session.getUserProperties().get("userName") + ">建立连接！");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        webSocketSessionSet.remove(session);
        log.error(session.getUserProperties().get("usreName") + ">断开连接！");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        // session.getUserProperties().get("usreName");
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error(session.getId(), error);
    }

    public void sendMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    public boolean sendMessage(String userCode, String message, String wsType) throws IOException {
        boolean flag = false;
        Session session = webSocketSessionSet.stream().filter(sess -> sess.getUserProperties().get("userId").equals(userCode)).findFirst().orElse(null);
        if (null != session && session.isOpen() && canSend(session, wsType)) {
            sendMessage(session, message);
            flag = true;
        }
        return flag;
    }

    public void sendMessageToAll(String message, String wsType) throws IOException {
        for (Session session : webSocketSessionSet) {
            //wsType为空，或session中没有区分type也发送
            if (session.isOpen() && canSend(session, wsType)) {
                sendMessage(session, message);
            }
        }
    }

    private boolean canSend(Session session, String wsType) {
        //如果wsType未定义
        if (StringUtils.isEmpty(wsType)) {
            return true;
        }
        //如果session中未区分type
        if (StringUtils.isEmpty(session.getUserProperties().get("wsType").toString())) {
            return true;
        }
        //如果session中做了区分，type与发送的type相同
        if (session.getUserProperties().get("wsType").equals(wsType)) {
            return true;
        }
        return false;
    }
}
