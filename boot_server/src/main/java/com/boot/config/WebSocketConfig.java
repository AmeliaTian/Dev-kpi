package com.boot.config;

import com.boot.repository.Au01UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-07-26 8:46
 * @ModifiedBy
 * @ModifiedDate
 */

@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator {

    /* 修改握手,就是在握手协议建立之前修改其中携带的内容 */
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession session = (HttpSession) request.getHttpSession();
        if (null != session && null != sec) {
            // 将http中session传入websocket session
            // 从SESSION中获取数据,需要在登录时将对应属性放到session中
            Au01UserVO loadUser = (Au01UserVO) session.getAttribute("userAuth");
            if (null != loadUser) {
                sec.getUserProperties().put("userName", loadUser.getUserName());
                sec.getUserProperties().put("userId", loadUser.getId());
            }
        }
        super.modifyHandshake(sec, request, response);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
