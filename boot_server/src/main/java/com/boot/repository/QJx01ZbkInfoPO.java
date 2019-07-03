package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 01指标库 QSL查询
 * @CreateDate 创建时间： 2019-03-25 15:53:17
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx01ZbkInfoPO extends EntityPathBase<Jx01ZbkInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx01ZbkInfoPO jx01ZbkInfoPO = new QJx01ZbkInfoPO("jx01ZbkInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 指标类别 */
    public final StringPath zblb = createString("zblb" );

    /** 指标所属部门 */
    public final StringPath zblsbm = createString("zblsbm" );

    /** 所属大类 */
    public final StringPath ssdl = createString("ssdl" );

    /** 指标类型 */
    public final StringPath zblx = createString("zblx" );

    /** 指标序号 */
    public final NumberPath zbxh = createNumber("zbxh" , Integer.class);

    /** 指标名称 */
    public final StringPath zbmc = createString("zbmc" );

    /** 指标定义 */
    public final StringPath zbdy = createString("zbdy" );

    /** 目标值 */
    public final StringPath mbz = createString("mbz" );

    /** 权重 */
    public final StringPath qz = createString("qz" );

    /** 评分标准 */
    public final StringPath pfbz = createString("pfbz" );

    /** 数据来源 */
    public final StringPath sjly = createString("sjly" );

    /** 指标展现类型 */
    public final StringPath zbzxlx = createString("zbzxlx" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx01ZbkInfoPO(String variable) {
        super(Jx01ZbkInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx01ZbkInfoPO(Path<? extends Jx01ZbkInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx01ZbkInfoPO(PathMetadata metadata) {
        super(Jx01ZbkInfoPO.class, metadata);
    }
}