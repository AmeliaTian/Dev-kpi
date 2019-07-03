package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx17ZbdlResultService;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx10BmkhjgResultService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author CodeGen
 * @Description 10部门考核结果汇总表（包括各等级人数） Service
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("jx10BmkhjgResultService")
public class Jx10BmkhjgResultServiceImpl extends BaseService implements IJx10BmkhjgResultService {
    @Autowired
    private Jx10BmkhjgResultDAO sdao;
    @Autowired
    private Jx17ZbdlResultDAO jx17ZbdlResultDAO;
    @Autowired
    private Jx23ZzkhzjjgInfoDAO jx23ZzkhzjjgInfoDAO;
    @Autowired
    private Va03OrgUsercountDAO va03OrgUsercountDAO;
    @Autowired
    private Jx13KhdjgjInfoDAO jx13KhdjgjInfoDAO;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Jx10BmkhjgResultPO.class));
    }

    @Override
    public Iterable<Jx10BmkhjgResultVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Jx10BmkhjgResultPO.class);

        Iterable<Jx10BmkhjgResultPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable);
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    /*如果可编辑(表)，则生成下边的更新操作*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Jx10BmkhjgResultVO> jx10BmkhjgResultVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx10BmkhjgResultPO> poList = ConvertBeanTools.convertGroupToPO(jx10BmkhjgResultVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Jx10BmkhjgResultVO> jx10BmkhjgResultVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx10BmkhjgResultPO> voMap = new HashMap<>(jx10BmkhjgResultVOS.size());
        for (Iterator iter = jx10BmkhjgResultVOS.iterator(); iter.hasNext(); ) {
            Jx10BmkhjgResultVO t = (Jx10BmkhjgResultVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx10BmkhjgResultPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx10BmkhjgResultPO p = (Jx10BmkhjgResultPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx10BmkhjgResultPO qpo = QJx10BmkhjgResultPO.jx10BmkhjgResultPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    //获取关键业绩类的最初的成绩（不包含组织占的比重）
    @Override
    public JSONObject addJg(String khnf, String khzq, String khdxid) {
        JSONObject jsonObject = jx17ZbdlResultDAO.queryGjyjjg(khdxid, khnf, khzq);
        return jsonObject;
    }

    //查询所有的等级
    @Override
    public List<String> queryDj(String khnf, String khzq) {
        List<String> strings = jx13KhdjgjInfoDAO.queryDj();
        return strings;
    }

    //获取组织关键业绩类最终的结果
    @Override
    public BigDecimal getGjyjlzzdf(String khnf, String khzq, String khdxid, String orgDesc) {
        if (orgDesc.equals("总部部门")) {
            return sdao.getGjyjlzzdf(khnf, khzq, khdxid);
        } else {
            return sdao.getGjyjlzzdf1(khnf, khzq, khdxid);
        }

    }

    //获取部门考核得分的最终得分
    @Override
    public BigDecimal getZzdf(String khnf, String khzq, String orgId, String orgDesc) {
        return sdao.getZzdf(khnf, khzq, orgId, orgDesc);
    }

    //更新组织关键业绩类最终的结果
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateGjyjldf(String khnf, String khzq, String orgId, BigDecimal gjyjlzzdf) {
        return sdao.updateGjyjldf(khnf, khzq, orgId, gjyjlzzdf);
    }

    //更新部门考核得分的最终得分
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateZzdf(String khnf, String khzq, String orgId, BigDecimal bmkhdf,String khxs) {
        return sdao.updateZzdf(khnf, khzq, orgId, bmkhdf,khxs);
    }

    //获取关联部门的得分
    @Override
    public List<String> getGlbmDf(String khnf, String khzq, String orgId) {
        return sdao.getGlbmDf(khnf, khzq, orgId);
    }

    @Override
    public List<JSONObject> getGlbm(String khnf, String khzq, String orgId) {
        return sdao.getGlbm(khnf, khzq, orgId);
    }

    @Override
    public BigDecimal getBndDf(String khnf, String orgId) {
        return sdao.getBndDf(khnf, orgId);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer updateRS(String khnf, String khzq, String bmid, String bmkhdf) {
        int saveRows=0;
        Double df = Double.parseDouble(bmkhdf);
        int peopleCount = va03OrgUsercountDAO.findPeopleCountById(bmid);
        List<String> djmcs = jx13KhdjgjInfoDAO.queryDj();//查询等级
        //保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if(peopleCount!=0){
            double ysrs=0.0; //预算人数
            for(String djmc:djmcs){//判断等级
                List<Jx13KhdjgjInfoPO> jx13KhdjgjInfoPOS = jx13KhdjgjInfoDAO.queryByDjmc(djmc);
                for(Jx13KhdjgjInfoPO jx13:jx13KhdjgjInfoPOS){
                        if(Double.parseDouble(jx13.getMinbmdf())<=df && df<=Double.parseDouble(jx13.getMaxbmdf())){
                            if(jx13.getDjrsbfb()==null||jx13.getDjrsbfb().equals("")){
                                sdao.updateYsrs(khnf,khzq,bmid,djmc,null);
                            }else{
                                ysrs=peopleCount*Double.parseDouble(jx13.getDjrsbfb())/100;
                                saveRows=sdao.updateYsrs(khnf,khzq,bmid,djmc,decimalFormat.format(ysrs));
                            }
                        }
                }
            }
        }else{
            for(String djmc:djmcs){
                sdao.updateYsrs(khnf,khzq,bmid,djmc,null);
            }
        }
        return saveRows;
    }


}