package com.boot.module.file.controller;

import com.boot.common.HttpOutMsgBean;
import com.boot.constant.SysConstants;
import com.boot.constant.WebConstants;
import com.boot.module.file.service.IJx22UserFileService;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description 用户-工作总结文件表 Controller
 * @CreateDate 创建时间： 2019-06-18 17:10:28
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
@Slf4j
@RestController
@Api(tags="用户-工作总结文件表",description = "'用户-工作总结文件表'增删改查api")
public class Jx22UserFileCtl {

    @Resource(name = "jx22UserFileService")
    private IJx22UserFileService jx22UserFileService;


    // 上传文件
    @ApiOperation(value = "文件上传", notes = "通过前端页面，上传文件，只能上传1个文件。")
    @RequestMapping(value = "/gzzjFile/upload", method = RequestMethod.POST)
    public HttpOutMsgBean fileUpload(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("uploadfile[]");
        try {
            file.transferTo(new File(WebConstants.FILE_UPLOAD_STORE_PATH + file.getOriginalFilename()));
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("file").msgContent(200).build();
        } catch (IOException e) {
            log.error("文件上传错误!", e);
            return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.ERROR).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("file").msgContent(404).build();
        }
    }
    //批量下载文件
    @ApiOperation(value = "批量下载文件", notes = "通过前端页面传递的用户文件表id，批量下载文件。")
    @RequestMapping(value = "/gzzjFile/download", method = RequestMethod.GET)
    public void fileDownload(HttpServletResponse response, @RequestParam(value = "ids") List<String> ids){
        if (ids!=null && ids.size()==1)
            fileDownloadOne(response,ids,null);
        else if (ids!=null && ids.size()>=2)
            fileDownloadMany(response,ids);
    }
    //下载单个文件
    public void fileDownloadOne(HttpServletResponse response, List<String> ids, String path) {
        File storeFile=null;
        String fjmc=null;
        if (path==null) {
            List<String> fjmcs = jx22UserFileService.getFjmc(ids);
            fjmc= fjmcs.get(0);
//        String path = WebConstants.FILE_UPLOAD_STORE_PATH+fjmc;
            storeFile= new File(WebConstants.FILE_UPLOAD_STORE_PATH + fjmc);
        }else {
            storeFile = new File(path);
            fjmc = storeFile.getName();
        }
        if (!storeFile.exists()) {
            log.error("文件不存在!");
            return;
        }

        try (FileInputStream fis = new FileInputStream(storeFile); OutputStream os = response.getOutputStream()) {
            response.setCharacterEncoding(SysConstants.SYS_ENCODE);
            response.setContentType("multipart/form-data");
            //设置响应头和客户端保存文件名
            //转为ISO8859-1，否则下载名称会乱码
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fjmc.getBytes(SysConstants.SYS_ENCODE), "ISO8859-1"));

            int length;
            byte[] buffer = new byte[1024];
            while ((length = fis.read(buffer)) != -1) {
                os.write(buffer, 0, length);
                os.flush();
            }
        } catch (Exception e) {
            log.error("下载失败", e);
        }
    }
    //下载多个文件，使用压缩流
    public void fileDownloadMany(HttpServletResponse response, List<String> ids){
        List<String> fjmcs = jx22UserFileService.getFjmc(ids);
        List<String> paths = fjmcs.stream().map(p -> WebConstants.FILE_UPLOAD_STORE_PATH + p).collect(Collectors.toList());

        //存放--服务器上zip文件的目录
        String directory = WebConstants.FILE_UPLOAD_STORE_PATH+ UUID.randomUUID().toString();
        File directoryFile=new File(directory);
        if(!directoryFile.isDirectory() && !directoryFile.exists()){
            directoryFile.mkdirs();
        }
        //设置最终输出zip文件的目录+文件名
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy年MM月dd日");
        String zipFileName = "工作总结"+formatter.format(new Date())+".zip";
        String strZipPath = directory+"/"+zipFileName;

        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        File zipFile = new File(strZipPath);
        try{
            //构造最终压缩包的输出流
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));
            for (int i = 0; i<paths.size() ;i++){
                //解码获取真实路径与文件名
                String realFileName = fjmcs.get(i);
                String realFilePath = paths.get(i);
                File file = new File(realFilePath);

                if(file.exists())
                {
                    zipSource = new FileInputStream(file);//将需要压缩的文件格式化为输入流
                    /**
                     * 压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样这里的name就是文件名,
                     * 文件名和之前的重复就会导致文件被覆盖
                     */
                    ZipEntry zipEntry = new ZipEntry(realFileName);//在压缩目录中文件的名字
                    zipStream.putNextEntry(zipEntry);//定位该压缩条目位置，开始写入文件到压缩包中
                    bufferStream = new BufferedInputStream(zipSource, 1024 * 10);
                    int read = 0;
                    byte[] buf = new byte[1024 * 10];
                    while((read = bufferStream.read(buf, 0, 1024 * 10)) != -1)
                    {
                        zipStream.write(buf, 0, read);
                    }
                }else continue;
            }
        } catch (Exception e) {
            log.error("批量下载出错 "+e);
        } finally {
            //关闭流
            try {
                if(null != bufferStream) bufferStream.close();
                if(null != zipStream){
                    zipStream.flush();
                    zipStream.close();
                }
                if(null != zipSource) zipSource.close();
            } catch (IOException e) {
                log.error("关闭 流 出错！"+e);
            }
        }
        //判断系统压缩文件是否存在：true-把该压缩文件通过流输出给客户端后删除该压缩文件
        if(zipFile.exists()){
            fileDownloadOne(response,null,strZipPath);
            zipFile.delete();
            directoryFile.delete();
        }else {
            log.error("压缩文件出错 "+strZipPath);
        }
    }

    /*如果可编辑(table)，则生成下边的更新操作*/
    @ApiOperation(value = "新增'用户-工作总结文件表'", notes = "输入参数为Jx22UserFileVO的列表")
    @RequestMapping(value = "/jx22UserFile/addOrUpdate", method = RequestMethod.POST)
    public HttpOutMsgBean save(@RequestParam(value = "khnf") String khnf,@RequestParam(value = "khzq") String khzq,
                               @RequestParam(value = "khdx") String khdx,@RequestParam(value = "khdxid") String khdxid,
                               @RequestParam(value = "ssbm") String ssbm,@RequestParam(value = "ssbmid") String ssbmid,
                               @RequestParam(value = "fjmc") String fjmc) {
        List<Jx22UserFileVO> jx22UserFileVOS = new ArrayList<>();
        Jx22UserFileVO jx22UserFileVO = new Jx22UserFileVO();
        jx22UserFileVO.setKhnf(khnf);
        jx22UserFileVO.setKhzq(khzq);
        jx22UserFileVO.setKhdx(khdx);
        jx22UserFileVO.setKhdxid(khdxid);
        jx22UserFileVO.setSsbm(ssbm);
        jx22UserFileVO.setSsbmid(ssbmid);
        jx22UserFileVO.setFjmc(fjmc);
        jx22UserFileVO.setFjpath(WebConstants.FILE_UPLOAD_STORE_PATH +fjmc);
        jx22UserFileVOS.add(jx22UserFileVO);
        Integer saveRows = jx22UserFileService.saveEntity(jx22UserFileVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("save").msgContent(saveRows).build();
    }

    /**
     * 根据考核对象id 获取所有的用户-工作总结文件表
     *


     @RequestMapping(value = "/jx22UserFile/getUserFile", method = RequestMethod.GET)
     public HttpOutMsgBean getUserFile(@RequestParam(value = "userid") String userid,@RequestParam(value = "khnf" ,required = false) String khnf,
     @RequestParam(value = "khzq",required = false) String khzq,@RequestParam(value = "rolenames") String rolenames){
     List<Jx22UserFileVO> jx22UserFileVOS = jx22UserFileService.getUserFile(userid,khnf,khzq,rolenames);
     return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(jx22UserFileVOS).build();
     }
     */

    @ApiOperation(value = "更新'用户-工作总结文件表'", notes = "批量更新,输入参数为Jx22UserFileVO的列表")
    @RequestMapping(value = "/jx22UserFile", method = RequestMethod.PUT)
    public HttpOutMsgBean update(@RequestBody List<Jx22UserFileVO> jx22UserFileVOS) {
        //如果有ID为空，则不更新
        for (Jx22UserFileVO vo : jx22UserFileVOS) {
            if(StringUtils.isEmpty(vo.getId())){
                return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent("ID字段不能为空").build();
            }
        }
        Integer saveRows =  jx22UserFileService.updateEntity(jx22UserFileVOS);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("update").msgContent(saveRows).build();
    }

    @ApiOperation(value = "删除'用户-工作总结文件表'", notes = "批量删除，传入参数为对应记录ID列表")
    @RequestMapping(value = "/jx22UserFile", method = RequestMethod.DELETE)
    public HttpOutMsgBean remove(@RequestParam(value="ids") List<String> ids) {
        Integer delRows =  jx22UserFileService.removeEntity(ids);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgDes("remove").msgContent(delRows).build();
    }


    @ApiOperation(value = "查询'用户-工作总结文件表'记录数", notes = "根据传入参数查询'用户-工作总结文件表'记录数,输入参数参照类Jx22UserFileVO")
    @RequestMapping(value = "/jx22UserFile", method = RequestMethod.HEAD)
    public HttpOutMsgBean count(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Long dataLen = jx22UserFileService.countEntity(paramMap);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(dataLen).build();
    }

    @ApiOperation(value = "查询'用户-工作总结文件表'", notes = "##### 根据传入参数查询'用户-工作总结文件表'，参数名称参照Jx22UserFileVO中的属性名，可通过添加后缀来实现‘等于’、‘大于’、‘LIKE’等操作。具体如下：\n" +
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
            @ApiImplicitParam(name = "Jx22UserFileVO.*", value = "Jx22UserFileVO实体中相关属性名", dataType = "*", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数，从0开始", dataType = "int",example = "0", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页行数", dataType = "int",example = "10", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/jx22UserFile/getUserFile", method = RequestMethod.GET)
    public HttpOutMsgBean query(HttpServletRequest request,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, @RequestParam(value = "sort",required = false) String sort) {
        Map<String, Object> paramMap = HttpRequestUtils.getParameterMapFromRequest(request, Arrays.asList("page", "size", "sort"));
        Pageable pageable= PageUtils.pageBuilder(page,size,sort);
        Iterable<Jx22UserFileVO> queryResult =  jx22UserFileService.getUserFile(paramMap, pageable);
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.ARR).msgDes("query").msgContent(queryResult).build();
    }


    @ApiOperation(value = "查询'用户-工作总结文件表'记录数", notes = "根据传入参数查询'用户-工作总结文件表'记录数,输入参数参照类Jx22UserFileVO")
    @RequestMapping(value = "/jx22UserFile/queryWjLj", method = RequestMethod.GET)
    public HttpOutMsgBean queryWjLj(@RequestParam(value = "khnf") String khnf,@RequestParam(value = "khzq") String khzq,@RequestParam(value = "khdxid") String khdxid) {
        List<Jx22UserFilePO> wjljs = jx22UserFileService.findByKhnfAndKhzqAndKhdxid(khnf, khzq, khdxid);
        Jx22UserFilePO wjlj=new Jx22UserFilePO();
        if(wjljs.size()==0){
            wjlj=null;
        }else{
            wjlj=wjljs.get(0);
        }
        return HttpOutMsgBean.builder().msgState(WebConstants.RET_MSG_STATE_ENUM.SUCCESS).msgType(WebConstants.RET_MSG_TYPE_ENUM.STR).msgContent(wjlj).build();
    }
}