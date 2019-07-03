package com.boot.module.file.service.impl;

import com.boot.module.auth.service.IAu12OrgUserService;
import com.boot.module.sys.service.BaseService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.repository.*;
import com.boot.module.file.service.IJx22UserFileService;
import com.boot.utils.DeleteFileUtils;
import com.querydsl.core.types.Predicate;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 用户-工作总结文件表 Service
 * @CreateDate 创建时间： 2019-06-18 17:10:28
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Service("jx22UserFileService")
public class Jx22UserFileServiceImpl extends BaseService implements IJx22UserFileService{
    @Autowired
    private Jx22UserFileDAO sdao;
    @Autowired
    private Au12OrgUserDAO au12OrgUserDAO;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap){
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap,Jx22UserFilePO.class));
    }

    @Override
    public Iterable<Jx22UserFileVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap,Jx22UserFilePO.class);

        Iterable<Jx22UserFilePO> dataPO = null;
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
    public Integer updateEntity(List<Jx22UserFileVO> jx22UserFileVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Jx22UserFilePO> poList = ConvertBeanTools.convertGroupToPO(jx22UserFileVOS, false);
        return sdao.saveAll(poList).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer saveEntity(List<Jx22UserFileVO> jx22UserFileVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Jx22UserFilePO> voMap = new HashMap<>(jx22UserFileVOS.size());
        for (Iterator iter = jx22UserFileVOS.iterator(); iter.hasNext(); ) {
            Jx22UserFileVO t = (Jx22UserFileVO) iter.next();
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t,true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        //由于id是自动生成，所以此时还没有id，voMap中key为null
        Jx22UserFilePO po = voMap.get(null);
        Iterable<Jx22UserFilePO> poList = sdao.findByKhnfAndKhzqAndKhdxid(po.getKhnf(),po.getKhzq(),po.getKhdxid());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Jx22UserFilePO p = (Jx22UserFilePO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(null), p);
            //替换
            voMap.put(null, p);
            break;
        }
        return sdao.saveAll(voMap.values()).size();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Integer removeEntity(List<String> ids) {
        QJx22UserFilePO qpo = QJx22UserFilePO.jx22UserFilePO;
        List<Jx22UserFilePO> allById = sdao.findAllById(ids);
        allById.stream().map(Jx22UserFilePO::getFjmc).forEach(DeleteFileUtils::deleteFile);


        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    //    @Override
//    public List<Jx22UserFileVO> getUserFile(String userid, String khnf, String khzq, String rolenames) {
//        List<Jx22UserFilePO> jx22UserFilePOS=new ArrayList<>();
//        if (rolenames.contains("公司董事长")||rolenames.contains("公司总经理")||rolenames.contains("分管领导")||
//                rolenames.contains("公司领导")||rolenames.contains("人力资源部")){
//            //查询当前年份、周期的所有人的文件表
//            jx22UserFilePOS= sdao.findByKhnfAndKhzq(khnf,khzq);
//        }else if (rolenames.contains("总部部门正职")||rolenames.contains("总部部门副职")){
//            //查询当前年份、周期、本部门的所有人的文件表
//            List<String> orgIds = au12OrgUserDAO.findOrgIdByUserId(userid);
//            jx22UserFilePOS=sdao.findByKhnfAndKhzqAndOrgid(khnf,khzq,orgIds);
//        }else {
//            //员工个人
//            jx22UserFilePOS = sdao.findByKhnfAndKhzqAndKhdxid(khnf,khzq,userid);
//        }
//        List<Jx22UserFileVO> jx22UserFileVOS = new ArrayList<>();
//        jx22UserFilePOS.stream().forEach(p->jx22UserFileVOS.add(ConvertBeanTools.convertToVO(p)));
//        return jx22UserFileVOS;
//    }
    @Override
    public Iterable<Jx22UserFileVO> getUserFile(Map<String, Object> paramMap, Pageable pageable) {
        String rolenames = (String) paramMap.getOrDefault("rolenames","");
        if (rolenames.contains("公司董事长")||rolenames.contains("公司总经理")||rolenames.contains("分管领导")||
                rolenames.contains("公司领导")||rolenames.contains("系统管理员")){
            //查询当前年份、周期的所有人的文件表
            paramMap.replace("khdxid",null);
            return queryEntity(paramMap,pageable);
        }else if (rolenames.contains("总部部门正职")||rolenames.contains("总部部门副职")){
            //查询当前年份、周期、本部门的所有人的文件表
            List<String> orgIds = au12OrgUserDAO.findOrgIdByUserId((String) paramMap.get("khdxid"));
//        orgIds.add("42CBTEE0P8N4");
//        orgIds.add("42CA84YYC5C0");
            paramMap.replace("khdxid",null);
            //不支持范围查询
//        paramMap.put("ssbmid",orgIds);
            List<Jx22UserFileVO> jx22UserFileVOS = new ArrayList<>();
            for (String ssbmid:orgIds) {
                paramMap.put("ssbmid",ssbmid);
                jx22UserFileVOS.addAll((Collection<? extends Jx22UserFileVO>) queryEntity(paramMap,pageable));
            }
            return jx22UserFileVOS;
        }else {
            //员工个人
            return queryEntity(paramMap,pageable);
        }
    }

    @Override
    public List<Jx22UserFilePO> findByKhnfAndKhzqAndKhdxid(String khnf, String khzq, String khdxid) {
        return sdao.findByKhnfAndKhzqAndKhdxid(khnf,khzq,khdxid);
    }

    @Override
    public List<String> getFjmc(List<String> ids) {
        List<String> fjmcs = sdao.findFjmcById(ids);
        return fjmcs;
    }
}