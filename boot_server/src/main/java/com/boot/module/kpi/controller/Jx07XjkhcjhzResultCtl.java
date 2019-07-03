package com.boot.module.kpi.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx07XjkhcjhzResultService;
import com.boot.module.kpi.service.IJx13KhdjgjInfoService;
import com.boot.repository.*;
import com.boot.utils.PageUtils;
import com.boot.utils.HttpRequestUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description 07绩效考核汇总表 Controller
 * @CreateDate 创建时间： 2019-03-04 11:17:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@RestController
@Api(tags="BASE_'07绩效考核汇总表'",description = "'07绩效考核汇总表'增删改查api")
public class Jx07XjkhcjhzResultCtl {

    @Resource(name = "jx07XjkhcjhzResultService")
    private IJx07XjkhcjhzResultService jx07XjkhcjhzResultService;
    @Resource(name = "")
    private IJx13KhdjgjInfoService jx13KhdjgjInfoService;

    @ApiOperation(value = "查询'07绩效考核汇总表'记录数", notes = "根据传入参数查询'07绩效考核汇总表'记录数,输入参数参照类Jx07XjkhcjhzResultVO")
    @RequestMapping(value = "/kpi/jx07XjkhcjhzResult", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx07XjkhcjhzResultService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'07绩效考核汇总表'", notes = "##### 根据传入参数查询'07绩效考核汇总表'，参数名称参照Jx07XjkhcjhzResultVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx07XjkhcjhzResultVO.*", value = "Jx07XjkhcjhzResultVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/kpi/jx07XjkhcjhzResult", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx07XjkhcjhzResultVO> queryResult =  jx07XjkhcjhzResultService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'07绩效考核汇总表'", notes = "批量新增,输入参数为Jx07XjkhcjhzResultVO的列表")
    @RequestMapping(value = "/kpi/jx07XjkhcjhzResult", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx07XjkhcjhzResultVO> jx07XjkhcjhzResultVOS) {
        Integer saveRows = jx07XjkhcjhzResultService.saveEntity(jx07XjkhcjhzResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'07绩效考核汇总表'", notes = "批量更新,输入参数为Jx07XjkhcjhzResultVO的列表")
    @RequestMapping(value = "/kpi/jx07XjkhcjhzResult", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx07XjkhcjhzResultVO> jx07XjkhcjhzResultVOS) {
        //如果有ID为空，则不更新
        for (Jx07XjkhcjhzResultVO vo : jx07XjkhcjhzResultVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx07XjkhcjhzResultService.updateEntity(jx07XjkhcjhzResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'07绩效考核汇总表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx07XjkhcjhzResult", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows =  jx07XjkhcjhzResultService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }

    /**
     * 根据登录用户的用户id，角色，考核年份，考核周期查询所管理员工的考核成绩
     * @param userId
     * @param roleNames
     * @param khnf
     * @param khzq
     * @return
     */
    @RequestMapping(value = "/jx07XjkhcjhzResult/query", method = RequestMethod.GET)
    public HttpOutMsgBean queryByRoleName(@RequestParam(value = "userId",required = false) String userId,
                                          @RequestParam(value = "roleNames",required = false) String  roleNames,
                                          @RequestParam(value = "khnf",required = false) String khnf,
                                          @RequestParam(value = "khzq",required = false) String khzq,
                                          @RequestParam(value = "khdxlx",required = false) String khdxlx) {

        List<JSONObject> khjgs = jx07XjkhcjhzResultService.queryKhjg(userId, roleNames, khnf, khzq,khdxlx);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khjgs).build();
    }

    /**
     * 根据考核对象id，考核年份 查询近三年的考核结果
     * @param khdxId
     * @param khnf
     * @return
     */
    @RequestMapping(value = "/jx07XjkhcjhzResult/queryByUserId", method = RequestMethod.GET)
    public HttpOutMsgBean queryByUserId(@RequestParam(value = "khdxId",required = false) String khdxId,
                                        @RequestParam(value = "khnf",required = false) String khnf) {
        List<JSONObject> khjgs = jx07XjkhcjhzResultService.queryKhjg(khdxId, khnf);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khjgs).build();
    }


    @RequestMapping(value = "/jx07XjkhcjhzResult/add", method = RequestMethod.POST)
    public HttpOutMsgBean add(@RequestParam(value = "khdxId",required = false) String khdxId,
                              @RequestParam(value = "khdxName",required = false) String khdxName,
                              @RequestParam(value = "khdxLb",required = false) String khdxLb,
                              @RequestParam(value = "khnf",required = false) String khnf,
                              @RequestParam(value = "khzq",required = false) String khzq,
                              @RequestParam(value = "khdxjs",required = false) String khdxjs,
                              @RequestParam(value = "bmmc",required = false) String bmmc) {
        Integer saveRows =0;
        String zzDf=null;
        List<Jx07XjkhcjhzResultVO> jx07XjkhcjhzResultVOS=new ArrayList<>();
        Jx07XjkhcjhzResultVO jx07XjkhcjhzResultVO=new Jx07XjkhcjhzResultVO();
        jx07XjkhcjhzResultVO.setKhnf(khnf);
        jx07XjkhcjhzResultVO.setKhzq(khzq);
        jx07XjkhcjhzResultVO.setKhdxlb(khdxLb);
        jx07XjkhcjhzResultVO.setKhdxmc(khdxName);
        jx07XjkhcjhzResultVO.setKhdxid(khdxId);
        jx07XjkhcjhzResultVO.setKhdxjs(khdxjs);
        jx07XjkhcjhzResultVO.setBmmc(bmmc);
         if(khdxLb.equals("员工")){
            zzDf = jx07XjkhcjhzResultService.getYgDf(khdxId, khnf, khzq);
        }else if(khdxLb.equals("中层")){
            zzDf = jx07XjkhcjhzResultService.getZcNdDf(khdxId, khnf, khzq, khdxjs, bmmc);
        }
        DecimalFormat format = new DecimalFormat("0.00");
        jx07XjkhcjhzResultVO.setKhdf(format.format(new BigDecimal(zzDf)));
        jx07XjkhcjhzResultVOS.add(jx07XjkhcjhzResultVO);
        saveRows = jx07XjkhcjhzResultService.saveEntity(jx07XjkhcjhzResultVOS);//计算最终成绩

        //设置等级
        jx07XjkhcjhzResultService.updateDj(khdxId,khnf,khzq,bmmc,khdxjs);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(saveRows).build();
    }

    /**
     * 修改最终等级
     * @param id
     * @param zzdj
     * @param khdjtzr
     * @return
     */
    @RequestMapping(value = "/jx07XjkhcjhzResult/updateDj", method = RequestMethod.POST)
    public HttpOutMsgBean updateDj(@RequestParam(value = "id",required = false) String id,
                                   @RequestParam(value = "zzdj",required = false) String zzdj,
                                   @RequestParam(value = "khdjtzr",required = false) String khdjtzr) {
        Jx07XjkhcjhzResultVO jx07XjkhcjhzResultVO=new Jx07XjkhcjhzResultVO();
        List<Jx07XjkhcjhzResultVO> jx07XjkhcjhzResultVOS=new ArrayList<Jx07XjkhcjhzResultVO>();
        jx07XjkhcjhzResultVO.setId(id);
        jx07XjkhcjhzResultVO.setZzdj(zzdj);
        List<Jx13KhdjgjInfoPO> jx13KhdjgjInfoPOS = jx13KhdjgjInfoService.queryByDjmc(zzdj);
        jx07XjkhcjhzResultVO.setJxjf(jx13KhdjgjInfoPOS.get(0).getJxjf());
        jx07XjkhcjhzResultVO.setKhxs(jx13KhdjgjInfoPOS.get(0).getJxxs());
        jx07XjkhcjhzResultVO.setKedjtzr(khdjtzr);
        jx07XjkhcjhzResultVOS.add(jx07XjkhcjhzResultVO);
        int i = jx07XjkhcjhzResultService.saveEntity(jx07XjkhcjhzResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(i).build();
    }

    /**
     * 等级分布图
     * @param khnf
     * @param khzq
     * @param bmmc
     * @return
     */
    @RequestMapping(value = "/jx07XjkhcjhzResult/queryDjCount", method = RequestMethod.GET)
    public HttpOutMsgBean queryDjCount(@RequestParam(value = "khnf",required = false) String khnf,
                                       @RequestParam(value = "khzq",required = false) String khzq,
                                       @RequestParam(value = "bmmc",required = false) String bmmc) {
        List<JSONObject> khjgs = jx07XjkhcjhzResultService.queryDjCount(khnf, khzq, bmmc);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khjgs).build();
    }

    /**
     * 考核成绩分布图
     * @param khnf
     * @param khzq
     * @param bmmc
     * @return
     */
    @RequestMapping(value = "/jx07XjkhcjhzResult/queryFs", method = RequestMethod.GET)
    public HttpOutMsgBean queryFs(@RequestParam(value = "khnf",required = false) String khnf,
                                  @RequestParam(value = "khzq",required = false) String khzq,
                                  @RequestParam(value = "bmmc",required = false) String bmmc) {
        List<JSONObject> khjgs = jx07XjkhcjhzResultService.queryFsCount(khnf, khzq, bmmc);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khjgs).build();
    }

    /**
     * 添加特殊成员的最终成绩成绩
     * @param khdxId
     * @param khdxName
     * @param khdxLb
     * @param khnf
     * @param khzq
     * @param khdxjs
     * @param bmmc
     * @return
     */
    @RequestMapping(value = "/jx07XjkhcjhzResult/addTeShu", method = RequestMethod.POST)
    public HttpOutMsgBean addTeShu(@RequestParam(value = "khdxId",required = false) String khdxId,
                                   @RequestParam(value = "khdxName",required = false) String khdxName,
                                   @RequestParam(value = "khdxLb",required = false) String khdxLb,
                                   @RequestParam(value = "khnf",required = false) String khnf,
                                   @RequestParam(value = "khzq",required = false) String khzq,
                                   @RequestParam(value = "khdxjs",required = false) String khdxjs,
                                   @RequestParam(value = "bmmc",required = false) String bmmc) {

        String msg = jx07XjkhcjhzResultService.addTeShu(khdxId,khdxName,khdxLb,khnf,khzq,khdxjs,bmmc);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("query").msgContent(msg).build();

    }


    /**
     * 首页 考核结果等级分布图
     * @param khnf
     * @param khzq
     * @return
     */
    /*@RequestMapping(value = "/jx07XjkhcjhzResult/getKhdjFenPei", method = RequestMethod.GET)
    public HttpOutMsgBean getKhdjFenPei(@RequestParam(value = "khnf") String khnf,
                                        @RequestParam(value = "khzq") String khzq) {
        List<JSONObject> khdjFenPeis = jx07XjkhcjhzResultService.getKhdjFenPei(khnf, khzq);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khdjFenPeis).build();
    }*/

}