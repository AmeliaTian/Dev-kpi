package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 10部门考核结果汇总表（包括各等级人数） QSL查询
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx10BmkhjgResultPO extends EntityPathBase<Jx10BmkhjgResultPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx10BmkhjgResultPO jx10BmkhjgResultPO = new QJx10BmkhjgResultPO("jx10BmkhjgResultPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 部门id */
    public final StringPath bmid = createString("bmid" );

    /** 部门名称 */
    public final StringPath bmmc = createString("bmmc" );

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 关键业绩类初始得分 */
    public final NumberPath<java.math.BigDecimal> gjyjlcsdf = createNumber("gjyjlcsdf" , java.math.BigDecimal.class);

    /** 关键业绩类最终得分 */
    public final NumberPath<java.math.BigDecimal> gjyjlzzdf = createNumber("gjyjlzzdf" , java.math.BigDecimal.class);

    /** 部门最终考核得分 */
    public final NumberPath<java.math.BigDecimal> bmkhdf = createNumber("bmkhdf" , java.math.BigDecimal.class);

    /** 等级名称 */
    public final StringPath djmc = createString("djmc" );

    /** 预算人数 */
    public final StringPath ysrs = createString("ysrs" );

    /** 实际调整人数 */
    public final StringPath sjtzrs = createString("sjtzrs" );

    /** 剩余可调人数 */
    public final StringPath syktrs = createString("syktrs" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx10BmkhjgResultPO(String variable) {
        super(Jx10BmkhjgResultPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx10BmkhjgResultPO(Path<? extends Jx10BmkhjgResultPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx10BmkhjgResultPO(PathMetadata metadata) {
        super(Jx10BmkhjgResultPO.class, metadata);
    }
}