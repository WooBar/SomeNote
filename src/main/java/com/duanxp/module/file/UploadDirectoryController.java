package com.duanxp.module.file;

import com.duanxp.common.file.TestFileDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/10/29 0029
 */
@Controller
public class UploadDirectoryController {

    @RequestMapping("/upload/directory")
    public String getList(
                        @RequestParam("path") String path
                        ){

        List<TestFileDto> files = getFiles(path);
        for (TestFileDto file : files) {
            System.out.println("一级 名称-----------------------> "+file.getName());
            System.out.println("一级 路径-----------------------> "+file.getPath());
            for (TestFileDto testFileDto : file.getFileNameList()) {
                System.out.println("    二级 名称---------> "+testFileDto.getName());
                System.out.println("    二级 路径---------> "+testFileDto.getPath());
            }

        }

        return "upload";

    }

    @RequestMapping("/upload")
    public String add(){

       return "upload";
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
                    direct.setPath(files[i].getPath());
                    List<TestFileDto> files1 = getFiles(files[i].getPath());
                    direct.setFileNameList(files1);

                    filesName.add(direct);

                } else {
                    //如果是文件
                    System.out.println("文件名称：" + files[i].getName());

                    TestFileDto fileName = new TestFileDto();
                    String[] split = files[i].getName().split("\\.");
                    fileName.setName(split[0]);
                    fileName.setPath(files[i].getPath());
                    filesName.add(fileName);

                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
        }

        System.out.println("=================================================结束=================================");

        return filesName;
    }



    public static void copyFile3(String srcPath, String destPath) throws IOException {

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




}
