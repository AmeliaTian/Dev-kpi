package com.boot.repository;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AM01_表单列表
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAm01FormMetaPO extends EntityPathBase<Am01FormMetaPO> {

    private static final long serialVersionUID = 1L;

    public static final QAm01FormMetaPO am01FormMetaPO = new QAm01FormMetaPO("am01FormMetaPO");
    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 表单名称
     */
    public final StringPath formName = createString("formName");

    /**
     * 所属分类
     */
    public final StringPath formType = createString("formType");

    /**
     * 表单编码
     */
    public final StringPath formCode = createString("formCode");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);

    /**
     * 描述
     */
    public final StringPath formDes = createString("formDes");

    public QAm01FormMetaPO(String variable) {
        super(Am01FormMetaPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAm01FormMetaPO(Path<? extends Am01FormMetaPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAm01FormMetaPO(PathMetadata metadata) {
        super(Am01FormMetaPO.class, metadata);
    }
}