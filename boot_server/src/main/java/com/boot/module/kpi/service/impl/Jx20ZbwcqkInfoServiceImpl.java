package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx20ZbwcqkInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 20指标完成情况表 Service
 * @CreateDate 创建时间： 2019-04-17 14:36:59
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx20ZbwcqkInfoService")
public class Jx20ZbwcqkInfoServiceImpl extends BaseService implements IJx20ZbwcqkInfoService{
    @Autowired
    private Jx20ZbwcqkInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx20ZbwcqkInfoPO.class));
    }

    @Override
    public Iterable<Jx20ZbwcqkInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx20ZbwcqkInfoPO.class);

        Iterable<Jx20ZbwcqkInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx20ZbwcqkInfoVO> jx20ZbwcqkInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx20ZbwcqkInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx20ZbwcqkInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx20ZbwcqkInfoVO> jx20ZbwcqkInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx20ZbwcqkInfoPO> voMap = new HashMap<>(jx20ZbwcqkInfoVOS.size());
        for (Iterator iter = jx20ZbwcqkInfoVOS.iterator(); iter.hasNext(); ) {
            Jx20ZbwcqkInfoVO t = (Jx20ZbwcqkInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx20ZbwcqkInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx20ZbwcqkInfoPO p = (Jx20ZbwcqkInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx20ZbwcqkInfoPO qpo = QJx20ZbwcqkInfoPO.jx20ZbwcqkInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }


    @Override
    public Jx20ZbwcqkInfoPO findBySfmxid(String zbid, String khnf) {
        return sdao.findBySfmxid(zbid,khnf);
    }
}