package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description
 * @CreateDate 创建时间： 2019-06-24 15:29:27
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Va03OrgUsercountDAO extends BaseDAO<Va03OrgUsercountPO, String> {
    @Query(value = "select peopleCount from va03_org_usercount where ORG_ID=?1",nativeQuery = true)
    Integer findPeopleCountById(String bmid);

    @Query(value = "select peopleCount from va03_org_usercount where ORG_NAME=?1",nativeQuery = true)
    Integer findByOrgName(String orgName);

}