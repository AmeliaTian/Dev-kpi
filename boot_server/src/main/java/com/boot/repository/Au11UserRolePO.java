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
 * @Description AU11_用户角色映射表
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AU11_USER_ROLE")
@EntityListeners(AuditingEntityListener.class)
public class Au11UserRolePO implements java.io.Serializable {

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
     * 用户ID
     */
    @Column(name = "USER_ID", nullable = true, length = 32)
    private String userId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID", nullable = true, length = 32)
    private String roleId;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;

}