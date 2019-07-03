package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 算法模板表 QSL查询
 * @CreateDate 创建时间： 2019-04-04 10:40:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx18SfmbInfoPO extends EntityPathBase<Jx18SfmbInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx18SfmbInfoPO jx18SfmbInfoPO = new QJx18SfmbInfoPO("jx18SfmbInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 算法名称 */
    public final StringPath sfmc = createString("sfmc" );

    /** 算法标识 */
    public final StringPath sflx = createString("sflx" );

    /** 算法 */
    public final StringPath sf = createString("sf" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx18SfmbInfoPO(String variable) {
        super(Jx18SfmbInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx18SfmbInfoPO(Path<? extends Jx18SfmbInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx18SfmbInfoPO(PathMetadata metadata) {
        super(Jx18SfmbInfoPO.class, metadata);
    }
}