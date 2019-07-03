package com.boot.module.auth.service;

import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Au04PrivilegeVO;

import java.util.Map;

/**
 * @author CodeGen
 * @Description AU04_权限(资源表)表 Service
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface IAu04PrivilegeService extends IBaseService<Au04PrivilegeVO> {
    /**
     * 将url资源与角色进行拆分拼接
     * ---------
     * 由格式:
     * form/am02FormMetaItem,POST,["A.id"]
     * form/am02FormMetaItem,GET,["A.id","B.id","C.id"]
     * 转换为：
     * "/form/am02FormMetaItem", "restFilter[POST:A,GET:A|B|C]"
     *
     * @return
     */
    Map<String, String> resourcePrivilege();
}