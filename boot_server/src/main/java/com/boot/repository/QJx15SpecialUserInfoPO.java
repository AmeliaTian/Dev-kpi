package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description JX15_SPECIAL_USER_INFO QSL查询
 * @CreateDate 创建时间： 2019-02-14 16:12:35
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx15SpecialUserInfoPO extends EntityPathBase<Jx15SpecialUserInfoPO> {

    private static final long serialVersionUID = 1L;

    public static final QJx15SpecialUserInfoPO jx15SpecialUserInfoPO = new QJx15SpecialUserInfoPO("jx15SpecialUserInfoPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 用户id */
    public final StringPath userId = createString("userId" );

    /** 特殊人员名称 */
    public final StringPath userName = createString("userName" );

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx15SpecialUserInfoPO(String variable) {
        super(Jx15SpecialUserInfoPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx15SpecialUserInfoPO(Path<? extends Jx15SpecialUserInfoPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx15SpecialUserInfoPO(PathMetadata metadata) {
        super(Jx15SpecialUserInfoPO.class, metadata);
    }
}