package com.boot.module.sys;

import com.boot.utils.CommonUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-11-17 11:11
 * @ModifiedBy
 * @ModifiedDate
 */

public class ObjectNameTools {
    private static String voRegx = "VO";
    private static String poRegx = "PO";

    /**
     * 字段转换成对象属性 例如：user_name to userName
     *
     * @param dbName 表名称或字段名称
     * @return
     */
    public static String dbNameToObjName(String dbName, boolean capitalize) {
        if (null == dbName) {
            return "";
        }
        char[] chars = dbName.toLowerCase().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        //如果要求首字母大字则大写，否则小写
        return (capitalize ? StringUtils.capitalize(sb.toString()) : StringUtils.uncapitalize(sb.toString()));
    }

    /**
     * 类名转PO  false au01User-->au01UserPO
     * true  au01User-->Au01UserPO
     *
     * @param objName
     * @return
     */
    public static String objNameToPoName(String objName, boolean capitalize) {
        return (capitalize ? StringUtils.capitalize(objName) : StringUtils.uncapitalize(objName)) + poRegx;
    }

    /**
     * 类名转VO   au01User-->au01UserVO
     *
     * @param objName
     * @return
     */
    public static String objNameToVoName(String objName, boolean capitalize) {
        return (capitalize ? StringUtils.capitalize(objName) : StringUtils.uncapitalize(objName)) + voRegx;
    }

    /**
     * 数据库名转PO   AU01_USER-->au01UserPO
     *
     * @param dbName
     * @return
     */
    public static String dbNameToPoName(String dbName, boolean capitalize) {
        return dbNameToObjName(dbName, capitalize) + poRegx;
    }


    /**
     * 数据库名转VO   AU01_USER-->au01UserVO
     *
     * @param dbName
     * @return
     */
    public static String dbNameToVoName(String dbName, boolean capitalize) {
        return dbNameToObjName(dbName, capitalize) + voRegx;
    }

    /**
     * VO转PO   au01UserVO-->au01UserPO
     *
     * @param voName
     * @return
     */
    public static String voNameToPoName(String voName) {
        return CommonUtils.replaceLast(voName, voRegx, poRegx);
    }

    /**
     * PO转VO   au01UserPO-->au01UserVO
     *
     * @param poName
     * @return
     */
    public static String poNameToVoName(String poName) {
        return CommonUtils.replaceLast(poName, poRegx, voRegx);
    }

    public static void main(String[] args) {
        System.out.println(dbNameToObjName("AU01_USER", false));
        System.out.println(dbNameToObjName("AU01_USER", true));
        System.out.println(objNameToPoName("au01User", false));
        System.out.println(objNameToPoName("au01User", true));
        System.out.println(objNameToVoName("au01User", false));
        System.out.println(objNameToVoName("au01User", true));
        System.out.println(dbNameToPoName("AU01_USER", false));
        System.out.println(dbNameToPoName("AU01_USER", true));
        System.out.println(dbNameToVoName("AU01_USER", false));
        System.out.println(dbNameToVoName("AU01_USER", true));
        System.out.println(voNameToPoName("au01UserVO"));
        System.out.println(voNameToPoName("Au01UserVO"));
        System.out.println(poNameToVoName("au01UserPO"));
        System.out.println(poNameToVoName("Au01UserPO"));
        System.out.println(poNameToVoName("Au01User"));
    }
}
