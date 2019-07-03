package com.boot.module.auth.service.impl;

import com.boot.eventlistener.UserAuthChangeEvent;
import com.boot.module.auth.service.IAu11UserRoleService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Au11UserRoleDAO;
import com.boot.repository.Au11UserRolePO;
import com.boot.repository.Au11UserRoleVO;
import com.boot.repository.QAu11UserRolePO;
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
 * @Description 针对'AU11_用户角色映射表'的增删改查操作。
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("au11UserRoleService")
public class Au11UserRoleServiceImpl extends BaseService implements IAu11UserRoleService {
    //用于注册事件
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Au11UserRoleDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au11UserRolePO.class));
    }

    @Override
    public Iterable<Au11UserRoleVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au11UserRolePO.class);

        Iterable<Au11UserRolePO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Au11UserRoleVO> au11UserRoleVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au11UserRolePO> poList = ConvertBeanTools.convertGroupToPO(au11UserRoleVOS, false);
        int count = sdao.saveAll(poList).size();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au11UserRoleVO> au11UserRoleVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au11UserRolePO> voMap = new HashMap<>(au11UserRoleVOS.size());
        for (Iterator iter = au11UserRoleVOS.iterator(); iter.hasNext(); ) {
            Au11UserRoleVO t = (Au11UserRoleVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        Iterable<Au11UserRolePO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au11UserRolePO p = (Au11UserRolePO) iter.next();
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
        QAu11UserRolePO qpo = QAu11UserRolePO.au11UserRolePO;
        int count = Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }
}
