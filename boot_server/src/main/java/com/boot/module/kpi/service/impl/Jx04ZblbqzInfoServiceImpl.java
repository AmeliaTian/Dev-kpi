package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx04ZblbqzInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 04指标类别权重表 Service
 * @CreateDate 创建时间： 2019-03-20 14:53:56
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx04ZblbqzInfoService")
public class Jx04ZblbqzInfoServiceImpl extends BaseService implements IJx04ZblbqzInfoService{
    @Autowired
    private Jx04ZblbqzInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx04ZblbqzInfoPO.class));
    }

    @Override
    public Iterable<Jx04ZblbqzInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx04ZblbqzInfoPO.class);

        Iterable<Jx04ZblbqzInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx04ZblbqzInfoVO> jx04ZblbqzInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx04ZblbqzInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx04ZblbqzInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx04ZblbqzInfoVO> jx04ZblbqzInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx04ZblbqzInfoPO> voMap = new HashMap<>(jx04ZblbqzInfoVOS.size());
        for (Iterator iter = jx04ZblbqzInfoVOS.iterator(); iter.hasNext(); ) {
            Jx04ZblbqzInfoVO t = (Jx04ZblbqzInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx04ZblbqzInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx04ZblbqzInfoPO p = (Jx04ZblbqzInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx04ZblbqzInfoPO qpo = QJx04ZblbqzInfoPO.jx04ZblbqzInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

}