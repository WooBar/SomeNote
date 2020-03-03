package com.duanxp.module.chifan.pojo;

import java.io.Serializable;


/**
 * @Description
 * @Author Hunter
 * @Date 2019-11-08
 */
public class LocationInfo implements Serializable {

    private static final long serialVersionUID = 6369567190574019789L;

    private Long id;

    private String createTime;

    private String operationTime;

    private String status;

    /**
     * ip所在地址
     */
    private String location;

    /**
     * ip
     */
    private String ip;

    private String userId;

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

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
