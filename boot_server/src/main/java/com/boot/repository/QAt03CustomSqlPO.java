package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AT03_自定义SQL QSL查询
 * @CreateDate 创建时间： 2018-09-30 13:32:33
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAt03CustomSqlPO extends EntityPathBase<At03CustomSqlPO> {

    private static final long serialVersionUID = 1L;

    public static final QAt03CustomSqlPO at03CustomSqlPO = new QAt03CustomSqlPO("at03CustomSqlPO");

    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * SQL标题
     */
    public final StringPath sqlTitle = createString("sqlTitle");

    /**
     * SQL语句
     */
    public final StringPath sqlContent = createString("sqlContent");

    /**
     * SQL描述
     */
    public final StringPath sqlDes = createString("sqlDes");


    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAt03CustomSqlPO(String variable) {
        super(At03CustomSqlPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAt03CustomSqlPO(Path<? extends At03CustomSqlPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAt03CustomSqlPO(PathMetadata metadata) {
        super(At03CustomSqlPO.class, metadata);
    }
}