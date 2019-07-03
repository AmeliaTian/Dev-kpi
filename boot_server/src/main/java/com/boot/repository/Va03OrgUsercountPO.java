package com.boot.repository;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @CreateDate 创建时间： 2019-06-24 15:29:27
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "VA03_ORG_USERCOUNT")
@EntityListeners(AuditingEntityListener.class)
public class Va03OrgUsercountPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** ID */
    @Column(name = "ORG_ID", nullable = false, length = 32)
    private String orgId;

    /** 机构名称 */
    @Column(name = "ORG_NAME", nullable = true, length = 100)
    private String orgName;

    /** PEOPLECOUNT */
    @Column(name = "PEOPLECOUNT", nullable = false, length = 19)
    private Long peoplecount;



}