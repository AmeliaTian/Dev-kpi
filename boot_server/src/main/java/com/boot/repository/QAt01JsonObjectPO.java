package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AT01_对象存储表
 * @CreateDate 创建时间：2018-08-13 11:27:27
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAt01JsonObjectPO extends EntityPathBase<At01JsonObjectPO> {

    private static final long serialVersionUID = 1L;

    public static final QAt01JsonObjectPO at01JsonObjectPO = new QAt01JsonObjectPO("at01JsonObjectPO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 类别名称
     */
    public final StringPath objType = createString("objType");

    /**
     * 子类别名称
     */
    public final StringPath objSubType = createString("objSubType");

    /**
     * 对象描述
     */
    public final StringPath objDesc = createString("objDesc");

    /**
     * 对象内容
     */
    public final StringPath objJson = createString("objJson");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);

    public QAt01JsonObjectPO(String variable) {
        super(At01JsonObjectPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAt01JsonObjectPO(Path<? extends At01JsonObjectPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAt01JsonObjectPO(PathMetadata metadata) {
        super(At01JsonObjectPO.class, metadata);
    }
}