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
 * @CreateDate 创建时间： 2019-04-28 11:37:24
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX06_XJKHJG_RESULT")
@EntityListeners(AuditingEntityListener.class)
public class Jx06XjkhjgResultPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 10)
    private String khnf;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 10)
    private String khzq;

    /** 考核对象类别 */
    @Column(name = "KHDXLB", nullable = true, length = 256)
    private String khdxlb;

    /** 考核对象id */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 考核对象名称 */
    @Column(name = "KHDXMC", nullable = true, length = 256)
    private String khdxmc;

    /** 指标类型 */
    @Column(name = "ZBLX", nullable = true, length = 256)
    private String zblx;

    /** 指标id */
    @Column(name = "ZBID", nullable = true, length = 20)
    private String zbid;

    /** 指标得分 */
    @Column(name = "ZBDF", nullable = true, length = 256)
    private String zbdf;

    /** 评分原因 */
    @Column(name = "PFYY", nullable = true, length = 256)
    private String pfyy;

    /** 考核主体id */
    @Column(name = "KHZTID", nullable = true, length = 20)
    private String khztid;

    /** 考核主体名称 */
    @Column(name = "KHZTMC", nullable = true, length = 256)
    private String khztmc;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 256)
    private String yxbs;

    /** 更新时间 */
    @Column(name = "UPDATETIME", nullable = true, length = 26)
    private Date updatetime;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 256)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}