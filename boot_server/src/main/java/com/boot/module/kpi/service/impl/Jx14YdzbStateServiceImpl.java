package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx14YdzbStateService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description JX14_YDZB_STATE Service
 * @CreateDate 创建时间： 2019-04-04 10:38:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx14YdzbStateService")
public class Jx14YdzbStateServiceImpl extends BaseService implements IJx14YdzbStateService{
    @Autowired
    private Jx14YdzbStateDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx14YdzbStatePO.class));
    }

    @Override
    public Iterable<Jx14YdzbStateVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx14YdzbStatePO.class);

        Iterable<Jx14YdzbStatePO> dataPO = null;
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
    public Integer updateEntity(List<Jx14YdzbStateVO> jx14YdzbStateVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx14YdzbStatePO> poList = ConvertBeanTools.convertGroupToPO(jx14YdzbStateVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx14YdzbStateVO> jx14YdzbStateVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx14YdzbStatePO> voMap = new HashMap<>(jx14YdzbStateVOS.size());
        for (Iterator iter = jx14YdzbStateVOS.iterator(); iter.hasNext(); ) {
            Jx14YdzbStateVO t = (Jx14YdzbStateVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx14YdzbStatePO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx14YdzbStatePO p = (Jx14YdzbStatePO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx14YdzbStatePO qpo = QJx14YdzbStatePO.jx14YdzbStatePO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public int updateYxbsByid(String khdxid, String khnf) {
        return sdao.updateYxbsByid(khdxid,khnf);
    }
}