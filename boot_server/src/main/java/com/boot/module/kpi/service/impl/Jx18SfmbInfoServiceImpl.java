package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx18SfmbInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 算法模板表 Service
 * @CreateDate 创建时间： 2019-04-04 10:40:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx18SfmbInfoService")
public class Jx18SfmbInfoServiceImpl extends BaseService implements IJx18SfmbInfoService{
    @Autowired
    private Jx18SfmbInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx18SfmbInfoPO.class));
    }

    @Override
    public Iterable<Jx18SfmbInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx18SfmbInfoPO.class);

        Iterable<Jx18SfmbInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx18SfmbInfoVO> jx18SfmbInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx18SfmbInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx18SfmbInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx18SfmbInfoVO> jx18SfmbInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx18SfmbInfoPO> voMap = new HashMap<>(jx18SfmbInfoVOS.size());
        for (Iterator iter = jx18SfmbInfoVOS.iterator(); iter.hasNext(); ) {
            Jx18SfmbInfoVO t = (Jx18SfmbInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx18SfmbInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx18SfmbInfoPO p = (Jx18SfmbInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx18SfmbInfoPO qpo = QJx18SfmbInfoPO.jx18SfmbInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

}