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
 * @CreateDate 创建时间： 2019-05-30 14:55:19
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX13_KHDJGJ_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx13KhdjgjInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核年份 */
   /* @Column(name = "KHNF", nullable = true, length = 4)
    private String khnf;

    *//** KHZQ *//*
    @Column(name = "KHZQ", nullable = true, length = 256)
    private String khzq;*/

    /** 考核等级 */
    @Column(name = "KHDJ", nullable = true, length = 256)
    private String khdj;

    /** 绩效积分 */
    @Column(name = "JXJF", nullable = true, length = 256)
    private String jxjf;

    /** 部门考核得分最低值 */
    @Column(name = "MINBMDF", nullable = true, length = 256)
    private String minbmdf;

    /** 部门考核得分最高值 */
    @Column(name = "MAXBMDF", nullable = true, length = 256)
    private String maxbmdf;

    /** 绩效系数 */
    @Column(name = "JXXS", nullable = true, length = 256)
    private String jxxs;

    /** 等级人数所占百分比 */
    @Column(name = "DJRSBFB", nullable = true, length = 256)
    private String djrsbfb;

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