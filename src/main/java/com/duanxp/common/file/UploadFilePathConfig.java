//package com.duanxp.common.file;
//
///**
// * @ClassName: UploadFilePathConfig
// * @Description:
// * @Author duanxp
// * @Date 2019/11/29 15:32
// */
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
//  * 设置虚拟路径，访问绝对路径下资源
//  * @author Administrator
//  *
//  */
//@Configuration
//public class UploadFilePathConfig implements WebMvcConfigurer {
//
//    @Value("${file.staticAccessPath}")
//    private String staticAccessPath;
//
//    @Value("${file.uploadFolder}")
//    private String uploadFolder;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
//    }
//}
//
