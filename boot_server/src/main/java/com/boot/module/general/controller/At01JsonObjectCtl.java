package com.boot.module.general.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.general.service.IAt01JsonObjectService;
import com.boot.repository.At01JsonObjectVO;
import com.boot.utils.HttpRequestUtils;
import com.boot.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description AT01_对象存储表
 * @CreateDate 创建时间：2018-08-13 11:27:28
 * @ModifiedBy
 * @ModifiedDate
 */

@RestController
@Api(tags = "BASE_'AT01_对象存储表'", description = "'AT01_对象存储表'增删改查的api，主要用于存储树型结构或不方便以标准格式存储的对象。")
public class At01JsonObjectCtl {

    @Resource(name = "at01JsonObjectService")
    private IAt01JsonObjectService at01JsonObjectService;

    @ApiOperation(value = "查询'AT01_对象存储表'记录数", notes = "根据传入参数查询'AT01_对象存储表'记录数,输入参数参照类At01JsonObjectVO")
    @RequestMapping(value = "/general/at01JsonObject", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = at01JsonObjectService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'AT01_对象存储表'", notes = "##### 根据传入参数查询'AT01_对象存储表'，输入参数参照类At01JsonObjectVO的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "At01JsonObjectVO.*", value = "At01JsonObjectVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int", example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int", example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/general/at01JsonObject", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);
        Iterable<At01JsonObjectVO> queryResult = at01JsonObjectService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    @ApiOperation(value = "新增'AT01_对象存储表'", notes = "批量新增,输入参数为At01JsonObjectVO的列表")
    @RequestMapping(value = "/general/at01JsonObject", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<At01JsonObjectVO> at01JsonObjectVOS) {
        Integer saveRows = at01JsonObjectService.saveEntity(at01JsonObjectVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'AT01_对象存储表'", notes = "批量更新,输入参数为At01JsonObjectVO的列表")
    @RequestMapping(value = "/general/at01JsonObject", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<At01JsonObjectVO> at01JsonObjectVOS) {
        //如果有ID为空，则不更新
        for (At01JsonObjectVO vo : at01JsonObjectVOS) {
            if (StringUtils.isEmpty(vo.getId())) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows = at01JsonObjectService.updateEntity(at01JsonObjectVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'AT01_对象存储表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/general/at01JsonObject", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows = at01JsonObjectService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove" + delRows).msgContent(delRows).build();
    }
}
