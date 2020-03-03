package com.duanxp.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Version
 * @Author dxp
 * @Date 2019/10/29
 */
public class Lianxi {

    /**
     * @param args
     * 练习题： 将一张图片拷贝到另外一个地方。
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String str1 = "F:\\2.13升级\\厂家主页--图\\礼品直供2.png";
        String str2 = "E:\\testfile\\1" ;
        String s3 = "测试1.jpg";

        copyFile3(str1, str2,s3);

    }
    // 方法一
    public static void copyFile1(String srcPath, String destPath) throws IOException {
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);

        // 读取和写入信息
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关

    }
    // 方法二
    public static void copyFile2(String srcPath, String destPath) throws IOException {

        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);

        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关

    }



    // 方法三
    public static void copyFile3(String srcPath, String destPath) throws IOException {

        File file = new File(destPath);
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }

        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);



        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关

    }

    public static void copyFile3(String srcPath, String destPath, String filename) throws IOException {

        File file = new File(destPath);
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }

        String newfile = destPath + "\\"+""+filename;

        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(newfile);



        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关

    }

}

