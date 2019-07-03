package com.boot.repository;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-06 11:12:30
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AM02_FORM_META_ITEM")
@EntityListeners(AuditingEntityListener.class)
public class Am02FormMetaItemPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /**
     * 表单ID
     */
    @Column(name = "FORM_ID", nullable = true, length = 100)
    private String formId;

    /**
     * 顺序号
     */
    @Column(name = "META_SEQ", nullable = true, length = 10)
    private Integer metaSeq;

    /**
     * 表单项名称
     */
    @Column(name = "META_NAME", nullable = true, length = 20)
    private String metaName;

    /**
     * 表单项编码
     */
    @Column(name = "META_CODE", nullable = true, length = 20)
    private String metaCode;

    /**
     * 表单项类型
     */
    @Column(name = "META_HTML_TYPE", nullable = true, length = 20)
    private String metaHtmlType;

    /**
     * 是否必填项
     */
    @Column(name = "IF_REQUIRED", nullable = true, length = 5)
    private String ifRequired;

    /**
     * 是否显示
     */
    @Column(name = "IF_SHOW", nullable = true, length = 5)
    private String ifShow;

    /**
     * 是否可编辑
     */
    @Column(name = "IF_CAN_EDIT", nullable = true, length = 5)
    private String ifCanEdit;

    /**
     * 是否可修改
     */
    @Column(name = "IF_CAN_MODIFY", nullable = true, length = 5)
    private String ifCanModify;

    /**
     * 内容校验正则表达式
     */
    @Column(name = "META_VALIDATE", nullable = true, length = 50)
    private String metaValidate;

    /**
     * 内容校验提示
     */
    @Column(name = "META_VALIDATE_TIP", nullable = true, length = 50)
    private String metaValidateTip;


    /**
     * 自定义样式
     */
    @Column(name = "META_CUS_CLASS", nullable = true, length = 100)
    private String metaCusClass;

    /**
     * 内容长度
     */
    @Column(name = "META_VALUE_LENGTH", nullable = true, length = 10)
    private Integer metaValueLength;

    /**
     * 默认值
     */
    @Column(name = "META_DEFAULT_VALUE", nullable = true, length = 500)
    private String metaDefaultValue;

    /**
     * 描述
     */
    @Column(name = "META_DES", nullable = true, length = 500)
    private String metaDes;

    /**
     * 信息提示
     */
    @Column(name = "META_PLACEHOLDER", nullable = true, length = 100)
    private String metaPlaceholder;

    /**
     * 显示宽度
     */
    @Column(name = "META_HTML_WIDTH", nullable = true, length = 10)
    private Integer metaHtmlWidth;

    /**
     * 待选内容
     */
    @Column(name = "META_VALUE_LIST", nullable = true, length = 500)
    private String metaValueList;

    /**
     * 扩展属性
     */
    @Column(name = "META_EXTEND", nullable = true, length = 500)
    private String metaExtend;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;

}