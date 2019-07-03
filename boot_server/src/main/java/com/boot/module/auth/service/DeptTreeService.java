package com.boot.module.auth.service;

import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Au01UserVO;
import com.boot.repository.DeptTree;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface DeptTreeService extends IBaseService<Au01UserVO> {
   List<DeptTree> queryDeptUserTreeList(String userId,String roleName);

    List<DeptTree> queryDeptUserTreeList1(String userId,String roleName);

    List<DeptTree> queryUserTreeList (String userId,String roleName);
}