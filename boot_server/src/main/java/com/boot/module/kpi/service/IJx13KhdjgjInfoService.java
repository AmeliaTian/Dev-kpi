package com.boot.module.kpi.service;

import com.boot.repository.Jx13KhdjgjInfoPO;
import com.boot.repository.Jx13KhdjgjInfoVO;
import com.boot.module.sys.service.IBaseService;


import java.util.List;

/**
 * @Description 13考核等级系数管理表 Service
 * @CreateDate 创建时间： 2019-05-30 14:55:19
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx13KhdjgjInfoService extends IBaseService<Jx13KhdjgjInfoVO> {
    List<Jx13KhdjgjInfoPO> queryByDjmc(String djmc);
}