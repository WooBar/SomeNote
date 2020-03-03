package com.duanxp.common.file;

import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/10/29 0029
 */
public class TestFileDto {


    private String name;

    private String path;

    private List<TestFileDto> fileNameList;

    /**
     * 节点： 1级 2级 3级
     */
    private Integer node;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestFileDto> getFileNameList() {
        return fileNameList;
    }

    public void setFileNameList(List<TestFileDto> fileNameList) {
        this.fileNameList = fileNameList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getNode() {

        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }
}
