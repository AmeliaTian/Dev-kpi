package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU12_机构人员映射表 QSL查询
 * @CreateDate 创建时间： 2018-09-13 16:00:19
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu12OrgUserPO extends EntityPathBase<Au12OrgUserPO> {

    private static final long serialVersionUID = 1L;

    public static final QAu12OrgUserPO au12OrgUserPO = new QAu12OrgUserPO("au12OrgUserPO");

    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 组织机构ID
     */
    public final StringPath orgId = createString("orgId");

    /**
     * 人员ID
     */
    public final StringPath userId = createString("userId");


    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu12OrgUserPO(String variable) {
        super(Au12OrgUserPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu12OrgUserPO(Path<? extends Au12OrgUserPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu12OrgUserPO(PathMetadata metadata) {
        super(Au12OrgUserPO.class, metadata);
    }
}