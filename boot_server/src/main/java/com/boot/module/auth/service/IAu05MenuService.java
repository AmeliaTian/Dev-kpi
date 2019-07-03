package com.boot.module.auth.service;

import com.boot.repository.Au05MenuPO;
import com.boot.repository.Au05MenuVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description AU05_菜单表 Service
 * @CreateDate 创建时间： 2019-01-15 17:47:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IAu05MenuService extends IBaseService<Au05MenuVO> {
    List<Au05MenuPO> getByParentidandRoleid(String roleid,String parentid);
    List<Au05MenuPO> getMenusByHrId(String  userid);
    List<Au05MenuPO> getByParentidandRoleid1(List roleids,String parentid);
}