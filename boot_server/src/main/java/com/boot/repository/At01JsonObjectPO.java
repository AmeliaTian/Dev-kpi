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
 * @Description AT01_对象存储表
 * @CreateDate 创建时间：2018-08-13 11:27:27
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AT01_JSON_OBJECT")
@EntityListeners(AuditingEntityListener.class)
public class At01JsonObjectPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ID", nullable = false, length = 36)
    private String id;

    /**
     * 类别名称
     */
    @Column(name = "OBJ_TYPE", nullable = true, length = 100)
    private String objType;

    /**
     * 子类别名称
     */
    @Column(name = "OBJ_SUB_TYPE", nullable = true, length = 100)
    private String objSubType;

    /**
     * 对象描述
     */
    @Column(name = "OBJ_DES", nullable = true, length = 500)
    private String objDes;

    /**
     * 对象内容
     */
    @Column(name = "OBJ_JSON", nullable = true, length = 0, columnDefinition = "LONGTEXT")
    private String objJson;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}