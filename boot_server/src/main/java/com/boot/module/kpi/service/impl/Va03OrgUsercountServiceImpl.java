package com.boot.module.kpi.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IVa03OrgUsercountService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description VIEW Service
 * @CreateDate 创建时间： 2019-06-24 15:29:27
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("va03OrgUsercountService")
public class Va03OrgUsercountServiceImpl extends BaseService implements IVa03OrgUsercountService{
    @Autowired
    private Va03OrgUsercountDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Va03OrgUsercountPO.class));
    }

    @Override
    public Iterable<Va03OrgUsercountVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Va03OrgUsercountPO.class);

        Iterable<Va03OrgUsercountPO> dataPO = null;
        if(null==pageable){
            dataPO= sdao.findAll(specification);
        }else{
            dataPO= sdao.findAll(specification, pageable);
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    public Integer updateEntity(List<Va03OrgUsercountVO> va03OrgUsercountVOS) {
        return null;
    }

    @Override
    public Integer saveEntity(List<Va03OrgUsercountVO> va03OrgUsercountVOS) {
        return null;
    }

    @Override
    public Integer removeEntity(List<String> ids) {
        return null;
    }

}