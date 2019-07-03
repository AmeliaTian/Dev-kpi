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
 * @CreateDate 创建时间： 2019-02-14 16:12:35
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX15_SPECIAL_USER_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx15SpecialUserInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 用户id */
    @Column(name = "USER_ID", nullable = true, length = 20)
    private String userId;

    /** 特殊人员名称 */
    @Column(name = "USER_NAME", nullable = true, length = 50)
    private String userName;

    /** 考核年份 */
    @Column(name = "KHNF", nullable = true, length = 4)
    private String khnf;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 50)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 200)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}