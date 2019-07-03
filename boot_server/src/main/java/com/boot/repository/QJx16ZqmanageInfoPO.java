package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 考核周期阶段管理 QSL查询
 * @CreateDate 创建时间： 2019-03-06 10:16:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx16ZqmanageInfoPO extends EntityPathBase<Jx16ZqmanageInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx16ZqmanageInfoPO jx16ZqmanageInfoPO = new QJx16ZqmanageInfoPO("jx16ZqmanageInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** JDBH */
    public final StringPath jdbh = createString("jdbh" );

    /** JDMC */
    public final StringPath jdmc = createString("jdmc" );

    /** YXBS */
    public final StringPath yxbs = createString("yxbs" );

    /** UPDATE_TIME */
    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime" , java.util.Date.class);

    /** BZ */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx16ZqmanageInfoPO(String variable) {
        super(Jx16ZqmanageInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx16ZqmanageInfoPO(Path<? extends Jx16ZqmanageInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx16ZqmanageInfoPO(PathMetadata metadata) {
        super(Jx16ZqmanageInfoPO.class, metadata);
    }
}