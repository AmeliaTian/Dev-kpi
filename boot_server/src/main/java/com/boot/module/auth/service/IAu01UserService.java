package com.boot.module.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Au01UserPO;
import com.boot.repository.Au01UserVO;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface IAu01UserService extends IBaseService<Au01UserVO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    Au01UserVO queryEntityByUserName(String userName);

    public List<JSONObject> queryByRoleName(String roleName, String khnf, String khzq);

    Au01UserPO findAu01UserPOById(String id);
}