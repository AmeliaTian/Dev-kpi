package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description AU14_菜单角色映射表 QSL查询
 * @CreateDate 创建时间： 2019-01-15 17:56:52
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu14MenuRolePO extends EntityPathBase<Au14MenuRolePO> {

    private static final long serialVersionUID = 1L;

    public static final QAu14MenuRolePO au14MenuRolePO = new QAu14MenuRolePO("au14MenuRolePO");

    /** ID */
    public final StringPath id = createString("id");

    /** 菜单ID */
    public final StringPath menuId = createString("menuId" );

    /** 角色ID */
    public final StringPath roleId = createString("roleId" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QAu14MenuRolePO(String variable) {
        super(Au14MenuRolePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu14MenuRolePO(Path<? extends Au14MenuRolePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu14MenuRolePO(PathMetadata metadata) {
        super(Au14MenuRolePO.class, metadata);
    }
}