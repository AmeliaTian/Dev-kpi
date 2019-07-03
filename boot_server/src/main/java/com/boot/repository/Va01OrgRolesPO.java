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
@Table(name = "VA01_ORG_ROLES")
@EntityListeners(AuditingEntityListener.class)
public class Va01OrgRolesPO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /**
     * 机构ID
     */
    @Column(name = "ORG_ID", nullable = false, length = 32)
    private String orgId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID", nullable = true, length = 32)
    private String roleId;

}