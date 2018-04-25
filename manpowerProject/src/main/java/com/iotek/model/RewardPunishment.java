package com.iotek.model;

import java.util.Date;

public class RewardPunishment {
    private Long rpId;

    private Date rpTime;

    private String rpCause;

    private Long rpSal;

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
        this.rpCause = rpCause == null ? null : rpCause.trim();
    }

    public Long getRpSal() {
        return rpSal;
    }

    public void setRpSal(Long rpSal) {
        this.rpSal = rpSal;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }
}