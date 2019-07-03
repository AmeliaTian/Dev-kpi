package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description VIEW QSL查询
 * @CreateDate 创建时间： 2019-06-24 15:29:27
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QVa03OrgUsercountPO extends EntityPathBase<Va03OrgUsercountPO> {

    private static final long serialVersionUID = 1L;

    public static final QVa03OrgUsercountPO va03OrgUsercountPO = new QVa03OrgUsercountPO("va03OrgUsercountPO");

    /** ID */
    public final StringPath id = createString("id");

    /** ID */
    public final StringPath orgId = createString("orgId" );

    /** 机构名称 */
    public final StringPath orgName = createString("orgName" );

    /** PEOPLECOUNT */
    public final NumberPath peoplecount = createNumber("peoplecount" , Long.class);


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QVa03OrgUsercountPO(String variable) {
        super(Va03OrgUsercountPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QVa03OrgUsercountPO(Path<? extends Va03OrgUsercountPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVa03OrgUsercountPO(PathMetadata metadata) {
        super(Va03OrgUsercountPO.class, metadata);
    }
}