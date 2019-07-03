package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx15SpecialUserInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description JX15_SPECIAL_USER_INFO Service
 * @CreateDate 创建时间： 2019-02-14 16:12:35
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx15SpecialUserInfoService")
public class Jx15SpecialUserInfoServiceImpl extends BaseService implements IJx15SpecialUserInfoService{
    @Autowired
    private Jx15SpecialUserInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx15SpecialUserInfoPO.class));
    }

    @Override
    public Iterable<Jx15SpecialUserInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx15SpecialUserInfoPO.class);

        Iterable<Jx15SpecialUserInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx15SpecialUserInfoVO> jx15SpecialUserInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx15SpecialUserInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx15SpecialUserInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx15SpecialUserInfoVO> jx15SpecialUserInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx15SpecialUserInfoPO> voMap = new HashMap<>(jx15SpecialUserInfoVOS.size());
        for (Iterator iter = jx15SpecialUserInfoVOS.iterator(); iter.hasNext(); ) {
            Jx15SpecialUserInfoVO t = (Jx15SpecialUserInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx15SpecialUserInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx15SpecialUserInfoPO p = (Jx15SpecialUserInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx15SpecialUserInfoPO qpo = QJx15SpecialUserInfoPO.jx15SpecialUserInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

   /* @Override
    public List<String> getByKhdxIdAndKhnf(String khdxid, String khnf) {
        return sdao.getByKhdxIdAndKhnf(khdxid,khnf);
    }*/
}