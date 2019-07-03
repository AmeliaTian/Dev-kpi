package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU03_角色表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu03RolePO extends EntityPathBase<Au03RolePO> {

    private static final long serialVersionUID = 1L;

    public static final QAu03RolePO au03RolePO = new QAu03RolePO("au03RolePO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 角色名称
     */
    public final StringPath roleName = createString("roleName");

    /**
     * 角色编码
     */
    public final StringPath roleCode = createString("roleCode");

    /**
     * 角色描述
     */
    public final StringPath roleDesc = createString("roleDesc");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu03RolePO(String variable) {
        super(Au03RolePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu03RolePO(Path<? extends Au03RolePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu03RolePO(PathMetadata metadata) {
        super(Au03RolePO.class, metadata);
    }
}