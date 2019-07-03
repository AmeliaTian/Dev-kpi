package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 20指标完成情况表 QSL查询
 * @CreateDate 创建时间： 2019-04-17 14:36:59
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx20ZbwcqkInfoPO extends EntityPathBase<Jx20ZbwcqkInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx20ZbwcqkInfoPO jx20ZbwcqkInfoPO = new QJx20ZbwcqkInfoPO("jx20ZbwcqkInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 算法明细id   02表 */
    public final StringPath sfmxid = createString("sfmxid" );

    /** 明细完成情况 */
    public final StringPath mxwcqk = createString("mxwcqk" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx20ZbwcqkInfoPO(String variable) {
        super(Jx20ZbwcqkInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx20ZbwcqkInfoPO(Path<? extends Jx20ZbwcqkInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx20ZbwcqkInfoPO(PathMetadata metadata) {
        super(Jx20ZbwcqkInfoPO.class, metadata);
    }
}