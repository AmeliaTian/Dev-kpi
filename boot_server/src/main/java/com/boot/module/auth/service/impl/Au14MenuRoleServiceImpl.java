package com.boot.module.auth.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.auth.service.IAu14MenuRoleService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description AU14_菜单角色映射表 Service
 * @CreateDate 创建时间： 2019-01-15 17:56:52
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("au14MenuRoleService")
public class Au14MenuRoleServiceImpl extends BaseService implements IAu14MenuRoleService{
    @Autowired
    private Au14MenuRoleDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Au14MenuRolePO.class));
    }

    @Override
    public Iterable<Au14MenuRoleVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Au14MenuRolePO.class);

        Iterable<Au14MenuRolePO> dataPO = null;
        if(null==pageable){
            dataPO= sdao.findAll(specification);
        }else{
            dataPO= sdao.findAll(specification, pageable);
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    /*如果可编辑(表)，则生成下边的更新操作*/
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer updateEntity(List<Au14MenuRoleVO> au14MenuRoleVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au14MenuRolePO> poList = ConvertBeanTools.convertGroupToPO(au14MenuRoleVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Au14MenuRoleVO> au14MenuRoleVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au14MenuRolePO> voMap = new HashMap<>(au14MenuRoleVOS.size());
        for (Iterator iter = au14MenuRoleVOS.iterator(); iter.hasNext(); ) {
            Au14MenuRoleVO t = (Au14MenuRoleVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au14MenuRolePO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au14MenuRolePO p = (Au14MenuRolePO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu14MenuRolePO qpo = QAu14MenuRolePO.au14MenuRolePO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

}