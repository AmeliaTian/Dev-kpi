package com.boot.repository;

import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.*;
import javax.annotation.Generated;

/**
 * @Description JX14_YDZB_STATE QSL查询
 * @CreateDate 创建时间： 2019-04-04 10:38:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */

@Generated("com.querydsl.codegen.EntitySerializer")
public class QJx14YdzbStatePO extends EntityPathBase<Jx14YdzbStatePO> {

    private static final long serialVersionUID = 1L;

    public static final QJx14YdzbStatePO jx14YdzbStatePO = new QJx14YdzbStatePO("jx14YdzbStatePO");

    /** ID */
    public final StringPath id = createString("id");

    /** 考核年份 */
    public final StringPath khnf = createString("khnf" );

    /** 考核对象 */
    public final StringPath khdx = createString("khdx" );

    /** 考核对象ID */
    public final StringPath khdxid = createString("khdxid" );

    /** 状态 0：提交    1：一级审核    2：二级审核   3：一级退回 4：二级退回 */
    public final StringPath zt = createString("zt" );

    /** 有效标识 */
    public final StringPath yxbs = createString("yxbs" );

    /** 退回原因 */
    public final StringPath thyy = createString("thyy" );

    /** 退回人员id */
    public final StringPath thuserid = createString("thuserid" );

    /** 退回人名称 */
    public final StringPath thuser = createString("thuser" );


    /** 创建时间 */
    public final DateTimePath<java.util.Date> oprCrtTime = createDateTime("oprCrtTime",java.util.Date.class);

    public QJx14YdzbStatePO(String variable) {
        super(Jx14YdzbStatePO.class, PathMetadataFactory.forVariable(variable));
    }

    public QJx14YdzbStatePO(Path<? extends Jx14YdzbStatePO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJx14YdzbStatePO(PathMetadata metadata) {
        super(Jx14YdzbStatePO.class, metadata);
    }
}