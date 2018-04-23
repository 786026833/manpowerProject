package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

public class ResumeDd implements Serializable{
    private Long rdId;

    private Long rId;

    private Date rdTime;

    private String rdState;

    public ResumeDd() {
    }

    public ResumeDd(Long rId) {
        this.rId = rId;
    }

    public Long getRdId() {
        return rdId;
    }

    public void setRdId(Long rdId) {
        this.rdId = rdId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Date getRdTime() {
        return rdTime;
    }

    public void setRdTime(Date rdTime) {
        this.rdTime = rdTime;
    }

    public String getRdState() {
        return rdState;
    }

    public void setRdState(String rdState) {
        this.rdState = rdState == null ? null : rdState.trim();
    }
}