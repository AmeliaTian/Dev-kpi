package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 部门管理表 QSL查询
 * @CreateDate 创建时间： 2019-05-29 13:46:33
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx21BmglInfoPO extends EntityPathBase<Jx21BmglInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx21BmglInfoPO jx21BmglInfoPO = new QJx21BmglInfoPO("jx21BmglInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核对象id （ 部门） */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象名称（部门） */
    public final StringPath khdxmc = createString("khdxmc" );

    /** 关联部门id */
    public final StringPath glbmid = createString("glbmid" );

    /** 关联部门名称 */
    public final StringPath glbmmc = createString("glbmmc" );

    /** 权重 */
    public final StringPath qz = createString("qz" );

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx21BmglInfoPO(String variable) {
        super(Jx21BmglInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx21BmglInfoPO(Path<? extends Jx21BmglInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx21BmglInfoPO(PathMetadata metadata) {
        super(Jx21BmglInfoPO.class, metadata);
    }
}