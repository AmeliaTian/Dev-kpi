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
 * @CreateDate 创建时间： 2019-04-12 10:34:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX19_ZBTHYY_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx19ZbthyyInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 已签订指标id */
    @Column(name = "ZBID", nullable = true, length = 20)
    private String zbid;

    /** 退回原因 */
    @Column(name = "THYY", nullable = true, length = 2000)
    private String thyy;

    /** 退回人id */
    @Column(name = "THUSERID", nullable = true, length = 20)
    private String thuserid;

    /** 退回人 */
    @Column(name = "THUSER", nullable = true, length = 20)
    private String thuser;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 2)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 200)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}