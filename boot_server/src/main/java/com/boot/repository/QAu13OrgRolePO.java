package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU13_机构角色映射表 QSL查询
 * @CreateDate 创建时间： 2018-09-13 16:00:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu13OrgRolePO extends EntityPathBase<Au13OrgRolePO> {

    private static final long serialVersionUID = 1L;

    public static final QAu13OrgRolePO au13OrgRolePO = new QAu13OrgRolePO("au13OrgRolePO");

    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 组织机构ID
     */
    public final StringPath orgId = createString("orgId");

    /**
     * 角色ID
     */
    public final StringPath roleId = createString("roleId");


    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu13OrgRolePO(String variable) {
        super(Au13OrgRolePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu13OrgRolePO(Path<? extends Au13OrgRolePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu13OrgRolePO(PathMetadata metadata) {
        super(Au13OrgRolePO.class, metadata);
    }
}