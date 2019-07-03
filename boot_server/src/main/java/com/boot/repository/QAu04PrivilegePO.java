package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU04_权限(资源表)表 QSL查询
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu04PrivilegePO extends EntityPathBase<Au04PrivilegePO> {

    private static final long serialVersionUID = 1L;

    public static final QAu04PrivilegePO au04PrivilegePO = new QAu04PrivilegePO("au04PrivilegePO");

    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 访问的链接和数据库资源
     */
    public final StringPath privType = createString("privType");

    /**
     * 资源路径
     */
    public final StringPath privResource = createString("privResource");

    /**
     * 访问方式
     */
    public final StringPath privMethod = createString("privMethod");

    /**
     * 资源描述
     */
    public final StringPath privDes = createString("privDes");

    /**
     * 分配角色
     */
    public final StringPath privRoles = createString("privRoles");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu04PrivilegePO(String variable) {
        super(Au04PrivilegePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu04PrivilegePO(Path<? extends Au04PrivilegePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu04PrivilegePO(PathMetadata metadata) {
        super(Au04PrivilegePO.class, metadata);
    }
}