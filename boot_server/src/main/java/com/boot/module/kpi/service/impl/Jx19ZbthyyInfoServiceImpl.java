package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx19ZbthyyInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description JX19_ZBTHYY_INFO Service
 * @CreateDate 创建时间： 2019-04-12 10:34:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx19ZbthyyInfoService")
public class Jx19ZbthyyInfoServiceImpl extends BaseService implements IJx19ZbthyyInfoService{
    @Autowired
    private Jx19ZbthyyInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx19ZbthyyInfoPO.class));
    }

    @Override
    public Iterable<Jx19ZbthyyInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx19ZbthyyInfoPO.class);

        Iterable<Jx19ZbthyyInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx19ZbthyyInfoVO> jx19ZbthyyInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx19ZbthyyInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx19ZbthyyInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx19ZbthyyInfoVO> jx19ZbthyyInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx19ZbthyyInfoPO> voMap = new HashMap<>(jx19ZbthyyInfoVOS.size());
        for (Iterator iter = jx19ZbthyyInfoVOS.iterator(); iter.hasNext(); ) {
            Jx19ZbthyyInfoVO t = (Jx19ZbthyyInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx19ZbthyyInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx19ZbthyyInfoPO p = (Jx19ZbthyyInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx19ZbthyyInfoPO qpo = QJx19ZbthyyInfoPO.jx19ZbthyyInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

}