package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.kpi.service.IJx07XjkhcjhzResultService;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CodeGen
 * @Description 07绩效考核汇总表 Service
 * @CreateDate 创建时间： 2019-03-04 11:17:20
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("jx07XjkhcjhzResultService")
public class Jx07XjkhcjhzResultServiceImpl extends BaseService implements IJx07XjkhcjhzResultService {
    @Autowired
    private Jx07XjkhcjhzResultDAO sdao;
    @Autowired
    private Jx17ZbdlResultDAO jx17ZbdlResultDAO;
    @Autowired
    private Jx10BmkhjgResultDAO jx10BmkhjgResultDAO;
    @Autowired
    private Va03OrgUsercountDAO va03OrgUsercountDAO;
    @Autowired
    private Jx13KhdjgjInfoDAO jx13KhdjgjInfoDAO;
    @Autowired
    private Jx12KhztrwInfoDAO jx12KhztrwInfoDAO;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Jx07XjkhcjhzResultPO.class));
    }

    @Override
    public Iterable<Jx07XjkhcjhzResultVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Jx07XjkhcjhzResultPO.class);

        Iterable<Jx07XjkhcjhzResultPO> dataPO = null;
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
    public Integer updateEntity(List<Jx07XjkhcjhzResultVO> jx07XjkhcjhzResultVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx07XjkhcjhzResultPO> poList = ConvertBeanTools.convertGroupToPO(jx07XjkhcjhzResultVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Jx07XjkhcjhzResultVO> jx07XjkhcjhzResultVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx07XjkhcjhzResultPO> voMap = new HashMap<>(jx07XjkhcjhzResultVOS.size());
        for (Iterator iter = jx07XjkhcjhzResultVOS.iterator(); iter.hasNext(); ) {
            Jx07XjkhcjhzResultVO t = (Jx07XjkhcjhzResultVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx07XjkhcjhzResultPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx07XjkhcjhzResultPO p = (Jx07XjkhcjhzResultPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx07XjkhcjhzResultPO qpo = QJx07XjkhcjhzResultPO.jx07XjkhcjhzResultPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }


    @Override
    public List<JSONObject> queryKhjg(String userId, String roleName, String khnf, String khzq, String khdxlx) {
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        if (khdxlx.indexOf("员工") != -1) {//考核对象为员工  结果只显示员工
            if (roleName.indexOf("正职") != -1 || roleName.indexOf("副职") != -1) {
                jsonObjects = sdao.queryKhjg(khnf, khzq, userId);
            } else if ((roleName.indexOf("公司董事长")) != -1
                    || (roleName.indexOf("公司领导")) != -1
                    || (roleName.indexOf("系统管理员")) != -1
                    || (roleName.indexOf("公司总经理")) != -1
                    || (roleName.indexOf("分管领导")) != -1) {
                jsonObjects = sdao.queryKhjg(khnf, khzq);
            }
        } else if (khdxlx.indexOf("中层") != -1) {//如果是中层领导 只显示中层
            jsonObjects = sdao.queryKhjgZc(khnf, khzq);
        }

        return jsonObjects;
    }

    @Override
    public List<JSONObject> queryKhjg(String khdxId, String khnf) {
        return sdao.queryByKhdxId(khdxId, khnf);
    }

    @Override
    public List<JSONObject> queryDjCount(String khnf, String khzq, String bmmc) {
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        if (bmmc.indexOf("全部") != -1) {
            jsonObjects = sdao.queryDjCount(khnf, khzq);
        } else {
            jsonObjects = sdao.queryDjCount(khnf, khzq, bmmc);
        }
        return jsonObjects;
    }

    @Override
    public List<JSONObject> queryFsCount(String khnf, String khzq, String bmmc) {
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        if (bmmc.indexOf("全部") != -1) {
            jsonObjects = sdao.queryFsCount(khnf, khzq);
        } else {
            jsonObjects = sdao.queryFsCount(khnf, khzq, bmmc);
        }
        return jsonObjects;
    }

    //获取员工的最终得分
    @Override
    public String getYgDf(String khdxid, String khnf, String khzq) {
        return jx17ZbdlResultDAO.getYgDf(khdxid, khnf, khzq);
    }

    @Override
    public String getZcNdDf(String khdxid, String khnf, String khzq, String khdxjs, String bmmc) {
        return jx17ZbdlResultDAO.getZcNdDf(khdxid, khnf, khzq, khdxjs, bmmc);
    }

    @Override
    /**
     * 在员工考核页面  先判断部门有没有考核成绩
     */
    public int updateDj(String khdxid, String khnf, String khzq, String bmmc, String khdxjs) {
        int saveRows = 0;
        //先判断部门成绩  如果没有成绩不操作，
        List<Jx10BmkhjgResultPO> zzcj = jx10BmkhjgResultDAO.getZzcj(khnf, khzq, bmmc);
        //如果部门成绩不为空 判断该部门的所有员工是否都考核完成
        if (zzcj.size() != 0 && !StringUtils.isEmpty(zzcj.get(0).getBmkhdf())) {
            List<JSONObject> ygDfDj = sdao.getAllYgDf(khnf, khzq, khdxid);
            boolean wkhFlag = false;//全部已考核
            boolean wdjFlag = false;//员工有等级
            for (JSONObject dj : ygDfDj) {
                if (dj.getString("KHDF") == null) {//考核得分出现null  则为未考核完成
                    wkhFlag = true;
                }
                if (dj.getString("ZZDJ") == null) {
                    wdjFlag = true;
                }
            }
            if (!wkhFlag) {//全部考核完成
                if (wdjFlag) {//只要出现一个无等级的  执行生成等级方法
                    saveRows = this.jsDj(khnf, khzq, bmmc, zzcj);
                }
            }
        }
        return saveRows;
    }


    /**
     * 在部门考核页面  判断员工有没有分数和等级
     */
    @Override
    public int updateDj(String khnf, String khzq, String bmmc, String bmid) {
        int saveRows = 0;
        Integer peopleCountById = va03OrgUsercountDAO.findPeopleCountById(bmid);
        if (peopleCountById != 0) {//判断部门总人数  如果不等于0 则执行
            List<JSONObject> allYgDf = sdao.getAllYgDf1(khnf, khzq, bmid);//查询需要考核的员工得分和等级
            boolean wkhFlag = false;//全部已考核
            boolean wdjFlag = false;//员工有等级
            for (JSONObject dj : allYgDf) {
                if (dj.getString("KHDF") == null) {//考核得分出现null  则为未考核完成
                    wkhFlag = true;
                }
                if (dj.getString("ZZDJ") == null) {
                    wdjFlag = true;
                }
            }
            if (!wkhFlag) {//全部考核完成
                if (wdjFlag) {//只要出现一个无等级的  执行生成等级方法
                    List<Jx10BmkhjgResultPO> zzcj = jx10BmkhjgResultDAO.getZzcj(khnf, khzq, bmmc);
                    saveRows = this.jsDj(khnf, khzq, bmmc, zzcj);
                }
            }
        }
        return saveRows;
    }


    public int jsDj(String khnf, String khzq, String bmmc, List<Jx10BmkhjgResultPO> zzcj) {
        //排序
        List<Jx07XjkhcjhzResultPO> jx07XjkhcjhzResultPOS = sdao.findByBmmc(khnf, khzq, bmmc);
        //查询人数
        String[] djs = {"卓越", "优秀", "不合格", "称职"};
        double ysrsZY = 0.0;
        double ysrsYX = 0.0;
        double ysrsBHG = 0.0;
        for (Jx10BmkhjgResultPO jx10 : zzcj) {
            if (jx10.getDjmc().equals(djs[0])) {//获取卓越的预算人数
                if (jx10.getYsrs() == null) {
                    ysrsZY = 0;
                } else {
                    ysrsZY = Math.floor(Double.parseDouble(jx10.getYsrs()));
                }
            } else if (jx10.getDjmc().equals(djs[1])) {//获取优秀的预算人数
                if (jx10.getYsrs() == null) {
                    ysrsYX = 0;
                } else {
                    ysrsYX = Math.floor(Double.parseDouble(jx10.getYsrs()));
                }
            } else if (jx10.getDjmc().equals(djs[2])) {
                if (jx10.getYsrs() == null) {
                    ysrsBHG = 0;
                } else {
                    ysrsBHG = Math.floor(Double.parseDouble(jx10.getYsrs()));
                }
            }
        }
        double ysrsCZ = Math.round(va03OrgUsercountDAO.findByOrgName(bmmc) - ysrsZY - ysrsYX - ysrsBHG);//获取称职的人数  为总人数减去卓越、优秀、不合格的人数

        //更新等级为卓越的员工信息
        String khjf=jx13KhdjgjInfoDAO.queryByDjmc(djs[0]).get(0).getJxjf();
        jx07XjkhcjhzResultPOS.stream().limit((long) ysrsZY).forEach(p -> p.setKhdj(djs[0]));
        jx07XjkhcjhzResultPOS.stream().limit((long) ysrsZY).forEach(p -> p.setZzdj(djs[0]));
        jx07XjkhcjhzResultPOS.stream().limit((long) ysrsZY).forEach(p -> p.setJxjf(khjf));
        jx07XjkhcjhzResultPOS.stream().limit((long) ysrsZY).forEach(p -> p.setKhxs(jx13KhdjgjInfoDAO.queryByDjmc(djs[0]).get(0).getJxxs()));
        //更新等级为优秀的员工信息
        jx07XjkhcjhzResultPOS.stream().skip((long) ysrsZY).limit((long) ysrsYX).forEach(p -> p.setKhdj(djs[1]));
        jx07XjkhcjhzResultPOS.stream().skip((long) ysrsZY).limit((long) ysrsYX).forEach(p -> p.setZzdj(djs[1]));
        jx07XjkhcjhzResultPOS.stream().skip((long) ysrsZY).limit((long) ysrsYX).forEach(p -> p.setJxjf(jx13KhdjgjInfoDAO.queryByDjmc(djs[1]).get(0).getJxjf()));
        jx07XjkhcjhzResultPOS.stream().skip((long) ysrsZY).limit((long) ysrsYX).forEach(p -> p.setKhxs(jx13KhdjgjInfoDAO.queryByDjmc(djs[1]).get(0).getJxxs()));
        //更新等级为称职的员工信息
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX)).limit((long) ysrsCZ).forEach(p -> p.setKhdj(djs[3]));
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX)).limit((long) ysrsCZ).forEach(p -> p.setZzdj(djs[3]));
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX)).limit((long) ysrsCZ).forEach(p -> p.setJxjf(jx13KhdjgjInfoDAO.queryByDjmc(djs[3]).get(0).getJxjf()));
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX)).limit((long) ysrsCZ).forEach(p -> p.setKhxs(jx13KhdjgjInfoDAO.queryByDjmc(djs[3]).get(0).getJxxs()));
        //更新等级为不合格的员工信息
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX + ysrsCZ)).limit((long) ysrsBHG).forEach(p -> p.setKhdj(djs[2]));
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX + ysrsCZ)).limit((long) ysrsBHG).forEach(p -> p.setZzdj(djs[2]));
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX + ysrsCZ)).limit((long) ysrsBHG).forEach(p -> p.setJxjf(jx13KhdjgjInfoDAO.queryByDjmc(djs[2]).get(0).getJxjf()));
        jx07XjkhcjhzResultPOS.stream().skip((long) (ysrsZY + ysrsYX + ysrsCZ)).limit((long) ysrsBHG).forEach(p -> p.setKhxs(jx13KhdjgjInfoDAO.queryByDjmc(djs[2]).get(0).getJxxs()));
        jx07XjkhcjhzResultPOS.stream().forEach(p -> p.setUpdatetime(new Date()));
        return sdao.saveAll(jx07XjkhcjhzResultPOS).size();
    }

    @Override
    public String addTeShu(String khdxId, String khdxName, String khdxLb, String khnf, String khzq, String khdxjs, String bmmc) {
        List<String> strings = jx12KhztrwInfoDAO.queryDf(khdxId, khnf, khzq);
        boolean b = strings==null || strings.contains(null) || strings.contains("");
        if (strings==null||strings.size()==0||strings.contains(null) || strings.contains("")){
            return "还有未打分";
        }else {
            List<Jx12KhztrwInfoPO> jx12KhztrwInfoPOS = jx12KhztrwInfoDAO.queryByKhdxid(khdxId, khnf, khzq);
            Double zf = 0.0;
            for (Jx12KhztrwInfoPO po:jx12KhztrwInfoPOS
                    ) {
                zf+=Double.parseDouble(po.getKhdf())*Double.parseDouble(po.getKhztqz())/100;
            }
            String khdj=null;
            if (zf>=100)
                khdj="卓越";
            else if (zf>=90)
                khdj="优秀";
            else if (zf>=80)
                khdj="称职";
            else if (zf>=70)
                khdj="待改进";
            else
                khdj="不合格";
            Jx07XjkhcjhzResultPO jx07XjkhcjhzResultPO = new Jx07XjkhcjhzResultPO();
            jx07XjkhcjhzResultPO.setKhnf(khnf);
            jx07XjkhcjhzResultPO.setKhzq(khzq);
            jx07XjkhcjhzResultPO.setKhdxlb(khdxLb);
            jx07XjkhcjhzResultPO.setKhdxmc(khdxName);
            jx07XjkhcjhzResultPO.setKhdxid(khdxId);
//            jx07XjkhcjhzResultPO.setKhdxjsid();
            jx07XjkhcjhzResultPO.setKhdxjs(khdxjs);
            jx07XjkhcjhzResultPO.setBmmc(bmmc);
            jx07XjkhcjhzResultPO.setKhdf(String.format("%.2f", zf));
            jx07XjkhcjhzResultPO.setKhdj(khdj);
            jx07XjkhcjhzResultPO.setZzdj(khdj);
            sdao.save(jx07XjkhcjhzResultPO);
            return "success";
        }
    }


    /*@Override
    public List<JSONObject> getKhdjFenPei(String khnf, String khzq) {
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        List<String> bmmcs = au02OrganizationDAO.queryBmmc();
//        String[] bmmcs = {"人力资源部",""};
        for (String bmmc:bmmcs
                ) {
            List<JSONObject> khdjs= sdao.getKhdjRs(khnf,khzq,bmmc);
            Map<String,Object> map = new HashMap<>();
            map.put(bmmc, khdjs);
            jsonObjects.add(new JSONObject(map));
        }
        return jsonObjects;
    }*/
}