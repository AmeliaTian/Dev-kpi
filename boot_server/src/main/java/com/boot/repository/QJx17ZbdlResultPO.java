package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 考核得分中间表(指标大类得分) QSL查询
 * @CreateDate 创建时间： 2019-05-29 13:47:02
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx17ZbdlResultPO extends EntityPathBase<Jx17ZbdlResultPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx17ZbdlResultPO jx17ZbdlResultPO = new QJx17ZbdlResultPO("jx17ZbdlResultPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核对象ID */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象名称 */
    public final StringPath khdxmc = createString("khdxmc" );

    /** 考核对象角色id */
    public final StringPath khdxjsid = createString("khdxjsid" );

    /** 指标大类   业绩类 态度类 胜任力 */
    public final StringPath zbdl = createString("zbdl" );

    /** 指标大类权重 */
    public final StringPath zbdlqz = createString("zbdlqz" );

    /** 考核得分 */
    public final StringPath df = createString("df" );

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx17ZbdlResultPO(String variable) {
        super(Jx17ZbdlResultPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx17ZbdlResultPO(Path<? extends Jx17ZbdlResultPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx17ZbdlResultPO(PathMetadata metadata) {
        super(Jx17ZbdlResultPO.class, metadata);
    }
}