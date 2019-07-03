package com.boot.module.general.service.impl;

import com.boot.module.general.service.IAt02DataDictionaryService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.At02DataDictionaryDAO;
import com.boot.repository.At02DataDictionaryPO;
import com.boot.repository.At02DataDictionaryVO;
import com.boot.repository.QAt02DataDictionaryPO;
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
 * @Description 针对'AT02_数据字典表'的增删改查操作。
 * @CreateDate 创建时间：2018-08-13 12:41:06
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("at02DataDictionaryService")
public class At02DataDictionaryServiceImpl extends BaseService implements IAt02DataDictionaryService {
    @Autowired
    private At02DataDictionaryDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, At02DataDictionaryPO.class));
    }

    @Override
    public Iterable<At02DataDictionaryVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, At02DataDictionaryPO.class);

        Iterable<At02DataDictionaryPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<At02DataDictionaryVO> at02DataDictionaryVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<At02DataDictionaryPO> poList = ConvertBeanTools.convertGroupToPO(at02DataDictionaryVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<At02DataDictionaryVO> at02DataDictionaryVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, At02DataDictionaryPO> voMap = new HashMap<>(at02DataDictionaryVOS.size());
        for (Iterator iter = at02DataDictionaryVOS.iterator(); iter.hasNext(); ) {
            At02DataDictionaryVO t = (At02DataDictionaryVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<At02DataDictionaryPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            At02DataDictionaryPO p = (At02DataDictionaryPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAt02DataDictionaryPO qpo = QAt02DataDictionaryPO.at02DataDictionaryPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }
}
