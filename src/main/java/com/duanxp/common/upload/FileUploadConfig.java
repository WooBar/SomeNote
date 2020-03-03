package com.duanxp.common.upload;

/**
 * 文件上传参数
 * @author yulekuan
 */
public class FileUploadConfig {
	/**
	 * 上传路径
	 */
	private String uploadPath = "";

	/**
	 * 访问路径
	 */
	private String requestPath = "";

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}
}
