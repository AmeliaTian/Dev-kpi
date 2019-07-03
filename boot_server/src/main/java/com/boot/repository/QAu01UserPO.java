package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AU01_系统用户表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAu01UserPO extends EntityPathBase<Au01UserPO> {

    private static final long serialVersionUID = 1L;

    public static final QAu01UserPO au01UserPO = new QAu01UserPO("au01UserPO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 用户姓名
     */
    public final StringPath userNameCn = createString("userNameCn");

    /**
     * 登录用户名
     */
    public final StringPath userName = createString("userName");

    /**
     * 登录密码
     */
    public final StringPath password = createString("password");

    /**
     * 电话号码
     */
    public final StringPath phoneNumber = createString("phoneNumber");

    /**
     * EMAIL
     */
    public final StringPath email = createString("email");

    /**
     * 帐号是否过期
     */
    public final StringPath accountExpired = createString("accountExpired");

    /**
     * 账号是否锁定
     */
    public final StringPath accountLocked = createString("accountLocked");

    /**
     * 用户是否启用
     */
    public final StringPath accountEnabled = createString("accountEnabled");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);


    public QAu01UserPO(String variable) {
        super(Au01UserPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAu01UserPO(Path<? extends Au01UserPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAu01UserPO(PathMetadata metadata) {
        super(Au01UserPO.class, metadata);
    }
}