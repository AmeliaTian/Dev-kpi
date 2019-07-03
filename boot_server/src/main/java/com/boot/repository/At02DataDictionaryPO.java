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
 * @Description AT02_数据字典表
 * @CreateDate 创建时间：2018-08-13 12:41:06
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AT02_DATA_DICTIONARY")
@EntityListeners(AuditingEntityListener.class)
public class At02DataDictionaryPO implements java.io.Serializable {

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
    @Column(name = "DICT_TID", nullable = true, length = 100)
    private String dictTid;

    /**
     * 顺序号
     */
    @Column(name = "DICT_SEQ", nullable = true, length = 100)
    private Integer dictSeq;

    /**
     * 字典名称
     */
    @Column(name = "DICT_NAME", nullable = true, length = 100)
    private String dictName;

    /**
     * 字典编码
     */
    @Column(name = "DICT_CODE", nullable = true, length = 100)
    private String dictCode;

    /**
     * 字典项描述
     */
    @Column(name = "DICT_DES", nullable = true, length = 500)
    private String dictDes;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;

}