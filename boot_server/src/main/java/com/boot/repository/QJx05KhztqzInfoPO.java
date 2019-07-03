package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 05考核主体权重表 QSL查询
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx05KhztqzInfoPO extends EntityPathBase<Jx05KhztqzInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx05KhztqzInfoPO jx05KhztqzInfoPO = new QJx05KhztqzInfoPO("jx05KhztqzInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** KHDXJSID */
    public final StringPath khdxjsid = createString("khdxjsid" );

    /** 考核对象角色 */
    public final StringPath khdxjs = createString("khdxjs" );

    /** 指标大类 */
    public final StringPath zbdl = createString("zbdl" );

    /** 指标类型 */
   /* public final StringPath zblx = createString("zblx" );*/

    /** KHZTJSID */
    public final StringPath khztjsid = createString("khztjsid" );

    /** 考核主体角色 */
    public final StringPath khztjs = createString("khztjs" );

    /** 权重 */
    public final StringPath qz = createString("qz" );

    /** 考核年份 */
    /*public final StringPath khnf = createString("khnf" );*/

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 更新时间 */
    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime" , java.util.Date.class);

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx05KhztqzInfoPO(String variable) {
        super(Jx05KhztqzInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx05KhztqzInfoPO(Path<? extends Jx05KhztqzInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx05KhztqzInfoPO(PathMetadata metadata) {
        super(Jx05KhztqzInfoPO.class, metadata);
    }
}