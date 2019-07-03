package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 03已签订指标表 QSL查询
 * @CreateDate 创建时间： 2019-04-04 10:38:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx03YqdzbInfoPO extends EntityPathBase<Jx03YqdzbInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx03YqdzbInfoPO jx03YqdzbInfoPO = new QJx03YqdzbInfoPO("jx03YqdzbInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核对象Id */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象 */
    public final StringPath khdx = createString("khdx" );

    /** 指标大类 */
    public final StringPath zbdl = createString("zbdl" );

    /** 指标定义 */
    public final StringPath zbdy = createString("zbdy" );

    /** 目标值 */
    public final StringPath mbz = createString("mbz" );

    /** 指标权重 */
    public final StringPath qz = createString("qz" );

    /** 关联指标明细 */
    public final StringPath gid = createString("gid" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );

    /** 创建人 */
    public final StringPath createUser = createString("createUser" );

    /** 指标名称 */
    public final StringPath zbmc = createString("zbmc" );

    /** 更新人 */
    public final StringPath updateUser = createString("updateUser" );

    /** 评分标准 */
    public final StringPath pfbz = createString("pfbz" );

    /** 退回原因 */
    public final StringPath thyy = createString("thyy" );

    /** 退回人员id */
    public final StringPath thuserid = createString("thuserid" );

    /** 退回人员名称 */
    public final StringPath thuser = createString("thuser" );

    /** 算法模板id */
    public final StringPath sfmbid = createString("sfmbid" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx03YqdzbInfoPO(String variable) {
        super(Jx03YqdzbInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx03YqdzbInfoPO(Path<? extends Jx03YqdzbInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx03YqdzbInfoPO(PathMetadata metadata) {
        super(Jx03YqdzbInfoPO.class, metadata);
    }
}