package com.duanxp.common.file;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/10/29 0029
 */
public class Test {


    public static void main(String[] args) {


        String path = "E:\\";

//        List<TestFileDto> files = getFiles(path);
//        for (TestFileDto file : files) {
//            System.out.println("一级 -----------------------> " + file.getName());
//            for (TestFileDto testFileDto : file.getFileNameList()) {
//                System.out.println("    二级 ---------> " + testFileDto.getName());
//            }
//
//        }
//
//
//        String newpath = "E:\\testfile";

        getLevelOneFile(path);


    }

    public void test2() {


    }


    public void writerContent(String directory, String newFileName_dat, String s) {
        //本地创建目录并且将内容S写入文件内
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(directory, newFileName_dat);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file2);
            //向指定文件中写入内容
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(s.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<TestFileDto> getFiles(String path) {
        File file = new File(path);


        ArrayList<TestFileDto> filesName = new ArrayList<>();

        // 如果这个路径是文件夹
        if (file.isDirectory()) {

            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {

                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    //如果是文件夹
                    System.out.println("目录名称：" + files[i].getName());

                    TestFileDto direct = new TestFileDto();
                    direct.setName(files[i].getName());
                    List<TestFileDto> files1 = getFiles(files[i].getPath());
                    direct.setFileNameList(files1);

                    filesName.add(direct);

                } else {
                    //如果是文件
                    System.out.println("文件名称：" + files[i].getName());

                    TestFileDto fileName = new TestFileDto();
                    String[] split = files[i].getName().split("\\.");
                    fileName.setName(split[0]);
                    filesName.add(fileName);

                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
        }

        System.out.println("=================================================结束=================================");

        return filesName;
    }


    public static List<TestFileDto> getLevelOneFile(String path) {

        File file = new File(path);

        ArrayList<TestFileDto> filesName = new ArrayList<>();

        if (file.isDirectory()) {

            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {

                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {

                    System.out.println("文件夹的名称是：" + files[i].getName() + "  路径是 --------> " + files[i].getPath());
                    System.out.println("-----------------------------------------------------------------------------");

                    getLevelOneFile(files[i].getPath());

                } else {

                    System.out.println("文件的名称是：" + files[i].getName() + "  路径是 --------> " + files[i].getPath());

                }

            }

        }
        return null;
    }


    public static String[] fileType() {

        String[] filetype = {".JPG", ".jpg", ".png", ".docx", ".doc", ".mp4", ".mp3", ".xls", ".xlsx", ".pdf", ".gif", ".sql", ".xml", ".rar", ".LDM", ".txt"};

        return filetype;
    }

}




