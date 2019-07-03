package com.boot.module.kpi.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx14YdzbStateService;
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
 * @Description JX14_YDZB_STATE Controller
 * @CreateDate 创建时间： 2019-01-10 14:19:25
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@RestController
@Api(tags="BASE_'JX14_YDZB_STATE'",description = "'JX14_YDZB_STATE'增删改查api")
public class Jx14YdzbStateCtl {

    @Resource(name = "jx14YdzbStateService")
    private IJx14YdzbStateService jx14YdzbStateService;

    @ApiOperation(value = "查询'JX14_YDZB_STATE'记录数", notes = "根据传入参数查询'JX14_YDZB_STATE'记录数,输入参数参照类Jx14YdzbStateVO")
    @RequestMapping(value = "/kpi/jx14YdzbState", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx14YdzbStateService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'JX14_YDZB_STATE'", notes = "##### 根据传入参数查询'JX14_YDZB_STATE'，参数名称参照Jx14YdzbStateVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx14YdzbStateVO.*", value = "Jx14YdzbStateVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/jx14YdzbState/query", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx14YdzbStateVO> queryResult =  jx14YdzbStateService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    /*@ApiOperation(value = "新增'JX14_YDZB_STATE'", notes = "批量新增,输入参数为Jx14YdzbStateVO的列表")
    @RequestMapping(value = "/kpi/jx14YdzbState", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx14YdzbStateVO> jx14YdzbStateVOS) {
        Integer saveRows = jx14YdzbStateService.saveEntity(jx14YdzbStateVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }*/
/*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'JX14_YDZB_STATE'", notes = "批量新增,输入参数为Jx14YdzbStateVO的列表")
    @RequestMapping(value = "/jx14YdzbState/reset", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestParam(value = "khdxName",required = false) String khdxName,
                               @RequestParam(value = "khdxId",required = false) String khdxId,
                               @RequestParam(value = "khnf",required = false) String khnf,
                               @RequestParam(value = "zbzt",required = false) String zbzt,
                               @RequestParam(value="id",required = false)String id,
                               @RequestParam(value="thyy",required = false)String thyy,
                               @RequestParam(value="thry",required = false)String thry,
                               @RequestParam(value="thryid",required = false)String thryid) {
        List<Jx14YdzbStateVO> jx14YdzbStateVOS=new ArrayList<>();
        Jx14YdzbStateVO jx14YdzbStateVO=new Jx14YdzbStateVO();
        Integer saveRows=null;
        //将所有的考核对象的原有状态数据设置为N
        jx14YdzbStateVO.setKhdx(khdxName);
        jx14YdzbStateVO.setKhdxid(khdxId);
        jx14YdzbStateVO.setKhnf(khnf);
        jx14YdzbStateVO.setZt(zbzt);
        jx14YdzbStateVO.setThyy(thyy);
        jx14YdzbStateVO.setThuser(thry);
        jx14YdzbStateVO.setThuserid(thryid);
        jx14YdzbStateVO.setYxbs("Y");
        if(StringUtils.isEmpty(id)){
            jx14YdzbStateVOS.add(jx14YdzbStateVO);
            saveRows=jx14YdzbStateService.saveEntity(jx14YdzbStateVOS);
        }else{
            jx14YdzbStateVO.setId(id);
            jx14YdzbStateVOS.add(jx14YdzbStateVO);
            saveRows= jx14YdzbStateService.saveEntity(jx14YdzbStateVOS);
        }
       /* jx14YdzbStateService.updateYxbsByid(khdxId,khnf);*/
        //新增考核对象签订及审核状态


        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'JX14_YDZB_STATE'", notes = "批量新增,输入参数为Jx14YdzbStateVO的列表")
    @RequestMapping(value = "/jx14YdzbState/saveAndUpdate", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestParam(value = "khdxName",required = false) String khdxName,
                               @RequestParam(value = "khdxId",required = false) String khdxId,
                               @RequestParam(value = "khnf",required = false) String khnf,
                               @RequestParam(value = "zbzt",required = false) String zbzt,
                               @RequestParam(value="id",required = false)String id) {
        List<Jx14YdzbStateVO> jx14YdzbStateVOS=new ArrayList<>();
        Jx14YdzbStateVO jx14YdzbStateVO=new Jx14YdzbStateVO();
        Integer saveRows=null;
        jx14YdzbStateVO.setKhdx(khdxName);
        jx14YdzbStateVO.setKhdxid(khdxId);
        jx14YdzbStateVO.setKhnf(khnf);
        jx14YdzbStateVO.setZt(zbzt);
        if(StringUtils.isEmpty(id)){
            jx14YdzbStateVOS.add(jx14YdzbStateVO);
            saveRows = jx14YdzbStateService.saveEntity(jx14YdzbStateVOS);
        }else{
            jx14YdzbStateVO.setId(id);
            jx14YdzbStateVOS.add(jx14YdzbStateVO);
            saveRows= jx14YdzbStateService.updateEntity(jx14YdzbStateVOS);
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }
    @ApiOperation(value = "更新'JX14_YDZB_STATE'", notes = "批量更新,输入参数为Jx14YdzbStateVO的列表")
    @RequestMapping(value = "/kpi/jx14YdzbState", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx14YdzbStateVO> jx14YdzbStateVOS) {
        //如果有ID为空，则不更新
        for (Jx14YdzbStateVO vo : jx14YdzbStateVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx14YdzbStateService.updateEntity(jx14YdzbStateVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    /*@ApiOperation(value = "删除'JX14_YDZB_STATE'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx14YdzbState", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows =  jx14YdzbStateService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }*/

    @ApiOperation(value = "删除'JX14_YDZB_STATE'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/jx14YdzbState/remove", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestParam(value = "rowid",required = false) String rowid) {
        List<String> ids=new ArrayList<>();
        ids.add(rowid);
        Integer delRows =  jx14YdzbStateService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }


}