package com.boot.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 删除文件
 *
 */
@Slf4j
public class DeleteFileUtils {

    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                log.info("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                log.error("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            log.error("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    public static void main(String[] args) {
      // 删除单个文件
//      String file = "E:/TEMP/up/2.txt";
//        boolean b = DeleteFileUtils.deleteFile(file);
//        System.out.println(b);

    }

}
