package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 12考核主体任务表 QSL查询
 * @CreateDate 创建时间： 2019-02-14 16:11:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx12KhztrwInfoPO extends EntityPathBase<Jx12KhztrwInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx12KhztrwInfoPO jx12KhztrwInfoPO = new QJx12KhztrwInfoPO("jx12KhztrwInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 考核类型 */
    public final StringPath khlx = createString("khlx" );

    /** 考核主体id */
    public final StringPath khztid = createString("khztid" );

    /** 考核主体 */
    public final StringPath khzt = createString("khzt" );

    /** 考核对象id */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象 */
    public final StringPath khdx = createString("khdx" );

    /** 考核主体权重 */
    public final StringPath khztqz = createString("khztqz" );

    /** 考核得分 */
    public final StringPath khdf = createString("khdf" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx12KhztrwInfoPO(String variable) {
        super(Jx12KhztrwInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx12KhztrwInfoPO(Path<? extends Jx12KhztrwInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx12KhztrwInfoPO(PathMetadata metadata) {
        super(Jx12KhztrwInfoPO.class, metadata);
    }
}