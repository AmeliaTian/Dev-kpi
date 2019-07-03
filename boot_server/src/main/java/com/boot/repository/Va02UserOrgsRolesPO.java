package com.boot.repository;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-17 11:27:41
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@Table(name = "VA02_USER_ORGS_ROLES")
@EntityListeners(AuditingEntityListener.class)
public class Va02UserOrgsRolesPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID", nullable = false, length = 32)
    private String userId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID", nullable = true, length = 32)
    private String roleId;

    /**
     * 机构ID
     */
    @Column(name = "ORG_ID", nullable = true, length = 32)
    private String orgId;
}