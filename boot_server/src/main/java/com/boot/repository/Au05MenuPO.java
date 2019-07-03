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
 * @CreateDate 创建时间： 2019-01-15 17:47:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AU05_MENU")
@EntityListeners(AuditingEntityListener.class)
public class Au05MenuPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GenericGenerator(name="idGenerator", strategy="com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** 父级ID */
    @Column(name = "PARENT_ID", nullable = true, length = 32)
    private String parentId;

    /** 菜单图标 */
    @Column(name = "MENU_ICON", nullable = true, length = 100)
    private String menuIcon;

    /** 菜单名称 */
    @Column(name = "MENU_NAME", nullable = true, length = 100)
    private String menuName;

    /** 菜单链接 */
    @Column(name = "MENU_URL", nullable = true, length = 100)
    private String menuUrl;


    /** 创建时间 */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}