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
 * @CreateDate 创建时间： 2019-05-31 18:09:39
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX07_XJKHCJHZ_RESULT")
@EntityListeners(AuditingEntityListener.class)
public class Jx07XjkhcjhzResultPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 256)
    private String khnf;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 256)
    private String khzq;

    /** 考核对象类别 */
    @Column(name = "KHDXLB", nullable = true, length = 256)
    private String khdxlb;

    /** 考核对象名称 */
    @Column(name = "KHDXMC", nullable = true, length = 256)
    private String khdxmc;

    /** 考核对象id */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 考核对象角色id */
    @Column(name = "KHDXJSID", nullable = true, length = 20)
    private String khdxjsid;

    /** 考核对象角色 */
    @Column(name = "KHDXJS", nullable = true, length = 200)
    private String khdxjs;

    /** 部门名称 */
    @Column(name = "BMMC", nullable = true, length = 256)
    private String bmmc;

    /** 考核得分 */
    @Column(name = "KHDF", nullable = true, length = 256)
    private String khdf;

    /** 考核系数 */
    @Column(name = "KHXS", nullable = true, length = 256)
    private String khxs;

    /** 考核等级 */
    @Column(name = "KHDJ", nullable = true, length = 256)
    private String khdj;

    /** 最终等级 */
    @Column(name = "ZZDJ", nullable = true, length = 256)
    private String zzdj;

    /** 考核等级调整人 */
    @Column(name = "KEDJTZR", nullable = true, length = 256)
    private String kedjtzr;

    /** 绩效积分 */
    @Column(name = "JXJF", nullable = true, length = 256)
    private String jxjf;

    /** 是否调薪 */
    @Column(name = "SFTX", nullable = true, length = 256)
    private String sftx;

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