package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 04指标类别权重表 QSL查询
 * @CreateDate 创建时间： 2019-03-20 14:53:56
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx04ZblbqzInfoPO extends EntityPathBase<Jx04ZblbqzInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx04ZblbqzInfoPO jx04ZblbqzInfoPO = new QJx04ZblbqzInfoPO("jx04ZblbqzInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核对象角色ID */
    public final StringPath khdxjsid = createString("khdxjsid" );

    /** 考核对象角色 */
    public final StringPath khdxjs = createString("khdxjs" );

    /** 指标大类 */
    public final StringPath zbdl = createString("zbdl" );

    /** 权重 */
    public final StringPath qz = createString("qz" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx04ZblbqzInfoPO(String variable) {
        super(Jx04ZblbqzInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx04ZblbqzInfoPO(Path<? extends Jx04ZblbqzInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx04ZblbqzInfoPO(PathMetadata metadata) {
        super(Jx04ZblbqzInfoPO.class, metadata);
    }
}