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
 * @CreateDate 创建时间： 2018-09-30 13:32:33
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AT03_CUSTOM_SQL")
@EntityListeners(AuditingEntityListener.class)
public class At03CustomSqlPO implements java.io.Serializable {

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
     * SQL标题
     */
    @Column(name = "SQL_TITLE", nullable = true, length = 100)
    private String sqlTitle;

    /**
     * SQL语句
     */
    @Column(name = "SQL_CONTENT", nullable = true, length = 4000)
    private String sqlContent;

    /**
     * SQL描述
     */
    @Column(name = "SQL_DES", nullable = true, length = 500)
    private String sqlDes;

    /**
     * SQL操作
     */
    @Column(name = "SQL_ACTION", nullable = true, length = 500)
    private String sqlAction;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}