//package com.duanxp.common.upload;
//
//
//import com.drew.imaging.jpeg.JpegMetadataReader;
//import com.drew.imaging.jpeg.JpegProcessingException;
//import com.drew.metadata.Directory;
//import com.drew.metadata.Metadata;
//import com.drew.metadata.MetadataException;
//import com.drew.metadata.exif.ExifIFD0Directory;
//import com.duanxp.common.constant.SZConstant;
//import com.duanxp.module.time.DateUtils;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.Base64Utils;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
///**
// * 文件上传工具类
// *
// * @author yulekuan
// *
// */
//public class FileUploadUtil {
//
//	/**
//	 * logger
//	 */
//	private static Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
//
//	/**
//	 * 获取文件上传参数
//	 *
//	 * @param fileType
//	 * @return
//	 */
//	public static FileUploadConfig getSysFileUploadConfig(FileType fileType) {
//		logger.debug("Get File Upload Config ---> begin: ");
//
//		FileUploadConfig fileUploadConfig = new FileUploadConfig();
//		switch (fileType) {
//		case IMG:
//			fileUploadConfig.setUploadPath(FilePathConstant.IMG_UPLOAD_PATH);
//			fileUploadConfig.setRequestPath(FilePathConstant.IMG_REQUEST_PATH);
//			return fileUploadConfig;
////		case APK:
////			fileUploadConfig.setUploadPath(SysConfigUtil.getSysConfig(SysConfigConstant.apkUploadPath));
////			fileUploadConfig.setRequestPath(SysConfigUtils.getSysConfig(SysConfigConstant.apkRequestURl));
////			return fileUploadConfig;
//		case AVATAR:
//			fileUploadConfig.setUploadPath(FilePathConstant.AVATAR_UPLOAD_PATH);
//			fileUploadConfig.setRequestPath(FilePathConstant.AVATAR_REQEUET_PATH);
//			return fileUploadConfig;
////		case IDCARD:
////			fileUploadConfig.setUploadPath(SysConfigUtils.getSysConfig(SysConfigConstant.idcardUploadPath));
////			fileUploadConfig.setRequestPath(SysConfigUtils.getSysConfig(SysConfigConstant.idcardRequestUrl));
////			return fileUploadConfig;
////		case CHARTER:
////			fileUploadConfig.setUploadPath(SysConfigUtils.getSysConfig(SysConfigConstant.charterUploadPath));
////			fileUploadConfig.setRequestPath(SysConfigUtils.getSysConfig(SysConfigConstant.charterRequestUrl));
////			return fileUploadConfig;
//		default:
//			return fileUploadConfig;
//		}
//	}
//
//	/**
//	 * 上传流文件至阿里云
//	 *
//	 * @param file
//	 * @return
//	 * @throws IOException
//	 */
////	public static String uploadFile(MultipartFile file) throws IOException {
////		// return alyUploadStreamfile(file.getInputStream());
////		//return alyUploadStreamfile(file);
////		// 测试环境
////		if (StringUtils.equals(SZConstant.DISABLE, SysConfigUtils.getSysConfig(SysConfigConstant.isTest))) {
////			return uploadFile(file, FileType.IMG);
////		}
////		// 生产环境
////		return uploadImgs(file);
////	}
//
//	/**
//	 * 上传单文件
//	 *
//	 * @param file
//	 * @param fileType
//	 * @return
//	 * @throws IllegalStateException
//	 * @throws IOException
//	 */
//	public static String uploadFile(MultipartFile file, FileType fileType) throws IllegalStateException, IOException {
//		logger.debug("Upload file ---> 开始：");
//		FileUploadConfig config = getSysFileUploadConfig(fileType);
//
//		// 获取上传文件的原名
//		String oldFileName = file.getOriginalFilename();
//		logger.debug("Upload file ---> oldFileName: " + oldFileName);
//
//		// 上传文件
//		if (file != null && oldFileName != null && oldFileName.length() > 0) {
//			// 按照日期 生成文件夹
//			String dirName = DateUtils.getCurrentDateStr(DateUtils.YYYYMMDD) + "/";
//			// 文件保存目录地址
//			String dirPath = config.getUploadPath() + dirName;
//			// 若当前日志目录不存在 则新建
//			File dirFile = new File(dirPath);
//			if (!dirFile.exists()) {
//				dirFile.mkdirs();
//			}
//			logger.debug("Upload file ---> DirPath: " + dirPath);
//
//			// 文件访问地址
//			String fileRequestPath = config.getRequestPath() + dirName;
//			// 新的文件名称
//			String newFileName = DateUtils.getCurrentDateStr(DateUtils.YYYYMMDDHHMMSS)
//					+ String.valueOf(Math.round(Math.random() * 1000000))
//					+ oldFileName.substring(oldFileName.lastIndexOf("."));
//			logger.debug("Upload file ---> newFileName: " + newFileName);
//
//			// 获取图片正确显示需要旋转的角度（顺时针）
//			int rotateAngleForPhoto = getRotateAngleForPhoto(dirPath + newFileName);
//			//  旋转手机照片
//			String rotatePhonePhoto = rotatePhonePhoto(dirPath + newFileName, rotateAngleForPhoto);
//			// 新文件
//			File newFile = new File(rotatePhonePhoto);
//			//File newFile = new File(dirPath + newFileName);
//			// 将内存中的数据写入磁盘
//			file.transferTo(newFile);
//			logger.debug("Upload file ---> imgRequestPath: " + fileRequestPath + newFileName);
//			return fileRequestPath + newFileName;
//		} else {
//			logger.debug("Upload file ---> error: 文件错误");
//			return ResultMessage.FILE_ERROR.getMessage();
//		}
//	}
//
//	/**
//	 * base64格式单文件上传
//	 *
//	 * @param base64Data
//	 * @param fileType
//	 * @return
//	 * @throws IOException
//	 */
//	public static String uploadBase64(String base64Data, FileType fileType) throws IOException {
//		logger.debug("Upload base64 File ---> 开始");
//
//		// 获取文件上传参数
//		FileUploadConfig uploadConfig = getSysFileUploadConfig(fileType);
//		try {
//			String dataPrix = "";
//			String data = "";
//			if (base64Data == null || "".equals(base64Data)) {
//				throw new Exception("上传失败，上传图片数据为空");
//			} else {
//				String[] d = base64Data.split("base64,");
//				if (d != null && d.length == 2) {
//					dataPrix = d[0];
//					data = d[1];
//				} else {
//					throw new Exception("上传失败，数据不合法");
//				}
//			}
//			String suffix = "";
//			if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
//				suffix = ".jpg";
//			} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {// data:image/x-icon;base64,base64编码的icon图片数据
//				suffix = ".ico";
//			} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {// data:image/gif;base64,base64编码的gif图片数据
//				suffix = ".gif";
//			} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {// data:image/png;base64,base64编码的png图片数据
//				suffix = ".png";
//			} else {
//				throw new Exception("上传图片格式不合法");
//			}
//
//			// 按照日期 生成文件夹
//			String dirName = DateUtils.getCurrentDateStr(DateUtils.YYYYMMDD) + "/";
//			// 文件保存目录地址
//			String dirPath = uploadConfig.getUploadPath() + dirName;
//			File dirFile = new File(dirPath);
//			if (!dirFile.exists()) {
//				dirFile.mkdirs();
//			}
//
//			String fileName = DateUtils.getCurrentDateStr(DateUtils.YYYYMMDDHHMMSS)
//					+ String.valueOf(Math.round(Math.random() * 1000000)) + suffix;
//			logger.debug("Upload base64 File ---> fileName: " + fileName);
//
//			// 文件存储目录
//			String uploadPath = dirPath + "/" + fileName;
//			logger.debug("Upload base64 File ---> uploadPath: " + uploadPath);
//
//			// 文件访问地址
//			String requestPath = uploadConfig.getRequestPath() + dirName;
//			logger.debug("Upload base64 File ---> requestPath: " + requestPath);
//
//			// 因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
//			byte[] bs = Base64Utils.decodeFromString(data);
//			try {
//				// 使用apache提供的工具类操作流
//				FileUtils.writeByteArrayToFile(new File(dirPath, fileName), bs);
//			} catch (Exception ee) {
//				logger.debug("上传失败，写入文件失败");
//				ee.printStackTrace();
//				return null;
//			}
//			return requestPath + fileName;
//		} catch (Exception e) {
//			logger.debug("上传失败");
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static String uploadBase64(String base64Data) throws Exception {
//		// 测试环境
//		if (StringUtils.equals(SZConstant.DISABLE, "1")) {
//			return uploadBase64(base64Data, FileType.IMG);
//		}
//
//		// 生产环境
//		String dataPrix = "";
//		String data = "";
//		if (base64Data == null || "".equals(base64Data)) {
//			throw new Exception("上传失败，上传图片数据为空");
//		} else {
//			String[] d = base64Data.split("base64,");
//			if (d != null && d.length == 2) {
//				dataPrix = d[0];
//				data = d[1];
//			} else {
//				throw new Exception("上传失败，数据不合法");
//			}
//		}
//		if (!"data:image/jpeg;".equalsIgnoreCase(dataPrix) && !"data:image/x-icon;".equalsIgnoreCase(dataPrix)
//				&& !"data:image/gif;".equalsIgnoreCase(dataPrix) && !"data:image/png;".equalsIgnoreCase(dataPrix)) {
//			throw new Exception("上传图片格式不合法");
//		}
//
//		// 因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
//		byte[] bytes = Base64Utils.decodeFromString(data);
//		InputStream fileStream;
//		fileStream = new ByteArrayInputStream(bytes);
//
//
//		// 上传至阿里云
////		String imageUrl = alyUploadStreamfile(fileStream);
//		return null;
//	}
//
////	public static String alyUploadStreamfile(InputStream fileStream) throws IOException {
////		logger.debug("Aly Upload Stream File --> 开始：");
////
////		// 1.流文件为空，则返回空字符串
////		if (fileStream == null) {
////			logger.debug("before ...");
////			return "";
////		}
////		logger.debug("after ...");
////		// 2.获取alAccessKeyId
////		String accessKeyId = SysConfigUtils.getSysConfig(SysConfigConstant.alAccessKeyId);
////
////		// 3.获取accessKeySecret
////		String accessKeySecret = SysConfigUtils.getSysConfig(SysConfigConstant.alAccessKeySecret);
////
////		// 3.调用阿里云上传工具类
////		UploadImageRequest request = new UploadImageRequest(accessKeyId, accessKeySecret, "default");
////		request.setStorageLocation(SysConfigUtils.getSysConfig(SysConfigConstant.alStorageLocation));
////		request.setInputStream(fileStream);
////
////		// 4.开始上传图片
////		UploadImageImpl uploadImage = new UploadImageImpl();
////		UploadImageResponse response = uploadImage.upload(request);
////		logger.debug("[RequestId = " + response.getRequestId() + "], [ImageId = " + response.getImageId()
////				+ "], [ImageURL = " + response.getImageURL() + "], [ErrorCode = " + response.getCode()
////				+ "], [ErrorMessage --> " + response.getMessage() + "]");
////		return response.getImageURL();
////	}
////
////	public static String alyUploadStreamfile(MultipartFile file) {
////		logger.debug("Aly Upload Stream File --> 开始：");
////		String imageURL = "";
////		try {
////			// 1.流文件为空，则返回空字符串
////			if (file == null) {
////				return "";
////			}
////
////			// 2.获取alAccessKeyId
////			String accessKeyId = SysConfigUtils.getSysConfig(SysConfigConstant.alAccessKeyId);
////
////			// 3.获取accessKeySecret
////			String accessKeySecret = SysConfigUtils.getSysConfig(SysConfigConstant.alAccessKeySecret);
////
////			// 3.调用阿里云上传工具类
////			UploadImageRequest request = new UploadImageRequest(accessKeyId, accessKeySecret, "default");
////			request.setStorageLocation(SysConfigUtils.getSysConfig(SysConfigConstant.alStorageLocation));
////			request.setFileName(file.getName());
////			request.setInputStream(file.getInputStream());
////
////			// 4.开始上传图片
////			UploadImageImpl uploadImage = new UploadImageImpl();
////			UploadImageResponse response = uploadImage.upload(request);
////			logger.debug("[RequestId = " + response.getRequestId() + "], [ImageId = " + response.getImageId()
////					+ "], [ImageURL = " + response.getImageURL() + "], [ErrorCode = " + response.getCode()
////					+ "], [ErrorMessage --> " + response.getMessage() + "]");
////			imageURL = response.getImageURL();
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return imageURL;
////	}
////
////	/* 获取图片上传地址和凭证函数 */
////	public static CreateUploadImageResponse createUploadImage(DefaultAcsClient client, MultipartFile file)
////			throws Exception {
////		CreateUploadImageRequest request = new CreateUploadImageRequest();
////		request.setImageType("default");
////		request.setImageExt("jpg");
////		request.setOriginalFileName(file.getOriginalFilename());
////		return client.getAcsResponse(request);
////	}
////
////	public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
////		// 点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
////		String regionId = "cn-shanghai";
////		DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
////		DefaultAcsClient client = new DefaultAcsClient(profile);
////		return client;
////	}
//
////	public static String uploadImgs(MultipartFile imgFile) {
////		logger.debug("Upload Img To Aly --> begin: ");
////
////		logger.debug("Img File Size ---> " + imgFile.getSize());
////		/******
////		 * 1.若图片大小大于512KB，则进行压缩
////		 * 2.若图片大小小于512KB，则不进行压缩
////		******/
////		// 文件流
////		InputStream fileStream = null;
////		if (imgFile.getSize()/1024 > 512) {
////			String uploadConfig = FilePathConstant.IMG_UPLOAD_PATH ;
//////			SysConfigUtils.getSysConfig(SysConfigConstant.imgUploadPath);
////
////			// 按照日期 生成文件夹
////			String dirName = DateUtils.getCurrentDateStr(DateUtils.YYYYMMDD) + "/";
////			// 文件保存目录地址
////			String dirPath = uploadConfig + dirName;
////			// 若当前目录不存在 则新建
////			File dirFile = new File(dirPath);
////			if (!dirFile.exists()) {
////				dirFile.mkdirs();
////			}
////
////			String newFileName = DateUtils.getCurrentDateStr(DateUtils.YYYYMMDDHHMMSS)
////					+ String.valueOf(Math.round(Math.random() * 1000000))
////					+ imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
////			try {
////				Image src = ImageIO.read(imgFile.getInputStream());
////		        int srcWidth = src.getWidth(null);
////		        int srcHeight = src.getHeight(null);
////		        double comBase = 0;
////		        if (srcWidth > srcHeight) {
////		        	comBase = srcWidth;
////		        } else {
////		        	comBase = srcHeight;
////		        }
////		        //logger.debug("srcWidth -> " + srcWidth);
////		        //logger.debug("srcHeight -> " + srcHeight);
////				ImageCompressUtil.saveMinPhoto(imgFile, dirPath + newFileName, comBase, 1);
////				// 获取图片正确显示需要旋转的角度（顺时针）
////				int rotateAngleForPhoto = getRotateAngleForPhoto(dirPath + newFileName);
////				//  旋转手机照片
////				String rotatePhonePhoto = rotatePhonePhoto(dirPath + newFileName, rotateAngleForPhoto);
////				fileStream = new FileInputStream(rotatePhonePhoto);
////			} catch (Exception e1) {
////				logger.debug("上传图片 压缩时失败 --> ");
////				e1.printStackTrace();
////				return "";
////			}
////
////		}
////
////
////
//////		// 调用阿里云SDK，上传图片
//////		UploadImageRequest request = new UploadImageRequest(SysConfigUtils.getSysConfig(SysConfigConstant.alAccessKeyId),
//////				SysConfigUtils.getSysConfig(SysConfigConstant.alAccessKeySecret), "default");
//////		/* 存储区域（可选） */
//////		String storageLocation = SysConfigUtils.getSysConfig(SysConfigConstant.alStorageLocation);
//////		request.setStorageLocation(storageLocation);
//////		/* 流式上传时，InputStream为必选，fileName为源文件名称，如:文件名称.png(可选) */
//////		request.setFileName(imgFile.getOriginalFilename());
//////
//////		// 1.文件流上传
//////		try {
//////			if (fileStream != null) {
//////				request.setInputStream(fileStream);
//////			} else {
//////				request.setInputStream(imgFile.getInputStream());
//////			}
//////			// 开始上传图片
//////			UploadImageImpl uploadImage = new UploadImageImpl();
//////			UploadImageResponse response = uploadImage.upload(request);
//////			logger.debug("ImageURL=" + response.getImageURL() + "\n");
//////			return response.getImageURL();
//////		} catch (Exception e) {
//////			logger.debug("上传图片至阿里云发生错误---->:");
//////			e.printStackTrace();
//////			return "";
//////		}
////
////	}
//
//	/**
//	 * 将BufferedImage转换为InputStream
//	 * @param image
//	 * @return
//	 */
//	public static InputStream bufferedImageToInputStream(BufferedImage image){
//	    ByteArrayOutputStream os = new ByteArrayOutputStream();
//	    try {
//	        ImageIO.write(image, "png", os);
//	        InputStream input = new ByteArrayInputStream(os.toByteArray());
//	        return input;
//	    } catch (IOException e) {
//	        logger.error("提示:",e);
//	    }
//	    return null;
//	}
//
//
//
//	/**
//     * 获取图片正确显示需要旋转的角度（顺时针）
//     * @return
//     */
//    public static int getRotateAngleForPhoto(String filePath){
//
//        File file = new File(filePath);
//
//        int angle = 0;
//
//        Metadata metadata;
//        try {
//			metadata = JpegMetadataReader.readMetadata(file);
//            Directory directory = metadata.getOrCreateDirectory(ExifIFD0Directory.class);
//                if(directory.containsTag(ExifIFD0Directory.TAG_ORIENTATION)){
//
//                  // Exif信息中方向　　
//                   int orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
//
//                   // 原图片的方向信息
//                   if(6 == orientation ){
//                       //6旋转90
//                       angle = 90;
//                   }else if( 3 == orientation){
//                      //3旋转180
//                       angle = 180;
//                   }else if( 8 == orientation){
//                      //8旋转90
//                       angle = 270;
//                   }
//                }
//        } catch (JpegProcessingException e) {
//            e.printStackTrace();
//        } catch (MetadataException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        return angle;
//    }
//
//    /**
//     * 旋转手机照片
//     * @return
//     */
//    public static String rotatePhonePhoto(String fullPath, int angel){
//
//        BufferedImage src;
//        try {
//            src = ImageIO.read(new File(fullPath));
//
//            int src_width = src.getWidth(null);
//            int src_height = src.getHeight(null);
//
//           // Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);
//            Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);
//
//            BufferedImage res = new BufferedImage(rect_des.width, rect_des.height,BufferedImage.TYPE_INT_RGB);
//            Graphics2D g2 = res.createGraphics();
//
//            g2.translate((rect_des.width - src_width) / 2,
//                    (rect_des.height - src_height) / 2);
//            g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);
//
//            g2.drawImage(src, null, null);
//
//            ImageIO.write(res, "jpg", new File(fullPath));
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//
//        return fullPath;
//
//    }
//
//    /**
//     * 计算转换后目标矩形的宽高
//     * @param src 源矩形
//     * @param angel 角度
//     * @return 目标矩形
//     */
//    private static Rectangle CalcRotatedSize(Rectangle src, int angel) {
//        double cos = Math.abs(Math.cos(Math.toRadians(angel)));
//        double sin = Math.abs(Math.sin(Math.toRadians(angel)));
//        int des_width = (int)(src.width *  cos) + (int)(src.height * sin);
//        int des_height =  (int)(src.height *  cos) + (int)(src.width * sin);
//        return new Rectangle(new Dimension(des_width, des_height));
//    }
//}
