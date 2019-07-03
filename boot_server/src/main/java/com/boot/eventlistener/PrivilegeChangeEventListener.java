package com.boot.eventlistener;

import com.boot.module.auth.principal.AuthShiroService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author h3dwy
 * @Description 资源权限修改事件监听
 * @CreateDate 创建时间：2018-10-17 17:53
 * @ModifiedBy
 * @ModifiedDate
 */

@Component
public class PrivilegeChangeEventListener {
    @Resource(name = "shiroService")
    private AuthShiroService authShiroService;
    @EventListener
    public void eventTrigger(PrivilegeChangeEvent privilegeChangeEvent) {
        //更新权限
        authShiroService.updateAuthPermission();
    }
}
