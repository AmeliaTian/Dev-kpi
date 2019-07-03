package com.boot.module.datatables;

import java.util.List;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-08-06 17:17
 * @ModifiedBy
 * @ModifiedDate
 */

public class DataTablesOutBean {
    /**
     * 数据
     */
    private List aaData;
    /**
     * 得到的记录数
     */
    private int iTotalDisplayRecords;
    /**
     * 数据库中记录数
     */
    private int iTotalRecords;
    /**
     * 请求服务器端次数
     */
    private int sEcho;

    public List getAaData() {
        return aaData;
    }

    public void setAaData(List aaData) {
        this.aaData = aaData;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getsEcho() {
        return sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }
}
