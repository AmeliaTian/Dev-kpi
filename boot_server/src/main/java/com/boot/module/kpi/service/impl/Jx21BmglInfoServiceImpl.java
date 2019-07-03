package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx21BmglInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 部门管理表 Service
 * @CreateDate 创建时间： 2019-05-29 13:46:33
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx21BmglInfoService")
public class Jx21BmglInfoServiceImpl extends BaseService implements IJx21BmglInfoService{
    @Autowired
    private Jx21BmglInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx21BmglInfoPO.class));
    }

    @Override
    public Iterable<Jx21BmglInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx21BmglInfoPO.class);

        Iterable<Jx21BmglInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx21BmglInfoVO> jx21BmglInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx21BmglInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx21BmglInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx21BmglInfoVO> jx21BmglInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx21BmglInfoPO> voMap = new HashMap<>(jx21BmglInfoVOS.size());
        for (Iterator iter = jx21BmglInfoVOS.iterator(); iter.hasNext(); ) {
            Jx21BmglInfoVO t = (Jx21BmglInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx21BmglInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx21BmglInfoPO p = (Jx21BmglInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx21BmglInfoPO qpo = QJx21BmglInfoPO.jx21BmglInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

}