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
 * @CreateDate 创建时间： 2019-03-25 15:53:17
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX01_ZBK_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx01ZbkInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 指标类别 */
    @Column(name = "ZBLB", nullable = true, length = 256)
    private String zblb;

    /** 指标所属部门 */
    @Column(name = "ZBLSBM", nullable = true, length = 256)
    private String zblsbm;

    /** 所属大类 */
    @Column(name = "SSDL", nullable = true, length = 256)
    private String ssdl;

    /** 指标类型 */
    @Column(name = "ZBLX", nullable = true, length = 256)
    private String zblx;

    /** 指标序号 */
    @Column(name = "ZBXH", nullable = true, length = 10)
    private Integer zbxh;

    /** 指标名称 */
    @Column(name = "ZBMC", nullable = true, length = 256)
    private String zbmc;

    /** 指标定义 */
    @Column(name = "ZBDY", nullable = true, length = 2000)
    private String zbdy;

    /** 目标值 */
    @Column(name = "MBZ", nullable = true, length = 256)
    private String mbz;

    /** 权重 */
    @Column(name = "QZ", nullable = true, length = 256)
    private String qz;

    /** 评分标准 */
    @Column(name = "PFBZ", nullable = true, length = 256)
    private String pfbz;

    /** 数据来源 */
    @Column(name = "SJLY", nullable = true, length = 256)
    private String sjly;

    /** 指标展现类型 */
    @Column(name = "ZBZXLX", nullable = true, length = 256)
    private String zbzxlx;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 256)
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


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}