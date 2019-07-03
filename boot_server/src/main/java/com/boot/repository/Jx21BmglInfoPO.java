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
 * @CreateDate 创建时间： 2019-05-29 13:46:33
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX21_BMGL_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx21BmglInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核对象id （ 部门） */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 考核对象名称（部门） */
    @Column(name = "KHDXMC", nullable = true, length = 255)
    private String khdxmc;

    /** 关联部门id */
    @Column(name = "GLBMID", nullable = true, length = 20)
    private String glbmid;

    /** 关联部门名称 */
    @Column(name = "GLBMMC", nullable = true, length = 255)
    private String glbmmc;

    /** 权重 */
    @Column(name = "QZ", nullable = true, length = 255)
    private String qz;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 255)
    private String khnf;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 255)
    private String khzq;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 255)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 255)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}