package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

/**
 * @author CodeGen
 * @Description AM02_表单内容 QSL查询
 * @CreateDate 创建时间： 2018-09-06 11:12:30
 * @ModifiedBy
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAm02FormMetaItemPO extends EntityPathBase<Am02FormMetaItemPO> {

    private static final long serialVersionUID = 1L;

    public static final QAm02FormMetaItemPO am02FormMetaItemPO = new QAm02FormMetaItemPO("am02FormMetaItemPO");

    /**
     * ID
     */
    public final StringPath id = createString("id");

    /**
     * 表单ID
     */
    public final StringPath formId = createString("formId");

    /**
     * 顺序号
     */
    public final NumberPath metaSeq = createNumber("metaSeq", Integer.class);

    /**
     * 表单项名称
     */
    public final StringPath metaName = createString("metaName");

    /**
     * 表单项编码
     */
    public final StringPath metaCode = createString("metaCode");

    /**
     * 表单项类型
     */
    public final StringPath metaHtmlType = createString("metaHtmlType");

    /**
     * 是否必填项
     */
    public final StringPath ifRequired = createString("ifRequired");

    /**
     * 是否显示
     */
    public final StringPath ifShow = createString("ifShow");

    /**
     * 是否可编辑
     */
    public final StringPath ifCanEdit = createString("ifCanEdit");

    /**
     * 自定义样式
     */
    public final StringPath metaCusClass = createString("metaCusClass");

    /**
     * 内容长度
     */
    public final NumberPath metaValueLength = createNumber("metaValueLength", Integer.class);

    /**
     * 默认值
     */
    public final StringPath metaDefaultValue = createString("metaDefaultValue");

    /**
     * 描述
     */
    public final StringPath metaDes = createString("metaDes");

    /**
     * 信息提示
     */
    public final StringPath metaPlaceholder = createString("metaPlaceholder");

    /**
     * 显示宽度
     */
    public final NumberPath metaHtmlWidth = createNumber("metaHtmlWidth", Integer.class);

    /**
     * 待选内容
     */
    public final StringPath metaValueList = createString("metaValueList");

    /**
     * 扩展属性
     */
    public final StringPath metaExtend = createString("metaExtend");

    /**
     * 创建时间
     */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime", java.util.Date.class);

    public QAm02FormMetaItemPO(String variable) {
        super(Am02FormMetaItemPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAm02FormMetaItemPO(Path<? extends Am02FormMetaItemPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAm02FormMetaItemPO(PathMetadata metadata) {
        super(Am02FormMetaItemPO.class, metadata);
    }
}