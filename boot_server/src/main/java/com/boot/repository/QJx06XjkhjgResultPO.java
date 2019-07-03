package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 06绩效考核结果明细表 QSL查询
 * @CreateDate 创建时间： 2019-04-28 11:37:24
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx06XjkhjgResultPO extends EntityPathBase<Jx06XjkhjgResultPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx06XjkhjgResultPO jx06XjkhjgResultPO = new QJx06XjkhjgResultPO("jx06XjkhjgResultPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 考核对象类别 */
    public final StringPath khdxlb = createString("khdxlb" );

    /** 考核对象id */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象名称 */
    public final StringPath khdxmc = createString("khdxmc" );

    /** 指标id */
    public final StringPath zbid = createString("zbid" );

    /** 指标得分 */
    public final StringPath zbdf = createString("zbdf" );

    /** 评分原因 */
    public final StringPath pfyy = createString("pfyy" );

    /** 考核主体id */
    public final StringPath khztid = createString("khztid" );

    /** 考核主体名称 */
    public final StringPath khztmc = createString("khztmc" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx06XjkhjgResultPO(String variable) {
        super(Jx06XjkhjgResultPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx06XjkhjgResultPO(Path<? extends Jx06XjkhjgResultPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx06XjkhjgResultPO(PathMetadata metadata) {
        super(Jx06XjkhjgResultPO.class, metadata);
    }
}