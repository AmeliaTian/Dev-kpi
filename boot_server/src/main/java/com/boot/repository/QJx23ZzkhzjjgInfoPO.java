package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 23组织考核中间结果表 QSL查询
 * @CreateDate 创建时间： 2019-06-20 11:47:03
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx23ZzkhzjjgInfoPO extends EntityPathBase<Jx23ZzkhzjjgInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx23ZzkhzjjgInfoPO jx23ZzkhzjjgInfoPO = new QJx23ZzkhzjjgInfoPO("jx23ZzkhzjjgInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 考核主体id */
    public final StringPath khztid = createString("khztid" );

    /** 考核主体 */
    public final StringPath khztmc = createString("khztmc" );

    /** 考核对象id */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象 */
    public final StringPath khdxmc = createString("khdxmc" );

    /** 考核主体权重 */
    public final StringPath khztqz = createString("khztqz" );

    /** 考核得分 */
    public final StringPath khdf = createString("khdf" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx23ZzkhzjjgInfoPO(String variable) {
        super(Jx23ZzkhzjjgInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx23ZzkhzjjgInfoPO(Path<? extends Jx23ZzkhzjjgInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx23ZzkhzjjgInfoPO(PathMetadata metadata) {
        super(Jx23ZzkhzjjgInfoPO.class, metadata);
    }
}