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
 * @CreateDate 创建时间： 2019-04-09 15:30:22
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "JX02_ZBPFXZ_INFO")
@EntityListeners(AuditingEntityListener.class)
public class Jx02ZbpfxzInfoPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 指标ID 关联指标 */
    @Column(name = "ZBGID", nullable = true, length = 20)
    private String zbgid;

    /** 算法 */
    @Column(name = "SFID", nullable = true, length = 20)
    private String sfid;

    /** 明细编号 */
    @Column(name = "MXBH", nullable = true, length = 10)
    private String mxbh;

    /** 明细分值 */
    @Column(name = "MXFZ", nullable = true, length = 256)
    private String mxfz;

    /** 明细名称 */
    @Column(name = "MXMC", nullable = true, length = 256)
    private String mxmc;

    /** SFINFO */
    @Column(name = "SFINFO", nullable = true, length = 20)
    private String sfinfo;

    /** 算法变量分值  减加分 */
   /* @Column(name = "SFBLFZ", nullable = true, length = 22)
    private Double sfblfz;
*/
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