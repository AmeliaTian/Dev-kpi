package com.boot.module.file.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.SysConstants;
import com.boot.constant.WebConstants;
import com.boot.module.file.service.IAf01FileStoreService;
import com.boot.repository.Af01FileStoreVO;
import com.boot.utils.CommonUtils;
import com.boot.utils.HttpRequestUtils;
import com.boot.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author CodeGen
 * @Description AF01_文件存储
 * @CreateDate 创建时间：2018-07-16 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
@RestController
@Api(tags = "文件上传下载", description = "提供文件上传/下载，及'AF01_文件存储'增删改查api")
public class Af01FileStoreCtl {

    @Resource(name = "af01FileStoreService")
    private IAf01FileStoreService af01FileStoreService;

    // 上传文件
    @ApiOperation(value = "文件上传", notes = "通过前端页面，上传文件，可批量上传多个文件。")
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public void fileUpload(MultipartHttpServletRequest request) {
        try {
            List<Af01FileStoreVO> af01FileStoreVOS = new ArrayList<>();

            //获取文件
            Iterator<String> itr = request.getFileNames();
            while (itr.hasNext()) {
                MultipartFile file = request.getFile(itr.next());
                //前台传输时，将文件名修改为uuid|name
                String[] fileUuidName = file.getOriginalFilename().split("\\|");
                //文件存储
                file.transferTo(new File(WebConstants.FILE_UPLOAD_STORE_PATH + fileUuidName[0]));

                Af01FileStoreVO vo = new Af01FileStoreVO();
                vo.setFileUuid(fileUuidName[0]);
                vo.setFileName(fileUuidName[1]);
                vo.setFileSize(Long.valueOf(file.getSize()).intValue());
                vo.setFileType(file.getContentType());
                //后缀名
                vo.setFileSuffix(CommonUtils.getFileSuffixName(fileUuidName[1]));

                af01FileStoreVOS.add(vo);
            }
            //存储入库
            af01FileStoreService.saveEntity(af01FileStoreVOS);
        } catch (IOException e) {
            log.error("文件上传错误!", e);
        }
    }

    //文件下载
    @ApiOperation(value = "文件下载", notes = "通过指定文件ID，下载文件，若fileName不为空，则下载时覆盖文件原始名称。")
    @RequestMapping(value = "/file/download", method = RequestMethod.GET)
    public void fileDownload(HttpServletResponse response, @RequestParam(value = "fileId") String fileId, @RequestParam(value = "fileName", required = false) String fileName) {
        File storeFile = new File(WebConstants.FILE_UPLOAD_STORE_PATH + fileId);
        if (!storeFile.exists()) {
            log.error("文件不存在!" + fileId);
            return;
        }

        if (StringUtils.isEmpty(fileName)) {
            //从数据库查询文件名
            Af01FileStoreVO vo = af01FileStoreService.queryAf01FileStore(fileId);
            fileName = (null == vo) ? fileId : vo.getFileName();
        }

        try (FileInputStream fis = new FileInputStream(storeFile); OutputStream os = response.getOutputStream()) {
            response.setCharacterEncoding(SysConstants.SYS_ENCODE);
            response.setContentType("multipart/form-data");
            //设置响应头和客户端保存文件名
            //转为ISO8859-1，否则下载名称会乱码
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes(SysConstants.SYS_ENCODE), "ISO8859-1"));

            int length;
            byte[] buffer = new byte[1024 * 8];
            while ((length = fis.read(buffer)) != -1) {
                os.write(buffer, 0, length);
                os.flush();
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @ApiOperation(value = "查询'AF01_文件存储'记录数", notes = "根据传入参数查询'AF01_文件存储'记录数,输入参数参照类Af01FileStoreVO")
    @RequestMapping(value = "/file/af01FileStore", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = af01FileStoreService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'AF01_文件存储'", notes = "##### 根据传入参数查询'AF01_文件存储'，输入参数参照类Af01FileStoreVO的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
    @RequestMapping(value = "/file/af01FileStore", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sort", required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable = PageUtils.pageBuilder(page, size, sort);
        Iterable<Af01FileStoreVO> queryResult = af01FileStoreService.queryEntity(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }

    @ApiOperation(value = "删除'AF01_文件存储'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/file/af01FileStore", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestBody List<String> ids) {
        Integer delRows = af01FileStoreService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }
}
