package com.iotek.model;

import java.math.BigDecimal;
import java.util.Date;

public class Salary {
    private Long sId;

    private double sBaseSal;

    private double sPerfSal;

    private double sOverSal;

    private double sPenaltySal;

    private double sSocSal;

    private double sTotalSal;

    private Long eId;

    private Date sMonth;

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public double getsBaseSal() {
        return sBaseSal;
    }

    public void setsBaseSal(double sBaseSal) {
        this.sBaseSal = sBaseSal;
    }

    public double getsPerfSal() {
        return sPerfSal;
    }

    public void setsPerfSal(double sPerfSal) {
        this.sPerfSal = sPerfSal;
    }

    public double getsOverSal() {
        return sOverSal;
    }

    public void setsOverSal(double sOverSal) {
        this.sOverSal = sOverSal;
    }

    public double getsPenaltySal() {
        return sPenaltySal;
    }

    public void setsPenaltySal(double sPenaltySal) {
        this.sPenaltySal = sPenaltySal;
    }

    public double getsSocSal() {
        return sSocSal;
    }

    public void setsSocSal(double sSocSal) {
        this.sSocSal = sSocSal;
    }

    public double getsTotalSal() {
        return sTotalSal;
    }

    public void setsTotalSal(double sTotalSal) {
        this.sTotalSal = sTotalSal;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Date getsMonth() {
        return sMonth;
    }

    public void setsMonth(Date sMonth) {
        this.sMonth = sMonth;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sId=" + sId +
                ", sBaseSal=" + sBaseSal +
                ", sPerfSal=" + sPerfSal +
                ", sOverSal=" + sOverSal +
                ", sPenaltySal=" + sPenaltySal +
                ", sSocSal=" + sSocSal +
                ", sTotalSal=" + sTotalSal +
                ", eId=" + eId +
                ", sMonth=" + sMonth +
                '}';
    }
}