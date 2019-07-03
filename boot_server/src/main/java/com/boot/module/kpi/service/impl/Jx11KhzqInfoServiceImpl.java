package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx11KhzqInfoService;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 11绩效考核周期管理 Service
 * @CreateDate 创建时间： 2019-03-04 13:54:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx11KhzqInfoService")
public class Jx11KhzqInfoServiceImpl extends BaseService implements IJx11KhzqInfoService{
    @Autowired
    private Jx11KhzqInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx11KhzqInfoPO.class));
    }

    @Override
    public Iterable<Jx11KhzqInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx11KhzqInfoPO.class);

        Iterable<Jx11KhzqInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx11KhzqInfoVO> jx11KhzqInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx11KhzqInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx11KhzqInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx11KhzqInfoVO> jx11KhzqInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx11KhzqInfoPO> voMap = new HashMap<>(jx11KhzqInfoVOS.size());
        for (Iterator iter = jx11KhzqInfoVOS.iterator(); iter.hasNext(); ) {
            Jx11KhzqInfoVO t = (Jx11KhzqInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx11KhzqInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx11KhzqInfoPO p = (Jx11KhzqInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx11KhzqInfoPO qpo = QJx11KhzqInfoPO.jx11KhzqInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public Jx11KhzqInfoPO findJx11KhzqInfoPOByKhnf(String khnf, String khjdbh) {
        return sdao.findJx11KhzqInfoPOByKhnf(khnf,khjdbh);
    }

    @Override
    public List<Jx11KhzqInfoPO> queryByKhnf(String sTime, String eTime) {
        return sdao.queryByKhnf(sTime,eTime);
    }

    @Override
    public String getMaxKhnf() {
        return sdao.getMaxKhnf();
    }

    @Override
    public List<Jx11KhzqInfoPO> queryByMaxKhnf() {
        return sdao.queryByMaxKhnf();
    }

    /*@Override
    public int updateYjkssj(String khnf, String khjdbh, String startTime) {
        return sdao.updateYjkssj(khnf,khjdbh,startTime);
    }

    @Override
    public int updateYjjssj(String khnf, String khjdbh, String endTime) {
        return sdao.updateYjjssj(khnf,khjdbh,endTime);
    }*/
}