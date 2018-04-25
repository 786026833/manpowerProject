package com.iotek.model;

import java.math.BigDecimal;
import java.util.Date;

public class Check {
    private Long cId;

    private Date cWorkTime;

    private Date cOffworkTine;

    private String cLate;

    private String cLeave;

    private BigDecimal eId;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Date getcWorkTime() {
        return cWorkTime;
    }

    public void setcWorkTime(Date cWorkTime) {
        this.cWorkTime = cWorkTime;
    }

    public Date getcOffworkTine() {
        return cOffworkTine;
    }

    public void setcOffworkTine(Date cOffworkTine) {
        this.cOffworkTine = cOffworkTine;
    }

    public String getcLate() {
        return cLate;
    }

    public void setcLate(String cLate) {
        this.cLate = cLate == null ? null : cLate.trim();
    }

    public String getcLeave() {
        return cLeave;
    }

    public void setcLeave(String cLeave) {
        this.cLeave = cLeave == null ? null : cLeave.trim();
    }

    public BigDecimal geteId() {
        return eId;
    }

    public void seteId(BigDecimal eId) {
        this.eId = eId;
    }
}