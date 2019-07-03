package com.boot.module.auth.service.impl;

import com.boot.module.auth.service.IAu03RoleService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Au03RoleDAO;
import com.boot.repository.Au03RolePO;
import com.boot.repository.Au03RoleVO;
import com.boot.repository.QAu03RolePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description 针对'AU03_角色表'的增删改查操作。
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("au03RoleService")
public class Au03RoleServiceImpl extends BaseService implements IAu03RoleService {
    @Autowired
    private Au03RoleDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au03RolePO.class));
    }

    @Override
    public Iterable<Au03RoleVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au03RolePO.class);

        Iterable<Au03RolePO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Au03RoleVO> au03RoleVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au03RolePO> poList = ConvertBeanTools.convertGroupToPO(au03RoleVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au03RoleVO> au03RoleVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au03RolePO> voMap = new HashMap<>(au03RoleVOS.size());
        for (Iterator iter = au03RoleVOS.iterator(); iter.hasNext(); ) {
            Au03RoleVO t = (Au03RoleVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        Iterable<Au03RolePO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au03RolePO p = (Au03RolePO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu03RolePO qpo = QAu03RolePO.au03RolePO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }
}
