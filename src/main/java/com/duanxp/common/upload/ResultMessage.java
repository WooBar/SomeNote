package com.duanxp.common.upload;

public enum ResultMessage {

	OK("OK"),
	
	SERVER("服务器出现异常"),

	PARAM("参数错误"),
	
	PASSWORD("密码错误"),
	
	DELETEOK("删除成功"),
	
	PASSWORDOK("密码正确"),
	
	DATA_ERROR("数据错误"),

	COURSE_APPLY("报名成功！"),
	
	DATA_NOT_EXIST("数据不存在"),
	
	ERROR("操作失败"),
	
	VOTE_EXIST("已投票"),
	
	FILE_ERROR("文件错误")
	;
	private String message;
	
	private ResultMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
