package com.boot.module.file.service.impl;

import com.boot.module.file.service.IAf01FileStoreService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Af01FileStoreDAO;
import com.boot.repository.Af01FileStorePO;
import com.boot.repository.Af01FileStoreVO;
import com.boot.repository.QAf01FileStorePO;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description 针对'AF01_文件存储'的增删改查操作。
 * @CreateDate 创建时间：2018-07-16 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("af01FileStoreService")
public class Af01FileStoreServiceImpl extends BaseService implements IAf01FileStoreService {
    @Autowired
    private Af01FileStoreDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Af01FileStorePO.class));
    }

    /**
     * 根据uuid查询文件
     *
     * @param uuid
     * @return
     */
    @Override
    public Af01FileStoreVO queryAf01FileStore(String uuid) {
        Af01FileStorePO af01FileStorePO = sdao.findByFileUuid(uuid);
        return ConvertBeanTools.convertToVO(af01FileStorePO);
    }

    @Override
    public Iterable<Af01FileStoreVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Af01FileStorePO.class);

        Iterable<Af01FileStorePO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Af01FileStoreVO> af01FileStoreVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Af01FileStorePO> poList = ConvertBeanTools.convertGroupToPO(af01FileStoreVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Af01FileStoreVO> af01FileStoreVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Af01FileStorePO> voMap = new HashMap<>(af01FileStoreVOS.size());
        for (Af01FileStoreVO t : af01FileStoreVOS) {
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        Iterable<Af01FileStorePO> poList = sdao.findAllById(voMap.keySet());
        for (Af01FileStorePO p : poList) {
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAf01FileStorePO qpo = QAf01FileStorePO.af01FileStorePO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }
}
