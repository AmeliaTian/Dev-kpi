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
 * @CreateDate 创建时间： 2019-03-13 11:30:29
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX11_KHZQ_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx11KhzqInfoPO implements java.io.Serializable {

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

    /** 考核阶段编号 */
    @Column(name = "KHJDBH", nullable = true, length = 256)
    private String khjdbh;

    /** 考核阶段名称 */
    @Column(name = "KHJDMC", nullable = true, length = 256)
    private String khjdmc;

    /** 阶段预计开始时间 */
    @Column(name = "JDYJKSSJ", nullable = true, length = 12)
    private String jdyjkssj;

    /** 阶段实际开始时间 */
    @Column(name = "JDSJKSSJ", nullable = true, length = 12)
    private String jdsjkssj;

    /** 阶段预计结束时间 */
    @Column(name = "JDYJJSDJ", nullable = true, length = 12)
    private String jdyjjsdj;

    /** 阶段实际结束时间 */
    @Column(name = "JDSJJSSJ", nullable = true, length = 12)
    private String jdsjjssj;

    /** 阶段状态 点击按钮 前一个阶段结束 后一个阶段开始  0：未完成 ；1：进行中 ；2：已完成 */
    @Column(name = "JDZT", nullable = true, length = 2)
    private String jdzt;

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