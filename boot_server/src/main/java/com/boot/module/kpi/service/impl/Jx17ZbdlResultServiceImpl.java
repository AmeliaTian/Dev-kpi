package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx17ZbdlResultService;
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
 * @Description 考核得分中间表(指标大类得分) Service
 * @CreateDate 创建时间： 2019-05-29 13:47:02
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx17ZbdlResultService")
public class Jx17ZbdlResultServiceImpl extends BaseService implements IJx17ZbdlResultService{
    @Autowired
    private Jx17ZbdlResultDAO sdao;
    @Autowired
    private Jx12KhztrwInfoDAO jx12KhztrwInfoDAO;
    @Resource(name = "jx17ZbdlResultService")
    private IJx17ZbdlResultService jx17ZbdlResultService;
    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx17ZbdlResultPO.class));
    }

    @Override
    public Iterable<Jx17ZbdlResultVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx17ZbdlResultPO.class);

        Iterable<Jx17ZbdlResultPO> dataPO = null;
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
    public Integer updateEntity(List<Jx17ZbdlResultVO> jx17ZbdlResultVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx17ZbdlResultPO> poList = ConvertBeanTools.convertGroupToPO(jx17ZbdlResultVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx17ZbdlResultVO> jx17ZbdlResultVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx17ZbdlResultPO> voMap = new HashMap<>(jx17ZbdlResultVOS.size());
        for (Iterator iter = jx17ZbdlResultVOS.iterator(); iter.hasNext(); ) {
            Jx17ZbdlResultVO t = (Jx17ZbdlResultVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx17ZbdlResultPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx17ZbdlResultPO p = (Jx17ZbdlResultPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx17ZbdlResultPO qpo = QJx17ZbdlResultPO.jx17ZbdlResultPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public int addZbdlJg(String khnf, String khzq, String khdxid) {
        //判断是否所有的考核任务都已经完成
        List<String> dfs = jx12KhztrwInfoDAO.queryDf(khdxid, khnf, khzq);
        Integer saveRows=0;
        boolean contains = dfs.contains(null);
        //boolean aa = dfs.contains("");
        //boolean cc = dfs.contains(" ");
        if(dfs.contains(null)==false){//如果没有包含null  则还有没有完成的考核任务x
            // 1.生成个指标大类的得分 17表
            List<JSONObject> jsonObjects = jx12KhztrwInfoDAO.queryZbdlDf(khdxid, khnf, khzq);
            List<Jx17ZbdlResultVO> jx17ZbdlResultVOS=new ArrayList<Jx17ZbdlResultVO>();
            for(JSONObject o:jsonObjects){
                Jx17ZbdlResultVO jx17ZbdlResultVO=new Jx17ZbdlResultVO();
                jx17ZbdlResultVO.setKhdxid(khdxid);
                jx17ZbdlResultVO.setKhdxmc(o.getString("KHDX"));
                jx17ZbdlResultVO.setKhdxjsid(o.getString("KHDXJS"));
                DecimalFormat format = new DecimalFormat("0.00");
                jx17ZbdlResultVO.setDf(format.format(new BigDecimal(o.getString("ZBDLDF"))));
                jx17ZbdlResultVO.setZbdl(o.getString("ZBLX"));
                jx17ZbdlResultVO.setKhnf(khnf);
                jx17ZbdlResultVO.setKhzq(khzq);
                jx17ZbdlResultVOS.add(jx17ZbdlResultVO);
                saveRows = jx17ZbdlResultService.saveEntity(jx17ZbdlResultVOS);
            }
            return saveRows;
        }else{//如果全都考核完成
            return saveRows;
        }
    }

    @Override
    public int addZcsrl(String khnf, String khzq, String khdxid) {
        //判断是否所有的考核任务都已经完成
        List<String> dfs = jx12KhztrwInfoDAO.queryDf(khdxid, khnf, khzq);
        Integer saveRows=0;
        boolean contains = dfs.contains(null);
        if(dfs.contains(null)==false){//如果完成考核任务
            // 1.生成个指标大类的得分 17表
            List<JSONObject> jsonObjects = jx12KhztrwInfoDAO.querySrlDf(khdxid, khnf, khzq);
            List<Jx17ZbdlResultVO> jx17ZbdlResultVOS=new ArrayList<Jx17ZbdlResultVO>();
            for(JSONObject o:jsonObjects){
                Jx17ZbdlResultVO jx17ZbdlResultVO=new Jx17ZbdlResultVO();
                jx17ZbdlResultVO.setKhdxid(khdxid);
                jx17ZbdlResultVO.setKhdxmc(o.getString("KHDX"));
                jx17ZbdlResultVO.setKhdxjsid(o.getString("KHDXJS"));
                jx17ZbdlResultVO.setDf(o.getString("ZBDLDF"));
                jx17ZbdlResultVO.setZbdl(o.getString("ZBLX"));
                jx17ZbdlResultVO.setKhnf(khnf);
                jx17ZbdlResultVO.setKhzq(khzq);
                jx17ZbdlResultVOS.add(jx17ZbdlResultVO);
                saveRows = jx17ZbdlResultService.saveEntity(jx17ZbdlResultVOS);
            }
            return saveRows;
        }else{//如果没有考核完成
            return saveRows;
        }
    }

    @Override
    public JSONObject getDjInfo(String khdxid, String khnf, String khzq) {
        return sdao.getDjInfo(khdxid,khnf,khzq);
    }


}