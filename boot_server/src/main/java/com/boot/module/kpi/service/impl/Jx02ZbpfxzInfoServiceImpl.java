package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx02ZbpfxzInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 02指标评分细则 Service
 * @CreateDate 创建时间： 2019-04-09 15:30:22
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx02ZbpfxzInfoService")
public class Jx02ZbpfxzInfoServiceImpl extends BaseService implements IJx02ZbpfxzInfoService{
    @Autowired
    private Jx02ZbpfxzInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx02ZbpfxzInfoPO.class));
    }

    @Override
    public Iterable<Jx02ZbpfxzInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx02ZbpfxzInfoPO.class);

        Iterable<Jx02ZbpfxzInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx02ZbpfxzInfoVO> jx02ZbpfxzInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx02ZbpfxzInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx02ZbpfxzInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx02ZbpfxzInfoVO> jx02ZbpfxzInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx02ZbpfxzInfoPO> voMap = new HashMap<>(jx02ZbpfxzInfoVOS.size());
        for (Iterator iter = jx02ZbpfxzInfoVOS.iterator(); iter.hasNext(); ) {
            Jx02ZbpfxzInfoVO t = (Jx02ZbpfxzInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx02ZbpfxzInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx02ZbpfxzInfoPO p = (Jx02ZbpfxzInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx02ZbpfxzInfoPO qpo = QJx02ZbpfxzInfoPO.jx02ZbpfxzInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<String> findIdByGid(String zbgid) {
        return sdao.findIdByGid(zbgid);
    }
}