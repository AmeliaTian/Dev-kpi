package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description VIEW QSL查询
 * @CreateDate 创建时间： 2018-09-17 11:27:41
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QVa01OrgRolesPO extends EntityPathBase<Va01OrgRolesPO> {

    private static final long serialVersionUID = 1L;

    public static final QVa01OrgRolesPO va01OrgRolesPO = new QVa01OrgRolesPO("va01OrgRolesPO");

    /**
     * 机构ID
     */
    public final StringPath orgId = createString("orgId");

    /**
     * 角色ID
     */
    public final StringPath roleId = createString("roleId");

    public QVa01OrgRolesPO(String variable) {
        super(Va01OrgRolesPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QVa01OrgRolesPO(Path<? extends Va01OrgRolesPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVa01OrgRolesPO(PathMetadata metadata) {
        super(Va01OrgRolesPO.class, metadata);
    }
}