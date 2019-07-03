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
 * @CreateDate 创建时间： 2019-04-04 10:38:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX14_YDZB_STATE")
@EntityListeners(AuditingEntityListener.class)
public class Jx14YdzbStatePO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 50)
    private String khnf;

    /** 考核对象 */
    @Column(name = "KHDX", nullable = true, length = 50)
    private String khdx;

    /** 考核对象ID */
    @Column(name = "KHDXID", nullable = true, length = 20)
    private String khdxid;

    /** 状态 0：提交    1：一级审核    2：二级审核   3：一级退回 4：二级退回 */
    @Column(name = "ZT", nullable = true, length = 4)
    private String zt;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 200)
    private String yxbs;

    /** 退回原因 */
    @Column(name = "THYY", nullable = true, length = 2000)
    private String thyy;

    /** 退回人员id */
    @Column(name = "THUSERID", nullable = true, length = 20)
    private String thuserid;

    /** 退回人名称 */
    @Column(name = "THUSER", nullable = true, length = 200)
    private String thuser;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}