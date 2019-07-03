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
 * @Description AU01_系统用户表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AU01_USER")
@EntityListeners(AuditingEntityListener.class)
public class Au01UserPO implements java.io.Serializable {

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
     * 用户姓名
     */
    @Column(name = "USER_NAME_CN", nullable = true, length = 100)
    private String userNameCn;

    /**
     * 登录用户名
     */
    @Column(name = "USER_NAME", nullable = true, length = 20)
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "PASSWORD", nullable = true, length = 100)
    private String password;

    /**
     * 电话号码
     */
    @Column(name = "PHONE_NUMBER", nullable = true, length = 100)
    private String phoneNumber;

    /**
     * EMAIL
     */
    @Column(name = "EMAIL", nullable = true, length = 100)
    private String email;

    /**
     * 直接上级
     */
    @Column(name = "DIRECT_SUPERIOR", nullable = true, length = 50)
    private String directSuperior;

    /**
     * 用户访问Key
     */
    @Column(name = "USER_ASK_KEY", nullable = true, length = 100)
    private String userAskKey;

    /**
     * 扩展属性
     */
    @Column(name = "USER_EXTEND", nullable = true, length = 5)
    private String userExtend;

    /**
     * 帐号是否过期
     */
    @Column(name = "ACCOUNT_EXPIRED", nullable = true, length = 5)
    private String accountExpired;

    /**
     * 账号是否锁定
     */
    @Column(name = "ACCOUNT_LOCKED", nullable = true, length = 5)
    private String accountLocked;

    /**
     * 用户是否启用
     */
    @Column(name = "ACCOUNT_ENABLED", nullable = true, length = 5)
    private String accountEnabled;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;

}