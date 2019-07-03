package com.boot.module.general.service.impl;

import com.boot.module.general.service.IAt04ChartCfgService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.At04ChartCfgDAO;
import com.boot.repository.At04ChartCfgPO;
import com.boot.repository.At04ChartCfgVO;
import com.boot.repository.QAt04ChartCfgPO;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Description AT04_图表配置 Service
 * @CreateDate 创建时间： 2018-11-21 16:27:47
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("at04ChartCfgService")
public class At04ChartCfgServiceImpl extends BaseService implements IAt04ChartCfgService{
    @Autowired
    private At04ChartCfgDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,At04ChartCfgPO.class));
    }

    @Override
    public Iterable<At04ChartCfgVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,At04ChartCfgPO.class);

        Iterable<At04ChartCfgPO> dataPO = null;
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
    public Integer updateEntity(List<At04ChartCfgVO> at04ChartCfgVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<At04ChartCfgPO> poList = ConvertBeanTools.convertGroupToPO(at04ChartCfgVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<At04ChartCfgVO> at04ChartCfgVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, At04ChartCfgPO> voMap = new HashMap<>(at04ChartCfgVOS.size());
        for (Iterator iter = at04ChartCfgVOS.iterator(); iter.hasNext(); ) {
            At04ChartCfgVO t = (At04ChartCfgVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<At04ChartCfgPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            At04ChartCfgPO p = (At04ChartCfgPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAt04ChartCfgPO qpo = QAt04ChartCfgPO.at04ChartCfgPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

}