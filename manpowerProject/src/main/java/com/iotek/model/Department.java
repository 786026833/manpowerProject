package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable{
    private Long dId;

    private String dName;
    private Date dTime;

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }
}