package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 11绩效考核周期管理 QSL查询
 * @CreateDate 创建时间： 2019-03-13 11:30:29
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx11KhzqInfoPO extends EntityPathBase<Jx11KhzqInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx11KhzqInfoPO jx11KhzqInfoPO = new QJx11KhzqInfoPO("jx11KhzqInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 考核阶段编号 */
    public final StringPath khjdbh = createString("khjdbh" );

    /** 考核阶段名称 */
    public final StringPath khjdmc = createString("khjdmc" );

    /** 阶段预计开始时间 */
    public final StringPath jdyjkssj = createString("jdyjkssj" );

    /** 阶段实际开始时间 */
    public final StringPath jdsjkssj = createString("jdsjkssj" );

    /** 阶段预计结束时间 */
    public final StringPath jdyjjsdj = createString("jdyjjsdj" );

    /** 阶段实际结束时间 */
    public final StringPath jdsjjssj = createString("jdsjjssj" );

    /** 阶段状态 点击按钮 前一个阶段结束 后一个阶段开始  0：未完成 ；1：进行中 ；2：已完成 */
    public final StringPath jdzt = createString("jdzt" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx11KhzqInfoPO(String variable) {
        super(Jx11KhzqInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx11KhzqInfoPO(Path<? extends Jx11KhzqInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx11KhzqInfoPO(PathMetadata metadata) {
        super(Jx11KhzqInfoPO.class, metadata);
    }
}