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
 * @Description AM01_表单列表
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AM01_FORM_META")
@EntityListeners(AuditingEntityListener.class)
public class Am01FormMetaPO implements java.io.Serializable {

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
     * 表单名称
     */
    @Column(name = "FORM_NAME", nullable = true, length = 100)
    private String formName;

    /**
     * 所属分类
     */
    @Column(name = "FORM_TYPE", nullable = true, length = 100)
    private String formType;

    /**
     * 表单编码
     */
    @Column(name = "FORM_CODE", nullable = true, length = 100)
    private String formCode;

    /**
     * 描述
     */
    @Column(name = "FORM_DES", nullable = true, length = 255)
    private String formDes;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;

}