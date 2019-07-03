package com.boot.repository.common;

import com.boot.utils.SnowflakeIdUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * @author h3dwy
 * @Description 自定义主键生成器, 当传入的实体有ID时，使用实体ID，不自动分配ID
 * @CreateDate 创建时间：2018-07-10 12:46
 * @ModifiedBy
 * @ModifiedDate
 */

public class IdGenerator extends UUIDGenerator {
    /**
     * 基于雪花算法生成惟一id
     */
    private SnowflakeIdUtils idGenerator = new SnowflakeIdUtils(0, 0);

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedImplementor, Object obj) throws HibernateException {
        Serializable id = sharedImplementor.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, sharedImplementor);
        //如果传入的ID为空，则使用传入ID，否则生成ID
        //原为long类型，转为36进制，缩短编码
        return (null == id) ? Long.toString(idGenerator.nextId(), 36).toUpperCase() : id;
    }
}
