package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx05KhztqzInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author CodeGen
 * @Description 05考核主体权重表 Service
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("jx05KhztqzInfoService")
public class Jx05KhztqzInfoServiceImpl extends BaseService implements IJx05KhztqzInfoService {
    @Autowired
    private Jx05KhztqzInfoDAO sdao;
    @Autowired
    private Au01UserDAO au01UserDAO;
    @Autowired
    private Au02OrganizationDAO au02OrganizationDAO;
    @Autowired
    private  Au03RoleDAO au03RoleDAO;
    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Jx05KhztqzInfoPO.class));
    }

    @Override
    public Iterable<Jx05KhztqzInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Jx05KhztqzInfoPO.class);

        Iterable<Jx05KhztqzInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx05KhztqzInfoVO> jx05KhztqzInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx05KhztqzInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx05KhztqzInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Jx05KhztqzInfoVO> jx05KhztqzInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx05KhztqzInfoPO> voMap = new HashMap<>(jx05KhztqzInfoVOS.size());
        for (Iterator iter = jx05KhztqzInfoVOS.iterator(); iter.hasNext(); ) {
            Jx05KhztqzInfoVO t = (Jx05KhztqzInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx05KhztqzInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx05KhztqzInfoPO p = (Jx05KhztqzInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx05KhztqzInfoPO qpo = QJx05KhztqzInfoPO.jx05KhztqzInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<Jx05KhztqzInfoPO> findByKhdxjsId(String khdxjsid) {
        return sdao.findByKhdxjsId(khdxjsid);
    }

    public List<JSONObject> queryUserInfo(String userid, String roleid,String orgId,String zsldid,String zblx) {
        List<JSONObject> list = new ArrayList<JSONObject>();
        if (StringUtils.isEmpty(roleid)) {//如果是组织的话  roleid 为null
            JSONObject dep = new JSONObject();
            dep.put("ROLE_NAME", "人力资源管理委员会");
            List<JSONObject> jsonObjects = sdao.queryUserZz();
            dep.put("USER_LIST", jsonObjects);
            list.add(dep);
        } else if (roleid.equals("42CBTEE0P8N4")) {//如果是员工的话  判断直接上级是正职还是副职
            List<JSONObject> khzts=new ArrayList<JSONObject>();
            if(zblx.equals("关键业绩类")){//如果是业绩类 查询正副职及分管领导
                JSONObject khztjs = new JSONObject();
                List<JSONObject> userList=new ArrayList<JSONObject>();
                khzts = sdao.queryYg(roleid, "","关键业绩类");
                khztjs.put("khztjs", khzts.get(0).get("KHZTJSID") + "-" + khzts.get(0).get("KHZTJS"));
                khztjs.put("qz", khzts.get(0).get("QZ"));
                List<JSONObject> fglds = au02OrganizationDAO.queryOrgFgld(orgId);
                for(JSONObject fgld:fglds){
                    userList.add(fgld);
                }
                String[] ids={"42CELDUPTKW0","42CRAX4V3FGG","4742LUXLX4W0","4742NSLOGVLS"};
                List<JSONObject> leaders = au01UserDAO.queryByOrgidAndroleName(orgId, ids);//查询部门的所有正职和副职
                //List<JSONObject> leaders = au01UserDAO.getZjld(orgId,userid);
                for(JSONObject leader:leaders){
                    userList.add(leader);
                }
                khztjs.put("USER_LIST",userList);
                list.add(khztjs);
            }else if(zblx.equals("态度类")){//如果是态度类
                List<JSONObject> jsonObjects = au03RoleDAO.queryByUserid(zsldid);//查询直接领导的职位
                //如果直接领导为正职
                if(jsonObjects.get(0).getString("ROLE_NAME").indexOf("正职")!=-1){
                    //查询所有的领导
                    khzts = sdao.queryYg(roleid, "正","态度类");
                }else if(jsonObjects.get(0).getString("ROLE_NAME").indexOf("副职")!=-1){
                    khzts = sdao.queryYg(roleid, "副","态度类");
                }
                for (JSONObject o : khzts) {
                    List<JSONObject> userList=new ArrayList<JSONObject>();
                    JSONObject khztjs = new JSONObject();
                    khztjs.put("khztjs", o.get("KHZTJSID") + "-" + o.get("KHZTJS"));
                    khztjs.put("qz", o.get("QZ"));
                    if(o.getString("KHZTJS").indexOf("分管领导")!=-1){//查询分管领导
                        List<JSONObject> fglds = au02OrganizationDAO.queryOrgFgld(orgId);
                        for(JSONObject fgld:fglds){
                            userList.add(fgld);
                        }
                    }else if(o.getString("KHZTJS").indexOf("正职")!=-1){//查询正副职
                        //String[] ids={o.getString("KHZTJSID")};
                        //List<JSONObject> leaders = au01UserDAO.queryByOrgidAndroleName(orgId,ids);
                        List<JSONObject> leaders = au01UserDAO.getZzld(orgId);
                        for(JSONObject jsonObject:leaders){
                            userList.add(jsonObject);
                        }
                    }else {
                        List<JSONObject> leaders = au01UserDAO.getFzLd(orgId, userid);
                        for(JSONObject jsonObject:leaders){
                            userList.add(jsonObject);
                        }
                    }
                    khztjs.put("USER_LIST",userList);
                    list.add(khztjs);
                }

            }
        } else {//如果是正副职   //查询考核主体
            List<JSONObject> khzts = sdao.queryByKhdxjsId(roleid);
            for (JSONObject o : khzts) {
                JSONObject khztjs = new JSONObject();
                khztjs.put("khztjs", o.get("KHZTJSID") + "-" + o.get("KHZTJS"));
                khztjs.put("qz", o.get("QZ"));
                if (o.getString("KHZTJS").equals("公司董事长") || o.getString("KHZTJS").equals("公司总经理")||o.getString("KHZTJS").indexOf("公司领导")!=-1) {
                    List<JSONObject> khztUsers = au01UserDAO.queryByRoleName(o.getString("KHZTJS"));
                    khztjs.put("khztUsers", khztUsers);
                } else if (o.getString("KHZTJS").equals("分管领导")) {
                    List<JSONObject> fglds = au02OrganizationDAO.queryOrgFgld(orgId);
                    khztjs.put("khztUsers", fglds);
                }else if(o.getString("KHZTJS").equals("总部各部门")){
                    //查询所有的总部部门
                    List<Au02OrganizationPO> depByZbbm = au02OrganizationDAO.findDepByZbbm();
                    List<JSONObject> users=new ArrayList<>();
                    for(Au02OrganizationPO org:depByZbbm){
                        //根据部门id查询正副职 分管领导
                        JSONObject user =new JSONObject();
                        user.put("depid",org.getId());
                        user.put("depName",org.getOrgName());
                        //查询正副职
                        //String[] ids={"42CELDUPTKW0","42CRAX4V3FGG"};
                        String[] ids={"42CELDUPTKW0"};
                        List<JSONObject> leaders = au01UserDAO.queryByOrgidAndroleName(org.getId(), ids);
                        //如果没有正职 在查询副职和分管领导
                        if(leaders.size()==0){
                            //查询分管领导
                            List<JSONObject> fglds = au02OrganizationDAO.queryOrgFgld(org.getId());
                            user.put("fglds",fglds);
                            //查询副职
                            String[] idsa={"42CRAX4V3FGG"};
                            List<JSONObject> leadersa = au01UserDAO.queryByOrgidAndroleName(org.getId(), idsa);
                            user.put("lesders",leadersa);
                        }else{
                            user.put("fglds",null);
                            user.put("lesders",leaders);
                        }
                        users.add(user);
                    }
                    khztjs.put("khztUsers", users);
                }else if(roleid.equals("42CELDUPTKW0")&o.getString("KHZTJS").equals("所属公司正职")){//总部部门正职查询所属公司正职 查所有的所属公司正职 副职 分管领导
                    List<Au02OrganizationPO> depBySsgs = au02OrganizationDAO.findDepBySsgs();
                    List<JSONObject> users=new ArrayList<>();
                    for(Au02OrganizationPO org:depBySsgs){
                        JSONObject ssgsUsers=new JSONObject();
                        ssgsUsers.put("depid",org.getId());
                        ssgsUsers.put("depName",org.getOrgName());
                        //根据部门id查询正副职
                        //String[] ids={"4742LUXLX4W0","4742NSLOGVLS"};
                        String[] ids={"4742LUXLX4W0"};
                        List<JSONObject> leaders = au01UserDAO.queryByOrgidAndroleName(org.getId(),ids);
                        if(leaders.size()==0){
                            //查询分管领导
                            List<JSONObject> fglds = au02OrganizationDAO.queryOrgFgld(org.getId());
                            ssgsUsers.put("fglds",fglds);
                            String[] idsb={"4742NSLOGVLS"};
                            List<JSONObject> leadersb = au01UserDAO.queryByOrgidAndroleName(org.getId(),idsb);
                            ssgsUsers.put("lesders",leadersb);
                        }else{
                            ssgsUsers.put("fglds",null);
                            ssgsUsers.put("lesders",leaders);
                        }


                        users.add(ssgsUsers);
                    }
                    khztjs.put("khztUsers", users);
                }else if(roleid.equals("4742NSLOGVLS")&o.getString("KHZTJS").equals("所属公司正职")){//考核对象为所属公司副职 查询本部门的正职和分管领导
                    String[] ids={o.getString("KHZTJSID")};
                    List<JSONObject> jsonObjects = au01UserDAO.queryByOrgidAndroleName(orgId,ids);
                    khztjs.put("khztUsers", jsonObjects);
                }else if(o.getString("KHZTJS").equals("总部部门正职")){
                    String[] ids={o.getString("KHZTJSID")};
                    List<JSONObject> jsonObjects = au01UserDAO.queryByOrgidAndroleName(orgId,ids);
                    khztjs.put("khztUsers", jsonObjects);
                }
                list.add(khztjs);
            }
        }
        return list;
    }
}