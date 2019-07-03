package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description AU05_菜单表 QSL查询
 * @CreateDate 创建时间： 2019-01-15 17:47:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu05MenuPO extends EntityPathBase<Au05MenuPO> {

    private static final long serialVersionUID = 1L;

    public static final QAu05MenuPO au05MenuPO = new QAu05MenuPO("au05MenuPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 父级ID */
    public final StringPath parentId = createString("parentId" );

    /** 菜单图标 */
    public final StringPath menuIcon = createString("menuIcon" );

    /** 菜单名称 */
    public final StringPath menuName = createString("menuName" );

    /** 菜单链接 */
    public final StringPath menuUrl = createString("menuUrl" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QAu05MenuPO(String variable) {
        super(Au05MenuPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu05MenuPO(Path<? extends Au05MenuPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu05MenuPO(PathMetadata metadata) {
        super(Au05MenuPO.class, metadata);
    }
}