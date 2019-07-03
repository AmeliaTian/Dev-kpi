package com.boot.module.form.service.impl;

import com.boot.module.form.service.IAm02FormMetaItemService;
import com.boot.module.general.service.CustomNativeSqlService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.Am02FormMetaItemDAO;
import com.boot.repository.Am02FormMetaItemPO;
import com.boot.repository.Am02FormMetaItemVO;
import com.boot.repository.QAm02FormMetaItemPO;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author CodeGen
 * @Description 针对'AM02_表单内容'的增删改查操作。
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("am02FormMetaItemService")
public class Am02FormMetaItemServiceImpl extends BaseService implements IAm02FormMetaItemService {

    @Autowired
    private Am02FormMetaItemDAO sdao;
    @Resource(name = "customNativeSqlService")
    private CustomNativeSqlService customSqlService;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Am02FormMetaItemPO.class));
    }

    @Override
    public Iterable<Am02FormMetaItemVO> queryEntityByFormId(String formId) {
        Iterable<Am02FormMetaItemPO> dataPO = sdao.findByFormId(formId);
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    public Iterable<Am02FormMetaItemVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Am02FormMetaItemPO.class);

        Iterable<Am02FormMetaItemPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Am02FormMetaItemVO> am02FormMetaItemVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Am02FormMetaItemPO> poList = ConvertBeanTools.convertGroupToPO(am02FormMetaItemVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Am02FormMetaItemVO> am02FormMetaItemVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Am02FormMetaItemPO> voMap = new HashMap<>(am02FormMetaItemVOS.size());
        for (Iterator iter = am02FormMetaItemVOS.iterator(); iter.hasNext(); ) {
            Am02FormMetaItemVO t = (Am02FormMetaItemVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        Iterable<Am02FormMetaItemPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Am02FormMetaItemPO p = (Am02FormMetaItemPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAm02FormMetaItemPO qpo = QAm02FormMetaItemPO.am02FormMetaItemPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    /**
     * 特选列表中可以输入sql，判断如果为sql，则从数据库中加载后，填充回对象中
     *
     * @param metaList
     * @param keepOrgin 是否转换
     * @return
     */
    @Override
    public Iterable<Am02FormMetaItemVO> loadMetaValueListFromDb(Iterable<Am02FormMetaItemVO> metaList, boolean keepOrgin) {
        //如果为true,则保持原样，不转换，为了提供前台配置
        if (keepOrgin) {
            return metaList;
        }
        for (Am02FormMetaItemVO metaObj : metaList) {
            //"metaValueList": "[\"ODB\"]"  "metaExtend":"select a value,b label from table";
            if ("[\"ODB\"]".equals(metaObj.getMetaValueList()) && StringUtils.isNotEmpty(metaObj.getMetaExtend())) {
                List<Map<String, Object>> result = customSqlService.queryBySqlMapParams(metaObj.getMetaExtend(), null);

                if (null != result && result.size() > 0) {
                    List<String> valList = new ArrayList<>();
                    for (Map<String, Object> map : result) {
                        if (null == map.get("value") || null == map.get("label")) {
                            continue;
                        }
                        valList.add(map.get("value") + "|" + map.get("label"));
                    }
                    metaObj.setMetaValueList(new Gson().toJson(valList));
                }
            }
        }
        return metaList;
    }
}
