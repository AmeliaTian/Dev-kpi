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
 * @CreateDate 创建时间： 2019-03-06 10:16:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX16_ZQMANAGE_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx16ZqmanageInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** JDBH */
    @Column(name = "JDBH", nullable = true, length = 20)
    private String jdbh;

    /** JDMC */
    @Column(name = "JDMC", nullable = true, length = 20)
    private String jdmc;

    /** YXBS */
    @Column(name = "YXBS", nullable = true, length = 20)
    private String yxbs;

    /** UPDATE_TIME */
    @Column(name = "UPDATE_TIME", nullable = true, length = 26)
    private Date updateTime;

    /** BZ */
    @Column(name = "BZ", nullable = true, length = 200)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}