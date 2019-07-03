package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx06XjkhjgResultService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 06绩效考核结果明细表 Service
 * @CreateDate 创建时间： 2019-04-28 09:20:56
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx06XjkhjgResultService")
public class Jx06XjkhjgResultServiceImpl extends BaseService implements IJx06XjkhjgResultService{
    @Autowired
    private Jx06XjkhjgResultDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx06XjkhjgResultPO.class));
    }

    @Override
    public Iterable<Jx06XjkhjgResultVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx06XjkhjgResultPO.class);

        Iterable<Jx06XjkhjgResultPO> dataPO = null;
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
    public Integer updateEntity(List<Jx06XjkhjgResultVO> jx06XjkhjgResultVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx06XjkhjgResultPO> poList = ConvertBeanTools.convertGroupToPO(jx06XjkhjgResultVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx06XjkhjgResultVO> jx06XjkhjgResultVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx06XjkhjgResultPO> voMap = new HashMap<>(jx06XjkhjgResultVOS.size());
        for (Iterator iter = jx06XjkhjgResultVOS.iterator(); iter.hasNext(); ) {
            Jx06XjkhjgResultVO t = (Jx06XjkhjgResultVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx06XjkhjgResultPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx06XjkhjgResultPO p = (Jx06XjkhjgResultPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx06XjkhjgResultPO qpo = QJx06XjkhjgResultPO.jx06XjkhjgResultPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<JSONObject> queryDf(String khnf, String khzq, String khdxId, String khztId, String khdxLb,String zblx) {
        return sdao.queryDf(khnf,khzq,khztId,khdxId,zblx,khdxLb);
    }
}