package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 02指标评分细则 QSL查询
 * @CreateDate 创建时间： 2019-04-09 15:30:22
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx02ZbpfxzInfoPO extends EntityPathBase<Jx02ZbpfxzInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx02ZbpfxzInfoPO jx02ZbpfxzInfoPO = new QJx02ZbpfxzInfoPO("jx02ZbpfxzInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 指标ID 关联指标 */
    public final StringPath zbgid = createString("zbgid" );

    /** 算法 */
    public final StringPath sfid = createString("sfid" );

    /** 明细编号 */
    public final NumberPath mxbh = createNumber("mxbh" , Integer.class);

    /** 明细分值 */
    public final StringPath mxfz = createString("mxfz" );

    /** 明细名称 */
    public final StringPath mxmc = createString("mxmc" );

    /** SFINFO */
    public final StringPath sfinfo = createString("sfinfo" );

    /** 算法变量分值  减加分 */
    /*public final NumberPath sfblfz = createNumber("sfblfz" , Double.class);*/

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx02ZbpfxzInfoPO(String variable) {
        super(Jx02ZbpfxzInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx02ZbpfxzInfoPO(Path<? extends Jx02ZbpfxzInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx02ZbpfxzInfoPO(PathMetadata metadata) {
        super(Jx02ZbpfxzInfoPO.class, metadata);
    }
}