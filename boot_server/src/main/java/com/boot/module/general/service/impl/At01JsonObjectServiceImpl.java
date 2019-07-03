package com.boot.module.general.service.impl;

import com.boot.module.general.service.IAt01JsonObjectService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.At01JsonObjectDAO;
import com.boot.repository.At01JsonObjectPO;
import com.boot.repository.At01JsonObjectVO;
import com.boot.repository.QAt01JsonObjectPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description 针对'AT01_对象存储表'的增删改查操作。
 * @CreateDate 创建时间：2018-08-13 11:27:28
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("at01JsonObjectService")
public class At01JsonObjectServiceImpl extends BaseService implements IAt01JsonObjectService {
    @Autowired
    private At01JsonObjectDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, At01JsonObjectPO.class));
    }

    @Override
    public Iterable<At01JsonObjectVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, At01JsonObjectPO.class);

        Iterable<At01JsonObjectPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<At01JsonObjectVO> at01JsonObjectVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<At01JsonObjectPO> poList = ConvertBeanTools.convertGroupToPO(at01JsonObjectVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<At01JsonObjectVO> at01JsonObjectVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, At01JsonObjectPO> voMap = new HashMap<>(at01JsonObjectVOS.size());
        for (Iterator iter = at01JsonObjectVOS.iterator(); iter.hasNext(); ) {
            At01JsonObjectVO t = (At01JsonObjectVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<At01JsonObjectPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            At01JsonObjectPO p = (At01JsonObjectPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAt01JsonObjectPO qpo = QAt01JsonObjectPO.at01JsonObjectPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }
}
