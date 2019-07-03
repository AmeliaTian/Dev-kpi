package com.boot.constant;

import org.springframework.stereotype.Component;

/**
 * 类说明
 *
 * @author h3dwy
 * @CreateDate 创建时间：2016-12-14 上午10:38:48
 * @Describe 常用变量
 * @ModifiedBy
 * @ModifiedDate
 */

@Component
public class WebConstants {
    /**
     * 登录后，选择remember me后，cookie保存的时限
     */
    public static final int WEB_REMEMBER_ME_DAY_NUM = 7;
    /**
     * 表示YES的字符串
     */
    public static final String IS_YES_STR = "Y";
    /**
     * 表示NO的字符串
     */
    public static final String IS_NO_STR = "N";

    /**
     * 允许访问的域名
     */
    public static final String ALLOW_ORIGIN = "*";

    /**
     * 允许访问的方法，逗号分隔
     */
    public static final String HTTP_ALLOW_METHODS = "*";

    /**
     * COOKIE的加密KEY,可为任意字符
     */
    public static final String COOKIE_CIPHER_KEY = "cookiekey";

    /**
     * 上传文件存储的位置
     */
    //public static final String FILE_UPLOAD_STORE_PATH = "/data/file/";
    public static final String FILE_UPLOAD_STORE_PATH = "F://";
    /**
     * 允许所有角色访问时的角色名称定义
     */
    public static final String ALLOW_ALL_ROLES_INVOKE_NAME = "ROLE_ANY";

    /**
     * 允许未登录角色访问的名称定义
     */
    public static final String ALLOW_UNLOGIN_USERS_INVOKE_NAME = "LOGIN_ANY";

    /**
     * 向前台返回通用json消息，用于表示消息状态
     * SUCCESS 返回正确信息，如提交成功等
     * ERROR 报错信息
     * INFO 普通信息
     */
    public enum RET_MSG_STATE_ENUM {
        //成功
        SUCCESS,
        //错误
        ERROR,
        //信息
        INFO
    }

    /**
     * 向前台返回通用json消息，用于表示消息类型
     * STR 字符串
     * OBJ 对象
     * ARR 对象数组
     */
    public enum RET_MSG_TYPE_ENUM {
        //字符串
        STR,
        //对象
        OBJ,
        //对象列表
        ARR
    }
}
