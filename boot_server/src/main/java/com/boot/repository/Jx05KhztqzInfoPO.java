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
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX05_KHZTQZ_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx05KhztqzInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** KHDXJSID */
    @Column(name = "KHDXJSID", nullable = true, length = 20)
    private String khdxjsid;

    /** 考核对象角色 */
    @Column(name = "KHDXJS", nullable = true, length = 256)
    private String khdxjs;

    /** 指标大类 */
    @Column(name = "ZBDL", nullable = true, length = 256)
    private String zbdl;

    /** 指标类型 */
    /*@Column(name = "ZBLX", nullable = true, length = 256)
    private String zblx;*/

    /** KHZTJSID */
    @Column(name = "KHZTJSID", nullable = true, length = 20)
    private String khztjsid;

    /** 考核主体角色 */
    @Column(name = "KHZTJS", nullable = true, length = 256)
    private String khztjs;

    /** 权重 */
    @Column(name = "QZ", nullable = true, length = 256)
    private String qz;

    /** 考核年份 */
    /*@Column(name = "KHNF", nullable = true, length = 256)
    private String khnf;*/

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