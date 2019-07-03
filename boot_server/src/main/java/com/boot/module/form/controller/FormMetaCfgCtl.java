package com.boot.module.form.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.WebConstants;
import com.boot.module.form.service.IAm01FormMetaService;
import com.boot.module.form.service.IAm02FormMetaItemService;
import com.boot.repository.Am01FormMetaVO;
import com.boot.repository.Am02FormMetaItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author h3dwy
 * @Description 获取指定实体的form表单配置
 * @CreateDate 创建时间：2018-08-22 8:49
 * @ModifiedBy
 * @ModifiedDate
 */

@RestController
@Api(tags = "获取表单配置", description = "获取指定实体的form表单配置")
public class FormMetaCfgCtl {

    @Resource(name = "am01FormMetaService")
    private IAm01FormMetaService am01FormMetaService;

    @Resource(name = "am02FormMetaItemService")
    private IAm02FormMetaItemService am02FormMetaItemService;

    @ApiOperation(value = "批量查询获取表单配置", notes = "根据传入的实体名称,获取实体表的表单配置,多个formCode用逗号分隔。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "formCodes", required = true, value = "formCode即entityName(如：am01FormMeta），多个用逗号分隔", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/meta/{formCodes}", method = RequestMethod.GET)
    public HttpOutMsgBean queryFormMetaCfgGroup(@PathVariable(value = "formCodes") String formCodes, @RequestParam(value = "keepOrgin", required = false) String keepOrgin) {
        List<String> formCodeArr = Arrays.asList(formCodes.split(","));

        Iterable<Am01FormMetaVO> queryResult = am01FormMetaService.queryEntityByFormCodes(formCodeArr);

        Map<String, Am01FormMetaVO> retMap = new HashMap<>();
        for (Am01FormMetaVO am01FormMetaVO : queryResult) {
            Iterable<Am02FormMetaItemVO> am02FormMetaItemVOS = am02FormMetaItemService.queryEntityByFormId(am01FormMetaVO.getId());

            //是否转换待选列表,Y不转换，其他选项转换，
            am02FormMetaItemService.loadMetaValueListFromDb(am02FormMetaItemVOS, "Y".equals(keepOrgin));
            //排序
            List<Am02FormMetaItemVO> list = IteratorUtils.toList(am02FormMetaItemVOS.iterator());
            Collections.sort(list, Comparator.comparingInt(Am02FormMetaItemVO::getMetaSeq));
            am01FormMetaVO.setFormItems(list);

            retMap.put(am01FormMetaVO.getFormCode(), am01FormMetaVO);
        }
        return HttpOutMsgBean.builder().msgType(WebConstants.RET_MSG_TYPE_ENUM.OBJ).msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgContent(retMap).build();
    }
}


