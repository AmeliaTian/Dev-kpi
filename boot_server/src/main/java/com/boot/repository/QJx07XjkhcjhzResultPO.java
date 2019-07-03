package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 07绩效考核汇总表 QSL查询
 * @CreateDate 创建时间： 2019-05-31 18:09:39
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx07XjkhcjhzResultPO extends EntityPathBase<Jx07XjkhcjhzResultPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx07XjkhcjhzResultPO jx07XjkhcjhzResultPO = new QJx07XjkhcjhzResultPO("jx07XjkhcjhzResultPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** 考核对象类别 */
    public final StringPath khdxlb = createString("khdxlb" );

    /** 考核对象名称 */
    public final StringPath khdxmc = createString("khdxmc" );

    /** 考核对象id */
    public final StringPath khdxid = createString("khdxid" );

    /** 考核对象角色id */
    public final StringPath khdxjsid = createString("khdxjsid" );

    /** 考核对象角色 */
    public final StringPath khdxjs = createString("khdxjs" );

    /** 部门名称 */
    public final StringPath bmmc = createString("bmmc" );

    /** 考核得分 */
    public final StringPath khdf = createString("khdf" );

    /** 考核系数 */
    public final StringPath khxs = createString("khxs" );

    /** 考核等级 */
    public final StringPath khdj = createString("khdj" );

    /** 最终等级 */
    public final StringPath zzdj = createString("zzdj" );

    /** 考核等级调整人 */
    public final StringPath kedjtzr = createString("kedjtzr" );

    /** 绩效积分 */
    public final StringPath jxjf = createString("jxjf" );

    /** 是否调薪 */
    public final StringPath sftx = createString("sftx" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx07XjkhcjhzResultPO(String variable) {
        super(Jx07XjkhcjhzResultPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx07XjkhcjhzResultPO(Path<? extends Jx07XjkhcjhzResultPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx07XjkhcjhzResultPO(PathMetadata metadata) {
        super(Jx07XjkhcjhzResultPO.class, metadata);
    }
}