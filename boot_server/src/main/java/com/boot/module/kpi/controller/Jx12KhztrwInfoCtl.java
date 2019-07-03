package com.boot.module.kpi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx12KhztrwInfoService;
import com.boot.module.kpi.service.KhdxTreeService;
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
import net.sf.json.JSONArray;
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
 * @author CodeGen
 * @Description 12考核主体任务表 Controller
 * @CreateDate 创建时间： 2019-02-14 16:11:13
 * @ModifiedBy
 * @ModifiedDate
 */
@RestController
@Api(tags = "BASE_'12考核主体任务表'", description = "'12考核主体任务表'增删改查api")
public class Jx12KhztrwInfoCtl {

    @Resource(name = "jx12KhztrwInfoService")
    private IJx12KhztrwInfoService jx12KhztrwInfoService;
    @Resource(name = "khdxTreeService")
    private KhdxTreeService khdxTreeService;

    @ApiOperation(value = "查询'12考核主体任务表'记录数", notes = "根据传入参数查询'12考核主体任务表'记录数,输入参数参照类Jx12KhztrwInfoVO")
    @RequestMapping(value = "/kpi/jx12KhztrwInfo", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx12KhztrwInfoService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'12考核主体任务表'", notes = "##### 根据传入参数查询'12考核主体任务表'，参数名称参照Jx12KhztrwInfoVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx12KhztrwInfoVO.*", value = "Jx12KhztrwInfoVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int", example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int", example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/jx12KhztrwInfo/query", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);
        Iterable<Jx12KhztrwInfoVO> queryResult = jx12KhztrwInfoService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    /*@ApiOperation(value = "新增'12考核主体任务表'", notes = "批量新增,输入参数为Jx12KhztrwInfoVO的列表")
    @RequestMapping(value = "/kpi/jx12KhztrwInfo", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS) {
        Integer saveRows = jx12KhztrwInfoService.saveEntity(jx12KhztrwInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }*/
    @ApiOperation(value = "新增'12考核主体任务表'", notes = "批量新增,输入参数为Jx12KhztrwInfoVO的列表")
    @RequestMapping(value = "/jx12KhztrwInfo/add", method = RequestMethod.POST)
    public HttpOutMsgBean add(@RequestParam(value = "arr") String arr) {
        //根据考核对象id 考核年份 考核周期 考核指标类型删除所有的考核主体任务

        List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS = new ArrayList<Jx12KhztrwInfoVO>();
        Integer saveRows=0;
        System.out.println(arr);
        net.sf.json.JSONObject khzt= net.sf.json.JSONObject.fromObject(arr);
        System.out.println(khzt.get("khztList"));
        net.sf.json.JSONArray khztList = (net.sf.json.JSONArray)khzt.get("khztList");
        String khztList1 = khzt.getString("khztList");
        String[] khdlss =khzt.getString("khdlList").split(",");
        List<String> ids = jx12KhztrwInfoService.getJx12ByKhdxIdAndKhnf(khzt.getString("khdxId"), khzt.getString("khnf"), khzt.getString("khzq"),khdlss);
        Integer integer = jx12KhztrwInfoService.removeEntity(ids);

        for (String khlb : khdlss) {
        for(int i=0;i<khztList.size();i++){
            net.sf.json.JSONObject khztInfo = net.sf.json.JSONObject.fromObject(khztList.get(i));
            System.out.println(khztInfo);
            Jx12KhztrwInfoVO jx12KhztrwInfoVO = new Jx12KhztrwInfoVO();
            jx12KhztrwInfoVO.setKhnf( khzt.getString("khnf"));
            jx12KhztrwInfoVO.setKhdx(khzt.getString("khdxName"));
            jx12KhztrwInfoVO.setKhdxid(khzt.getString("khdxId"));
            jx12KhztrwInfoVO.setKhdxjs(khzt.getString("khdxRoleName"));
            jx12KhztrwInfoVO.setKhztid(khztInfo.getString("khztId"));
            jx12KhztrwInfoVO.setKhzt(khztInfo.getString("khzt"));
            jx12KhztrwInfoVO.setKhztqz(khztInfo.getString("khztQz"));
            jx12KhztrwInfoVO.setKhztjs(khztInfo.getString("khztRoleName"));
            jx12KhztrwInfoVO.setKhlx(khzt.getString("khlx"));
            jx12KhztrwInfoVO.setKhzq(khzt.getString("khzq"));
            jx12KhztrwInfoVO.setBz(khztInfo.getString("bz"));
            jx12KhztrwInfoVO.setZblx(khlb);
            jx12KhztrwInfoVOS.add(jx12KhztrwInfoVO);
            saveRows = jx12KhztrwInfoService.saveEntity(jx12KhztrwInfoVOS);
        }
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /*@ApiOperation(value = "更新'12考核主体任务表'", notes = "批量更新,输入参数为Jx12KhztrwInfoVO的列表")
    @RequestMapping(value = "/kpi/jx12KhztrwInfo", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS) {
        //如果有ID为空，则不更新
        for (Jx12KhztrwInfoVO vo : jx12KhztrwInfoVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                 return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx12KhztrwInfoService.updateEntity(jx12KhztrwInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }*/
    /*@ApiOperation(value = "更新'12考核主体任务表'", notes = "批量更新,输入参数为Jx12KhztrwInfoVO的列表")
    @RequestMapping(value = "/jx12KhztrwInfo/update", method = RequestMethod.POST)
    public HttpOutMsgBean update(@RequestParam(value = "id") String id,
                                 @RequestParam(value = "khztName") String khztName,
                                 @RequestParam(value = "khztId") String khztId,
                                 @RequestParam(value = "khztQz") String khztQz) {
        //如果有ID为空，则不更新
        if (StringUtils.isEmpty(id)) {
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
        }
        int updateRows = jx12KhztrwInfoService.updateYxbsByid(id, khztId, khztName, khztQz);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(updateRows).build();
    }*/

    @ApiOperation(value = "删除'12考核主体任务表'", notes = "批量删除，传入参数为对应记录ID列表")
     @RequestMapping(value = "/jx12KhztrwInfo/delete", method = RequestMethod.POST)
     public HttpOutMsgBean remove(  @RequestParam(value = "khdxid", required = false) String khdxid,
                                    @RequestParam(value = "khzq", required = false) String khzq,
                                   @RequestParam(value = "khnf", required = false) String khnf,
                                   @RequestParam(value = "zblb", required = false) String zblb,
                                    @RequestParam(value = "khztid", required = false) String khztid ) {
        String[] zblbs = zblb.split(",");
        List<String> khrwids = jx12KhztrwInfoService.getId(khdxid, khnf,  khzq,zblbs, khztid);
         Integer delRows =  jx12KhztrwInfoService.removeEntity(khrwids);
         return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
     }
    /*@ApiOperation(value = "删除'12考核主体任务表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/jx12KhztrwInfo/delete", method = RequestMethod.POST)
    public HttpOutMsgBean remove(@RequestParam(value = "id") String id) {
        List<String> ids = new ArrayList<String>();
        ids.add(id);
        Integer delRows = jx12KhztrwInfoService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }*/

    /*@ApiOperation(value = "查询'12考核主体任务表'记录数", notes = "根据传入参数查询'12考核主体任务表'记录数,输入参数参照类Jx12KhztrwInfoVO")
    @RequestMapping(value = "/jx12KhztrwInfo/saveAll", method = RequestMethod.POST)
    public HttpOutMsgBean SaveAll(HttpServletRequest request) {
        jx12KhztrwInfoService.addRws();
        //Integer integer = jx12KhztrwInfoService.saveEntity(jx12KhztrwInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent("").build();
    }*/

    /**
     * 根据考核主体和考核类型 查询考核对象
     * 用于考核页面的侧边栏
     * @param userId
     * @param roleNames
     * @param khzq
     * @param khnf
     * @param khlx
     * @return
     */
    @RequestMapping(value = "/jx12KhztrwInfo/queryByKhztIdAndRole", method = RequestMethod.GET)
    public HttpOutMsgBean queryByKhztIdAndRole(@RequestParam(value = "userId", required = false) String userId,
                                               @RequestParam(value = "roleNames", required = false) String roleNames,
                                               @RequestParam(value = "khzq", required = false) String khzq,
                                               @RequestParam(value = "khnf", required = false) String khnf,
                                               @RequestParam(value = "khlx", required = false) String khlx) {

        List<JSONObject> khdxTreeList = khdxTreeService.queryKhdx(userId, roleNames,khzq,khnf,khlx);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khdxTreeList).build();
    }

    /**
     * 查询考核任务
     * 用于考核主体分配页面 表格展示
     * @param khzq
     * @param khnf
     * @return
     */
    @RequestMapping(value = "/jx12KhztrwInfo/queryAll", method = RequestMethod.GET)
    public HttpOutMsgBean queryAll(@RequestParam(value = "khzq") String khzq,@RequestParam(value = "khnf") String khnf) {
        List<Jx12KhztrwInfoPO> jx12KhztrwInfoPOS = jx12KhztrwInfoService.queryAll(khzq,khnf);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(jx12KhztrwInfoPOS).build();
    }


    /**
     * 更新考核得分
     * @param khdfArr
     * @return
     */
    @RequestMapping(value = "/jx12KhztrwInfo/updateDf", method = RequestMethod.POST)
    public HttpOutMsgBean updateDf(@RequestParam(value = "khdfArr") String khdfArr) {
        //根据考核对象id 考核年份 考核周期 考核指标类型删除所有的考核主体任务

        List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS = new ArrayList<Jx12KhztrwInfoVO>();
        Integer saveRows=0;
       System.out.println(khdfArr);
        net.sf.json.JSONObject khdf= net.sf.json.JSONObject.fromObject(khdfArr);
        System.out.println(khdf.get("khDfList"));
        net.sf.json.JSONArray khDfList = (net.sf.json.JSONArray)khdf.get("khDfList");
            for(int i=0;i<khDfList.size();i++){
                net.sf.json.JSONObject khdfInfo = net.sf.json.JSONObject.fromObject(khDfList.get(i));
                System.out.println(khdfInfo);
                saveRows=jx12KhztrwInfoService.updateDf(khdfInfo.getString("khdf"),khdfInfo.getString("khdxId"),khdfInfo.getString("khztId"),khdfInfo.getString("khnf"),khdfInfo.getString("khzq"),khdfInfo.getString("zblx"));
            }

        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /**
     * 查找特殊员工
     * 用于特殊员工考核页面侧边栏
     * @param userId
     * @param khzq
     * @param khnf
     * @return
     */
    @RequestMapping(value = "/jx12KhztrwInfo/queryTsry", method = RequestMethod.GET)
    public HttpOutMsgBean queryTsry(@RequestParam(value = "userId") String userId,
                                    @RequestParam(value = "khzq") String khzq,
                                    @RequestParam(value = "khnf") String khnf) {

        List<JSONObject> khdxTreeList = khdxTreeService.queryTsry(userId,khzq,khnf);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(khdxTreeList).build();
    }
}