package com.boot.module.auth.service.impl;

import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.auth.service.IAu05MenuService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description AU05_菜单表 Service
 * @CreateDate 创建时间： 2019-01-15 17:47:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("au05MenuService")
public class Au05MenuServiceImpl extends BaseService implements IAu05MenuService{
    @Autowired
    private Au05MenuDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Au05MenuPO.class));
    }

    @Override
    public Iterable<Au05MenuVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Au05MenuPO.class);

        Iterable<Au05MenuPO> dataPO = null;
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
    public Integer updateEntity(List<Au05MenuVO> au05MenuVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au05MenuPO> poList = ConvertBeanTools.convertGroupToPO(au05MenuVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Au05MenuVO> au05MenuVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au05MenuPO> voMap = new HashMap<>(au05MenuVOS.size());
        for (Iterator iter = au05MenuVOS.iterator(); iter.hasNext(); ) {
            Au05MenuVO t = (Au05MenuVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au05MenuPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au05MenuPO p = (Au05MenuPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu05MenuPO qpo = QAu05MenuPO.au05MenuPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<Au05MenuPO> getByParentidandRoleid(String roleid, String parentid) {
        return sdao.getByParentidandRoleid(roleid,parentid);
    }

    @Override
    public List<Au05MenuPO> getMenusByHrId(String  userid) {
        return sdao.getMenusByHrId(userid);
    }

    @Override
    public List<Au05MenuPO> getByParentidandRoleid1(List roleids, String parentid) {
        return sdao.getByParentidandRoleid1(roleids,parentid);
    }


}