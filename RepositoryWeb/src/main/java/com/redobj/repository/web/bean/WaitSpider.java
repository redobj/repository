package com.redobj.repository.web.bean;

public class WaitSpider {
    private Integer waitId;

    private String waitGoods;

    private Boolean waitStatus;

    public Integer getWaitId() {
        return waitId;
    }

    public void setWaitId(Integer waitId) {
        this.waitId = waitId;
    }

    public String getWaitGoods() {
        return waitGoods;
    }

    public void setWaitGoods(String waitGoods) {
        this.waitGoods = waitGoods == null ? null : waitGoods.trim();
    }

    public Boolean getWaitStatus() {
        return waitStatus;
    }

    public void setWaitStatus(Boolean waitStatus) {
        this.waitStatus = waitStatus;
    }
}