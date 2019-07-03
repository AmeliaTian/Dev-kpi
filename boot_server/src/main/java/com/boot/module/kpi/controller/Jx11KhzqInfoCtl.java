package com.boot.module.kpi.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.kpi.service.IJx11KhzqInfoService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description 11绩效考核周期管理 Controller
 * @CreateDate 创建时间： 2019-03-04 13:54:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@RestController
@Api(tags="BASE_'11绩效考核周期管理'",description = "'11绩效考核周期管理'增删改查api")
public class Jx11KhzqInfoCtl {

    @Resource(name = "jx11KhzqInfoService")
    private IJx11KhzqInfoService jx11KhzqInfoService;

    @ApiOperation(value = "查询'11绩效考核周期管理'记录数", notes = "根据传入参数查询'11绩效考核周期管理'记录数,输入参数参照类Jx11KhzqInfoVO")
    @RequestMapping(value = "/kpi/jx11KhzqInfo", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx11KhzqInfoService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'11绩效考核周期管理'", notes = "##### 根据传入参数查询'11绩效考核周期管理'，参数名称参照Jx11KhzqInfoVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx11KhzqInfoVO.*", value = "Jx11KhzqInfoVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "jx11KhzqInfo/query", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx11KhzqInfoVO> queryResult =  jx11KhzqInfoService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

/*如果可编辑(table)，则生成下边的更新操作*/
   /* @ApiOperation(value = "新增'11绩效考核周期管理'", notes = "批量新增,输入参数为Jx11KhzqInfoVO的列表")
    @RequestMapping(value = "/kpi/jx11KhzqInfo", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Jx11KhzqInfoVO> jx11KhzqInfoVOS) {
        Integer saveRows = jx11KhzqInfoService.saveEntity(jx11KhzqInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }*/

    /*@ApiOperation(value = "更新'11绩效考核周期管理'", notes = "批量更新,输入参数为Jx11KhzqInfoVO的列表")
    @RequestMapping(value = "/kpi/jx11KhzqInfo", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx11KhzqInfoVO> jx11KhzqInfoVOS) {
        //如果有ID为空，则不更新
        for (Jx11KhzqInfoVO vo : jx11KhzqInfoVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                 return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }*/

    @ApiOperation(value = "删除'11绩效考核周期管理'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/kpi/jx11KhzqInfo", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows =  jx11KhzqInfoService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }


    @ApiOperation(value = "新增'11绩效考核周期管理'", notes = "批量新增,输入参数为Jx11KhzqInfoVO的列表")
    @RequestMapping(value = "/jx11KhzqInfo/save", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestParam(value="startTime",required = false) String  startTime,
                               @RequestParam(value="endTime",required = false) String endTime,
                               @RequestParam(value="jdName",required = false) String jdName,
                               @RequestParam(value="jdBh",required = false) String jdBh,
                               @RequestParam(value="khnf" ,required = false)String khnf) throws ParseException {

        System.out.println(startTime);
        Date now = new Date();
        List<Jx11KhzqInfoVO> jx11KhzqInfoVOS = new ArrayList<>();
        Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf, jdBh);
        Integer rows=0;
        Jx11KhzqInfoVO jx11KhzqInfoVO = new Jx11KhzqInfoVO();
        String st = null;
        String et = null;
        //查询为空插入
        if(jx11KhzqInfoPOByKhnf==null) {
                if (startTime.equals("")|| StringUtils.isEmpty(startTime)) {
                    st=null;
                }else{
                    st = startTime;
                }
                if(endTime.equals("")||StringUtils.isEmpty(endTime)){
                    et =null;
                }else{
                    et=endTime;
                }
                jx11KhzqInfoVO.setJdyjkssj(st);
                jx11KhzqInfoVO.setJdyjjsdj(et);
                jx11KhzqInfoVO.setKhjdmc(jdName);
                jx11KhzqInfoVO.setKhjdbh(jdBh);
                jx11KhzqInfoVO.setJdzt("0");
                jx11KhzqInfoVO.setKhnf(khnf);
                jx11KhzqInfoVO.setKhzq("年度/半年度");
            jx11KhzqInfoVOS.add(jx11KhzqInfoVO);
            rows = jx11KhzqInfoService.saveEntity(jx11KhzqInfoVOS);
        }else{
            //更新
            if (StringUtils.isNotEmpty(startTime)) {
                jx11KhzqInfoVO.setJdyjkssj(startTime);
                jx11KhzqInfoVO.setJdyjjsdj(jx11KhzqInfoPOByKhnf.getJdyjjsdj());
                jx11KhzqInfoVO.setJdsjkssj(jx11KhzqInfoPOByKhnf.getJdsjkssj());
                jx11KhzqInfoVO.setJdsjjssj(jx11KhzqInfoPOByKhnf.getJdsjjssj());
                jx11KhzqInfoVO.setJdzt(jx11KhzqInfoPOByKhnf.getJdzt());
                jx11KhzqInfoVOS.add(addRows(jx11KhzqInfoPOByKhnf,jx11KhzqInfoVO));
                rows =jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS);
            } else if(StringUtils.isNotEmpty(endTime)){
                jx11KhzqInfoVO.setJdyjjsdj(endTime);
                jx11KhzqInfoVO.setJdyjkssj(jx11KhzqInfoPOByKhnf.getJdyjkssj());
                jx11KhzqInfoVO.setJdsjjssj(jx11KhzqInfoPOByKhnf.getJdsjjssj());
                jx11KhzqInfoVO.setJdsjkssj(jx11KhzqInfoPOByKhnf.getJdsjkssj());
                jx11KhzqInfoVO.setJdzt(jx11KhzqInfoPOByKhnf.getJdzt());
                jx11KhzqInfoVOS.add(addRows(jx11KhzqInfoPOByKhnf,jx11KhzqInfoVO));
                rows =jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS);
            }else{
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("error").msgContent("输入正确的值").build();
            }
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(rows).build();
    }


    @ApiOperation(value = "更新'11绩效考核周期管理'", notes = "批量更新,输入参数为Jx11KhzqInfoVO的列表")
    @RequestMapping(value = "/jx11KhzqInfo/update", method = RequestMethod.POST)
    public HttpOutMsgBean update(@RequestParam(value="jdBh",required = false) String jdBh,
                                 @RequestParam(value="khnf" ,required = false)String khnf) throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(d);
        int i = Integer.parseInt(jdBh);
        Integer saveRows=0;
        //如果是指标制定  直接更新实际开始时间
        String s = String.valueOf(i - 1);
        if(jdBh.equals("1")){
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,jdBh);
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO = new Jx11KhzqInfoVO();
            jx11KhzqInfoVO.setJdzt("1");
            jx11KhzqInfoVO.setJdyjkssj(jx11KhzqInfoPOByKhnf.getJdyjkssj());
            jx11KhzqInfoVO.setJdyjjsdj(jx11KhzqInfoPOByKhnf.getJdyjjsdj());
            jx11KhzqInfoVO.setJdsjkssj(time);
            jx11KhzqInfoVO.setJdsjjssj(jx11KhzqInfoPOByKhnf.getJdsjjssj());
            jx11KhzqInfoVOS.add(addRows(jx11KhzqInfoPOByKhnf,jx11KhzqInfoVO));
            saveRows = jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS);
        }else if(jdBh.equals("2")||jdBh.equals("5")){
            //查询上一阶段 更新实际结束时间 和状态
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,s);
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO = new Jx11KhzqInfoVO();
            jx11KhzqInfoVO.setJdzt("2");
            jx11KhzqInfoVO.setJdyjkssj(jx11KhzqInfoPOByKhnf.getJdyjkssj());
            jx11KhzqInfoVO.setJdyjjsdj(jx11KhzqInfoPOByKhnf.getJdyjjsdj());
            jx11KhzqInfoVO.setJdsjkssj(jx11KhzqInfoPOByKhnf.getJdsjkssj());
            jx11KhzqInfoVO.setJdsjjssj(time);
            jx11KhzqInfoVOS.add(addRows(jx11KhzqInfoPOByKhnf,jx11KhzqInfoVO));
            saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS);
            //更新当前阶段的实际开始时间和状态
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf1 = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,jdBh);
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS1 = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO1 = new Jx11KhzqInfoVO();
            jx11KhzqInfoVO1.setJdzt("1");
            jx11KhzqInfoVO1.setJdyjkssj(jx11KhzqInfoPOByKhnf1.getJdyjkssj());
            jx11KhzqInfoVO1.setJdyjjsdj(jx11KhzqInfoPOByKhnf1.getJdyjjsdj());
            jx11KhzqInfoVO1.setJdsjkssj(time);
            jx11KhzqInfoVO1.setJdsjjssj(jx11KhzqInfoPOByKhnf1.getJdsjjssj());
            jx11KhzqInfoVOS1.add(addRows(jx11KhzqInfoPOByKhnf1,jx11KhzqInfoVO1));
            saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS1);
        }else if(jdBh.equals("3")||jdBh.equals("4")){
            //更新制定指标的状态为进行中"1"
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,"1");
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO = new Jx11KhzqInfoVO();
            if(jdBh.equals("3")){
                jx11KhzqInfoVO.setJdzt("1");
            }else{
                jx11KhzqInfoVO.setJdzt("2");
            }
            jx11KhzqInfoVO.setJdyjkssj(jx11KhzqInfoPOByKhnf.getJdyjkssj());
            jx11KhzqInfoVO.setJdyjjsdj(jx11KhzqInfoPOByKhnf.getJdyjjsdj());
            jx11KhzqInfoVO.setJdsjkssj(jx11KhzqInfoPOByKhnf.getJdsjkssj());
            jx11KhzqInfoVO.setJdsjjssj(jx11KhzqInfoPOByKhnf.getJdsjjssj());
            jx11KhzqInfoVOS.add(addRows(jx11KhzqInfoPOByKhnf,jx11KhzqInfoVO));
            saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS);
            //更新半年度考核阶段的状态为已完成，并且修改实际结束实际为当前时间
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf2 = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,s);
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS2 = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO2 = new Jx11KhzqInfoVO();
            jx11KhzqInfoVO2.setJdzt("2");
            jx11KhzqInfoVO2.setJdyjkssj(jx11KhzqInfoPOByKhnf2.getJdyjkssj());
            jx11KhzqInfoVO2.setJdyjjsdj(jx11KhzqInfoPOByKhnf2.getJdyjjsdj());
            jx11KhzqInfoVO2.setJdsjkssj(jx11KhzqInfoPOByKhnf2.getJdsjkssj());
            jx11KhzqInfoVO2.setJdsjjssj(time);
            jx11KhzqInfoVOS2.add(addRows(jx11KhzqInfoPOByKhnf2,jx11KhzqInfoVO2));
            saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS2);
            //更新当前阶段的状态为正在进行时，并且更新实际开始时间为当前时间
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf3 = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,jdBh);
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS3 = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO3 = new Jx11KhzqInfoVO();
            jx11KhzqInfoVO3.setJdzt("1");
            jx11KhzqInfoVO3.setJdyjkssj(jx11KhzqInfoPOByKhnf3.getJdyjkssj());
            jx11KhzqInfoVO3.setJdyjjsdj(jx11KhzqInfoPOByKhnf3.getJdyjjsdj());
            jx11KhzqInfoVO3.setJdsjkssj(time);
            jx11KhzqInfoVO3.setJdsjjssj(jx11KhzqInfoPOByKhnf3.getJdsjjssj());
            jx11KhzqInfoVOS3.add(addRows(jx11KhzqInfoPOByKhnf3,jx11KhzqInfoVO3));
            saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS3);
        }else{
            Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf5 = jx11KhzqInfoService.findJx11KhzqInfoPOByKhnf(khnf,"5");
            List<Jx11KhzqInfoVO> jx11KhzqInfoVOS5 = new ArrayList<>();
            Jx11KhzqInfoVO jx11KhzqInfoVO5 = new Jx11KhzqInfoVO();
            jx11KhzqInfoVO5.setJdzt("2");
            jx11KhzqInfoVO5.setJdyjkssj(jx11KhzqInfoPOByKhnf5.getJdyjkssj());
            jx11KhzqInfoVO5.setJdyjjsdj(jx11KhzqInfoPOByKhnf5.getJdyjjsdj());
            jx11KhzqInfoVO5.setJdsjkssj(jx11KhzqInfoPOByKhnf5.getJdsjkssj());
            jx11KhzqInfoVO5.setJdsjjssj(time);
            jx11KhzqInfoVOS5.add(addRows(jx11KhzqInfoPOByKhnf5,jx11KhzqInfoVO5));
            saveRows =  jx11KhzqInfoService.updateEntity(jx11KhzqInfoVOS5);
        }
        List<Jx11KhzqInfoPO> jx11KhzqInfoPOS = jx11KhzqInfoService.queryByMaxKhnf();
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(jx11KhzqInfoPOS).build();
    }

    /**
     * 查询近几年的考核阶段及时间
     * @param sTime
     * @param eTime
     * @return
     */
    @RequestMapping(value = "/jx11KhzqInfo/queryByKhnf", method = RequestMethod.GET)
    public HttpOutMsgBean queryByKhnf(@RequestParam(value = "sTime",required = false) String sTime,
                                      @RequestParam(value = "eTime",required = false) String eTime) {

        List<Jx11KhzqInfoPO> jx11KhzqInfoPOS = jx11KhzqInfoService.queryByKhnf(sTime, eTime);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(jx11KhzqInfoPOS).build();
    }

    @RequestMapping(value="/jx11KhzqInfo/queryMaxKhnf",method = RequestMethod.GET)
    public HttpOutMsgBean queryMaxKhnf(){
        String maxKhnf = jx11KhzqInfoService.getMaxKhnf();
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("maxKhnf").msgContent(maxKhnf).build();
    }


    public Jx11KhzqInfoVO addRows(Jx11KhzqInfoPO jx11KhzqInfoPOByKhnf,Jx11KhzqInfoVO jx11KhzqInfoVO){
        Date now = new Date();
        jx11KhzqInfoVO.setId(jx11KhzqInfoPOByKhnf.getId());
        jx11KhzqInfoVO.setKhnf(jx11KhzqInfoPOByKhnf.getKhnf());
        jx11KhzqInfoVO.setKhzq(jx11KhzqInfoPOByKhnf.getKhzq());
        jx11KhzqInfoVO.setKhjdbh(jx11KhzqInfoPOByKhnf.getKhjdbh());
        jx11KhzqInfoVO.setKhjdmc(jx11KhzqInfoPOByKhnf.getKhjdmc());
        jx11KhzqInfoVO.setUpdatetime(now);
        jx11KhzqInfoVO.setOprCrtTime(jx11KhzqInfoPOByKhnf.getOprCrtTime());
        return jx11KhzqInfoVO;
    }

}