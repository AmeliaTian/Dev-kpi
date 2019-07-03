package com.boot.module.file.service;

import com.boot.repository.Jx22UserFilePO;
import com.boot.repository.Jx22UserFileVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * @Description 用户-工作总结文件表 Service
 * @CreateDate 创建时间： 2019-06-18 17:10:28
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx22UserFileService extends IBaseService<Jx22UserFileVO> {

//    List<Jx22UserFileVO> getUserFile(String userid, String khnf, String khzq, String rolenames);

    List<String> getFjmc(List<String> ids);

    Iterable<Jx22UserFileVO> getUserFile(Map<String, Object> paramMap, Pageable pageable);

    List<Jx22UserFilePO> findByKhnfAndKhzqAndKhdxid(String khnf, String khzq, String khdxid);
}