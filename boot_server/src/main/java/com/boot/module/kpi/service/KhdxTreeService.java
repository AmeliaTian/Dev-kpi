package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Au01UserVO;
import com.boot.repository.KhdxTree;

import java.util.List;


/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface KhdxTreeService extends IBaseService<Au01UserVO> {
    List<KhdxTree> queryDeptUserTreeList(String khztid, String roleName,String khzq,String khnf,String khlx);
    List<JSONObject> queryKhdx(String khztid, String roleNames,String khzq, String khnf, String khlx);
    List<JSONObject> queryTsry(String khztid, String khzq, String khnf);
}