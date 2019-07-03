package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx01ZbkInfoPO;
import com.boot.repository.Jx01ZbkInfoVO;
import com.boot.repository.Jx01ZbkInfoDAO;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx01ZbkInfoService;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 01指标库 Service
 * @CreateDate 创建时间： 2018-12-26 15:25:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx01ZbkInfoService")
public class Jx01ZbkInfoServiceImpl extends BaseService implements IJx01ZbkInfoService{
    @Autowired
    private Jx01ZbkInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx01ZbkInfoPO.class));
    }

    @Override
    public Iterable<Jx01ZbkInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx01ZbkInfoPO.class);

        Iterable<Jx01ZbkInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx01ZbkInfoVO> jx01ZbkInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx01ZbkInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx01ZbkInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx01ZbkInfoVO> jx01ZbkInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx01ZbkInfoPO> voMap = new HashMap<>(jx01ZbkInfoVOS.size());
        for (Iterator iter = jx01ZbkInfoVOS.iterator(); iter.hasNext(); ) {
            Jx01ZbkInfoVO t = (Jx01ZbkInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx01ZbkInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx01ZbkInfoPO p = (Jx01ZbkInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx01ZbkInfoPO qpo = QJx01ZbkInfoPO.jx01ZbkInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }


    @Override
    public List<Jx01ZbkInfoPO> getByIdArr(List<String> idList) {
        List<Jx01ZbkInfoPO> byIdArr = sdao.getByIdArr(idList);
        return byIdArr;
    }

    @Override
    public List<JSONObject> getZb() {
        List<JSONObject> tdlzbs=new ArrayList<JSONObject>();
        List<String> zbmcs = sdao.getZbmc();
        for(String zbmc:zbmcs){
            JSONObject zb=new JSONObject();
            zb.put("zbmc",zbmc);
            List<Jx01ZbkInfoPO> zbs = sdao.getZb(zbmc);
            zb.put("zbs",zbs);
            tdlzbs.add(zb);
        }
        return tdlzbs;

    }


}