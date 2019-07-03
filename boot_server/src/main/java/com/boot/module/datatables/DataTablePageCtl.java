package com.boot.module.datatables;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.general.service.CustomNativeSqlService;
import com.boot.module.sys.ObjectNameTools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author h3dwy
 * @Description 向前台dataTables提供数据，由于输入输出格式有特殊要求，因此单独提取出来
 * @CreateDate 创建时间：2018-08-06 14:14
 * @ModifiedBy
 * @ModifiedDate
 */

@RestController
@Api(tags = "前台表格分页查询", description = "向前端dataTables.js提供的数据api，后台分页查询")
public class DataTablePageCtl {

    @Resource(name = "customNativeSqlService")
    private CustomNativeSqlService customSqlService;

    @ApiOperation(value = "根据实体和分页，查询datatables要求的数据", notes = "根据实体和分页，查询datatables要求的数据")
    @RequestMapping(value = "/datatables/{entityName}", method = RequestMethod.GET)
    public HttpOutMsgBean count(@PathVariable("entityName") String entityName, @RequestParam(value = "aoData") String aoData, @RequestParam(value = "filter", required = false) String filter) {

        //获取datatables参数
        List<DataTableParamBean> aoDataObj = new Gson().fromJson(aoData, new TypeToken<List<DataTableParamBean>>() {
        }.getType());
        Map<String, String> parmMap = new HashMap<>(aoDataObj.size());
        for (DataTableParamBean dataTableParamBean : aoDataObj) {
            parmMap.put(dataTableParamBean.getName(), dataTableParamBean.getValue());
        }

        //开始记录号
        int iDisplayStart = Integer.parseInt(parmMap.get("iDisplayStart"));
        //每页条数
        int iDisplayLength = Integer.parseInt(parmMap.get("iDisplayLength"));
        //前台传入需要原样返回给前台
        int sEcho = Integer.parseInt(parmMap.get("sEcho"));
        //转为JPA的页数
        int page = iDisplayStart / iDisplayLength + 1;

        //为了保持一致性，前台传入的是实体对应的表(am02FormMetaItem)，要转换成实体(Am02FormMetaItemPO)
        entityName = ObjectNameTools.objNameToPoName(entityName,true);

        //过滤条件
        Map<String, Object> filterParamsMap = new HashMap<>();
        //组装where
        String whereFilter = "";
        if (StringUtils.isNotEmpty(filter)) {
            Map<String, String> tmpParamsMap = new Gson().fromJson(filter, new TypeToken<Map<String, String>>() {
            }.getType());
            for (Map.Entry<String, String> map : tmpParamsMap.entrySet()) {
                if (null == map.getValue() || StringUtils.isEmpty(map.getValue().toString())) {
                    continue;
                }
                // and param=:param;
                whereFilter += " and " + map.getKey() + " = :" + map.getKey();
                filterParamsMap.put(map.getKey(), map.getValue().trim());
            }
        }

        //总行数
        List<Long> totalNum = customSqlService.queryByHqlMapParams("select count(*) as num from " + entityName + " where 1=1" + whereFilter, filterParamsMap, null, null);
        //分页查询
        List data = customSqlService.queryByHqlMapParams("from " + entityName + " where 1=1" + whereFilter, filterParamsMap, page, iDisplayLength);

        DataTablesOutBean dataTablesOutBean = new DataTablesOutBean();
        dataTablesOutBean.setiTotalDisplayRecords(totalNum.get(0).intValue());
        dataTablesOutBean.setiTotalRecords(totalNum.get(0).intValue());
        dataTablesOutBean.setsEcho(sEcho);
        dataTablesOutBean.setAaData(data);

        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.OBJ).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgContent(dataTablesOutBean).build();
    }
}
