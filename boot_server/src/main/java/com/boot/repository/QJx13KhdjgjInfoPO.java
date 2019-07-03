package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 13考核等级系数管理表 QSL查询
 * @CreateDate 创建时间： 2019-05-30 14:55:19
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx13KhdjgjInfoPO extends EntityPathBase<Jx13KhdjgjInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx13KhdjgjInfoPO jx13KhdjgjInfoPO = new QJx13KhdjgjInfoPO("jx13KhdjgjInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** KHZQ */
    public final StringPath khzq = createString("khzq" );

    /** 考核等级 */
    public final StringPath khdj = createString("khdj" );

    /** 绩效积分 */
    public final StringPath jxjf = createString("jxjf" );

    /** 部门考核得分最低值 */
    public final StringPath minbmdf = createString("minbmdf" );

    /** 部门考核得分最高值 */
    public final StringPath maxbmdf = createString("maxbmdf" );

    /** 绩效系数 */
    public final StringPath jxxs = createString("jxxs" );

    /** 等级人数所占百分比 */
    public final StringPath djrsbfb = createString("djrsbfb" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx13KhdjgjInfoPO(String variable) {
        super(Jx13KhdjgjInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx13KhdjgjInfoPO(Path<? extends Jx13KhdjgjInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx13KhdjgjInfoPO(PathMetadata metadata) {
        super(Jx13KhdjgjInfoPO.class, metadata);
    }
}