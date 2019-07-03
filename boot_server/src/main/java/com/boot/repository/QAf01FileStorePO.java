package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AF01_文件存储
 * @CreateDate 创建时间：2018-07-16 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAf01FileStorePO extends EntityPathBase<Af01FileStorePO> {

    private static final long serialVersionUID = 1L;

    public static final QAf01FileStorePO af01FileStorePO = new QAf01FileStorePO("af01FileStorePO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 文件名称
     */
    public final StringPath fileName = createString("fileName");

    /**
     * 文件存储ID
     */
    public final StringPath fileUuid = createString("fileUuid");

    /**
     * 文件描述
     */
    public final StringPath fileDesc = createString("fileDesc");

    /**
     * 文件类型
     */
    public final StringPath fileType = createString("fileType");

    /**
     * 文件大小(字节)
     */
    public final NumberPath fileSize = createNumber("fileSize", Integer.class);

    /**
     * 文件后缀
     */
    public final StringPath fileSuffix = createString("fileSuffix");

    /**
     * 上传人
     */
    public final StringPath fileUploadPerson = createString("fileUploadPerson");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);

    public QAf01FileStorePO(String variable) {
        super(Af01FileStorePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAf01FileStorePO(Path<? extends Af01FileStorePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAf01FileStorePO(PathMetadata metadata) {
        super(Af01FileStorePO.class, metadata);
    }
}