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
 * @CreateDate 创建时间： 2019-05-29 13:47:02
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX17_ZBDL_RESULT")
@EntityListeners(AuditingEntityListener.class)
public class Jx17ZbdlResultPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核对象ID */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 考核对象名称 */
    @Column(name = "KHDXMC", nullable = true, length = 256)
    private String khdxmc;

    /** 考核对象角色id */
    @Column(name = "KHDXJSID", nullable = true, length = 20)
    private String khdxjsid;

    /** 指标大类   业绩类 态度类 胜任力 */
    @Column(name = "ZBDL", nullable = true, length = 256)
    private String zbdl;

    /** 指标大类权重 */
    @Column(name = "ZBDLQZ", nullable = true, length = 256)
    private String zbdlqz;

    /** 考核得分 */
    @Column(name = "DF", nullable = true, length = 256)
    private String df;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 256)
    private String khnf;

    /** 考核周期 */
    @Column(name = "KHZQ", nullable = true, length = 256)
    private String khzq;

    /** 更新时间 */
    @Column(name = "UPDATETIME", nullable = true, length = 26)
    private Date updatetime;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 2000)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 256)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}