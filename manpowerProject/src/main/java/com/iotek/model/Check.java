package com.iotek.model;

import java.math.BigDecimal;
import java.util.Date;

public class Check {
    private Long cId;

    private Date cWorkTime;

    private Date cOffworkTine;

    private String cLate;

    private String cLeave;

    private long eId;
    private String cAbsenteeism;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcAbsenteeism() {
        return cAbsenteeism;
    }

    public void setcAbsenteeism(String cAbsenteeism) {
        this.cAbsenteeism = cAbsenteeism;
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

    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "Check{" +
                "cId=" + cId +
                ", cWorkTime=" + cWorkTime +
                ", cOffworkTine=" + cOffworkTine +
                ", cLate='" + cLate + '\'' +
                ", cLeave='" + cLeave + '\'' +
                ", eId=" + eId +
                ", cAbsenteeism='" + cAbsenteeism + '\'' +
                '}';
    }
}