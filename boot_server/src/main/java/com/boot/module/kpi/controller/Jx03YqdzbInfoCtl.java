package com.boot.module.kpi.controller;


import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx02ZbpfxzInfoService;
import com.boot.module.kpi.service.IJx03YqdzbInfoService;
import com.boot.repository.Jx02ZbpfxzInfoVO;
import com.boot.repository.Jx03YqdzbInfoPO;
import com.boot.repository.Jx03YqdzbInfoVO;
import com.boot.repository.ZbEntity;
import com.boot.utils.HttpRequestUtils;
import com.boot.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.lang3.StringUtils;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description 03已签订指标表 Controller
 * @CreateDate 创建时间： 2019-04-04 10:38:13
 * @ModifiedBy
 * @ModifiedDate
 */
@RestController
@Api(tags = "BASE_'03已签订指标表'", description = "'03已签订指标表'增删改查api")
public class Jx03YqdzbInfoCtl {



    @Resource(name = "jx03YqdzbInfoService")
    private IJx03YqdzbInfoService jx03YqdzbInfoService;

    @Resource(name = "jx02ZbpfxzInfoService")
    private IJx02ZbpfxzInfoService jx02ZbpfxzInfoService;

    @ApiOperation(value = "查询'03已签订指标表'记录数", notes = "根据传入参数查询'03已签订指标表'记录数,输入参数参照类Jx03YqdzbInfoVO")
    @RequestMapping(value = "/kpi/jx03YqdzbInfo", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx03YqdzbInfoService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'03已签订指标表'", notes = "##### 根据传入参数查询'03已签订指标表'，参数名称参照Jx03YqdzbInfoVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx03YqdzbInfoVO.*", value = "Jx03YqdzbInfoVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int", example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int", example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/kpi/jx03YqdzbInfo", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);
        Iterable<Jx03YqdzbInfoVO> queryResult = jx03YqdzbInfoService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'03已签订指标表'", notes = "批量新增,输入参数为Jx03YqdzbInfoVO的列表")
    @RequestMapping(value = "/kpi/jx03YqdzbInfo", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS) {
        Integer saveRows = jx03YqdzbInfoService.saveEntity(jx03YqdzbInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'03已签订指标表'", notes = "批量更新,输入参数为Jx03YqdzbInfoVO的列表")
    @RequestMapping(value = "/kpi/jx03YqdzbInfo", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS) {
        //如果有ID为空，则不更新
        for (Jx03YqdzbInfoVO vo : jx03YqdzbInfoVOS) {
            if (StringUtils.isEmpty(vo.getId())) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows = jx03YqdzbInfoService.updateEntity(jx03YqdzbInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

   /* @ApiOperation(value = "删除'03已签订指标表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx03YqdzbInfo", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows = jx03YqdzbInfoService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }*/

    /**
     * 根据id逻辑删除   将有效标识变为N
     * @param id
     * @param updateuser
     * @return
     */
    @ApiOperation(value = "删除'03已签订指标表'", notes = "根据id，修改有效标识和更新人")
    @RequestMapping(value = "/jx03YqdzbInfo/remove", method = RequestMethod.POST)
    public HttpOutMsgBean remove(@RequestParam(value = "id",required = false) String id,
                                 @RequestParam(value = "updateuser",required = false) String updateuser) {
        Integer delRows = jx03YqdzbInfoService.updateYxbsByid(id,updateuser);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }

    /**
     * 新增和更新已签订的指标
     * @param
     * @param
     * @return
     */
    @ApiOperation(value = "新增或更新'03已签订指标表''02指标评分细则'", notes = "新增或更新,输入参数为GId,jsonStr")
    @RequestMapping(value = "/jx03YqdzbInfo/addOrUpdate", method = RequestMethod.POST)
    public HttpOutMsgBean save(HttpServletRequest request) {
        Integer saveRows = 0;
       /* jsonObj = JSONArray.parseObject(str);*/
        String id = request.getParameter("id");
        String isedit = request.getParameter("isedit");
        if (StringUtils.isEmpty(id)) {
            //新增指标
            List<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS = addJx03YqdzbInfoVOS(request);
            saveRows = jx03YqdzbInfoService.saveEntity(jx03YqdzbInfoVOS);
            //保存算法明细
            String sfArr = request.getParameter("sfArr");
            if (StringUtils.isEmpty(sfArr)||sfArr.equals("[]")){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
            }else{
                saveSfmx(request);
            }
        } else {
            if(isedit.equals("Y")){
                //先更新之前的指标有效标识为N，在新增一条数据
                String updateUser = request.getParameter("updateUser");
                jx03YqdzbInfoService.updateYxbsByid(id, updateUser);
                //新增
                List<Jx03YqdzbInfoVO> jx03YqdzbInfoVOS = addJx03YqdzbInfoVOS(request);
                saveRows = jx03YqdzbInfoService.saveEntity(jx03YqdzbInfoVOS);
                //根据指标gid查询所有的算法明细id  删除算法明细
                List<String> ids = jx02ZbpfxzInfoService.findIdByGid(request.getParameter("gid"));
                jx02ZbpfxzInfoService.removeEntity(ids);
                //保存算法明细
                String sfArr = request.getParameter("sfArr");
                if (StringUtils.isEmpty(sfArr)||sfArr.equals("[]")){
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
                }else{
                    saveSfmx(request);
                }
            }else{
                //根据指标gid查询所有的算法明细id  删除算法明细
                List<String> ids = jx02ZbpfxzInfoService.findIdByGid(request.getParameter("gid"));
                jx02ZbpfxzInfoService.removeEntity(ids);
                //保存算法明细
                String sfArr = request.getParameter("sfArr");
                if (StringUtils.isEmpty(sfArr)||sfArr.equals("[]")){
                    return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
                }else{
                    saveSfmx(request);
                }
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("edit").msgContent("已签订指标没有修改！").build();
            }

        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /**
     *  将返回的数据插入list
     * @param request
     * @return
     */
    public List<Jx03YqdzbInfoVO> addJx03YqdzbInfoVOS(HttpServletRequest request) {
        List<Jx03YqdzbInfoVO> list = new ArrayList<>();
        Jx03YqdzbInfoVO jx03YqdzbInfoVO = new Jx03YqdzbInfoVO();
        jx03YqdzbInfoVO.setKhnf(request.getParameter("khnf"));
        jx03YqdzbInfoVO.setKhdxid(request.getParameter("khdxId"));
        jx03YqdzbInfoVO.setKhdx(request.getParameter("khdx"));
        jx03YqdzbInfoVO.setZbmc(request.getParameter("zbmc"));
        jx03YqdzbInfoVO.setZbdl(request.getParameter("zbdl"));
        jx03YqdzbInfoVO.setZbdy(request.getParameter("zbdy"));
        jx03YqdzbInfoVO.setMbz(request.getParameter("mbz"));
        jx03YqdzbInfoVO.setQz(request.getParameter("qz"));
        jx03YqdzbInfoVO.setPfbz(request.getParameter("pfbz"));
        jx03YqdzbInfoVO.setYxbs("Y");
        jx03YqdzbInfoVO.setKhzq(request.getParameter("khzq"));
        jx03YqdzbInfoVO.setGid(request.getParameter("gid"));
        jx03YqdzbInfoVO.setCreateUser(request.getParameter("createUser"));
        jx03YqdzbInfoVO.setKhdxbmid(request.getParameter("khdxbmid"));
        jx03YqdzbInfoVO.setKhdxbm(request.getParameter("khdxbm"));
        jx03YqdzbInfoVO.setPflx(request.getParameter("pflx"));
        list.add(jx03YqdzbInfoVO);
        return list;
    }

    /**
     * 保存算法
     * @param request
     * @return
     */
    public int saveSfmx(HttpServletRequest request){
        int saveRows=0;
        //算法的保存
        String sfArr = request.getParameter("sfArr");
        JSONArray jsonArray = JSONArray.fromObject(sfArr);
        List<Jx02ZbpfxzInfoVO> list = JSONArray.toList(jsonArray,new Jx02ZbpfxzInfoVO(),new JsonConfig());
         List<Jx02ZbpfxzInfoVO> jx02ZbpfxzInfoVOS=new ArrayList<Jx02ZbpfxzInfoVO>();
        for(Jx02ZbpfxzInfoVO jx02ZbpfxzInfoVO:list){
            Jx02ZbpfxzInfoVO jx02=new Jx02ZbpfxzInfoVO();
            jx02.setZbgid(request.getParameter("gid"));
            jx02.setSfid(jx02ZbpfxzInfoVO.getSfid());
            jx02.setMxbh(jx02ZbpfxzInfoVO.getMxbh());
            jx02.setMxfz(request.getParameter("qz"));
            jx02.setMxmc(jx02ZbpfxzInfoVO.getMxmc());
            jx02.setSfinfo(jx02ZbpfxzInfoVO.getSfinfo());
            jx02ZbpfxzInfoVOS.add(jx02);
            saveRows=jx02ZbpfxzInfoService.saveEntity(jx02ZbpfxzInfoVOS);
        }
        return saveRows;
    }

    /**
     * 根据考核对象id和考核年份 获取不同类别的所有的指标
     * @param request
     * @param khdxId
     * @param khnf
     * @return
     */
    @RequestMapping(value = "/jx03YqdzbInfo/getZb", method = RequestMethod.GET)
    public HttpOutMsgBean getZb(HttpServletRequest request,@RequestParam(value = "khdxId",required = false) String khdxId, @RequestParam(value = "khnf",required = false) String khnf) {
        List<ZbEntity> zb = jx03YqdzbInfoService.findZb(khdxId, khnf);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(zb).build();
    }

    /**
     * 根据考核对象id和考核年份 获取已签订所有的指标以及退回原因
     * @param request
     * @param khdxId
     * @param khnf
     * @return
     */
    @RequestMapping(value = "/jx03YqdzbInfo/getZbAndThyy", method = RequestMethod.GET)
    public HttpOutMsgBean getZbAndThyy(HttpServletRequest request,@RequestParam(value = "khdxId",required = false) String khdxId, @RequestParam(value = "khnf",required = false) String khnf) {
        List<Jx03YqdzbInfoVO> zbAndYy = jx03YqdzbInfoService.findZbAndYy(khdxId, khnf);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(zbAndYy).build();
    }

    /*@RequestMapping(value = "/jx03YqdzbInfo/getKhzb", method = RequestMethod.GET)
    public HttpOutMsgBean getKhZb(HttpServletRequest request,
                                  @RequestParam(value = "khdxId",required = false) String khdxId,
                                  @RequestParam(value = "khnf",required = false) String khnf,
                                  @RequestParam(value = "khzq",required = false)String khzq) {
        List<ZbEntity> zb = jx03YqdzbInfoService.findKhZb(khdxId, khnf,khzq);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(zb).build();
    }*/


    @ApiOperation(value = "添加'03已签订指标表'", notes = "根据id查询指标内容，添加到已签订表中")
    @RequestMapping(value = "/kpi/addYqdzb", method = RequestMethod.POST)
    public HttpOutMsgBean addYqdzb(@RequestParam(value = "idArr",required = false) String idArr,
                                   @RequestParam(value = "khdxbm",required = false) String khdxbm,
                                   @RequestParam(value = "khdxbmid",required = false) String khdxbmid,
                                   @RequestParam(value = "username",required = false) String username,
                                   @RequestParam(value="khnf",required = false) String khnf) {
        //获取当前年份
        String[] idArrs=idArr.split(",");
        List<String> idList=new ArrayList<>();
        for (String id:idArrs) {
            idList.add(id);
        }
        Integer saveRows=0;
        //根据id查找指标
        List<Jx03YqdzbInfoPO> byIdArr = jx03YqdzbInfoService.getByIdArr(idList);
        for(Jx03YqdzbInfoPO zb:byIdArr){
            List<Jx03YqdzbInfoVO> list =new ArrayList<>();
            Jx03YqdzbInfoVO jx03YqdzbInfoVO=new Jx03YqdzbInfoVO();
            jx03YqdzbInfoVO.setGid(zb.getGid());
            jx03YqdzbInfoVO.setKhnf(khnf);
            jx03YqdzbInfoVO.setKhzq(zb.getKhzq());
            jx03YqdzbInfoVO.setKhdxid(zb.getKhdxid());
            jx03YqdzbInfoVO.setKhdx(zb.getKhdx());
            jx03YqdzbInfoVO.setZbmc(zb.getZbmc());
            jx03YqdzbInfoVO.setZbdl(zb.getZbdl());
            jx03YqdzbInfoVO.setZbdy(zb.getZbdy());
            jx03YqdzbInfoVO.setMbz(zb.getMbz());
            jx03YqdzbInfoVO.setQz(zb.getQz());
            jx03YqdzbInfoVO.setPfbz(zb.getPfbz());
            jx03YqdzbInfoVO.setPflx(zb.getPflx());
            jx03YqdzbInfoVO.setYxbs("Y");
            jx03YqdzbInfoVO.setCreateUser(username);
            jx03YqdzbInfoVO.setKhdxbm(khdxbm);
            jx03YqdzbInfoVO.setKhdxbmid(khdxbmid);
            list.add(jx03YqdzbInfoVO);
            System.out.println(list);
            saveRows = jx03YqdzbInfoService.saveEntity(list);
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /**
     * 根据考核对象id  考核年份 考核周期 查询所有的指标和算法以及算法完成情况
     * @param khdxId
     * @param khnf
     * @param khzq
     * @return
     */
    @RequestMapping(value = "/jx03YqdzbInfo/getZbAndSf", method = RequestMethod.GET)
    public HttpOutMsgBean getZbAndSf(@RequestParam(value = "khdxId",required = false) String khdxId,
                                     @RequestParam(value = "khnf",required = false) String khnf,
                                     @RequestParam(value = "khzq",required = false) String khzq) {
        List<JSONObject> jsonObjects = jx03YqdzbInfoService.queryZbAndSf(khdxId, khnf,khzq);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(jsonObjects).build();
    }


}