package com.boot.eventlistener;

import org.springframework.context.ApplicationEvent;

/**
 * @author h3dwy
 * @Description 资源权限修改事件
 * @CreateDate 创建时间：2018-10-17 17:48
 * @ModifiedBy
 * @ModifiedDate
 */

public class PrivilegeChangeEvent extends ApplicationEvent {
    public PrivilegeChangeEvent(Object source) {
        super(source);
    }
}
