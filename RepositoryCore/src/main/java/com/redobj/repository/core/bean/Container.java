package com.redobj.repository.core.bean;

public class Container {
    //id
    private Integer containerId;
    //名称
    private String containerName;
    //已使用
    private Integer containerUsed;
    //最大容量
    private Integer containerCapacity;
    //环境id
    private Integer containerEnvironment;
    //备注
    private String containerNote;
    //查询时用联合查询获取到的环境信息
    private Environment environment;

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Integer getContainerId() {
        return containerId;
    }

    public void setContainerId(Integer containerId) {
        this.containerId = containerId;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName == null ? null : containerName.trim();
    }

    public Integer getContainerUsed() {
        return containerUsed;
    }

    public void setContainerUsed(Integer containerUsed) {
        this.containerUsed = containerUsed;
    }

    public Integer getContainerCapacity() {
        return containerCapacity;
    }

    public void setContainerCapacity(Integer containerCapacity) {
        this.containerCapacity = containerCapacity;
    }

    public Integer getContainerEnvironment() {
        return containerEnvironment;
    }

    public void setContainerEnvironment(Integer containerEnvironment) {
        this.containerEnvironment = containerEnvironment;
    }

    public String getContainerNote() {
        return containerNote;
    }

    public void setContainerNote(String containerNote) {
        this.containerNote = containerNote == null ? null : containerNote.trim();
    }
}