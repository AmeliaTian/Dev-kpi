package com.boot.eventlistener;

import com.boot.module.auth.principal.AuthShiroService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author h3dwy
 * @Description 用户、组织机构、角色权限修改事件
 * @CreateDate 创建时间：2018-10-17 17:53
 * @ModifiedBy
 * @ModifiedDate
 */

@Component
public class UserAuthChangeEventListener {
    @Resource(name = "shiroService")
    private AuthShiroService authShiroService;

    @EventListener
    public void eventTrigger(PrivilegeChangeEvent privilegeChangeEvent) {
        System.out.println("111111111111--------");
        //更新权限
        authShiroService.refreshUserRoles();
    }
}
