package com.boot.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author h3dwy
 * @CreateDate 创建时间：2017-03-24 17:17
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
public class CommonUtils {
     /**
     * 获取文件后缀名
     *
     * @param filename
     * @return
     */
    public static String getFileSuffixName(String filename) {
        String retStr = "";
        if (StringUtils.isNotEmpty(filename)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                retStr = filename.substring(dot + 1);
            }
        }
        return retStr;
    }

    /**
     * 获取字符串的MD5值，为尽量简短，采用36进制返回
     *
     * @param inStr
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5StrShort(String inStr) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(inStr.getBytes("UTF-8"));
            return new BigInteger(1, md.digest()).toString(36);
        } catch (Exception e) {
            log.error("", e);
            return inStr;
        }
    }

    /**
     * 获取字符串的MD5值，16进制返回
     *
     * @param inStr
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5Str(String inStr) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(inStr.getBytes("UTF-8"));
            return bytesToHex(md.digest());
        } catch (Exception e) {
            return inStr;
        }
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (byte aByte : bytes) {
            num = aByte;
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString();
    }

    /**
     * 判断一个列表中是否包含了另一列表中的任意元素
     *
     * @param orgColl
     * @param ckColl  此列表中的任意元素在orgColl中存储，则返回true
     * @return
     */
    public static boolean groupContains(Collection<?> orgColl, Collection<?> ckColl) {
        for (Object o : ckColl) {
            if (orgColl.contains(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将byte[]转为各种进制的字符串
     *
     * @param bytes byte[]
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String toBinaryString(byte[] bytes, int radix) {
        // 这里的1代表正数
        return null == bytes ? "" : new BigInteger(1, bytes).toString(radix);
    }

    /**
     * 删除Html标签
     *
     * @param inputString
     * @return
     */
    public static String removeHtmlTag(String inputString) {
        if (inputString == null) {
            return null;
        }
        // 含html标签的字符串
        String htmlStr = inputString;
        String textStr = "";
        try {
            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regExscript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regExstyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            // 定义HTML标签的正则表达式
            String regExhtml = "<[^>]+>";
            // 定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            String regExspecial = "\\&[a-zA-Z]{1,10};";
            Pattern pscript = Pattern.compile(regExscript, Pattern.CASE_INSENSITIVE);
            Matcher mscript = pscript.matcher(htmlStr);

            // 过滤script标签
            htmlStr = mscript.replaceAll("");
            Pattern pstyle = Pattern.compile(regExstyle, Pattern.CASE_INSENSITIVE);
            Matcher mstyle = pstyle.matcher(htmlStr);

            // 过滤style标签
            htmlStr = mstyle.replaceAll("");
            Pattern phtml = Pattern.compile(regExhtml, Pattern.CASE_INSENSITIVE);
            Matcher mhtml = phtml.matcher(htmlStr);

            // 过滤html标签
            htmlStr = mhtml.replaceAll("");
            Pattern pspecial = Pattern.compile(regExspecial, Pattern.CASE_INSENSITIVE);
            Matcher mspecial = pspecial.matcher(htmlStr);

            // 过滤特殊标签
            htmlStr = mspecial.replaceAll("");
            textStr = htmlStr;
        } catch (Exception e) {
            log.error("", e);
        }
        // 返回文本字符串
        return textStr;
    }

    /**
     * 去除空白字符
     *
     * @param str
     * @return
     */
    private static Pattern regxMatcher = Pattern.compile("\\s+|\t|\r|\n");

    public static String removeBlank(String str) {
        String dest = "";
        if (str != null) {
            Matcher m = regxMatcher.matcher(str);
            dest = m.replaceAll(" ");
        }
        return dest;
    }

    /**
     * 替换最后一次出现的字符
     * @param text
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }
}
