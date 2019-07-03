package com.boot.repository;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description
 * @CreateDate 创建时间： 2018-11-21 16:27:47
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AT04_CHART_CFG")
@EntityListeners(AuditingEntityListener.class)
public class At04ChartCfgPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 图表标题 */
    @Column(name = "CHART_TITLE", nullable = true, length = 100)
    private String chartTitle;

    /** 图表OPTION */
    @Column(name = "CHART_OPTION", nullable = true, length = 4000)
    private String chartOption;

    /** 图表描述 */
    @Column(name = "CHART_DES", nullable = true, length = 500)
    private String chartDes;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}