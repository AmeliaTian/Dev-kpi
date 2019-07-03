package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description 用户-工作总结文件表 QSL查询
 * @CreateDate 创建时间： 2019-06-18 15:48:30
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx22UserFilePO extends EntityPathBase<Jx22UserFilePO> {

    private static final long serialVersionUID = 1L;

    public static final QJx22UserFilePO jx22UserFilePO = new QJx22UserFilePO("jx22UserFilePO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核周期 */
    public final StringPath khzq = createString("khzq" );

    /** userid */
    public final StringPath userid = createString("userid" );

    /** 文件名 */
    public final StringPath filename = createString("filename" );

    /** 文件地址 */
    public final StringPath fileaddress = createString("fileaddress" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 备注 */
    public final StringPath bz = createString("bz" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx22UserFilePO(String variable) {
        super(Jx22UserFilePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx22UserFilePO(Path<? extends Jx22UserFilePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx22UserFilePO(PathMetadata metadata) {
        super(Jx22UserFilePO.class, metadata);
    }
}