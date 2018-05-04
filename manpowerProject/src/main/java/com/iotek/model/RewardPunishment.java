package com.iotek.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RewardPunishment {
    private Long rpId;
   //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date rpTime;
    private String rpCause;
    private String reName;
    private double rpSal;
    private Long eId;

    public Long getRpId() {
        return rpId;
    }

    public void setRpId(Long rpId) {
        this.rpId = rpId;
    }

    public Date getRpTime() {
        return rpTime;
    }

    public void setRpTime(Date rpTime) {
        this.rpTime = rpTime;
    }

    public String getRpCause() {
        return rpCause;
    }

    public void setRpCause(String rpCause) {
        this.rpCause = rpCause;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public double getRpSal() {
        return rpSal;
    }

    public void setRpSal(double rpSal) {
        this.rpSal = rpSal;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "RewardPunishment{" +
                "rpId=" + rpId +
                ", rpTime=" + rpTime +
                ", rpCause='" + rpCause + '\'' +
                ", reName='" + reName + '\'' +
                ", rpSal=" + rpSal +
                ", eId=" + eId +
                '}';
    }
}