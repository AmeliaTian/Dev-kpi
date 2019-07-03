package com.boot.module.kpi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.kpi.service.IJx12KhztrwInfoService;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 12考核主体任务表 Service
 * @CreateDate 创建时间： 2019-02-14 16:11:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx12KhztrwInfoService")
public class Jx12KhztrwInfoServiceImpl extends BaseService implements IJx12KhztrwInfoService{
    @Autowired
    private Jx12KhztrwInfoDAO sdao;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx12KhztrwInfoPO.class));
    }

    @Override
    public Iterable<Jx12KhztrwInfoVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx12KhztrwInfoPO.class);
        Iterable<Jx12KhztrwInfoPO> dataPO = null;
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
    public Integer updateEntity(List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx12KhztrwInfoPO> poList = ConvertBeanTools.convertGroupToPO(jx12KhztrwInfoVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx12KhztrwInfoPO> voMap = new HashMap<>(jx12KhztrwInfoVOS.size());
        for (Iterator iter = jx12KhztrwInfoVOS.iterator(); iter.hasNext(); ) {
            Jx12KhztrwInfoVO t = (Jx12KhztrwInfoVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Jx12KhztrwInfoPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx12KhztrwInfoPO p = (Jx12KhztrwInfoPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx12KhztrwInfoPO qpo = QJx12KhztrwInfoPO.jx12KhztrwInfoPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<String> getJx12ByKhdxIdAndKhnf(String khdxid, String khnf,String khzq,String[] zblb) {
        return sdao.getJx12ByKhdxIdAndKhnf(khdxid,khnf,khzq,zblb);
    }

    @Override
    public List<String> getJx12ByKhdxIdAndKhnf(String khdxid, String khnf, String khzq) {
        return sdao.getJx12ByKhdxIdAndKhnf(khdxid,khnf,khzq);
    }

    @Override
    public List<Jx12KhztrwInfoPO> queryAll(String khzq,String khnf) {
        return sdao.queryAll(khzq,khnf);
    }

    @Override
    public int updateDf(String khdf, String khdxid, String khztid, String khnf, String khzq, String zblx) {
        return sdao.updateDf(khdf,khdxid,khztid,khnf,khzq,zblx);
    }

    @Override
    public List<String> getId(String khdxid, String khnf, String khzq, String[] zblb, String khztid) {
        return sdao.getId(khdxid, khnf, khzq, zblb, khztid);
    }

    /*@Override
    public int updateYxbsByid(String id, String khztId, String khztName, String khztQz) {
        return sdao.updateYxbsByid(id,khztId,khztName,khztQz);
    }*/

    /*@Override
    public void addRws() {
        //List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS=new ArrayList<Jx12KhztrwInfoVO>();
        List<Au03RolePO> roles = au03RoleDAO.findAll();
        for(int i=0;i<roles.size();i++){

            String khztjsid=roles.get(i).getId();
            List<Au11UserRolePO> leaders = au11UserRoleDAO.findByRoleId(khztjsid);
            List khdxInfos =null;
            System.out.println(roles.get(i).getRoleName());
            if(roles.get(i).getRoleName().equals("公司董事长")){
                leaderInfo=au01UserDAO.findAu01UserPOById(leaders.get(0).getUserId());
                khdxInfos = sdao.getKhdxInfo(khztjsid);
                add(khdxInfos);
            }else if(roles.get(i).getRoleName().equals("分管领导")){
               // System.out.println("1111111111=========分管领导");
                for(Au11UserRolePO leader:leaders){
                    leaderInfo=au01UserDAO.findAu01UserPOById(leader.getUserId());
                    khdxInfos = sdao.getFgKhdxInfo(khztjsid, leaderInfo.getId());
                    add(khdxInfos);
                }
            }else if(roles.get(i).getRoleName().indexOf("正职")!=-1){
                System.out.println("1111111111=========正职");
                for(Au11UserRolePO leader:leaders){
                     leaderInfo=au01UserDAO.findAu01UserPOById(leader.getUserId());
                     khdxInfos =sdao.getZhKhdxInfo(khztjsid,leaderInfo.getId());
                //根据考核对象id查询 直接上级 如果直接上级为正职 查询权重
                for(Object khdsInfo:khdxInfos) {
                    Object[] ob1 = (Object[]) khdsInfo;
                    System.out.println((String)ob1[9]);
                    List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS=new ArrayList<Jx12KhztrwInfoVO>();
                    Jx12KhztrwInfoVO jx12KhztrwInfoVO=new Jx12KhztrwInfoVO();
                    if(((String)ob1[9]).equals("总部部门正职")){
                        jx12KhztrwInfoVO.setKhztqz(jx05KhztqzInfoDAO.findQz((String)ob1[0],(String)ob1[4],"正"));
                    }else if(((String)ob1[9]).equals("总部部门副职")){
                        jx12KhztrwInfoVO.setKhztqz(jx05KhztqzInfoDAO.findQz((String)ob1[0],(String)ob1[4],"正"));
                    }else{
                        String qz = jx05KhztqzInfoDAO.findQz((String)ob1[0],(String)ob1[4],null);
                        jx12KhztrwInfoVO.setKhztqz(qz);
                    }
                    jx12KhztrwInfoVO.setKhztid(leaderInfo.getId());
                    jx12KhztrwInfoVO.setKhzt(leaderInfo.getUserNameCn());
                    jx12KhztrwInfoVO.setKhnf("2019");
                    jx12KhztrwInfoVO.setKhzq("半年度");
                    jx12KhztrwInfoVO.setKhdx((String)ob1[6]);
                    jx12KhztrwInfoVO.setKhdxid((String)ob1[5]);
                    jx12KhztrwInfoVO.setKhlx("绩效");
                    jx12KhztrwInfoVOS.add(jx12KhztrwInfoVO);
                    Integer integer = this.saveEntity(jx12KhztrwInfoVOS);
                }
                }
            }else if(roles.get(i).getRoleName().equals("总部部门副职")){
                for(Au11UserRolePO leader:leaders) {
                leaderInfo=au01UserDAO.findAu01UserPOById(leader.getUserId());
                khdxInfos =sdao.getFzKhdxInfo(khztjsid,leaderInfo.getId());
                add(khdxInfos);
                }
            }else{
                continue;
            }

        }


    }*/
   /* public void  add(List khdxInfos){
        for(Object khdsInfo:khdxInfos) {
            Object[] ob1 = (Object[]) khdsInfo;
            List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS=new ArrayList<Jx12KhztrwInfoVO>();
            Jx12KhztrwInfoVO jx12KhztrwInfoVO=new Jx12KhztrwInfoVO();
            jx12KhztrwInfoVO.setKhztid(leaderInfo.getId());
            jx12KhztrwInfoVO.setKhzt(leaderInfo.getUserNameCn());
            jx12KhztrwInfoVO.setKhnf("2019");
            jx12KhztrwInfoVO.setKhzq("半年度");
            jx12KhztrwInfoVO.setKhdx((String)ob1[8]);
            jx12KhztrwInfoVO.setKhdxid((String)ob1[7]);
            jx12KhztrwInfoVO.setKhztqz((String)ob1[2]);
            jx12KhztrwInfoVO.setKhlx("绩效");
            jx12KhztrwInfoVOS.add(jx12KhztrwInfoVO);
            Integer integer = this.saveEntity(jx12KhztrwInfoVOS);
        }
    }*/
    /*public List<Jx12KhztrwInfoVO> addRws() {
        //查询所有的主体
        List<Jx05KhztqzInfoPO> jx05KhztqzInfoPOS = jx05KhztqzInfoDAO.findAll();
        //遍历考核主体id
        List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS=new ArrayList<Jx12KhztrwInfoVO>();

        List<Jx05KhztqzInfoPO> getDxjsIdByztjsid =new ArrayList<Jx05KhztqzInfoPO>();
        List<Au11UserRolePO> getUserIdByDxjsId =new ArrayList<Au11UserRolePO>();
        List<Au11UserRolePO> getLeaders =new ArrayList<Au11UserRolePO>();
        for(Jx05KhztqzInfoPO ki:jx05KhztqzInfoPOS){
            if(ki.getKhztjs().equals("公司董事长")){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);

                //根据所有的考核主体id查询所对应的考核对象角色id
                System.out.println(ki.getKhztjsid());
                getDxjsIdByztjsid=jx05KhztqzInfoDAO.findByKhdxjsId(ki.getKhztjsid());
                //遍历所有的角色id
                for(Jx05KhztqzInfoPO jx05KhztqzInfoPO:getDxjsIdByztjsid){
                    //根据角色id查询所有的员工id
                    System.out.println(jx05KhztqzInfoPO.getKhdxjsid());
                    getUserIdByDxjsId= au11UserRoleDAO.findByRoleId(jx05KhztqzInfoPO.getKhdxjsid());

                    getLeaders=au11UserRoleDAO.findByRoleId(jx05KhztqzInfoPO.getKhztjsid());
                    for(int i=0;i<getLeaders.size();i++){
                        Au01UserPO leader = au01UserDAO.findAu01UserPOById(getLeaders.get(0).getUserId());
                        String qz = jx05KhztqzInfoDAO.findQz(jx05KhztqzInfoPO.getKhdxjsid(), ki.getKhztjsid());
                        //遍历员工id 查询员工
                        for(Au11UserRolePO au11UserRolePO:getUserIdByDxjsId){
                            Au01UserPO au01UserPOById1 = au01UserDAO.findAu01UserPOById(au11UserRolePO.getUserId());
                            Jx12KhztrwInfoVO jx12KhztrwInfoVO=new Jx12KhztrwInfoVO();
                            jx12KhztrwInfoVO.setKhnf(""+year);
                            jx12KhztrwInfoVO.setKhztid(leader.getId());
                            jx12KhztrwInfoVO.setKhztid(leader.getUserNameCn());
                            jx12KhztrwInfoVO.setKhdx(au01UserPOById1.getUserNameCn());
                            jx12KhztrwInfoVO.setKhztid(au01UserPOById1.getId());
                            jx12KhztrwInfoVO.setKhzq(qz);
                            jx12KhztrwInfoVOS.add(jx12KhztrwInfoVO);
                        }
                    }
                }
            }
        }
        return jx12KhztrwInfoVOS;
    }*/


}