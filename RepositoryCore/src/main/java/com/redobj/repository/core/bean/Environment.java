package com.redobj.repository.core.bean;

import java.util.Date;

public class Environment {
    private Integer environmentId;
    private String environmentName;
    private Double temperature;
    private Date tDatetime;
    private Integer tDatasize;
    private Double humidity;
    private Date hDatetime;
    private Integer hDatasize;
    private Double sun;
    private Date sDatetime;
    private Integer sDatasize;

    public Integer getEnvironmentId() {
        return environmentId;
    }
    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }
    public String getEnvironmentName() {
        return environmentName;
    }
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName == null ? null : environmentName.trim();
    }
    public Double getTemperature() {
        return temperature;
    }
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    public Date gettDatetime() {
        return tDatetime;
    }
    public void settDatetime(Date tDatetime) {
        this.tDatetime = tDatetime;
    }
    public Integer gettDatasize() {
        return tDatasize;
    }
    public void settDatasize(Integer tDatasize) {
        this.tDatasize = tDatasize;
    }
    public Double getHumidity() {
        return humidity;
    }
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
    public Date gethDatetime() {
        return hDatetime;
    }
    public void sethDatetime(Date hDatetime) {
        this.hDatetime = hDatetime;
    }
    public Integer gethDatasize() {
        return hDatasize;
    }
    public void sethDatasize(Integer hDatasize) {
        this.hDatasize = hDatasize;
    }
    public Double getSun() {
        return sun;
    }
    public void setSun(Double sun) {
        this.sun = sun;
    }
    public Date getsDatetime() {
        return sDatetime;
    }
    public void setsDatetime(Date sDatetime) {
        this.sDatetime = sDatetime;
    }
    public Integer getsDatasize() {
        return sDatasize;
    }
    public void setsDatasize(Integer sDatasize) {
        this.sDatasize = sDatasize;
    }

    @Override
    public String toString() {
        return  " 环境ID："+environmentId+" 环境名："+environmentName+
                " 温度："+temperature+" 湿度："+humidity+
                " 光照："+sun;
    }
}