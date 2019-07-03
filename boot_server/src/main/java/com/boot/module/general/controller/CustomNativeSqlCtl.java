package com.boot.module.general.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.general.service.CustomNativeSqlService;
import com.boot.repository.At03CustomSqlDAO;
import com.boot.repository.At03CustomSqlPO;
import com.boot.utils.HttpRequestUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author h3dwy
 * @Description 自定义查询
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@RestController
@Api(tags = "执行自定义SQL", description = "执行后台配置的原生SQL")
public class CustomNativeSqlCtl {
    @Resource(name = "customNativeSqlService")
    private CustomNativeSqlService nativeSqlService;

    @Autowired
    private At03CustomSqlDAO sdao;

    @ApiOperation(value = "执行自定义SQL查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parmsMap.*", value = "SQL对应的参数值", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "sqlCode", value = "SQL语句对应编码", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/general/sqlQuery", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "sqlCode") String sqlCode) {
        //获取sql语句
        Optional<At03CustomSqlPO> opo = sdao.findById(sqlCode);
        //
        if (!opo.isPresent()) {
            return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgDes("QUERY").msgContent("sql不存在:" + sqlCode).build();
        }
        //获取传入参数
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("sqlCode"));
        List<Map<String, Object>> queryData = nativeSqlService.queryBySqlMapParams(opo.get().getSqlContent(), paramMap);
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("QUERY").msgContent(queryData).build();
    }

    @ApiOperation(value = "执行自定义SQL更新操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parmsMap.*", value = "SQL对应的参数值", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "sqlCode", value = "SQL语句对应编码", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/general/sqlUpdate", method = RequestMethod.GET)
    public HttpOutMsgBean update(HttpServletRequest request, @RequestParam(value = "sqlCode") String sqlCode) {
        //获取sql语句
        Optional<At03CustomSqlPO> opo = sdao.findById(sqlCode);

        if (!opo.isPresent()) {
            return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgDes("EDIT").msgContent("sql不存在:" + sqlCode).build();
        }
        //获取传入参数
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("sqlCode"));
        int num = nativeSqlService.executeBySqlMapParams(opo.get().getSqlContent(), paramMap);
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgDes("EDIT").msgContent(num).build();
    }
}
