package com.boot.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author h3dwy
 * 自定义异常类
 * @CreateDate 创建时间：2017-03-21 15:05
 * @ModifiedBy
 * @ModifiedDate
 */

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class SysCustomException extends Exception {

    /**
     * 异常标题
     */
    private String expTitle;

    /**
     * 异常对应的描述信息
     */
    private String expMessage;

    public SysCustomException(String expTitle) {
        super();
        this.expTitle = expTitle;
        this.expMessage = "";
    }

    public SysCustomException(String expTitle, String expMessage) {
        super();
        this.expTitle = expTitle;
        this.expMessage = expMessage;
    }

    @Override
    public String toString() {
        return expTitle + ": " + expMessage;
    }
}
