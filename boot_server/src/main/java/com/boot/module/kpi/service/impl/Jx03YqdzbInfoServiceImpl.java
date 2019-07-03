package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx03YqdzbInfoService;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 03已签订指标表 Service
 * @CreateDate 创建时间： 2019-01-09 10:49:45
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx03YqdzbInfoService")
@Transactional
public class Jx03YqdzbInfoServiceImpl extends BaseService implements IJx03YqdzbInfoService{
    @Autowired
    private Jx03YqdzbInfoDAO sdao;
    @Autowired
    private Jx19ZbthyyInfoDAO jx19ZbthyyInfoDAO;
    @Autowired
    private  Jx02ZbpfxzInfoDAO jx02ZbpfxzInfoDAO;
    @Autowired
    private Jx06XjkhjgResultDAO jx06XjkhjgResultDAO;
    @Autowired
    private Jx20ZbwcqkInfoDAO jx20ZbwcqkInfoDAO;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx03YqdzbInfoPO.class));
    }

    @Override
    public Iterable<Jx03YqdzbInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx03YqdzbInfoPO.class);
        Iterable<Jx03YqdzbInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx03YqdzbInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx03YqdzbInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx03YqdzbInfoPO> voMap = new HashMap<>(jx03YqdzbInfoVOS.size());
        for (Iterator iter = jx03YqdzbInfoVOS.iterator(); iter.hasNext(); ) {
            Jx03YqdzbInfoVO t = (Jx03YqdzbInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx03YqdzbInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx03YqdzbInfoPO p = (Jx03YqdzbInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx03YqdzbInfoPO qpo = QJx03YqdzbInfoPO.jx03YqdzbInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public int updateYxbsByid(String id, String updateuser) {
        return sdao.updateYxbsByid(id,updateuser);
    }

    @Override
    public List<ZbEntity> findZb(String khdxid, String khnf) {
        List<ZbEntity> zbEntities=new ArrayList<ZbEntity>();
        List<String> zblxs = sdao.FindZblx(khdxid, khnf);
        for(String zblx:zblxs){
            ZbEntity zbEntity=new ZbEntity();
            zbEntity.setKhnf(khnf);
            zbEntity.setZblx(zblx);
            List<Jx03YqdzbInfoPO> jx03YqdzbInfoPOS = sdao.FindZb(zblx, khnf,khdxid);
            Iterable<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS = ConvertBeanTools.convertGroupToVO(jx03YqdzbInfoPOS, Jx03YqdzbInfoVO.class);
            zbEntity.setJx03YqdzbInfoPOList(jx03YqdzbInfoVOS);
            zbEntities.add(zbEntity);
        }
        return zbEntities;
    }

    @Override
    public List<ZbEntity> findKhZb(String khdxid, String khnf, String khzq) {
        List<ZbEntity> zbEntities=new ArrayList<ZbEntity>();
        List<String> zblxs = sdao.FindKhZblx(khdxid, khnf,khzq);
        for(String zblx:zblxs){
            ZbEntity zbEntity=new ZbEntity();
            zbEntity.setKhnf(khnf);
            zbEntity.setZblx(zblx);
            List<Jx03YqdzbInfoPO> jx03YqdzbInfoPOS = sdao.FindKhZb(zblx, khnf,khdxid,khzq);
            Iterable<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS = ConvertBeanTools.convertGroupToVO(jx03YqdzbInfoPOS, Jx03YqdzbInfoVO.class);
            zbEntity.setJx03YqdzbInfoPOList(jx03YqdzbInfoVOS);
            zbEntities.add(zbEntity);
        }
        return zbEntities;
    }

    @Override
    public Jx03YqdzbInfoPO findById(String id) {
        return sdao.findByid(id);
    }

    @Override
    public List<Jx03YqdzbInfoVO> findZbAndYy(String khdxid, String khnf) {
            List<Jx03YqdzbInfoPO> jx03YqdzbInfoPOS = sdao.FindZb1(khnf,khdxid);
            List<Jx03YqdzbInfoVO> list=new ArrayList<Jx03YqdzbInfoVO>();
            for(Jx03YqdzbInfoPO jx03YqdzbInfoPO:jx03YqdzbInfoPOS){
                Jx03YqdzbInfoVO jx03YqdzbInfoVO = ConvertBeanTools.convertToVO(jx03YqdzbInfoPO, Jx03YqdzbInfoVO.class);
                String zbGid = jx03YqdzbInfoVO.getGid();
                Iterable<Jx19ZbthyyInfoVO> jx19ZbthyyInfoVOS = ConvertBeanTools.convertGroupToVO(jx19ZbthyyInfoDAO.getByZbid(zbGid), Jx19ZbthyyInfoVO.class);
                jx03YqdzbInfoVO.setJx19ZbthyyInfoVOS(jx19ZbthyyInfoVOS);
                list.add(jx03YqdzbInfoVO);
            }
        return list;
    }

    @Override
    public List<Jx03YqdzbInfoPO> getByIdArr(List<String> idList) {
        return sdao.getByIdArr(idList);
    }

    @Override
    /*public List<JSONObject> queryZbAndSf(String khdxid, String khnf,String khzq) {
        List<Jx03YqdzbInfoPO> jx03YqdzbInfoPOS = sdao.queryZb(khnf, khdxid,khzq);
        List<JSONObject> list=new ArrayList<JSONObject>();
        for(Jx03YqdzbInfoPO jx03YqdzbInfoPO:jx03YqdzbInfoPOS){
            JSONObject zb=new JSONObject();
            zb.put("id",jx03YqdzbInfoPO.getId());
            zb.put("khnf",jx03YqdzbInfoPO.getKhnf());
            zb.put("khzq",jx03YqdzbInfoPO.getKhzq());
            zb.put("zbmc",jx03YqdzbInfoPO.getZbmc());
            zb.put("zbdl",jx03YqdzbInfoPO.getZbdl());
            zb.put("zbdy",jx03YqdzbInfoPO.getZbdy());
            zb.put("mbz",jx03YqdzbInfoPO.getMbz());
            zb.put("qz",jx03YqdzbInfoPO.getQz());
            zb.put("pfbz",jx03YqdzbInfoPO.getPfbz());
            zb.put("pflx",jx03YqdzbInfoPO.getPflx());
            String gid = jx03YqdzbInfoPO.getGid();
            List<JSONObject> sfList = jx02ZbpfxzInfoDAO.queryByZbgid(gid, khnf);
            String zbid = jx03YqdzbInfoPO.getId();
            JSONObject zbdf = jx06XjkhjgResultDAO.queryZbdf(zbid, khnf, khzq);
            zb.put("sfList",sfList);
            zb.put("zbdf",zbdf);
            list.add(zb);
        }
        return list;
    }*/
    public List<JSONObject> queryZbAndSf(String khdxid, String khnf,String khzq) {
        //List<Jx03YqdzbInfoPO> jx03YqdzbInfoPOS = sdao.queryZb(khnf, khdxid,khzq);
        List<Jx03YqdzbInfoPO> jx03YqdzbInfoPOS = sdao.queryZb(khnf, khdxid);
        List<JSONObject> list=new ArrayList<JSONObject>();
        for(Jx03YqdzbInfoPO jx03YqdzbInfoPO:jx03YqdzbInfoPOS){
            JSONObject zb=new JSONObject();
            zb.put("id",jx03YqdzbInfoPO.getId());
            zb.put("khnf",jx03YqdzbInfoPO.getKhnf());
            zb.put("khzq",jx03YqdzbInfoPO.getKhzq());
            zb.put("zbmc",jx03YqdzbInfoPO.getZbmc());
            zb.put("zbdl",jx03YqdzbInfoPO.getZbdl());
            zb.put("zbdy",jx03YqdzbInfoPO.getZbdy());
            zb.put("mbz",jx03YqdzbInfoPO.getMbz());
            zb.put("qz",jx03YqdzbInfoPO.getQz());
            zb.put("pfbz",jx03YqdzbInfoPO.getPfbz());
            zb.put("pflx",jx03YqdzbInfoPO.getPflx());
            String gid = jx03YqdzbInfoPO.getGid();
            if(jx03YqdzbInfoPO.getPflx().equals("综合评分")){
                Jx20ZbwcqkInfoPO bySfmxid = jx20ZbwcqkInfoDAO.findBySfmxid(jx03YqdzbInfoPO.getId(), khnf);
                zb.put("sfList",bySfmxid);
            }else{
                List<JSONObject> sfList = jx02ZbpfxzInfoDAO.queryByZbgid(gid, khnf);
                zb.put("sfList",sfList);
            }
            String zbid = jx03YqdzbInfoPO.getId();
            JSONObject zbdf = jx06XjkhjgResultDAO.queryZbdf(zbid, khnf, khzq);
            zb.put("zbdf",zbdf);
            list.add(zb);
        }
        return list;
    }

}