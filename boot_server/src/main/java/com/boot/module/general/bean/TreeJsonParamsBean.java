package com.boot.module.general.bean;

import lombok.Data;

import java.util.List;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-09-14 14:09
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
public class TreeJsonParamsBean {
    private String nodeName;
    private String nodeId;
    private List<TreeJsonParamsBean> subNodeList;
}
