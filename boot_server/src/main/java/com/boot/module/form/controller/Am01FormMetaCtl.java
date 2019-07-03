package com.boot.module.form.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.form.service.IAm01FormMetaService;
import com.boot.module.form.service.IAm02FormMetaItemService;
import com.boot.repository.Am01FormMetaVO;
import com.boot.repository.Am02FormMetaItemVO;
import com.boot.utils.HttpRequestUtils;
import com.boot.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author CodeGen
 * @Description AM01_表单列表
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@RestController
@Api(tags = "BASE_'AM01_表单列表'", description = "'AM01_表单列表'增删改查api")
public class Am01FormMetaCtl {
    @Resource(name = "am01FormMetaService")
    private IAm01FormMetaService am01FormMetaService;

    @Resource(name = "am02FormMetaItemService")
    private IAm02FormMetaItemService am02FormMetaItemService;

    @ApiOperation(value = "查询'AM01_表单列表'记录数", notes = "根据传入参数查询'AM01_表单列表'记录数,输入参数参照类Am01FormMetaVO")
    @RequestMapping(value = "/form/am01FormMeta", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = am01FormMetaService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'AM01_表单列表'", notes = "##### 根据传入参数查询'AM01_表单列表'，输入参数参照类Am01FormMetaVO的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。" +
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
            @ApiImplicitParam(name = "Am01FormMetaVO.*", value = "Am01FormMetaVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int", example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int", example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "keepOrgin", value = "是否对待选内容进行转换", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/form/am01FormMeta", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "keepOrgin", required = false) String keepOrgin) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        //分页内容
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);
        Iterable<Am01FormMetaVO> queryResult = am01FormMetaService.queryEntity(paramMap, pageable);
        //
        for (Am01FormMetaVO am01FormMetaVO : queryResult) {
            Iterable<Am02FormMetaItemVO> am02FormMetaItemVOS = am02FormMetaItemService.queryEntityByFormId(am01FormMetaVO.getId());
            //是否转换待选列表,Y不转换，其他选项转换，
            am02FormMetaItemService.loadMetaValueListFromDb(am02FormMetaItemVOS, "Y".equals(keepOrgin));

            List<Am02FormMetaItemVO> list = IteratorUtils.toList(am02FormMetaItemVOS.iterator());
            Collections.sort(list, Comparator.comparingInt(Am02FormMetaItemVO::getMetaSeq));
            am01FormMetaVO.setFormItems(list);
        }
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("query").msgContent(queryResult).build();
    }

    @ApiOperation(value = "新增'AM01_表单列表'", notes = "批量新增,输入参数为Am01FormMetaVO的列表")
    @RequestMapping(value = "/form/am01FormMeta", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Am01FormMetaVO> am01FormMetaVOS) {
        Integer saveRows = am01FormMetaService.saveEntity(am01FormMetaVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'AM01_表单列表'", notes = "批量更新,输入参数为Am01FormMetaVO的列表")
    @RequestMapping(value = "/form/am01FormMeta", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Am01FormMetaVO> am01FormMetaVOS) {
        //如果有ID为空，则不更新
        for (Am01FormMetaVO vo : am01FormMetaVOS) {
            if (StringUtils.isEmpty(vo.getId())) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows = am01FormMetaService.updateEntity(am01FormMetaVOS);
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'AM01_表单列表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/form/am01FormMeta", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows = am01FormMetaService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("remove").msgContent(delRows).build();
    }
}
