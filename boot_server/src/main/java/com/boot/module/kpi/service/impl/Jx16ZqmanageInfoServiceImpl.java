package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx16ZqmanageInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 考核周期阶段管理 Service
 * @CreateDate 创建时间： 2019-03-06 10:16:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx16ZqmanageInfoService")
public class Jx16ZqmanageInfoServiceImpl extends BaseService implements IJx16ZqmanageInfoService{
    @Autowired
    private Jx16ZqmanageInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx16ZqmanageInfoPO.class));
    }

    @Override
    public Iterable<Jx16ZqmanageInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx16ZqmanageInfoPO.class);

        Iterable<Jx16ZqmanageInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx16ZqmanageInfoVO> jx16ZqmanageInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx16ZqmanageInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx16ZqmanageInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx16ZqmanageInfoVO> jx16ZqmanageInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx16ZqmanageInfoPO> voMap = new HashMap<>(jx16ZqmanageInfoVOS.size());
        for (Iterator iter = jx16ZqmanageInfoVOS.iterator(); iter.hasNext(); ) {
            Jx16ZqmanageInfoVO t = (Jx16ZqmanageInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx16ZqmanageInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx16ZqmanageInfoPO p = (Jx16ZqmanageInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx16ZqmanageInfoPO qpo = QJx16ZqmanageInfoPO.jx16ZqmanageInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<Jx16ZqmanageInfoPO> queryAll() {
        return sdao.queryAll();
    }
}