package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description AT04_图表配置 QSL查询
 * @CreateDate 创建时间： 2018-11-21 16:27:47
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAt04ChartCfgPO extends EntityPathBase<At04ChartCfgPO> {

    private static final long serialVersionUID = 1L;

    public static final QAt04ChartCfgPO at04ChartCfgPO = new QAt04ChartCfgPO("at04ChartCfgPO");

    /** ID */
    public final StringPath id = createString("id");

    /** 图表标题 */
    public final StringPath chartTitle = createString("chartTitle" );

    /** 图表OPTION */
    public final StringPath chartOption = createString("chartOption" );

    /** 图表描述 */
    public final StringPath chartDes = createString("chartDes" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QAt04ChartCfgPO(String variable) {
        super(At04ChartCfgPO.class, PathMetadataFactory.forVariable(variable));
    }

    public QAt04ChartCfgPO(Path<? extends At04ChartCfgPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAt04ChartCfgPO(PathMetadata metadata) {
        super(At04ChartCfgPO.class, metadata);
    }
}