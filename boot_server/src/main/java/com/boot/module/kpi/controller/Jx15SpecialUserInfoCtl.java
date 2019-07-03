package com.boot.module.kpi.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx12KhztrwInfoService;
import com.boot.module.kpi.service.IJx15SpecialUserInfoService;
import com.boot.module.kpi.service.impl.Jx12KhztrwInfoServiceImpl;
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
 * @Description JX15_SPECIAL_USER_INFO Controller
 * @CreateDate 创建时间： 2019-01-18 14:07:59
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@RestController
@Api(tags="BASE_'JX15_SPECIAL_USER_INFO'",description = "'JX15_SPECIAL_USER_INFO'增删改查api")
public class Jx15SpecialUserInfoCtl {

    @Resource(name = "jx15SpecialUserInfoService")
    private IJx15SpecialUserInfoService jx15SpecialUserInfoService;
    @Resource(name="jx12KhztrwInfoService")
    private IJx12KhztrwInfoService jx12KhztrwInfoService;
    @ApiOperation(value = "查询'JX15_SPECIAL_USER_INFO'记录数", notes = "根据传入参数查询'JX15_SPECIAL_USER_INFO'记录数,输入参数参照类Jx15SpecialUserInfoVO")
    @RequestMapping(value = "/kpi/jx15SpecialUserInfo", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx15SpecialUserInfoService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'JX15_SPECIAL_USER_INFO'", notes = "##### 根据传入参数查询'JX15_SPECIAL_USER_INFO'，参数名称参照Jx15SpecialUserInfoVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx15SpecialUserInfoVO.*", value = "Jx15SpecialUserInfoVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/jx15SpecialUserInfo/queryAll", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx15SpecialUserInfoVO> queryResult =  jx15SpecialUserInfoService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    /*@ApiOperation(value = "新增'JX15_SPECIAL_USER_INFO'", notes = "批量新增,输入参数为Jx15SpecialUserInfoVO的列表")
    @RequestMapping(value = "/kpi/jx15SpecialUserInfo", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx15SpecialUserInfoVO> jx15SpecialUserInfoVOS) {
        Integer saveRows = jx15SpecialUserInfoService.saveEntity(jx15SpecialUserInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }*/
    @ApiOperation(value = "新增'JX15_SPECIAL_USER_INFO'", notes = "批量新增,输入参数为Jx15SpecialUserInfoVO的列表")
    @RequestMapping(value = "/jx15SpecialUserInfo/save", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestParam(value="userId")String userId,
                               @RequestParam(value = "username")String userName) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        List<Jx15SpecialUserInfoVO> jx15SpecialUserInfoVOS=new ArrayList<>();
        Jx15SpecialUserInfoVO jx15SpecialUserInfoVO=new Jx15SpecialUserInfoVO();
        jx15SpecialUserInfoVO.setUserId(userId);
        jx15SpecialUserInfoVO.setUserName(userName);
        jx15SpecialUserInfoVO.setYxbs("Y");
        jx15SpecialUserInfoVO.setKhnf(""+year);
        jx15SpecialUserInfoVOS.add(jx15SpecialUserInfoVO);
        Integer saveRows = jx15SpecialUserInfoService.saveEntity(jx15SpecialUserInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }
    @ApiOperation(value = "更新'JX15_SPECIAL_USER_INFO'", notes = "批量更新,输入参数为Jx15SpecialUserInfoVO的列表")
    @RequestMapping(value = "/kpi/jx15SpecialUserInfo", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx15SpecialUserInfoVO> jx15SpecialUserInfoVOS) {
        //如果有ID为空，则不更新
        for (Jx15SpecialUserInfoVO vo : jx15SpecialUserInfoVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx15SpecialUserInfoService.updateEntity(jx15SpecialUserInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    /*@ApiOperation(value = "删除'JX15_SPECIAL_USER_INFO'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx15SpecialUserInfo", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows =  jx15SpecialUserInfoService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }*/

    @ApiOperation(value = "删除'JX15_SPECIAL_USER_INFO'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/jx15SpecialUserInfo/delete", method = RequestMethod.POST)
    public HttpOutMsgBean remove(@RequestParam(value="khdxid")String khdxid ,
                                 @RequestParam(value="khnf")String khnf,
                                 @RequestParam(value="id")String id,
                                 @RequestParam(value = "khzq")String khzq) {

        List<String> jx15Ids = new ArrayList<String>();
        jx15Ids.add(id);
        List<String> jx12Ids = jx12KhztrwInfoService.getJx12ByKhdxIdAndKhnf(khdxid,khnf,khzq);
        if(jx12Ids.size()==0){
            Integer delRows =  jx15SpecialUserInfoService.removeEntity(jx15Ids);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
        }else{
            Integer delRows =  jx15SpecialUserInfoService.removeEntity(jx15Ids);
            Integer integer = jx12KhztrwInfoService.removeEntity(jx12Ids);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent("").build();
        }

    }
}