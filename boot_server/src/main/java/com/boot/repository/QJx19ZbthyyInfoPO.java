package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description JX19_ZBTHYY_INFO QSL查询
 * @CreateDate 创建时间： 2019-04-12 10:34:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx19ZbthyyInfoPO extends EntityPathBase<Jx19ZbthyyInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx19ZbthyyInfoPO jx19ZbthyyInfoPO = new QJx19ZbthyyInfoPO("jx19ZbthyyInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 已签订指标id */
    public final StringPath zbid = createString("zbid" );

    /** 退回原因 */
    public final StringPath thyy = createString("thyy" );

    /** 退回人id */
    public final StringPath thuserid = createString("thuserid" );

    /** 退回人 */
    public final StringPath thuser = createString("thuser" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx19ZbthyyInfoPO(String variable) {
        super(Jx19ZbthyyInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx19ZbthyyInfoPO(Path<? extends Jx19ZbthyyInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx19ZbthyyInfoPO(PathMetadata metadata) {
        super(Jx19ZbthyyInfoPO.class, metadata);
    }
}