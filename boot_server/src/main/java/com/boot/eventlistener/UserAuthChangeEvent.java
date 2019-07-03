package com.boot.eventlistener;

import org.springframework.context.ApplicationEvent;

/**
 * @author h3dwy
 * @Description 用户、组织机构、角色权限修改事件
 * @CreateDate 创建时间：2018-10-17 17:48
 * @ModifiedBy
 * @ModifiedDate
 */

public class UserAuthChangeEvent extends ApplicationEvent {
    public UserAuthChangeEvent(Object source) {
        super(source);
    }
}
