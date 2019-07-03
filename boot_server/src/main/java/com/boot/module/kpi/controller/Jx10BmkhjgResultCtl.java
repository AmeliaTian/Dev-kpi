package com.boot.module.kpi.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx07XjkhcjhzResultService;
import com.boot.module.kpi.service.IJx10BmkhjgResultService;
import com.boot.module.kpi.service.IJx17ZbdlResultService;
import com.boot.module.kpi.service.IJx23ZzkhzjjgInfoService;
import com.boot.repository.*;
import io.swagger.annotations.*;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.*;
import com.boot.utils.PageUtils;
import com.boot.utils.HttpRequestUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CodeGen
 * @Description 10部门考核结果汇总表（包括各等级人数） Controller
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @ModifiedDate
 */
@RestController
@Api(tags = "BASE_'10部门考核结果汇总表（包括各等级人数）'", description = "'10部门考核结果汇总表（包括各等级人数）'增删改查api")
public class Jx10BmkhjgResultCtl {

    @Resource(name = "jx10BmkhjgResultService")
    private IJx10BmkhjgResultService jx10BmkhjgResultService;

    @Resource(name = "jx17ZbdlResultService")
    private IJx17ZbdlResultService jx17ZbdlResultService;

    @Resource(name = "jx23ZzkhzjjgInfoService")
    private IJx23ZzkhzjjgInfoService jx23ZzkhzjjgInfoService;

    @Resource(name = "jx07XjkhcjhzResultService")
    private IJx07XjkhcjhzResultService jx07XjkhcjhzResultService;

    @ApiOperation(value = "查询'10部门考核结果汇总表（包括各等级人数）'记录数", notes = "根据传入参数查询'10部门考核结果汇总表（包括各等级人数）'记录数,输入参数参照类Jx10BmkhjgResultVO")
    @RequestMapping(value = "/kpi/jx10BmkhjgResult", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx10BmkhjgResultService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'10部门考核结果汇总表（包括各等级人数）'", notes = "##### 根据传入参数查询'10部门考核结果汇总表（包括各等级人数）'，参数名称参照Jx10BmkhjgResultVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
            ">  `空`：等于同EQ， 如userName=AAA表示为userName=AAA;\n" +
            ">  `EQ`：等于，如userName.EQ=AAA表示为userName=AAA;\n" +
            ">  `GT`：大于， 如userAge.GT=20表示为userAge 20;\n" +
            ">  `LT`：小于， 如userAge.LT=20表示为userAge<20;\n" +
            ">  `GE`：大于等于， 如userAge.GE=20表示为userAge =20;\n" +
            ">  `LE`：小于等于， 如userAge.LE=20表示为userAge<=20;\n" +
            ">  `NEQ`：不等于， 如userName.NEQ=AAA表示为userAge!=AAA;\n" +
            ">  `LK`：LIKE， 如userName.LK=AAA表示为userName like '%AAA%';\n" +
            ">  `NLK`：NOT LIKE， 如userName.NLK=AAA表示为userName not like '%AAA%';\n" +
            ">  `ST`：开始于， 如userName.ST=AAA表示为userName like 'AAA%';\n" +
            ">  `NST`：不开始于， 如userName.NST=AAA表示为userName not like 'AAA%';\n" +
            ">  `ED`：结束于， 如userName.ED=AAA表示为userName like '%AAA';\n" +
            ">  `NED`：不结束于， 如userName.NED=AAA表示为userName not like '%AAA';\n" +
            ">  `NU`：IS NULL， 如userName.NU=AAA表示为userName is NULL，参数任意;\n" +
            ">  `NNU`：IS NOT NULL， 如userName.NNU=AAA表示为userName is NOT NULL，参数任意;\n" +
            ">  `IN`：IN， 如userName.IN=AAA&userName.IN=BB表示为userName in ('AAA'，'BBB');\n" +
            ">  `NIN`：NOT IN， 如userName.NIN=AAA&userName.NIN=BB表示为userName not in ('AAA'，'BBB');\n" +
            "##### 分页查询输入参数：\n" +
            ">  `page`：第几页，从0开始，则不分页；\n" +
            ">  `size`：每一页的行数，若为空，则不分页；\n" +
            ">  `sort`：排序字段，可为空，以property;property(，ASC|DESC)的方式组织，如sort=firstname;lastname，desc表示在按firstname正序排列基础上按lastname倒序排列。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Jx10BmkhjgResultVO.*", value = "Jx10BmkhjgResultVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int", example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int", example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/jx10BmkhjgResult/query", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);
        Iterable<Jx10BmkhjgResultVO> queryResult = jx10BmkhjgResultService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'10部门考核结果汇总表（包括各等级人数）'", notes = "批量新增,输入参数为Jx10BmkhjgResultVO的列表")
    @RequestMapping(value = "/kpi/jx10BmkhjgResult", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx10BmkhjgResultVO> jx10BmkhjgResultVOS) {
        Integer saveRows = jx10BmkhjgResultService.saveEntity(jx10BmkhjgResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'10部门考核结果汇总表（包括各等级人数）'", notes = "批量更新,输入参数为Jx10BmkhjgResultVO的列表")
    @RequestMapping(value = "/kpi/jx10BmkhjgResult", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx10BmkhjgResultVO> jx10BmkhjgResultVOS) {
        //如果有ID为空，则不更新
        for (Jx10BmkhjgResultVO vo : jx10BmkhjgResultVOS) {
            if (StringUtils.isEmpty(vo.getId())) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows = jx10BmkhjgResultService.updateEntity(jx10BmkhjgResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'10部门考核结果汇总表（包括各等级人数）'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx10BmkhjgResult", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows = jx10BmkhjgResultService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }

    //生成关键业绩类的初始成绩 v1.0
    @ApiOperation(value = "新增'10部门考核结果汇总表（包括各等级人数）'", notes = "保存每个部门的成绩")
    @RequestMapping(value = "/jx10BmkhjgResult/add", method = RequestMethod.POST)
    public HttpOutMsgBean add(@RequestParam(value = "khnf", required = false) String khnf,
                              @RequestParam(value = "khzq", required = false) String khzq,
                              @RequestParam(value = "khdxid", required = false) String khdxid) {
        List<Jx10BmkhjgResultVO> jx10BmkhjgResultVOS = new ArrayList<>();
        Integer saveRows = 0;
        List<String> djs = jx10BmkhjgResultService.queryDj(khnf, khzq);
        JSONObject ob = jx10BmkhjgResultService.addJg(khnf, khzq, khdxid);
        if (ob.getString("KHDXJSID").equals("总部部门")) {
            for (String dj : djs) {
                Jx10BmkhjgResultVO jx10BmkhjgResultVO = new Jx10BmkhjgResultVO();
                jx10BmkhjgResultVO.setBmid(khdxid);
                jx10BmkhjgResultVO.setBmmc(ob.getString("BMMC"));
                jx10BmkhjgResultVO.setKhnf(khnf);
                jx10BmkhjgResultVO.setKhzq(khzq);
                jx10BmkhjgResultVO.setGjyjlcsdf(ob.getBigDecimal("GJYJLCSDF"));
                jx10BmkhjgResultVO.setDjmc(dj);
                jx10BmkhjgResultVOS.add(jx10BmkhjgResultVO);
                saveRows = jx10BmkhjgResultService.saveEntity(jx10BmkhjgResultVOS);
            }
        } else {
            Jx10BmkhjgResultVO jx10BmkhjgResultVO = new Jx10BmkhjgResultVO();
            jx10BmkhjgResultVO.setBmid(khdxid);
            jx10BmkhjgResultVO.setBmmc(ob.getString("BMMC"));
            jx10BmkhjgResultVO.setKhnf(khnf);
            jx10BmkhjgResultVO.setKhzq(khzq);
            jx10BmkhjgResultVO.setGjyjlcsdf(ob.getBigDecimal("GJYJLCSDF"));
            jx10BmkhjgResultVOS.add(jx10BmkhjgResultVO);
            saveRows = jx10BmkhjgResultService.saveEntity(jx10BmkhjgResultVOS);
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /**
     * 生成部门的最终结果
     * v1.0 点击各个部门生成考核得分
     */
    @ApiOperation(value = "新增'10部门考核结果汇总表（包括各等级人数）'", notes = "保存每个部门的成绩")
    @RequestMapping(value = "/jx10BmkhjgResult/updateZzdf", method = RequestMethod.POST)
    public HttpOutMsgBean updateZzdf(@RequestParam(value = "khnf", required = false) String khnf,
                                     @RequestParam(value = "khzq", required = false) String khzq,
                                     @RequestParam(value = "orgId", required = false) String orgId,
                                     @RequestParam(value = "orgDesc", required = false) String orgDesc) {
        Integer saveRows = 0;
        //生成年度关键业绩类最终结果
        if (orgDesc.equals("总部部门")) {
            List<String> glbmDf = jx10BmkhjgResultService.getGlbmDf(khnf, khzq, orgId);
            if (glbmDf.contains(null) || glbmDf.size() == 0) {//还有未考核的部门
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent("wwc").build();
            } else {
                BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, orgId, orgDesc);
                int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, orgId, gjyjlzzdf);
                if (i != 0) {
                    //查询有没有党建类的分值  没有党建类分值   直接取关键业绩类最终成绩
                    JSONObject djInfo = jx17ZbdlResultService.getDjInfo(orgId, khnf, khzq);
                    BigDecimal zzdf = null;
                    if (djInfo == null) {
                        zzdf = gjyjlzzdf;
                    } else {
                        zzdf = jx10BmkhjgResultService.getZzdf(khnf, khzq, orgId, orgDesc);
                    }
                    saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, orgId, zzdf, null);
                }
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
            }
        } else {
            BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, orgId, orgDesc);
            int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, orgId, gjyjlzzdf);
            if (i != 0) {
                //查询有没有党建类的分值  没有党建类分值   直接取关键业绩类最终成绩
                JSONObject djInfo = jx17ZbdlResultService.getDjInfo(orgId, khnf, khzq);
                BigDecimal zzdf = null;
                if (djInfo == null) {
                    zzdf = gjyjlzzdf;
                } else {
                    zzdf = jx10BmkhjgResultService.getZzdf(khnf, khzq, orgId, orgDesc);
                }
                saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, orgId, zzdf, null);
            }
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
        }

    }

    /**
     * 生成部门的最终结果
     * v2.0 判断关联部门是否考核完成  最后一个考核完成  遍历所有的关联部门生成考核成绩
     */
    @ApiOperation(value = "新增'10部门考核结果汇总表（包括各等级人数）'", notes = "保存每个部门的成绩")
    @RequestMapping(value = "/jx10BmkhjgResult/getDf", method = RequestMethod.POST)
    public HttpOutMsgBean getDf(@RequestParam(value = "khnf", required = false) String khnf,
                                @RequestParam(value = "khzq", required = false) String khzq,
                                @RequestParam(value = "orgId", required = false) String orgId,
                                @RequestParam(value = "orgDesc", required = false) String orgDesc) {
        Integer saveRows = 0;
        BigDecimal bndQz = new BigDecimal("0.3");
        BigDecimal ndQz = new BigDecimal("0.7");
        if (khzq.equals("半年度")) {//半年度成绩等于得分
            if (orgDesc.equals("总部部门")) {//总部部门
                List<String> glbmDf = jx10BmkhjgResultService.getGlbmDf(khnf, khzq, orgId);//查询管理部门的所有得分
                if (glbmDf.contains(null) || glbmDf.size() == 0) {//还有未考核的部门 直接返回
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent("wwc").build();
                } else {
                    List<JSONObject> glbm = jx10BmkhjgResultService.getGlbm(khnf, khzq, orgId);//查询所有的关联部门
                    for (JSONObject jx21BmglInfoPO : glbm) {//生成所有关联部门的最终业绩类得分和关键得分
                        BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), orgDesc);
                        int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), gjyjlzzdf);
                        if (i != 0) {
                            //查询有没有党建类的分值  没有党建类分值   直接取关键业绩类最终成绩
                            JSONObject djInfo = jx17ZbdlResultService.getDjInfo(jx21BmglInfoPO.getString("GLBMID"), khnf, khzq);
                            BigDecimal zzdf = null;
                            if (djInfo == null) {
                                zzdf = gjyjlzzdf;
                            } else {
                                zzdf = jx10BmkhjgResultService.getZzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), orgDesc);
                            }
                            saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), zzdf, null);
                        }
                    }
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
                }
            } else {
                BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, orgId, orgDesc);
                int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, orgId, gjyjlzzdf);
                if (i != 0) {
                    //查询有没有党建类的分值  没有党建类分值   直接取关键业绩类最终成绩
                    JSONObject djInfo = jx17ZbdlResultService.getDjInfo(orgId, khnf, khzq);
                    BigDecimal zzdf = jx10BmkhjgResultService.getZzdf(khnf, khzq, orgId, orgDesc);
                    saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, orgId, zzdf, null);
                }
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
            }
        } else {//年度成绩等于半年度成绩*权重+年度成绩*权重
            if (orgDesc.equals("总部部门")) {//总部部门
                List<String> glbmDf = jx10BmkhjgResultService.getGlbmDf(khnf, khzq, orgId);//查询关联部门的所有得分
                if (glbmDf.contains(null) || glbmDf.size() == 0) {//还有未考核的部门 直接返回
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent("wwc").build();
                } else {
                    List<JSONObject> glbm = jx10BmkhjgResultService.getGlbm(khnf, khzq, orgId);//查询所有的关联部门
                    for (JSONObject jx21BmglInfoPO : glbm) {//生成所有关联部门的最终业绩类得分和关键得分
                        BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), orgDesc);
                        int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, orgId, gjyjlzzdf);
                        if (i != 0) {
                            //查询有没有党建类的分值  没有党建类分值   直接取关键业绩类最终成绩
                            JSONObject djInfo = jx17ZbdlResultService.getDjInfo(jx21BmglInfoPO.getString("GLBMID"), khnf, khzq);
                            BigDecimal nzdf = null;
                            BigDecimal zzdf = null;
                            if (djInfo == null) {
                                nzdf = gjyjlzzdf;
                            } else {
                                nzdf = jx10BmkhjgResultService.getZzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), orgDesc);
                            }
                            BigDecimal bndDf = jx10BmkhjgResultService.getBndDf(khnf, jx21BmglInfoPO.getString("GLBMID"));
                            zzdf = bndDf.multiply(bndQz).add(nzdf.multiply(ndQz));
                            saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), zzdf, null);
                        }
                    }
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
                }
            } else {
                BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, orgId, orgDesc);
                int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, orgId, gjyjlzzdf);
                if (i != 0) {
                    //查询有没有党建类的分值  没有党建类分值   直接取关键业绩类最终成绩
                    JSONObject djInfo = jx17ZbdlResultService.getDjInfo(orgId, khnf, khzq);
                    BigDecimal bndDf = jx10BmkhjgResultService.getBndDf(khnf, orgId);
                    BigDecimal nddf = jx10BmkhjgResultService.getZzdf(khnf, khzq, orgId, orgDesc);
                    BigDecimal zzdf = bndDf.multiply(bndQz).add(nddf.multiply(ndQz));
                    saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, orgId, zzdf, null);
                }
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
            }

        }


    }


    /**
     * 半年度最终得分
     * 总部部门  先插入关键业绩类的初始成绩 判断关联部门是否考核完成 如果考核完成  计算关键业绩类的最终成绩即考核最终成绩
     * 获得各个等级的预算人数
     */
    @ApiOperation(value = "新增'10部门考核结果汇总表（包括各等级人数）'", notes = "保存每个部门的成绩")
    @RequestMapping(value = "/jx10BmkhjgResult/addBndDf", method = RequestMethod.POST)
    public HttpOutMsgBean addBndDf(@RequestParam(value = "khnf", required = false) String khnf,
                                   @RequestParam(value = "khzq", required = false) String khzq,
                                   @RequestParam(value = "orgId", required = false) String orgId,
                                   @RequestParam(value = "orgDesc", required = false) String orgDesc) {
        List<Jx10BmkhjgResultVO> jx10BmkhjgResultVOS = new ArrayList<>();
        Integer saveRows = 0;
        if (khzq.equals("半年度")) {//半年度成绩等于得分
            List<String> khztDfs = jx23ZzkhzjjgInfoService.getKhztDfs(khnf, khzq, orgId);
            if (khztDfs.contains(null) || khztDfs.size() == 0) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent("wwc").build();
            } else {
                JSONObject bnddf = jx23ZzkhzjjgInfoService.getBnddf(khnf, khzq, orgId);//查询组织的初始业绩类成绩
                if (orgDesc.equals("总部部门")) {//总部部门
                    List<String> djs = jx10BmkhjgResultService.queryDj(khnf, khzq);//获得等级信息
                    //遍历等级  插入初始得分
                    Integer saveCsdf = 0;
                    for (String dj : djs) {
                        Jx10BmkhjgResultVO jx10BmkhjgResultVO = new Jx10BmkhjgResultVO();
                        jx10BmkhjgResultVO.setBmid(orgId);
                        jx10BmkhjgResultVO.setBmmc(bnddf.getString("KHDXMC"));
                        jx10BmkhjgResultVO.setKhnf(khnf);
                        jx10BmkhjgResultVO.setKhzq(khzq);
                        jx10BmkhjgResultVO.setGjyjlcsdf(bnddf.getBigDecimal("BNDDF"));
                        jx10BmkhjgResultVO.setDjmc(dj);
                        jx10BmkhjgResultVOS.add(jx10BmkhjgResultVO);
                        saveCsdf = jx10BmkhjgResultService.saveEntity(jx10BmkhjgResultVOS);
                    }
                    if (saveCsdf != 0) {
                        List<String> glbmDf = jx10BmkhjgResultService.getGlbmDf(khnf, khzq, orgId);//查询管理部门的所有得分
                        if (glbmDf.contains(null) || glbmDf.size() == 0) {//还有未考核的部门 直接返回
                            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent("wwc").build();
                        } else {
                            List<JSONObject> glbm = jx10BmkhjgResultService.getGlbm(khnf, khzq, orgId);//查询所有的关联部门
                            for (JSONObject jx21BmglInfoPO : glbm) {//生成所有关联部门的最终业绩类得分和关键得分
                                BigDecimal gjyjlzzdf = jx10BmkhjgResultService.getGjyjlzzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), orgDesc);
                                BigDecimal khxss = gjyjlzzdf.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);//计算考核系数  如果大于1.4 则为1.4  如果小于0.6 则为0.6
                                String khxs = null;
                                if (khxss.compareTo(new BigDecimal("1.4")) == 1) {
                                    khxs = "1.4";
                                } else if (khxss.compareTo(new BigDecimal("0.6")) == -1) {
                                    khxs = "0.6";
                                } else {
                                    khxs = khxss.toString();
                                }
                                //添加关键业绩类最终成绩
                                int i = jx10BmkhjgResultService.updateGjyjldf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), gjyjlzzdf);
                                if (i != 0) {
                                    //半年度不考核党建类  关键业绩类成绩及半年度成绩
                                    saveRows = jx10BmkhjgResultService.updateZzdf(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), gjyjlzzdf, khxs);
                                    if (saveRows != 0) {
                                        //计算各个等级的预算人数
                                        jx10BmkhjgResultService.updateRS(khnf, khzq, jx21BmglInfoPO.getString("GLBMID"), gjyjlzzdf.toString());
                                    }
                                    //判断所有部门的员工的成绩和等级  不为空则更新等级信息
                                    jx07XjkhcjhzResultService.updateDj(khnf,khzq,jx21BmglInfoPO.getString("GLBMMC"),jx21BmglInfoPO.getString("GLBMID"));
                                }
                            }
                            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
                        }
                    }
                } else {//创新公司和路段公司
                    Jx10BmkhjgResultVO jx10BmkhjgResultVO = new Jx10BmkhjgResultVO();
                    jx10BmkhjgResultVO.setBmid(orgId);
                    jx10BmkhjgResultVO.setBmmc(bnddf.getString("KHDXMC"));
                    jx10BmkhjgResultVO.setKhnf(khnf);
                    jx10BmkhjgResultVO.setKhzq(khzq);
                    jx10BmkhjgResultVO.setGjyjlcsdf(bnddf.getBigDecimal("BNDDF"));
                    jx10BmkhjgResultVO.setGjyjlzzdf(bnddf.getBigDecimal("BNDDF"));
                    jx10BmkhjgResultVO.setBmkhdf(bnddf.getBigDecimal("BNDDF"));
                    BigDecimal khxss = bnddf.getBigDecimal("BNDDF").divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);//计算考核系数  如果大于1.4 则为1.4  如果小于0.6 则为0.6
                    String khxs = null;
                    if (khxss.compareTo(new BigDecimal("1.4")) == 1) {
                        khxs = "1.4";
                    } else if (khxss.compareTo(new BigDecimal("0.6")) == -1) {
                        khxs = "0.6";
                    } else {
                        khxs = khxss.toString();
                    }
                    jx10BmkhjgResultVO.setKhxs(khxs);
                    jx10BmkhjgResultVOS.add(jx10BmkhjgResultVO);
                    saveRows = jx10BmkhjgResultService.saveEntity(jx10BmkhjgResultVOS);
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();

                }
            }
        }

        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();

    }
}