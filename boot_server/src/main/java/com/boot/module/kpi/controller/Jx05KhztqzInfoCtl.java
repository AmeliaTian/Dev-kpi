package com.boot.module.kpi.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx05KhztqzInfoService;
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
import java.util.*;

/**
 * @Description 05考核主体权重表 Controller
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@RestController
@Api(tags="BASE_'05考核主体权重表'",description = "'05考核主体权重表'增删改查api")
public class Jx05KhztqzInfoCtl {

    @Resource(name = "jx05KhztqzInfoService")
    private IJx05KhztqzInfoService jx05KhztqzInfoService;

    @ApiOperation(value = "查询'05考核主体权重表'记录数", notes = "根据传入参数查询'05考核主体权重表'记录数,输入参数参照类Jx05KhztqzInfoVO")
    @RequestMapping(value = "/kpi/jx05KhztqzInfo", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx05KhztqzInfoService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'05考核主体权重表'", notes = "##### 根据传入参数查询'05考核主体权重表'，参数名称参照Jx05KhztqzInfoVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
        @ApiImplicitParam(name = "Jx05KhztqzInfoVO.*", value = "Jx05KhztqzInfoVO实体中相关属性名", dataType = "*", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
        @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
        @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/jx05KhztqzInfo/query", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx05KhztqzInfoVO> queryResult =  jx05KhztqzInfoService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

/*如果可编辑(table)，则生成下边的更新操作*/
   /* @ApiOperation(value = "新增'05考核主体权重表'", notes = "批量新增,输入参数为Jx05KhztqzInfoVO的列表")
    @RequestMapping(value = "/kpi/jx05KhztqzInfo", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx05KhztqzInfoVO> jx05KhztqzInfoVOS) {
        Integer saveRows = jx05KhztqzInfoService.saveEntity(jx05KhztqzInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'05考核主体权重表'", notes = "批量更新,输入参数为Jx05KhztqzInfoVO的列表")
    @RequestMapping(value = "/kpi/jx05KhztqzInfo", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx05KhztqzInfoVO> jx05KhztqzInfoVOS) {
        //如果有ID为空，则不更新
        for (Jx05KhztqzInfoVO vo : jx05KhztqzInfoVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                 return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx05KhztqzInfoService.updateEntity(jx05KhztqzInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }*/

    @ApiOperation(value = "删除'05考核主体权重表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/jx05KhztqzInfo/deleteById", method = RequestMethod.POST)
    public HttpOutMsgBean remove(@RequestParam(value="id",required = false) String id) {
        List<String> ids=new ArrayList<>();
        ids.add(id);
        Integer delRows =  jx05KhztqzInfoService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }

    @ApiOperation(value = "新增或更新'05考核主体权重表'", notes = "输入参数为Jx05KhztqzInfoVO的列表")
    @RequestMapping(value = "/jx05KhztqzInfo/savaOrUpdate", method = RequestMethod.POST)
    public HttpOutMsgBean savaOrUpdate(HttpServletRequest request) {
        //如果有ID为空，则不更新
       /* for (Jx05KhztqzInfoVO vo : jx05KhztqzInfoVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx05KhztqzInfoService.updateEntity(jx05KhztqzInfoVOS);*/
        Integer saveRows=null;
        List<Jx05KhztqzInfoVO> jx05KhztqzInfoVOS=new ArrayList<Jx05KhztqzInfoVO>();
        Jx05KhztqzInfoVO jx05KhztqzInfoVO=new Jx05KhztqzInfoVO();
        jx05KhztqzInfoVO.setKhdxjsid(request.getParameter("khdxjsid"));
        jx05KhztqzInfoVO.setKhdxjs(request.getParameter("khdxjs"));
        jx05KhztqzInfoVO.setZbdl(request.getParameter("zbdl"));
        jx05KhztqzInfoVO.setKhztjs(request.getParameter("khztjs"));
        jx05KhztqzInfoVO.setKhztjsid(request.getParameter("khztjsid"));
        jx05KhztqzInfoVO.setQz(request.getParameter("qz"));
        jx05KhztqzInfoVO.setYxbs("Y");
        jx05KhztqzInfoVO.setBz(request.getParameter("bz"));
       if(StringUtils.isEmpty(request.getParameter("id"))){
           jx05KhztqzInfoVOS.add(jx05KhztqzInfoVO);
           saveRows = jx05KhztqzInfoService.saveEntity(jx05KhztqzInfoVOS);
       }else{
           jx05KhztqzInfoVO.setId(request.getParameter("id"));
           jx05KhztqzInfoVO.setUpdatetime(new Date());
           jx05KhztqzInfoVOS.add(jx05KhztqzInfoVO);
           saveRows = jx05KhztqzInfoService.updateEntity(jx05KhztqzInfoVOS);
       }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }


    @ApiOperation(value = "根据角色id,用户id查询所有的考核主体及权重", notes = "用于考核主体配置页面")
    @RequestMapping(value = "/jx05KhztqzInfo/queryUserInfo",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean queryUserInfo(@RequestParam(value="roleId")String roleId,
                                        @RequestParam(value="userId")String userId,
                                        @RequestParam(value="orgId")String orgId,
                                        @RequestParam(value="zsldid")String zsldid,
                                        @RequestParam(value="zblx")String zblx) {
        List<JSONObject> jsonObjects = jx05KhztqzInfoService.queryUserInfo(userId, roleId, orgId,zsldid,zblx);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(jsonObjects).build();
    }
}