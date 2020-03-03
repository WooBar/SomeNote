package com.duanxp.module.choose.pojo;

import lombok.Data;

import java.io.Serializable;


/**
 * @Description
 * @Author Hunter
 * @Date 2019-11-08
 */
public class ChooseLocationInfo implements Serializable {

    private static final long serialVersionUID = 6369567190574019789L;

    private String id;

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

    private String url;

    private String uri;

    private String food;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
