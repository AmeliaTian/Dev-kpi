package com.boot.module.auth.service.impl;

import com.boot.module.auth.service.IAu02OrganizationService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.*;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author CodeGen
 * @Description AU02_组织机构表 Service
 * @CreateDate 创建时间： 2018-09-14 10:33:27
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("au02OrganizationService")
public class Au02OrganizationServiceImpl extends BaseService implements IAu02OrganizationService {

    @Autowired
    private Au02OrganizationDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au02OrganizationPO.class));
    }

    @Override
    public Iterable<Au02OrganizationVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au02OrganizationPO.class);

        Iterable<Au02OrganizationPO> dataPO = null;
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
    public Integer updateEntity(List<Au02OrganizationVO> au02OrganizationVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au02OrganizationPO> poList = ConvertBeanTools.convertGroupToPO(au02OrganizationVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au02OrganizationVO> au02OrganizationVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au02OrganizationPO> voMap = new HashMap<>(au02OrganizationVOS.size());
        for (Iterator iter = au02OrganizationVOS.iterator(); iter.hasNext(); ) {
            Au02OrganizationVO t = (Au02OrganizationVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au02OrganizationPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au02OrganizationPO p = (Au02OrganizationPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu02OrganizationPO qpo = QAu02OrganizationPO.au02OrganizationPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }


}
