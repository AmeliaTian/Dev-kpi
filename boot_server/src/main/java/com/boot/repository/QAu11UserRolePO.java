package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU11_用户角色映射表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu11UserRolePO extends EntityPathBase<Au11UserRolePO> {

    private static final long serialVersionUID = 1L;

    public static final QAu11UserRolePO au11UserRolePO = new QAu11UserRolePO("au11UserRolePO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 用户ID
     */
    public final StringPath userId = createString("userId");

    /**
     * 角色ID
     */
    public final StringPath roleId = createString("roleId");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu11UserRolePO(String variable) {
        super(Au11UserRolePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu11UserRolePO(Path<? extends Au11UserRolePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu11UserRolePO(PathMetadata metadata) {
        super(Au11UserRolePO.class, metadata);
    }
}