package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx23ZzkhzjjgInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 23组织考核中间结果表 Service
 * @CreateDate 创建时间： 2019-06-20 11:47:03
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx23ZzkhzjjgInfoService")
public class Jx23ZzkhzjjgInfoServiceImpl extends BaseService implements IJx23ZzkhzjjgInfoService{
    @Autowired
    private Jx23ZzkhzjjgInfoDAO sdao;
    @Autowired
    private Jx12KhztrwInfoDAO jx12KhztrwInfoDAO;
    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx23ZzkhzjjgInfoPO.class));
    }

   @Override
    public Iterable<Jx23ZzkhzjjgInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx23ZzkhzjjgInfoPO.class);

        Iterable<Jx23ZzkhzjjgInfoPO> dataPO = null;
        if(null==pageable){
            dataPO= sdao.findAll(specification);
        }else{
            dataPO= sdao.findAll(specification, pageable);
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    //重写save方法
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx23ZzkhzjjgInfoVO> jx23ZzkhzjjgInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx23ZzkhzjjgInfoPO> voMap = new HashMap<>(jx23ZzkhzjjgInfoVOS.size());
        for (Iterator iter = jx23ZzkhzjjgInfoVOS.iterator(); iter.hasNext(); ) {
            Jx23ZzkhzjjgInfoVO t = (Jx23ZzkhzjjgInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        //由于id是自动生成，所以此时还没有id，voMap中key为null
        Jx23ZzkhzjjgInfoPO po = voMap.get(null);
        Jx23ZzkhzjjgInfoPO p = sdao.findBy(po.getKhztid(), po.getKhzq(), po.getKhnf(), po.getKhdxid());
        if (p!=null){
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(null), p);
            //替换
            voMap.put(null, p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    /*如果可编辑(表)，则生成下边的更新操作*/
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer updateEntity(List<Jx23ZzkhzjjgInfoVO> jx23ZzkhzjjgInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx23ZzkhzjjgInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx23ZzkhzjjgInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    /*@Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx23ZzkhzjjgInfoVO> jx23ZzkhzjjgInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx23ZzkhzjjgInfoPO> voMap = new HashMap<>(jx23ZzkhzjjgInfoVOS.size());
        for (Iterator iter = jx23ZzkhzjjgInfoVOS.iterator(); iter.hasNext(); ) {
            Jx23ZzkhzjjgInfoVO t = (Jx23ZzkhzjjgInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx23ZzkhzjjgInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx23ZzkhzjjgInfoPO p = (Jx23ZzkhzjjgInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }*/

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx23ZzkhzjjgInfoPO qpo = QJx23ZzkhzjjgInfoPO.jx23ZzkhzjjgInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    //查询组织的半年度考核成绩
    @Override
    public JSONObject getBnddf(String khnf, String khzq, String khdxid) {
        return sdao.getBnddf(khnf, khzq, khdxid);
    }


    @Override
    public List<JSONObject> queryKhdx(String khztid, String khzq, String khnf) {
        List<JSONObject> khdxss = new ArrayList<>();
        List<JSONObject> khdxAll =new ArrayList<>();
        JSONObject jsonObjects = new JSONObject();
        //for (Au02OrganizationPO dt : dList) {
        String[] zblx = {"业绩类", "管理类", "任务类", "党建类", "财务类", "营运类", "创新类", "基础类", "加分类", "重要信息"};

       // List<JSONObject> khdxs = jx12KhztrwInfoDAO.queryYgKhdx(khztid, khnf, khzq,zblx);
        List<JSONObject> khdxs = jx12KhztrwInfoDAO.queryYgKhdx(khztid, khnf, khzq, zblx);
        for (JSONObject khdx : khdxs) {
            String khdxid = khdx.getString("KHDXID");
           // String zbQz = jx12KhztrwInfoDAO.queryZbQz(khdxid, khnf, khzq, khztid);
            List<JSONObject> zblxAndQz = jx12KhztrwInfoDAO.queryZblxAndQz(khdx.getString("KHDXID"), khnf, khzq, khztid);
            khdx.put("KHLXANDQZ",zblxAndQz);
            Jx23ZzkhzjjgInfoPO po = sdao.findBy(khztid,khzq,khnf,khdxid);
            if (po!=null) {
                khdx.put("KHZT", "ykh");
                khdx.put("KHDF",po.getKhdf());
            }else {
                khdx.put("KHZT", "wkh");
                khdx.put("KHDF",null);
            }
            khdxAll.add(khdx);
        }
        jsonObjects.put("KHDXS",khdxAll);
        khdxss.add(jsonObjects);
        return khdxss;
    }

    @Override
    public List<String> getKhztDfs(String khnf, String khzq, String khdxid) {
        return sdao.getKhztDfs(khnf,khzq,khdxid);
    }

}