package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AT02_数据字典表
 * @CreateDate 创建时间：2018-08-13 12:41:06
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAt02DataDictionaryPO extends EntityPathBase<At02DataDictionaryPO> {

    private static final long serialVersionUID = 1L;

    public static final QAt02DataDictionaryPO at02DataDictionaryPO = new QAt02DataDictionaryPO("at02DataDictionaryPO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 父ID
     */
    public final StringPath dictTid = createString("dictTid");

    /**
     * 字典名称
     */
    public final StringPath dictName = createString("dictName");

    /**
     * 字典编码
     */
    public final StringPath dictCode = createString("dictCode");

    /**
     * 字典项描述
     */
    public final StringPath dictDesc = createString("dictDesc");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAt02DataDictionaryPO(String variable) {
        super(At02DataDictionaryPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAt02DataDictionaryPO(Path<? extends At02DataDictionaryPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAt02DataDictionaryPO(PathMetadata metadata) {
        super(At02DataDictionaryPO.class, metadata);
    }
}