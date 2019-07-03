package com.boot.module.auth.service.impl;

import com.boot.eventlistener.UserAuthChangeEvent;
import com.boot.module.auth.service.IAu12OrgUserService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Au12OrgUserDAO;
import com.boot.repository.Au12OrgUserPO;
import com.boot.repository.Au12OrgUserVO;
import com.boot.repository.QAu12OrgUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description AU12_机构人员映射表 Service
 * @CreateDate 创建时间： 2018-09-13 16:00:19
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("au12OrgUserService")
public class Au12OrgUserServiceImpl extends BaseService implements IAu12OrgUserService {
    //用于注册事件
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Au12OrgUserDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au12OrgUserPO.class));
    }

    @Override
    public Iterable<Au12OrgUserVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au12OrgUserPO.class);

        Iterable<Au12OrgUserPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    /*如果可编辑(是表)，则生成下边的更新操作*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Au12OrgUserVO> au12OrgUserVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au12OrgUserPO> poList = ConvertBeanTools.convertGroupToPO(au12OrgUserVOS, false);
        int count = sdao.saveAll(poList).size();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au12OrgUserVO> au12OrgUserVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au12OrgUserPO> voMap = new HashMap<>(au12OrgUserVOS.size());
        for (Iterator iter = au12OrgUserVOS.iterator(); iter.hasNext(); ) {
            Au12OrgUserVO t = (Au12OrgUserVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au12OrgUserPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au12OrgUserPO p = (Au12OrgUserPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        int count = sdao.saveAll(voMap.values()).size();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu12OrgUserPO qpo = QAu12OrgUserPO.au12OrgUserPO;
        int count = Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
        //发布用户权限变更事件
        applicationContext.publishEvent(new UserAuthChangeEvent(this));
        return count;
    }

}