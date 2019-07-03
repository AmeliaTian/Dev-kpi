package com.boot.module.form.service.impl;

import com.boot.module.form.service.IAm01FormMetaService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Am01FormMetaDAO;
import com.boot.repository.Am01FormMetaPO;
import com.boot.repository.Am01FormMetaVO;
import com.boot.repository.QAm01FormMetaPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author CodeGen
 * @Description 针对'AM01_表单列表'的增删改查操作。
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("am01FormMetaService")
public class Am01FormMetaServiceImpl extends BaseService implements IAm01FormMetaService {
    @Autowired
    private Am01FormMetaDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Am01FormMetaPO.class));
    }

    @Override
    public Iterable<Am01FormMetaVO> queryEntityByFormCodes(List<String> formCodes) {
        Iterable<Am01FormMetaPO> dataPO = sdao.findByFormCodeIn(formCodes);
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    public Iterable<Am01FormMetaVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Am01FormMetaPO.class);

        Iterable<Am01FormMetaPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Am01FormMetaVO> am01FormMetaVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Am01FormMetaPO> poList = ConvertBeanTools.convertGroupToPO(am01FormMetaVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Am01FormMetaVO> am01FormMetaVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Am01FormMetaPO> voMap = new HashMap<>(am01FormMetaVOS.size());
        for (Iterator iter = am01FormMetaVOS.iterator(); iter.hasNext(); ) {
            Am01FormMetaVO t = (Am01FormMetaVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        Iterable<Am01FormMetaPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Am01FormMetaPO p = (Am01FormMetaPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    //逻辑删除
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAm01FormMetaPO qpo = QAm01FormMetaPO.am01FormMetaPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }
}
