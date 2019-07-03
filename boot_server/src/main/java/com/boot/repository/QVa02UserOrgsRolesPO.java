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
public class QVa02UserOrgsRolesPO extends EntityPathBase<Va02UserOrgsRolesPO> {

    private static final long serialVersionUID = 1L;

    public static final QVa02UserOrgsRolesPO va02UserOrgsRolesPO = new QVa02UserOrgsRolesPO("va02UserOrgsRolesPO");

    /**
     * 用户ID
     */
    public final StringPath userId = createString("userId");

    /**
     * 角色ID
     */
    public final StringPath roleId = createString("roleId");

    /**
     * 机构ID
     */
    public final StringPath orgId = createString("orgId");

    public QVa02UserOrgsRolesPO(String variable) {
        super(Va02UserOrgsRolesPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QVa02UserOrgsRolesPO(Path<? extends Va02UserOrgsRolesPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVa02UserOrgsRolesPO(PathMetadata metadata) {
        super(Va02UserOrgsRolesPO.class, metadata);
    }
}