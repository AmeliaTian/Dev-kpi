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
 * @CreateDate 创建时间： 2019-04-04 10:40:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX18_SFMB_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx18SfmbInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 算法名称 */
    @Column(name = "SFMC", nullable = true, length = 200)
    private String sfmc;

    /** 算法标识 */
    @Column(name = "SFLX", nullable = true, length = 200)
    private String sflx;

    /** 算法 */
    @Column(name = "SF", nullable = true, length = 2000)
    private String sf;

    /** 有效标识 */
    @Column(name = "YXBS", nullable = true, length = 2)
    private String yxbs;

    /** 备注 */
    @Column(name = "BZ", nullable = true, length = 200)
    private String bz;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}