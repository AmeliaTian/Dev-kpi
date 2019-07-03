package com.boot.module.kpi.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.boot.module.kpi.service.KhdxTreeService;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CodeGen
 * @Description AU02_组织机构表 Service
 * @CreateDate 创建时间： 2018-09-14 10:33:27
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("khdxTreeService")
public class KhdxTreeServiceImpl extends BaseService implements KhdxTreeService {
    @Autowired
    private Au02OrganizationDAO sdao;
    @Autowired
    private Jx12KhztrwInfoDAO jx12KhztrwInfoDAO;
    @Autowired
    private Jx06XjkhjgResultDAO jx06XjkhjgResultDAO;

    /**
     * 查询部门组织架构树(含部门下的人员)
     *
     * @return
     */

   /* public List<KhdxTree> queryDeptUserTreeList(String userId, String roleName) {

        List<KhdxTree> khdxTreeList = new ArrayList<KhdxTree>();
        List<Au02OrganizationPO> dList = null;
        if (roleName.indexOf("正职") != -1 || roleName.equals("总部部门副职")) {
            dList = sdao.findDepByUserId(userId);
            for (Au02OrganizationPO dt : dList) {
                KhdxTree khdxTree = new KhdxTree();
                khdxTree.setDeptId(dt.getId());
                khdxTree.setDeptName(dt.getOrgName());
                khdxTree.setDeptDes(dt.getOrgDesc());
                getTreeNodeData(khdxTree, userId);
                khdxTreeList.add(khdxTree);
            }
        } else if (roleName.equals("公司董事长") || roleName.equals("公司领导")) {
            dList = sdao.findAll();
            for (Au02OrganizationPO dt : dList) {
                KhdxTree khdxTree = new KhdxTree();
                khdxTree.setDeptId(dt.getId());
                khdxTree.setDeptName(dt.getOrgName());
                khdxTree.setDeptDes(dt.getOrgDesc());
                getTreeNodeData(khdxTree, userId);
                khdxTreeList.add(khdxTree);
            }
        } else if (roleName.equals("分管领导")) {
            dList = sdao.findOrgByFgld(userId);
            for (Au02OrganizationPO dt : dList) {
                KhdxTree khdxTree = new KhdxTree();
                khdxTree.setDeptId(dt.getId());
                khdxTree.setDeptName(dt.getOrgName());
                khdxTree.setDeptDes(dt.getOrgDesc());
                getTreeNodeData(khdxTree, userId);
                khdxTreeList.add(khdxTree);
            }
        }
        return khdxTreeList;
    }*/

    /**
     * 为每个部门插入相关人员
     *
     * @param
     * @return
     */
   /* public void getTreeNodeData(KhdxTree kt, String userId) {
        //查找所有部门的员工
        List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS = new ArrayList<Jx12KhztrwInfoVO>();
        List KhztIdAndKhnfs = jx12KhztrwInfoDAO.getByKhztIdAndKhnf(userId, year);
        for (Object KhztIdAndKhnf : KhztIdAndKhnfs) {
            Object[] ob1 = (Object[]) KhztIdAndKhnf;
            if (((String) ob1[15]).equals(kt.getDeptName())) {
                List<Au11UserRolePO> userRolePOs = au11UserRoleDAO.findByUserId((String) ob1[7]);
                List<Au03RolePO> au03RolePOS = new ArrayList<Au03RolePO>();
                for (Au11UserRolePO userRolePO : userRolePOs) {
                    String id = userRolePO.getRoleId();
                    Au03RolePO au03RolePO = au03RoleDAO.findAu03RolePOByRoleId(id);
                    au03RolePOS.add(au03RolePO);
                }
                Jx12KhztrwInfoVO jx12KhztrwInfoVO = new Jx12KhztrwInfoVO();
                jx12KhztrwInfoVO.setKhdxid((String) ob1[7]);
                jx12KhztrwInfoVO.setKhdx((String) ob1[8]);
                jx12KhztrwInfoVO.setKhnf((String) ob1[1]);
                jx12KhztrwInfoVO.setKhztqz((String) ob1[9]);
                jx12KhztrwInfoVO.setKhzt((String) ob1[6]);
                jx12KhztrwInfoVO.setKhztid((String) ob1[5]);
                jx12KhztrwInfoVO.setKhdf((String) ob1[10]);
                //jx12KhztrwInfoVO.setKhdxRoles(au03RolePOS);
                jx12KhztrwInfoVOS.add(jx12KhztrwInfoVO);
                kt.setJx12KhztrwInfoVOS(jx12KhztrwInfoVOS);
            } else {
                continue;
            }
        }
    }*/
    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return null;
    }

    @Override
    public Iterable<Au01UserVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        return null;
    }

    @Override
    public Integer updateEntity(List<Au01UserVO> au01UserVOS) {
        return null;
    }

    @Override
    public Integer saveEntity(List<Au01UserVO> au01UserVOS) {
        return null;
    }

    @Override
    public Integer removeEntity(List<String> ids) {
        return null;
    }

    @Override
    public List<KhdxTree> queryDeptUserTreeList(String khztid, String roleName, String khzq, String khnf, String khlx) {
        return null;
    }

    @Override
    public List<JSONObject> queryKhdx(String khztid, String roleNames, String khzq, String khnf, String khlx) {
        List<JSONObject> khdxss = new ArrayList<>();
        if (khlx.equals("组织")) {
            //List<Au02OrganizationPO> dList = sdao.findAll();
            List<JSONObject> khdxAll =new ArrayList<>();
            JSONObject jsonObjects = new JSONObject();
            //for (Au02OrganizationPO dt : dList) {
                String[] zblx = {"业绩类", "财务类", "营运类","管理类", "任务类", "创新类", "基础类", "加分类", "重要信息","党建类" };
                List<JSONObject> khdxs = jx12KhztrwInfoDAO.queryYgKhdx(khztid, khnf, khzq, zblx);
                for (JSONObject khdx : khdxs) {
                    List<JSONObject> zblxAndQz = jx12KhztrwInfoDAO.queryZblxAndQz(khdx.getString("KHDXID"), khnf, khzq, khztid);
                    khdx.put("zblxAndQz",zblxAndQz);
                    if (StringUtils.isEmpty(khdx.getString("KHDF"))) {
                        List<Jx06XjkhjgResultPO> khdxid = jx06XjkhjgResultDAO.queryZbkhjg(khztid, khdx.getString("KHDXID"), khnf, khzq);
                        if (khdxid.size() != 0) {
                            khdx.put("khzt", "khz");
                        } else {
                            khdx.put("khzt", "wkh");
                        }
                    } else {
                        khdx.put("khzt", "ykh");
                    }
                    khdxAll.add(khdx);
                }
                jsonObjects.put("khdxs", khdxAll);
                khdxss.add(jsonObjects);
        } else if (khlx.equals("中层")) {
            List<Au02OrganizationPO> dList = sdao.findAll();
            String[] zblx = {"胜任力"};
            for (Au02OrganizationPO dt : dList) {
                JSONObject jsonObjects = new JSONObject();
                jsonObjects.put("orgid", dt.getId());
                jsonObjects.put("orgName", dt.getOrgName());
                jsonObjects.put("orgDesc", dt.getOrgDesc());
                List<JSONObject> khdxs = jx12KhztrwInfoDAO.queryKhdx(khztid, khnf, khzq, dt.getId(), zblx);
                List<JSONObject> khdxAll = new ArrayList<>();
                for (JSONObject khdx : khdxs) {
                    if (StringUtils.isEmpty(khdx.getString("KHDF"))) {
                        List<Jx06XjkhjgResultPO> khdxid = jx06XjkhjgResultDAO.queryZbkhjg(khztid, khdx.getString("KHDXID"), khnf, khzq);
                        if (khdxid.size() != 0) {
                            khdx.put("khzt", "khz");
                        } else {
                            khdx.put("khzt", "wkh");
                        }
                    } else {
                        khdx.put("khzt", "ykh");
                    }
                    khdxAll.add(khdx);
                }
                jsonObjects.put("khdxs", khdxAll);
                khdxss.add(jsonObjects);
            }
        } else if (khlx.equals("员工")) {
            List<Au02OrganizationPO> dList = null;
            if (roleNames.indexOf("正职") != -1 || roleNames.equals("总部部门副职")) {
                dList = sdao.findDepByUserId(khztid);
            } else if (roleNames.indexOf("分管领导") != -1) {
                dList = sdao.findOrgByFgld(khztid);
            }
            for (Au02OrganizationPO dt : dList) {
                JSONObject jsonObjects = new JSONObject();
                jsonObjects.put("orgid", dt.getId());
                jsonObjects.put("orgName", dt.getOrgName());
                jsonObjects.put("orgDesc", dt.getOrgDesc());
                String[] zblx = {"关键业绩类", "态度类"};
                List<JSONObject> khdxs = jx12KhztrwInfoDAO.queryYgKhdx(khztid, khnf, khzq, dt.getId(), zblx);
                List<JSONObject> ygList = new ArrayList<JSONObject>();
                for (JSONObject yg : khdxs) {
                    List<JSONObject> zblxAndQz = jx12KhztrwInfoDAO.queryZblxAndQz(yg.getString("KHDXID"), khnf, khzq, khztid);
                    List<String> khdfss=zblxAndQz.stream().map(khdfArr->khdfArr.getString("KHDF")).collect(Collectors.toList());
                    yg.put("ZBLXANDQZ", zblxAndQz);
                    if (khdfss.contains(null)||khdfss.contains("")) {
                        List<Jx06XjkhjgResultPO> khdxid = jx06XjkhjgResultDAO.queryZbkhjg(khztid, yg.getString("KHDXID"), khnf, khzq);
                        if (khdxid.size() != 0) {
                            yg.put("KHZT", "khz");
                        } else {
                            yg.put("KHZT", "wkh");
                        }
                    } else {
                        yg.put("KHZT", "ykh");
                    }
                    ygList.add(yg);
                }
                jsonObjects.put("khdxs", ygList);
                khdxss.add(jsonObjects);
            }
        }

        return khdxss;
    }

    /**
     * 特殊人员考核情况
     * @param userId
     * @param khzq
     * @param khnf
     * @return
     */
    @Override
    public List<JSONObject> queryTsry(String khztid, String khzq, String khnf) {
        List<JSONObject> khdxss = new ArrayList<>();
        List<Au02OrganizationPO> dList = null;
        List<JSONObject> khdxs = jx12KhztrwInfoDAO.queryTsry(khztid, khzq,khnf);
        Set<String> bmmcs = new HashSet<>();
        for (JSONObject khdx : khdxs) {
            dList = sdao.findDepByUserId(khdx.getString("KHDXID"));
            if (dList != null && dList.size() > 0) {
                Au02OrganizationPO dt = dList.get(0);
                bmmcs.add(dt.getOrgName());
            }
        }
        for (String bm:bmmcs) {
            JSONObject jsonObjects = new JSONObject();
            List<JSONObject> ygList = new ArrayList<>();
            for (JSONObject yg : khdxs) {
                dList = sdao.findDepByUserId(yg.getString("KHDXID"));
                Au02OrganizationPO dt = dList.get(0);
                if (bm.equals(dt.getOrgName())) {
                    jsonObjects.put("orgid", dt.getId());
                    jsonObjects.put("orgName", dt.getOrgName());
                    jsonObjects.put("orgDesc", dt.getOrgDesc());
                    List<JSONObject> zblxAndQz = jx12KhztrwInfoDAO.queryZblxAndQz(yg.getString("KHDXID"), khnf, khzq, khztid);
                    List<String> khdfss = zblxAndQz.stream().map(khdfArr -> khdfArr.getString("KHDF")).collect(Collectors.toList());
                    //                yg.put("ZBLXANDQZ", zblxAndQz);
                    if (khdfss.contains(null) || khdfss.contains("")) {
                        //                    List<Jx06XjkhjgResultPO> khdxid = jx06XjkhjgResultDAO.queryZbkhjg(khztid, yg.getString("KHDXID"), khnf, khzq);
                        yg.put("KHZT", "wkh");
                    } else {
                        yg.put("KHZT", "ykh");
                    }
                    ygList.add(yg);
                }
            }
            jsonObjects.put("khdxs", ygList);
            khdxss.add(jsonObjects);
        }

        return khdxss;
    }

}

