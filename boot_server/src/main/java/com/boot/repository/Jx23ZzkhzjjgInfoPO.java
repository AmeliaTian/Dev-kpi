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
 * @CreateDate 创建时间： 2019-06-20 11:47:03
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX23_ZZKHZJJG_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx23ZzkhzjjgInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 4)
    private String khnf;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 256)
    private String khzq;

    /** 考核主体id */
    @Column(name = "KHZTID", nullable = true, length = 20)
    private String khztid;

    /** 考核主体 */
    @Column(name = "KHZTMC", nullable = true, length = 256)
    private String khztmc;

    /** 考核对象id */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 考核对象 */
    @Column(name = "KHDXMC", nullable = true, length = 256)
    private String khdxmc;

    /** 考核主体权重 */
    @Column(name = "KHZTQZ", nullable = true, length = 256)
    private String khztqz;

    /** 考核得分 */
    @Column(name = "KHDF", nullable = true, length = 256)
    private String khdf;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 255)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 256)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}