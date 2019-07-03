package com.boot.module.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.constant.WebStroage;
import com.boot.module.auth.service.IAu01UserService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.*;
import com.boot.repository.common.JpaSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author CodeGen
 * @Description 针对'AU01_系统用户表'的增删改查操作。
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("au01UserService")
public class Au01UserServiceImpl extends BaseService implements IAu01UserService {

    @Autowired
    private Au01UserDAO sdao;
    @Autowired
    private Jx12KhztrwInfoDAO jx12KhztrwInfoDAO;
    @Autowired
    private Au02OrganizationDAO au02OrganizationDAO;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au01UserPO.class));
    }

    @Override
    public Au01UserVO queryEntityByUserName(String userName) {
        Au01UserPO po = sdao.findByUserName(userName);
        if (null == po) {
            return null;
        }

        //获取缓存中的角色
        Set<Au03RoleVO> userRoles = WebStroage.loadUserRoles(userName);
        Au01UserVO vo = ConvertBeanTools.convertToVO(po);
        vo.setUserRoles(userRoles);
        return vo;
    }

    @Override
    public Iterable<Au01UserVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au01UserPO.class);

        Iterable<Au01UserPO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    /**
     * 如前台传入数据中只有一个参数有值，则库中其他字段会更新为null
     *
     * @param au01UserVOS)
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Au01UserVO> au01UserVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au01UserPO> poList = ConvertBeanTools.convertGroupToPO(au01UserVOS, false);
        return sdao.saveAll(poList).size();
    }

    /**
     * save and patch
     *
     * @param au01UserVOS)
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au01UserVO> au01UserVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au01UserPO> voMap = new HashMap<>(au01UserVOS.size());
        for (Iterator iter = au01UserVOS.iterator(); iter.hasNext(); ) {
            Au01UserVO t = (Au01UserVO) iter.next();
            // 给用户一个askKey，仅对新插入用户有效
            // 如果是新用户，则采用此值，如果是更新用户，则sdao.findAllById时会覆盖此值
            t.setUserAskKey(UUID.randomUUID().toString().toLowerCase());
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au01UserPO> poList = sdao.findAllById(voMap.keySet());
        for (Iterator iter = poList.iterator(); iter.hasNext(); ) {
            Au01UserPO p = (Au01UserPO) iter.next();
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }
        //如果数据库中没有对应数据，则会插入，有则会更新
        return sdao.saveAll(voMap.values()).size();
    }

    //逻辑删除
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu01UserPO qpo = QAu01UserPO.au01UserPO;
        return Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
    }

    @Override
    public List<JSONObject> queryByRoleName(String roleName,String khnf,String khzq){
        List<JSONObject> users=new ArrayList<JSONObject>();
        List<JSONObject> jsonObjects =null;
        if(roleName.equals("总部部门")||roleName.equals("路段公司")||roleName.equals("创新公司")){
            jsonObjects = au02OrganizationDAO.queryZbbm(roleName);
        }else{
             jsonObjects = sdao.queryByRoleName(roleName);
        }
        for (JSONObject o:jsonObjects){
            List<Jx12KhztrwInfoPO> jx12KhztrwInfoPOS = jx12KhztrwInfoDAO.queryByKhdxid(o.getString("USER_ID"), khnf, khzq);
            if(jx12KhztrwInfoPOS.size()==0){
                o.put("FPZT","N");
            }else{
                o.put("FPZT","Y");
            }
            users.add(o);
        }
        return users;
    }

    @Override
    public Au01UserPO findAu01UserPOById(String id) {
        return sdao.findAu01UserPOById(id);
    }
}
