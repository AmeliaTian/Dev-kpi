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
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AU04_PRIVILEGE")
@EntityListeners(AuditingEntityListener.class)
public class Au04PrivilegePO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.boot.repository.common.IdGenerator") //32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /**
     * 访问的链接和数据库资源
     */
    @Column(name = "PRIV_TYPE", nullable = true, length = 20)
    private String privType;

    /**
     * 资源路径
     */
    @Column(name = "PRIV_RESOURCE", nullable = true, length = 500)
    private String privResource;

    /**
     * 访问方式
     */
    @Column(name = "PRIV_METHOD", nullable = true, length = 10)
    private String privMethod;

    /**
     * 资源描述
     */
    @Column(name = "PRIV_DES", nullable = true, length = 10)
    private String privDes;

    /**
     * 分配角色
     */
    @Column(name = "PRIV_ROLES", nullable = true, length = 10)
    private String privRoles;

    //是否允许非登录访问
    @Column(name = "PRIV_UNLOGIN", nullable = true, length = 10)
    private String privUnlogin;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;

}