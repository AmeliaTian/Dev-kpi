package com.boot.module.auth.service.impl;

import com.boot.eventlistener.UserAuthChangeEvent;
import com.boot.module.auth.service.IAu13OrgRoleService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Au13OrgRoleDAO;
import com.boot.repository.Au13OrgRolePO;
import com.boot.repository.Au13OrgRoleVO;
import com.boot.repository.QAu13OrgRolePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description AU13_机构角色映射表 Service
 * @CreateDate 创建时间： 2018-09-13 16:00:38
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("au13OrgRoleService")
public class Au13OrgRoleServiceImpl extends BaseService implements IAu13OrgRoleService {
    //用于注册事件
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Au13OrgRoleDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au13OrgRolePO.class));
    }

    @Override
    public Iterable<Au13OrgRoleVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au13OrgRolePO.class);

        Iterable<Au13OrgRolePO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    /*如果可编辑(是表)，则生成下边的更新操作*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Au13OrgRoleVO> au13OrgRoleVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au13OrgRolePO> poList = ConvertBeanTools.convertGroupToPO(au13OrgRoleVOS, false);
        int count = sdao.saveAll(poList).size();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au13OrgRoleVO> au13OrgRoleVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au13OrgRolePO> voMap = new HashMap<>(au13OrgRoleVOS.size());
        for (Iterator iter = au13OrgRoleVOS.iterator(); iter.hasNext(); ) {
            Au13OrgRoleVO t = (Au13OrgRoleVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au13OrgRolePO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au13OrgRolePO p = (Au13OrgRolePO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        int count = sdao.saveAll(voMap.values()).size();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu13OrgRolePO qpo = QAu13OrgRolePO.au13OrgRolePO;
        int count = Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }
}