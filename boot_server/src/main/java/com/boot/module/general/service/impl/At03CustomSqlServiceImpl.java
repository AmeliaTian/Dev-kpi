package com.boot.module.general.service.impl;

import com.boot.module.general.service.IAt03CustomSqlService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.At03CustomSqlDAO;
import com.boot.repository.At03CustomSqlPO;
import com.boot.repository.At03CustomSqlVO;
import com.boot.repository.QAt03CustomSqlPO;
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
 * @Description AT03_自定义SQL Service
 * @CreateDate 创建时间： 2018-09-30 13:32:33
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("at03CustomSqlService")
public class At03CustomSqlServiceImpl extends BaseService implements IAt03CustomSqlService {
    @Autowired
    private At03CustomSqlDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, At03CustomSqlPO.class));
    }

    @Override
    public Iterable<At03CustomSqlVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, At03CustomSqlPO.class);

        Iterable<At03CustomSqlPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    /*如果可编辑(表)，则生成下边的更新操作*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<At03CustomSqlVO> at03CustomSqlVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<At03CustomSqlPO> poList = ConvertBeanTools.convertGroupToPO(at03CustomSqlVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<At03CustomSqlVO> at03CustomSqlVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, At03CustomSqlPO> voMap = new HashMap<>(at03CustomSqlVOS.size());
        for (Iterator iter = at03CustomSqlVOS.iterator(); iter.hasNext(); ) {
            At03CustomSqlVO t = (At03CustomSqlVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<At03CustomSqlPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            At03CustomSqlPO p = (At03CustomSqlPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAt03CustomSqlPO qpo = QAt03CustomSqlPO.at03CustomSqlPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }
}