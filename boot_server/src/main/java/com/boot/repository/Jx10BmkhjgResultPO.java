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
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX10_BMKHJG_RESULT")
@EntityListeners(AuditingEntityListener.class)
public class Jx10BmkhjgResultPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 部门id */
    @Column(name = "BMID", nullable = true, length = 20)
    private String bmid;

    /** 部门名称 */
    @Column(name = "BMMC", nullable = true, length = 256)
    private String bmmc;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 256)
    private String khnf;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 256)
    private String khzq;

    /** 关键业绩类初始得分 */
    @Column(name = "GJYJLCSDF", nullable = true, length = 14)
    private BigDecimal gjyjlcsdf;

    /** 关键业绩类最终得分 */
    @Column(name = "GJYJLZZDF", nullable = true, length = 14)
    private BigDecimal gjyjlzzdf;

    /** 部门最终考核得分 */
    @Column(name = "BMKHDF", nullable = true, length = 14)
    private BigDecimal bmkhdf;

    /** 等级名称 */
    @Column(name = "DJMC", nullable = true, length = 256)
    private String djmc;

    /** 预算人数 */
    @Column(name = "YSRS", nullable = true, length = 256)
    private String ysrs;

    /** 实际调整人数 */
    @Column(name = "SJTZRS", nullable = true, length = 256)
    private String sjtzrs;

    /** 剩余可调人数 */
    @Column(name = "SYKTRS", nullable = true, length = 256)
    private String syktrs;
    /**考核系数*/
    @Column(name = "KHXS", nullable = true, length = 256)
    private String khxs;
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