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
 * @CreateDate 创建时间： 2019-06-18 17:10:28
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX22_USER_FILE")
@EntityListeners(AuditingEntityListener.class)
public class Jx22UserFilePO implements java.io.Serializable {

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
    @Column(name = "KHZQ", nullable = true, length = 50)
    private String khzq;

    /** 考核对象 */
    @Column(name = "KHDX", nullable = true, length = 50)
    private String khdx;

    /** 考核对象ID */
    @Column(name = "KHDXID", nullable = true, length = 50)
    private String khdxid;

    /** 所属部门 */
    @Column(name = "SSBM", nullable = true, length = 50)
    private String ssbm;

    /** 所属部门ID */
    @Column(name = "SSBMID", nullable = true, length = 50)
    private String ssbmid;

    /** 文件名 */
    @Column(name = "FJMC", nullable = true, length = 2000)
    private String fjmc;

    /** 文件地址 */
    @Column(name = "FJPATH", nullable = true, length = 2000)
    private String fjpath;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 2000)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 2000)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}