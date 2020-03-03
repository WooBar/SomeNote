package com.duanxp.module.chifan.pojo;


import java.io.Serializable;


/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-11-08 
 */
public class LookLogger  implements Serializable {

	private static final long serialVersionUID =  6316065686138549132L;

	private Long id;

	private String createTime;

	private String userId;

	private String ip;

	private String status;

	private String operationTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
}
