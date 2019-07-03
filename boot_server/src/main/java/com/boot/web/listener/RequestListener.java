package com.boot.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author h3dwy
 * @Description ServletRequestListener监听器监听HTTP请求事件，Web服务器接收的每次请求都会通知该监听器
 * ServletContextListener只负责监听Web容器的启动和关闭的事件
 * 主要任务是用ServletRequest将我们的HttpSession携带过去,为websocket使用
 * @CreateDate 创建时间：2018-07-26 9:48
 * @ModifiedBy
 * @ModifiedDate
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        //将所有request请求都携带上httpSession
        ((HttpServletRequest) servletRequestEvent.getServletRequest()).getSession();
    }
}
