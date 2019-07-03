package com.boot.aoplistener;

import com.boot.module.form.service.IAm01FormMetaService;
import com.boot.module.sys.SpringBeanTools;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-10-18 11:28
 * @ModifiedBy
 * @ModifiedDate
 */

public class TestEventListener implements IEventListener {

    @Override
    public boolean eventExecute() {
        IAm01FormMetaService service = (IAm01FormMetaService) SpringBeanTools.getBean("am01FormMetaService");
        System.out.println("--------------================" + (null == service));
        return false;
    }
}
