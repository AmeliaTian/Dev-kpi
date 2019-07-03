package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU02_组织机构表 QSL查询
 * @CreateDate 创建时间： 2018-09-14 10:33:27
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu02OrganizationPO extends EntityPathBase<Au02OrganizationPO> {

    private static final long serialVersionUID = 1L;

    public static final QAu02OrganizationPO au02OrganizationPO = new QAu02OrganizationPO("au02OrganizationPO");

    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 父级ID
     */
    public final StringPath parentId = createString("parentId");

    /**
     * 机构名称
     */
    public final StringPath orgName = createString("orgName");

    /**
     * 机构说明
     */
    public final StringPath orgDesc = createString("orgDesc");


    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu02OrganizationPO(String variable) {
        super(Au02OrganizationPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu02OrganizationPO(Path<? extends Au02OrganizationPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu02OrganizationPO(PathMetadata metadata) {
        super(Au02OrganizationPO.class, metadata);
    }
}