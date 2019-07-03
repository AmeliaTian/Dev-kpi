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
 * @CreateDate 创建时间： 2019-04-04 10:38:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX03_YQDZB_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx03YqdzbInfoPO implements java.io.Serializable {

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

    /** 考核对象Id */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 考核对象 */
    @Column(name = "KHDX", nullable = true, length = 256)
    private String khdx;

    /** 指标大类 */
    @Column(name = "ZBDL", nullable = true, length = 50)
    private String zbdl;

    /** 指标定义 */
    @Column(name = "ZBDY", nullable = true, length = 1000)
    private String zbdy;

    /** 目标值 */
    @Column(name = "MBZ", nullable = true, length = 2000)
    private String mbz;

    /** 指标权重 */
    @Column(name = "QZ", nullable = true, length = 50)
    private String qz;

    /** 关联指标明细 */
    @Column(name = "GID", nullable = true, length = 64)
    private String gid;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 50)
    private String khzq;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 256)
    private String yxbs;

    /** 更新时间 */
    @Column(name = "UPDATETIME", nullable = true, length = 26)
    private Date updatetime;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 256)
    private String bz;

    /** 创建人 */
    @Column(name = "CREATE_USER", nullable = true, length = 50)
    private String createUser;

    /** 指标名称 */
    @Column(name = "ZBMC", nullable = true, length = 256)
    private String zbmc;

    /** 更新人 */
    @Column(name = "UPDATE_USER", nullable = true, length = 20)
    private String updateUser;

    /** 评分标准 */
    @Column(name = "PFBZ", nullable = true, length = 2000)
    private String pfbz;

    /** 退回原因 */
   /* @Column(name = "THYY", nullable = true, length = 2000)
    private String thyy;*/

    /** 退回人员id */
   /* @Column(name = "THUSERID", nullable = true, length = 20)
    private String thuserid;*/

    /** 退回人员名称 */
    /*@Column(name = "THUSER", nullable = true, length = 50)
    private String thuser;*/

    /** 算法模板id */
    /*@Column(name = "SFMBID", nullable = true, length = 20)
    private String sfmbid;*/
    /** 考核对象部门id */
    @Column(name = "KHDXBMID", nullable = true, length = 20)
    private String khdxbmid;

    /** 考核对象部门名称 */
    @Column(name = "KHDXBM", nullable = true, length = 20)
    private String khdxbm;

    /** 评分类型*/
    @Column(name = "PFLX", nullable = true, length = 50)
    private String pflx;
    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}