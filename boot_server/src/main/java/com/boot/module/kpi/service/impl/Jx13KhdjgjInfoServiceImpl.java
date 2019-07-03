package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx13KhdjgjInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 13考核等级系数管理表 Service
 * @CreateDate 创建时间： 2019-05-30 14:55:19
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx13KhdjgjInfoService")
public class Jx13KhdjgjInfoServiceImpl extends BaseService implements IJx13KhdjgjInfoService{
    @Autowired
    private Jx13KhdjgjInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx13KhdjgjInfoPO.class));
    }

    @Override
    public Iterable<Jx13KhdjgjInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx13KhdjgjInfoPO.class);

        Iterable<Jx13KhdjgjInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx13KhdjgjInfoVO> jx13KhdjgjInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx13KhdjgjInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx13KhdjgjInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx13KhdjgjInfoVO> jx13KhdjgjInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx13KhdjgjInfoPO> voMap = new HashMap<>(jx13KhdjgjInfoVOS.size());
        for (Iterator iter = jx13KhdjgjInfoVOS.iterator(); iter.hasNext(); ) {
            Jx13KhdjgjInfoVO t = (Jx13KhdjgjInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx13KhdjgjInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx13KhdjgjInfoPO p = (Jx13KhdjgjInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx13KhdjgjInfoPO qpo = QJx13KhdjgjInfoPO.jx13KhdjgjInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<Jx13KhdjgjInfoPO> queryByDjmc(String djmc) {
        return sdao.queryByDjmc(djmc);
    }
}