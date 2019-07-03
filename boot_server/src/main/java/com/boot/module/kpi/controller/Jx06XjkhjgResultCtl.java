package com.boot.module.kpi.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx06XjkhjgResultService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description 06绩效考核结果明细表 Controller
 * @CreateDate 创建时间： 2019-04-28 09:20:56
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@RestController
@Api(tags="BASE_'06绩效考核结果明细表'",description = "'06绩效考核结果明细表'增删改查api")
public class Jx06XjkhjgResultCtl {

    @Resource(name = "jx06XjkhjgResultService")
    private IJx06XjkhjgResultService jx06XjkhjgResultService;

    @ApiOperation(value = "查询'06绩效考核结果明细表'记录数", notes = "根据传入参数查询'06绩效考核结果明细表'记录数,输入参数参照类Jx06XjkhjgResultVO")
    @RequestMapping(value = "/kpi/jx06XjkhjgResult", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx06XjkhjgResultService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'06绩效考核结果明细表'", notes = "##### 根据传入参数查询'06绩效考核结果明细表'，参数名称参照Jx06XjkhjgResultVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx06XjkhjgResultVO.*", value = "Jx06XjkhjgResultVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/kpi/jx06XjkhjgResult", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx06XjkhjgResultVO> queryResult =  jx06XjkhjgResultService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'06绩效考核结果明细表'", notes = "批量新增,输入参数为Jx06XjkhjgResultVO的列表")
    @RequestMapping(value = "/kpi/jx06XjkhjgResult", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx06XjkhjgResultVO> jx06XjkhjgResultVOS) {
        Integer saveRows = jx06XjkhjgResultService.saveEntity(jx06XjkhjgResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'06绩效考核结果明细表'", notes = "批量更新,输入参数为Jx06XjkhjgResultVO的列表")
    @RequestMapping(value = "/kpi/jx06XjkhjgResult", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx06XjkhjgResultVO> jx06XjkhjgResultVOS) {
        //如果有ID为空，则不更新
        for (Jx06XjkhjgResultVO vo : jx06XjkhjgResultVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx06XjkhjgResultService.updateEntity(jx06XjkhjgResultVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'06绩效考核结果明细表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx06XjkhjgResult", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows =  jx06XjkhjgResultService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }

    /**
     * 每次打分都提交一次
     * @param khdxId
     * @param khdxName
     * @param khdxLb
     * @param khnf
     * @param khzq
     * @param khztId
     * @param khztName
     * @param zbId
     * @param pfyy
     * @param zbdfid
     * @param zbdf
     * @return
     */
    @ApiOperation(value = "新增'06绩效考核结果明细'", notes = "批量新增,输入参数为Jx06XjkhjgResultVO的列表")
    @RequestMapping(value = "/jx06XjkhjgResult/add", method = RequestMethod.POST)
    public HttpOutMsgBean add(@RequestParam(value = "khdxId",required = false) String khdxId,
                              @RequestParam(value = "khdxName",required = false) String khdxName,
                              @RequestParam(value = "khdxLb",required = false) String khdxLb,
                              @RequestParam(value = "khnf",required = false) String khnf,
                              @RequestParam(value = "khzq",required = false) String khzq,
                              @RequestParam(value = "khztId",required = false) String khztId,
                              @RequestParam(value = "khztName",required = false) String khztName,
                              @RequestParam(value = "zblx",required = false) String zblx,
                              @RequestParam(value = "zbId",required = false) String zbId,
                              @RequestParam(value = "pfyy",required = false) String pfyy,
                              @RequestParam(value = "zbdfid",required = false) String zbdfid,
                              @RequestParam(value = "zbdf",required = false) String zbdf) {
        List<Jx06XjkhjgResultVO> jx06XjkhjgResultVOS=new ArrayList<>();
        Jx06XjkhjgResultVO jx06XjkhjgResultVO=new Jx06XjkhjgResultVO();
        Integer saveRows =0;
        jx06XjkhjgResultVO.setKhnf(khnf);
        jx06XjkhjgResultVO.setKhzq(khzq);
        jx06XjkhjgResultVO.setKhdxlb(khdxLb);
        jx06XjkhjgResultVO.setKhdxmc(khdxName);
        jx06XjkhjgResultVO.setKhdxid(khdxId);
        jx06XjkhjgResultVO.setZbid(zbId);
        jx06XjkhjgResultVO.setZbdf(zbdf);
        jx06XjkhjgResultVO.setKhztid(khztId);
        jx06XjkhjgResultVO.setKhztmc(khztName);
        jx06XjkhjgResultVO.setPfyy(pfyy);
        jx06XjkhjgResultVO.setZblx(zblx);
        if(StringUtils.isEmpty(zbdfid)){
            jx06XjkhjgResultVOS.add(jx06XjkhjgResultVO);
            saveRows = jx06XjkhjgResultService.saveEntity(jx06XjkhjgResultVOS);
        }else{
            if(StringUtils.isEmpty(zbdf)){
                List<String> ids =new ArrayList<>();
                ids.add(zbdfid);
                saveRows =jx06XjkhjgResultService.removeEntity(ids);
            }else{
                jx06XjkhjgResultVO.setId(zbdfid);
                jx06XjkhjgResultVOS.add(jx06XjkhjgResultVO);
                saveRows = jx06XjkhjgResultService.saveEntity(jx06XjkhjgResultVOS);
            }
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /**
     * 查询胜任力和态度类的得分
     * 用于考核页面
     * @param khnf
     * @param khzq
     * @param khdxId
     * @param khztId
     * @param khdxLb
     * @param zblx
     * @return
     */
    @RequestMapping(value = "/jx06XjkhjgResult/queryDf", method = RequestMethod.GET)
    public HttpOutMsgBean queryDf(@RequestParam(value = "khnf",required = false) String khnf,
                                  @RequestParam(value = "khzq",required = false) String khzq,
                                  @RequestParam(value = "khdxId",required = false) String khdxId,
                                  @RequestParam(value = "khztId",required = false) String khztId,
                                  @RequestParam(value = "khdxLb",required = false) String khdxLb,
                                  @RequestParam(value = "zblx",required = false) String zblx) {

        List<JSONObject> jsonObjects = jx06XjkhjgResultService.queryDf(khnf,khzq,khdxId,khztId,khdxLb,zblx);
        //Iterable<Jx06XjkhjgResultVO> queryResult =  jx06XjkhjgResultService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(jsonObjects).build();
    }


}