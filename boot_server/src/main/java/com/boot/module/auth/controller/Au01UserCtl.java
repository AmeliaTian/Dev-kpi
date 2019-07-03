package com.boot.module.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.auth.principal.AuthShiroService;
import com.boot.module.auth.service.IAu01UserService;
import com.boot.module.auth.service.IAu02OrganizationService;
import com.boot.module.auth.service.impl.DeptTreeServiceImpl;
import com.boot.repository.Au01UserPO;
import com.boot.repository.Au01UserVO;
import com.boot.repository.DeptTree;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description AU01_系统用户表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@RestController
@Api(tags = "BASE_'AU01_系统用户表'", description = "'AU01_系统用户表'增删改查的api")
public class Au01UserCtl {

    @Resource(name = "au01UserService")
    private IAu01UserService au01UserService;

    @Resource(name="deptTreeService")
    private DeptTreeServiceImpl deptTreeService;


    @Resource(name = "shiroService")
    private AuthShiroService  shiroService;

    @ApiOperation(value = "查询'AU01_系统用户表'记录数", notes = "根据传入参数查询'AU01_系统用户表'记录数,输入参数参照类Au01UserVO")
    @RequestMapping(value = "/auth/au01User", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = au01UserService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'AU01_系统用户表'", notes = "##### 根据传入参数查询'AU01_系统用户表'，参数名称参照Au01UserVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Au01UserVO.*", value = "Au01UserVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int", example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int", example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/auth/au01User", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);

        Iterable<Au01UserVO> queryResult = au01UserService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    @ApiOperation(value = "新增'AU01_系统用户表'", notes = "批量新增,输入参数为Au01UserVO的列表")
    @RequestMapping(value = "/auth/au01User", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestBody List<Au01UserVO> au01UserVOS) {
        Integer saveRows = au01UserService.saveEntity(au01UserVOS);
        shiroService.refreshUserRoles();
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("save").msgContent(saveRows).build();
    }

    @ApiOperation(value = "更新'AU01_系统用户表'", notes = "批量更新,输入参数为Au01UserVO的列表")
    @RequestMapping(value = "/auth/au01User", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Au01UserVO> au01UserVOS) {
        //如果有ID为空，则不更新
        for (Au01UserVO vo : au01UserVOS) {
            if (StringUtils.isEmpty(vo.getId())) {
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows = au01UserService.updateEntity(au01UserVOS);
        shiroService.refreshUserRoles();
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'AU01_系统用户表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/auth/au01User", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows = au01UserService.removeEntity(ids);
        shiroService.refreshUserRoles();
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("remove").msgContent(delRows).build();
    }

    @ApiOperation(value = "查询所有部门及员工", notes = "先查询所有部门")
    @RequestMapping(value = "/auth/queryTree1",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean queryTree(@RequestParam(value="userId")String userId,
                                    @RequestParam(value="roleName")String roleName) {
        List<DeptTree> deptTreeList = deptTreeService.queryDeptUserTreeList(userId,roleName);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(deptTreeList).build();
    }


    @ApiOperation(value = "查询所有部门及员工", notes = "先查询所有部门")
    @RequestMapping(value = "/auth/queryShdxTree",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean queryTree1(@RequestParam(value="userId")String userId,
                                     @RequestParam(value="roleName")String roleName) {
        List<DeptTree> deptTreeList = deptTreeService.queryDeptUserTreeList1(userId,roleName);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(deptTreeList).build();
    }

    @ApiOperation(value = "查询所有部门及员工", notes = "先查询所有部门")
    @RequestMapping(value = "/auth/queryUserTree",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean queryUserTree(@RequestParam(value="userId")String userId,
                                     @RequestParam(value="roleName")String roleName) {
        List<DeptTree> deptTreeList = deptTreeService.queryUserTreeList(userId,roleName);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(deptTreeList).build();
    }


    /*@ApiOperation(value = "查询所有部门及员工", notes = "先查询所有部门")
    @RequestMapping(value = "/auth/index",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean index(@RequestParam(value="userId")String userId,
                                @RequestParam(value="roleName")String roleName,
                                @RequestParam(value="khzq")String khzq,
                                @RequestParam(value="zt")String zt) {
        List<DeptTree> deptTreeList = deptTreeService.queryDeptUserTreeList1(userId,roleName);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(deptTreeList).build();
    }*/
    @ApiOperation(value = "查询所有部门及员工", notes = "先查询所有部门")
    @RequestMapping(value = "/auth/queryUserInfo",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean queryUserInfo(@RequestParam(value="userId")String userId,
                                        @RequestParam(value="roleName")String roleName,
                                        @RequestParam(value = "khzq") String khzq,
                                        @RequestParam(value="khnf") String khnf) {
        List deptTreeList = deptTreeService.getUserInfo(userId,roleName,khzq,khnf);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(deptTreeList).build();
    }

    @ApiOperation(value = "根据角色名称查询所有的人员角色 部门", notes = "用于考核主体配置页面")
    @RequestMapping(value = "/auth/queryUserByRole",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean queryUserByRole(@RequestParam(value="roleName")String roleName,
                                          @RequestParam(value="khnf")String khnf,
                                          @RequestParam(value="khzq")String khzq) {
        List<JSONObject> users = au01UserService.queryByRoleName(roleName, khnf, khzq);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(users).build();
    }


    @ApiOperation(value = "获取用户密码", notes = "获取用户密码")
    @RequestMapping(value = "/auth/getPw",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean getPw(@RequestParam(value="userId")String userId,
                                @RequestParam(value="oldPw")String oldPw) {
        Au01UserPO au01UserPOById = au01UserService.findAu01UserPOById(userId);
        if(!oldPw.equals(au01UserPOById.getPassword())){
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent("请输入正确的密码!").build();
        }else{
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent("success").build();
        }
    }

    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @RequestMapping(value = "/auth/updatePw",method = {RequestMethod.POST, RequestMethod.GET})
    public HttpOutMsgBean updatePw(@RequestParam(value="userId")String userId,
                                   @RequestParam(value="newPw")String newPw) {

        /*List<JSONObject> users = au01UserService.queryByRoleName(roleName, khnf, khzq);*/
        List<Au01UserVO> au01UserVOS=new ArrayList<Au01UserVO>();
        Au01UserPO au01UserPOById = au01UserService.findAu01UserPOById(userId);
            Au01UserVO au01UserVO=new Au01UserVO();
            au01UserVO.setId(userId);
            au01UserVO.setPassword(newPw);
            au01UserVOS.add(au01UserVO);
            Integer saveRows = au01UserService.saveEntity(au01UserVOS);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent("密码修改成功！").build();

    }
}
