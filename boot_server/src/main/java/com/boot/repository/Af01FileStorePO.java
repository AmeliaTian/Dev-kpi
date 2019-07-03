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
 * @Description AF01_文件存储
 * @CreateDate 创建时间：2018-07-16 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "AF01_FILE_STORE")
@EntityListeners(AuditingEntityListener.class)
public class Af01FileStorePO implements java.io.Serializable {

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
     * 文件名称
     */
    @Column(name = "FILE_NAME", nullable = true, length = 100)
    private String fileName;

    /**
     * 文件存储ID
     */
    @Column(name = "FILE_UUID", nullable = true, length = 100)
    private String fileUuid;

    /**
     * 文件描述
     */
    @Column(name = "FILE_DESC", nullable = true, length = 500)
    private String fileDesc;

    /**
     * 文件类型
     */
    @Column(name = "FILE_TYPE", nullable = true, length = 100)
    private String fileType;

    /**
     * 文件大小(字节)
     */
    @Column(name = "FILE_SIZE", nullable = true, length = 10)
    private Integer fileSize;


    /**
     * 文件后缀名
     */
    @Column(name = "FILE_SUFFIX", nullable = true, length = 10)
    private String fileSuffix;

    /**
     * 上传人
     */
    @Column(name = "FILE_UPLOAD_PERSON", nullable = true, length = 20)
    private String fileUploadPerson;

    /**
     * 创建时间
     */
    @Column(name = "OPR_CRT_TIME", nullable = true, length = 19)
    @CreatedDate
    private Date oprCrtTime;
}